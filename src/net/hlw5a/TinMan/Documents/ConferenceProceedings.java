package net.hlw5a.TinMan.Documents;

import java.util.Iterator;
import java.util.Map;

import net.hlw5a.TinMan.Contributor.Person;
import net.hlw5a.TinMan.Contributor.Publisher;
import net.hlw5a.TinMan.Database.DBBool;
import net.hlw5a.TinMan.IDs.DOI;
import net.hlw5a.TinMan.IDs.ISBN;

public class ConferenceProceedings extends AbstractDocument {

    // Mendeley fields
    public DBBool isFavorite() { return favorite; }
    public String getNote() { return note; }
    // people fields
    public Iterator<Person> getAuthors() { return authors.iterator(); }
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