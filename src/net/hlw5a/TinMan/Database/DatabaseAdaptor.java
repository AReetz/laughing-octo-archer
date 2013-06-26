package net.hlw5a.TinMan.Database;

import java.util.Iterator;
import java.util.Vector;

import net.hlw5a.TinMan.Contributor.Person;
import net.hlw5a.TinMan.Documents.ConferenceProceedings;
import net.hlw5a.TinMan.Documents.AbstractDocument;
import net.hlw5a.TinMan.Documents.JournalArticle;

public class DatabaseAdaptor {

	//private static String newLine = System.getProperty("line.separator");
	
	public static Class<?>[] columnClasses = new Class<?>[] {
		Integer.class,
		String.class,
		String.class,
		String.class,
		String.class
	};
	
	public static String[] columnNames = new String[] {
		"Uuid",
		"Title",
		"Authors",
		"Publication",
		"Date"
	};
	
	public static Vector<Vector<Object>> getData() {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Iterator<AbstractDocument> iter = Database.getInstance().getAllDocuments(); 
		while (iter.hasNext()) {
			AbstractDocument doc = iter.next();
			Vector<Object> entry = new Vector<Object>();
			if (doc.getClass() == ConferenceProceedings.class) {
				ConferenceProceedings cp = (ConferenceProceedings)doc;
				entry.add(cp.getId());
				entry.add(cp.getTitle());
				entry.add(convertContributors(cp.getAuthors()));
				entry.add(cp.getPublication());
				if (cp.getYear() != null) entry.add(cp.getYear().toString()); else entry.add(null);
				data.add(entry);
			}
			else if (doc.getClass() == JournalArticle.class) {
				JournalArticle ja = (JournalArticle)doc;
				entry.add(ja.getId());
				entry.add(ja.getTitle());
				entry.add(convertContributors(ja.getAuthors()));
				entry.add(ja.getPublication());
				if (ja.getYear() != null) entry.add(ja.getYear().toString()); else entry.add(null);
				data.add(entry);
			}
		}
		return data;
	}
	
	private static String convertContributors(Iterator<Person> contributors) {
		StringBuilder result = new StringBuilder();
		while (contributors.hasNext()) {
			Person cont = contributors.next();
			result.append(cont.getLastName() + ", " + cont.getFirstNames());
			if (contributors.hasNext()) result.append("; ");
		}
		return result.toString();
	}
}
