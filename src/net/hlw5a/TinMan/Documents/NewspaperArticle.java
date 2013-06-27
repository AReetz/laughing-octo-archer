package net.hlw5a.TinMan.Documents;

import java.util.Iterator;
import java.util.Map;

import net.hlw5a.TinMan.Contributor.IPerson;
import net.hlw5a.TinMan.Contributor.IPublisher;
import net.hlw5a.TinMan.IDs.ISSN;

public class NewspaperArticle extends AbstractDocument {

	// contributor fields
	@Override
	public Iterator<IPerson> getAuthors() { return authors.iterator(); }
    @Override
	public Iterator<IPerson> getEditors() { throw new UnsupportedOperationException("getEditors() not supported in " + this.getClass().getName()); }
    @Override
    public IPublisher getPublisher() { throw new UnsupportedOperationException("getPublisher() not supported in " + this.getClass().getName()); }
    
    // date fields
    @Override
    public Integer getDay() { return day; }
    @Override
    public Integer getMonth() { return month; }
    @Override
    public Integer getYear() { return year; }

    // title fields
    @Override
    public String getPublication() { return publication; }
    @Override
	public String getVolume() { throw new UnsupportedOperationException("getVolume() not supported in " + this.getClass().getName()); }
    @Override
	public String getIssue() { throw new UnsupportedOperationException("getIssue() not supported in " + this.getClass().getName()); }
    @Override
	public String getEdition() { throw new UnsupportedOperationException("getEdition() not supported in " + this.getClass().getName()); }
    @Override
    public String getTitle() { return title; }
    @Override
    public String getPages() { return pages; }
    
    // id fields
    public ISSN getISSN() { return issn; }
    
	public NewspaperArticle(Map<String, Object> Values) {
		super(Values);
	}
}
