package org.qq120011676.snow;

import org.junit.Test;
import org.qq120011676.snow.base.BaseJunit;
import org.qq120011676.snow.util.SqlUtils;

public class SqlTest extends BaseJunit {

	@Test
	public void sqlTest(){
		
		System.out.println(SqlUtils.getSql("hospital.saveHospitalAllData"));
	}
}
