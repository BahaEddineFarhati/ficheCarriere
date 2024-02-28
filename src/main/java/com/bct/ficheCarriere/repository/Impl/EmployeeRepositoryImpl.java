package com.bct.ficheCarriere.repository.Impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bct.ficheCarriere.model.Employee;
import com.bct.ficheCarriere.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getEmployeesList() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT T.mat_pers AS id,"
				+ " T.nom_pers AS fName, T.pren_pers lName, case  when S1.GR100ABR is null then s1.GR100LIB else s1.GR100ABR  end As department, replace(F.LIB_FONCT,'_',' ') As function"
				+ " FROM grh.PERSONNEL t, grh.motif_sort m, grh.categorie c, grh.grade g, grh.fonctions f, gr100t_services s1, gr100t_services s2, grh.categorie c1, grh.grade g1, grh.fonctions q"
				+ " WHERE t.etat_act = 'A' AND t.cod_motif NOT LIKE '6%' AND t.cod_motif = m.cod_motif(+) AND t.cod_cat = c.cod_cat(+) AND t.cod_categ = c.cod_categ(+)"
				+ " AND t.cat_emb = c1.cod_cat(+) AND t.categ_emb = c1.cod_categ(+) "
				+ " AND t.cod_cat = g.cod_cat(+) AND t.cod_categ = g.cod_categ(+) AND t.cod_grad = g.cod_grad(+)"
				+ " AND t.cat_emb = g1.cod_cat(+) AND t.categ_emb = g1.cod_categ(+) AND t.grad_emb = g1.cod_grad(+)"
				+ " AND f.COD_FONCT(+) = T.COD_FONCT AND T.COD_DEPT = S1.GR100SCE(+) AND t.cod_serv = s2.gr100sce(+)"
				+ " AND t.categ_emb = c1.cod_categ(+) AND t.cat_emb = c1.cod_cat(+) "
				+ " AND t.qualf = q.cod_fonct(+)  AND q.typ_fonct(+) = 'Q' ORDER BY t.mat_pers");
		
		List<Employee> listEmployees = new ArrayList<Employee>();
		for (Map<String, Object> row : rows) {
			Employee employee = new Employee();
			employee.setId(String.valueOf(row.get("id")));
			employee.setFirstName(String.valueOf(row.get("fName")));
			employee.setLastName(String.valueOf(row.get("lName")));
			String tempDepartment = String.valueOf(row.get("department"));
			if (tempDepartment.equals("null")) {
				tempDepartment = "Non affecté(e)";
			}
			employee.setDepartment(tempDepartment);
			String tempFunction = String.valueOf(row.get("function"));
			if (tempFunction.equals("null")) {
				tempFunction = "Pas de fonction";
			}
			employee.setFunction(tempFunction);
			String imagePath;
	 	    if (Files.exists(Paths.get("src/main/resources/static/assets/img/photos/" + employee.getId() + ".png"))) {
	 	        imagePath = "/assets/img/photos/" + employee.getId() + ".png";
	 	    } else if (Files.exists(Paths.get("src/main/resources/static/assets/img/photos/" + employee.getId() + ".jpg")))  {
	 	        // If PNG doesn't exist, fallback to JPG
	 	        imagePath = "/assets/img/photos/" + employee.getId() + ".jpg";
	 	    }
	 	    else {
	 	    	imagePath = "/assets/img/photos/default.png";
	 	    }
	 	    employee.setImagePath(imagePath);

			listEmployees.add(employee);
		}
		return listEmployees;
	}

	@Override
	public List<String> getDepartmentsList() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select case  when GR100ABR is null then GR100LIB else GR100ABR  end As department"
				+ " from gr100t_services where GR100SCE like '%000'");
		List<String> listDepartments = new ArrayList<String>();
		for (Map<String, Object> row : rows) {
			listDepartments.add(String.valueOf(row.get("department")));
		}
		return listDepartments;
	}

	@Override
	public List<String> getFunctionsList() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select replace(lib_fonct,'_',' ') as lib_fonct from grh.fonctions  where typ_fonct like 'F'");
		List<String> listFunctions = new ArrayList<String>();
		for (Map<String, Object> row : rows) {
			listFunctions.add(String.valueOf(row.get("lib_fonct")));
		}
		return listFunctions;
	}

   
    }


