package net.hlw5a.TinMan.Documents;

import java.util.Iterator;
import java.util.Map;

import net.hlw5a.TinMan.Database.DBBool;
import net.hlw5a.TinMan.IDs.DOI;
import net.hlw5a.TinMan.IDs.ISBN;
import net.hlw5a.TinMan.People.Contributor;
import net.hlw5a.TinMan.People.Publisher;

public class ConferenceProceedings extends Document {

    // Mendeley fields
    public DBBool isFavorite() { return favorite; }
    public String getNote() { return note; }
    // people fields
    public Iterator<Contributor> getAuthors() { return authors.iterator(); }
    public Publisher getPublisher() { return publisher; }
    // date fields
    public Integer getYear() { return year; }
    // title fields
    public String getTitle() { return title; }
    public String getPages() { return pages; }
    public String getPublication() { return publication; }
    // id fields
    public DOI getDOI() { return doi; }
    public ISBN getISBN() { return isbn; }

    public ConferenceProceedings(Map<String, Object> Values)  {
    	super(Values);
    }
}