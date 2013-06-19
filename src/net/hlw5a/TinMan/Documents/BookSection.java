package net.hlw5a.TinMan.Documents;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.hlw5a.TinMan.Database.DBBool;
import net.hlw5a.TinMan.IDs.ISBN;
import net.hlw5a.TinMan.People.Contributor;
import net.hlw5a.TinMan.People.Publisher;

public class BookSection extends Document {

    // Mendeley fields
    public DBBool isFavorite() { return favorite; }
    public String getNote() { return note; }
    // people fields
    public List<Contributor> getAuthors() { return Collections.unmodifiableList(authors); }
    public List<Contributor> getEditors() { return Collections.unmodifiableList(editors); }
    public Publisher getPublisher() { return publisher; }
    // date fields
    public Integer getYear() { return year; }
    // title fields
    public String getTitle() { return title; }
    public String getPages() { return pages; }
    public String getPublication() { return publication; }
    // id fields
    public ISBN getISBN() { return isbn; }

    public BookSection(Map <String, Object> Values)  {
    	super(Values);
    }
}
