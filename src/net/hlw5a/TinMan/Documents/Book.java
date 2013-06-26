package net.hlw5a.TinMan.Documents;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.hlw5a.TinMan.Contributor.Person;
import net.hlw5a.TinMan.Contributor.Publisher;
import net.hlw5a.TinMan.Database.DBBool;
import net.hlw5a.TinMan.IDs.ISBN;

public class Book extends AbstractDocument {

    // Mendeley fields
    public DBBool isFavorite() { return favorite; }
    public String getNote() { return note; }
    // people fields
    public List<Person> getAuthors() { return Collections.unmodifiableList(authors); }
    public Publisher getPublisher() { return publisher; }
    // date fields
    public Integer getYear() { return year; }
    // title fields
    public String getTitle() { return title; }
    public String getPages() { return pages; }
    public String getPublication() { return publication; }
    // id fields
    public ISBN getISBN() { return isbn; }

    public Book(Map<String, Object> Values)  {
    	super(Values);
    }

}
