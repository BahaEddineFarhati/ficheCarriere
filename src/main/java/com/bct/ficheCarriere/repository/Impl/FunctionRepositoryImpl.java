package com.bct.ficheCarriere.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bct.ficheCarriere.model.Function;
import com.bct.ficheCarriere.repository.FunctionsRepository;

@Repository
public class FunctionRepositoryImpl implements FunctionsRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Function> getEmployeePositions (String id){
		List<Map<String, Object>> positionsRows = jdbcTemplate.queryForList("select c.mat_pers, to_char(c.dat_prom,'DD/MM/YYYY')as dat_prom ,replace(g.lib_grad,'_',' ') as lib_grad , s2.gr100lib,TP.LIB_PROM,"
				+ " case  when S1.GR100ABR is null then s1.GR100LIB else s1.GR100ABR  end As department"
				+ " from grh.cariere_pers c, grh.grade g,gr100t_services s1,gr100t_services s2, grh.type_promotion tp"
				+ " where c.cod_typ_prom = 'AG' and TP.COD_TYP_PROM = C.COD_TYP_PROM and c.COD_DEPT = S1.GR100SCE (+)"
				+ " and c.cod_serv = s2.gr100sce (+) "
				+ " and c.mat_pers = ? and g.cod_grad = c.nv_grad and g.cod_cat = c.nv_cat and g.cod_categ = c.nv_categ"
				+ " order by c.dat_prom desc",id);
		List<Function> positions = new ArrayList<Function>();
		for (Map<String, Object> postionsRow : positionsRows) {
			Function position = new Function ();
			position.setDate(String.valueOf(postionsRow.get("dat_prom")));
			String department = String.valueOf(postionsRow.get("department"));
			if (department.equals("null")) {
				department="";
			}
			position.setDepartment(department);
			position.setFunctionName(String.valueOf(postionsRow.get("lib_grad")));
			position.setPromotionType(String.valueOf(postionsRow.get("lib_prom")));
			String service = String.valueOf(postionsRow.get("gr100lib"));
			if (service.equals("null")) {
				service = "";
			}
			position.setService(service);
			positions.add(position);
		}
		return positions;
		
	}

	@Override
	public List<Function> getEmployeeFunctions(String id) {
		List<Map<String, Object>> functionsRows = jdbcTemplate.queryForList("select c.mat_pers,c.COD_DEPT,c.cod_serv, to_char(c.dat_prom,'DD/MM/YYYY') as dat_prom ,replace(f.lib_fonct,'_',' ') as lib_fonct, c.cod_typ_prom,case  when S1.GR100ABR is null then s1.GR100LIB else s1.GR100ABR  end As department,s2.gr100lib"
				+ " from grh.cariere_pers c, grh.fonctions f,gr100t_services s1,gr100t_services s2"
				+ " where c.nv_fonct = f.cod_fonct and c.COD_DEPT = S1.GR100SCE (+) and c.cod_serv = s2.gr100sce (+)"
				+ " and c.cod_typ_prom = 'FC' and c.mat_pers = ? order by c.dat_prom desc ",id);
		List<Function> functions = new ArrayList<Function>();
		for (Map<String, Object> functionRow : functionsRows) {
			Function function = new Function ();
			function.setDate(String.valueOf(functionRow.get("dat_prom")));
			String department = String.valueOf(functionRow.get("department"));
			if (department.equals("null")) {
				department="";
			}
			function.setDepartment(department);
			function.setFunctionName(String.valueOf(functionRow.get("lib_fonct")));
			String service = String.valueOf(functionRow.get("gr100lib"));
			if (service.equals("null")) {
				service = "";
			}
			function.setService(service);
			functions.add(function);
		}
		return functions;
	}
	
	

}
