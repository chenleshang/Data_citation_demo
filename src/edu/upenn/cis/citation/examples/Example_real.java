package edu.upenn.cis.citation.examples;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

import edu.upenn.cis.citation.Corecover.Query;
import edu.upenn.cis.citation.Pre_processing.populate_db;

public class Example_real {
	
	
	public static void main(String [] args) throws ClassNotFoundException, SQLException
	{
//		populate_db.db_url = "jdbc:postgresql://localhost:5432/test";
		
		Database_operation.clear();
		
		load_view_and_citations();
	}
	
	public static void load_view_and_citations() throws ClassNotFoundException, SQLException
	{
		Init_examples init = new Init_examples();
		
		init.load_properties();
		
		String view_file = init.configProp.getProperty("test.views");
		
		String citation_query_file = init.configProp.getProperty("test.citation_query");
		
		String connection_file = init.configProp.getProperty("test.connection");
		
		Vector<Query> views = Load_views_and_citation_queries.get_views(view_file);
		
		Vector<Query> citation_queries = Load_views_and_citation_queries.get_views(citation_query_file);
		
		Vector<String []> connections = Load_connections.get_view_citation_connection(connection_file);
		
//		populate_db.db_url = "jdbc:postgresql://localhost:5432/example";
		
		Database_operation.load2db(views, citation_queries, connections);
	}

}
