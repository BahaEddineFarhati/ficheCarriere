package com.bct.ficheCarriere.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bct.ficheCarriere.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bct.ficheCarriere.model.EmployeeDetails;
import com.bct.ficheCarriere.model.Formation;
import com.bct.ficheCarriere.model.Function;
import com.bct.ficheCarriere.repository.ContactDetailsRepository;
import com.bct.ficheCarriere.repository.EmployeeDetailsRepository;
import com.bct.ficheCarriere.repository.FunctionsRepository;

@Repository
public class EmployeeDetailsImpl implements EmployeeDetailsRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ContactDetailsRepository contactDetailsRepo;
	
	@Autowired
	FunctionsRepository functionRepo;

	@Override
	public EmployeeDetails getEmployeeDetails(String id) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select T.mat_pers AS id, T.nom_pers AS lName,"
				+ " T.pren_pers AS fName, to_char(T.dat_nais,'DD/MM/YYYY') as bDate,  case  when S1.GR100ABR is null then s1.GR100LIB else s1.GR100ABR  end As department,"
				+ " C.LIB_CAT AS actualPosition, to_char(t.DAT_EMB ,'DD/MM/YYYY') as hireDate, C1.lib_cat AS Grade_emb "
				+ " FROM grh.PERSONNEL t, grh.motif_sort m, grh.categorie c, grh.grade g, grh.fonctions f, gr100t_services s1, gr100t_services s2, grh.categorie c1, grh.grade g1, grh.fonctions q"
				+ " WHERE t.etat_act = 'A' AND t.cod_motif NOT LIKE '6%' and T.mat_pers = ? AND t.cod_motif = m.cod_motif(+) "
				+ " AND t.cod_cat = c.cod_cat(+) AND t.cod_categ = c.cod_categ(+)"
				+ " AND t.cat_emb = c1.cod_cat(+) AND t.categ_emb = c1.cod_categ(+)"
				+ " AND t.cod_cat = g.cod_cat(+) AND t.cod_categ = g.cod_categ(+) AND t.cod_grad = g.cod_grad(+)"
				+ " AND t.cat_emb = g1.cod_cat(+) AND t.categ_emb = g1.cod_categ(+) AND t.grad_emb = g1.cod_grad(+)"
				+ " AND f.COD_FONCT(+) = T.COD_FONCT AND T.COD_DEPT = S1.GR100SCE(+) AND t.cod_serv = s2.gr100sce(+)"
				+ " AND t.categ_emb = c1.cod_categ(+) AND t.cat_emb = c1.cod_cat(+) AND t.qualf = q.cod_fonct(+)  AND q.typ_fonct(+) = 'Q'"
				+ " ORDER BY t.mat_pers",id);
		EmployeeDetails employeeDetails = new EmployeeDetails();
		Map<String, Object> row = rows.get(0);
		employeeDetails.setId(String.valueOf(row.get("id")));
		employeeDetails.setfName(String.valueOf(row.get("fName")));
		employeeDetails.setlName(String.valueOf(row.get("lName")));
		employeeDetails.setBirthDate(String.valueOf(row.get("bDate")));
		employeeDetails.setActualPosition(String.valueOf(row.get("actualPosition")));
		employeeDetails.setActualDepartment(String.valueOf(row.get("department")));
		employeeDetails.setHireDate(String.valueOf(row.get("hireDate")));
		employeeDetails.setHireGrade(String.valueOf(row.get("Grade_emb")));
		List<Map<String, Object>> formationRows = jdbcTemplate.queryForList("select lib_niveau,case etude when 'PRO' then 'Professionnel' when 'UNI' then 'Universitaire' when 'SEC' then 'Secondaire' when 'PRI' then 'Primaire' else ' ' end as etude"
				+ " from grh.niveau_pers n, grh.param_niveau p where  p.cod_niveau = n.cod_niveau "
				+ " and N.MAT_PERS = ?",id);
		List<Formation> listFormations = new ArrayList<Formation>();
		for (Map<String, Object> formationRow : formationRows) {
			Formation formation = new Formation();
			formation.setDiploma(String.valueOf(formationRow.get("lib_niveau")));
			formation.setLevel(String.valueOf(formationRow.get("etude")));
			
			listFormations.add(formation);
		}
		employeeDetails.setFormationsList(listFormations);
		employeeDetails.setContactDetails(contactDetailsRepo.getContactDetailsById(id));
		employeeDetails.setPositionsList(functionRepo.getEmployeePositions(id));
		employeeDetails.setFunctionsList(functionRepo.getEmployeeFunctions(id));
		
		
		return employeeDetails;
	}





}
