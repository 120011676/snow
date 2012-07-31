package org.qq120011676.snow.xml.sql;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class SqlFileFilter implements FilenameFilter {

	private String pattern = "^\\w*.sql.xml$";

	@Override
	public boolean accept(File dir, String name) {
		return Pattern.compile(this.pattern).matcher(name).matches();
	}

}
