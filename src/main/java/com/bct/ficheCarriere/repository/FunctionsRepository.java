package com.bct.ficheCarriere.repository;

import java.util.List;


import com.bct.ficheCarriere.model.Function;

public interface FunctionsRepository {
	List<Function> getEmployeeFunctions (String id);
	List<Function> getEmployeePositions (String id);

}
