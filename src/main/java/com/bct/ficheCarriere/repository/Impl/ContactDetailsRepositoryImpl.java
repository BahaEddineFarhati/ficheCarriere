package com.bct.ficheCarriere.repository.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bct.ficheCarriere.model.ContactDetails;
import com.bct.ficheCarriere.repository.ContactDetailsRepository;

@Repository
public class ContactDetailsRepositoryImpl implements ContactDetailsRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ContactDetails getContactDetailsById(String id) {
		List<Map<String, Object>> email = jdbcTemplate.queryForList("select mail_destinataire from USERGRAM.MAILING_LIST"
				+ " where nom_mailing_list like 'POINTAGE' and mat_use = ?",id);
		List<Map<String, Object>> details = jdbcTemplate.queryForList("select MAT_PERS, nvl(LIB_GOUV,' ') as LIB_GOUV , nvl(RUE,' ') as rue ,nvl(TEL_PERS,' ') as TEL_PERS"
				+ " from GRH.ADR_PERS AD1, grh.gouvernorat AD2"
				+ " where AD1.COD_GOUV = AD2.COD_GOUV and AD1.MAT_PERS = ?",id);
		ContactDetails contactDetails = new ContactDetails();
		if (!email.isEmpty()) {
		Map<String, Object> emailRow = email.get(0);
		contactDetails.setEmail(String.valueOf(emailRow.get("mail_destinataire")));
		}
		if(!details.isEmpty()) {
		Map<String, Object> detailsRow = details.get(0);
		
		contactDetails.setStreet(String.valueOf(detailsRow.get("rue")));
		contactDetails.setCity(String.valueOf(detailsRow.get("lib_gouv")));
		contactDetails.setPhoneNumber(String.valueOf(detailsRow.get("tel_pers")));
		}
		return contactDetails;
	}


}
