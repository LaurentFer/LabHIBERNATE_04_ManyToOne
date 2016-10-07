package client;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GenerateSchema {
	public static void main(String[] args) {
	
		Configuration config = new AnnotationConfiguration().configure();
		SchemaExport exp = new SchemaExport(config);
		exp.setOutputFile("CreateDatabase.sql");
		exp.create(true, true);
	}
}