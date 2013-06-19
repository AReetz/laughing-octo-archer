package net.hlw5a.TinMan.Documents;

import java.util.Iterator;
import java.util.Map;

import net.hlw5a.TinMan.Database.DBBool;
import net.hlw5a.TinMan.IDs.DOI;
import net.hlw5a.TinMan.People.Contributor;

public class JournalArticle  extends Document {

	// Mendeley fields
    public DBBool isFavorite() { return favorite; }
    public String getNote() { return note; }
    // people fields
    public Iterator<Contributor> getAuthors() { return authors.iterator(); }
    // date fields
    public Integer getYear() { return year; }
    // title fields
    public String getTitle() {return title; }
    public String getPages() { return pages; }
    public String getIssue() { return issue; }
    public String getVolume() { return volume; }
    public String getPublication() { return publication; }
    // id fields
    public DOI getDOI() { return doi; }
    
	public JournalArticle(Map<String, Object> Values) {
		super(Values);
	}
}
