package net.hlw5a.TinMan.Database;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.hlw5a.TinMan.ReturningHashMap;
import net.hlw5a.TinMan.Contributor.Contribution;
import net.hlw5a.TinMan.Contributor.Person;
import net.hlw5a.TinMan.Contributor.Publisher;
import net.hlw5a.TinMan.Documents.AbstractDocument;
import net.hlw5a.TinMan.Documents.DocumentFactory;

public class Database {
	
	private static volatile Database instance = null;

	private static Map<String, Publisher> publishers = new ReturningHashMap<String, Publisher>();
	private static Map<String, Person> contributors = new ReturningHashMap<String, Person>();
	private static Map<Integer, AbstractDocument> documents = new ReturningHashMap<Integer, AbstractDocument>();
	
	public static Database getInstance() {
		if (instance == null) {
			synchronized (Database .class){
				if (instance == null) {
					instance = new Database();
					instance.loadDatabase();
				}
			}
		}
		return instance;
	}
	
	public Publisher addPublisher(String key, Publisher value) { return publishers.put(key, value); }
	public Publisher getPublisher(String key) { return publishers.get(key); }
	
	public Person addContributor(String key, Person value) { return contributors.put(key, value); }
	public Person getContributor(String key) { return contributors.get(key); }
	
	public AbstractDocument addDocument(Integer key, AbstractDocument value) { return documents.put(key, value); }
	public AbstractDocument getDocument(Integer key) { return documents.get(key); }
	public Iterator<AbstractDocument> getAllDocuments() { return documents.values().iterator(); }
		
	private void loadDatabase() {
		try { 
			Class.forName("org.sqlite.JDBC");
			try {
				String os = System.getProperty("os.name");
				String fileName;
				if (os.contains("Windows")) {
					fileName = System.getProperty("user.home") + "\\AppData\\Local\\Mendeley Ltd\\Mendeley Desktop";
				}
				else if (os.equals("Mac OS X")) {
					fileName = System.getProperty("user.home") + "/Library/Application Support/Mendeley Desktop/";
				}
				else {
					fileName = "";
				}
				fileName = new File(fileName).listFiles(new FilenameFilter() {
					public boolean accept(File arg0, String arg1) { return arg1.endsWith("@www.mendeley.com.sqlite"); }
				})[0].getAbsolutePath();
				
				Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fileName);
				try {
					PreparedStatement stmt;
					
					/*
					 * load documents
					 */
					stmt = conn.prepareStatement("SELECT * FROM Documents;");
					try {
						ResultSet rs = stmt.executeQuery();
						ResultSetMetaData rsmd = stmt.getMetaData();
						while (rs.next()) {
							Map<String, Object> values = new HashMap<String, Object>();
							for (int i = 1; i <= rsmd.getColumnCount(); i++) {
								switch(rsmd.getColumnType(i)) {
								case 0:
									values.put(rsmd.getColumnLabel(i), null);
									break;
								case 4:
									values.put(rsmd.getColumnLabel(i), rs.getInt(i));
									break;
								case 12:
									values.put(rsmd.getColumnLabel(i), rs.getString(i));
									break;
								}
							}
							AbstractDocument doc = DocumentFactory.Create(values);
							if (doc != null) documents.put(doc.getId(), doc);
						}
					} catch (SQLException e) {
						stmt.close();
					}
					
					/*
					 * load contributors
					 */
					stmt = conn.prepareStatement("SELECT * FROM DocumentContributors;");
					try {
						ResultSet rs = stmt.executeQuery();
						ResultSetMetaData rsmd = stmt.getMetaData();
						while (rs.next()) {
							Map<String, Object> values = new HashMap<String, Object>();
							for (int i = 1; i <= rsmd.getColumnCount(); i++) {
								switch(rsmd.getColumnType(i)) {
								case 0:
									values.put(rsmd.getColumnLabel(i), null);
									break;
								case 4:
									values.put(rsmd.getColumnLabel(i), rs.getInt(i));
									break;
								case 12:
									values.put(rsmd.getColumnLabel(i), rs.getString(i));
									break;
								}
							}
							
							Person contributor = new Person(values);
							contributor = contributors.put(contributor.toString(), contributor);
							
							/*
							 * match contributor and document
							 */
							Contribution contribution = Contribution.valueOf((String)values.get("contribution"));
							AbstractDocument document = documents.get((Integer)values.get("documentId"));
		                    if (document != null && contribution == Contribution.DocumentAuthor) {
		                    	contributor.addAuthored(document);
		                    	document.addAuthor(contributor);
		                    }
		                    else if (document != null && contribution == Contribution.DocumentEditor) {
		                    	contributor.addEdited(document);
		                    	document.addEditor(contributor);
		                    }
						}
						stmt.close();
					} catch (SQLException e) {
					}
					stmt.close();
				} catch (SQLException e) {
					conn.close();
				}
				conn.close();
			} catch (SQLException e) {
			}
		} catch (ClassNotFoundException e) {
		}
	}
}
