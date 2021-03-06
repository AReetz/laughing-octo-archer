package net.hlw5a.TinMan.Documents;

import java.util.Iterator;
import java.util.Map;

import net.hlw5a.TinMan.Contributor.IPerson;
import net.hlw5a.TinMan.Contributor.IPublisher;
import net.hlw5a.TinMan.IDs.ISBN;

public class Book extends AbstractDocument {

	// contributor fields
	@Override
	public Iterator<IPerson> getAuthors() { return authors.iterator(); }
    @Override
	public Iterator<IPerson> getEditors() { return editors.iterator(); }
    @Override
    public IPublisher getPublisher() { return publisher; }
    
    // date fields
    @Override
    public Integer getDay() { throw new UnsupportedOperationException("getDay() not supported in " + this.getClass().getName()); }
    @Override
    public Integer getMonth() { throw new UnsupportedOperationException("getMonth() not supported in " + this.getClass().getName()); }
    @Override
    public Integer getYear() { return year; }

    // title fields
    @Override
    public String getPublication() { return title; }
    @Override
	public String getVolume() { throw new UnsupportedOperationException("getVolume() not supported in " + this.getClass().getName()); }    
    @Override
	public String getIssue() { throw new UnsupportedOperationException("getIssue() not supported in " + this.getClass().getName()); }
    @Override
	public String getEdition() { return edition; }
    @Override
    public String getTitle() { return title; }
    @Override
    public String getPages() { return pages; }
    
    // id fields
    public ISBN getISBN() { return isbn; }

    public Book(Map<String, Object> Values)  {
    	super(Values);
    }

}
