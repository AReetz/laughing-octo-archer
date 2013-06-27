package net.hlw5a.TinMan.Documents;

import java.util.Iterator;
import java.util.Map;

import net.hlw5a.TinMan.Contributor.IPerson;
import net.hlw5a.TinMan.Contributor.IPublisher;
import net.hlw5a.TinMan.IDs.DOI;
import net.hlw5a.TinMan.IDs.ISBN;

public class ConferenceProceedings extends AbstractDocument {

    // contributor fields
	/**
	 * Returns the authors of this work.
	 * @see net.hlw5a.TinMan.Documents.IDocument#getAuthors()
	 */
	@Override
	public Iterator<IPerson> getAuthors() { return authors.iterator(); }
	/**
	 * unsupported field; not implemented
	 * @see net.hlw5a.TinMan.Documents.IDocument#getEditors()
	 * @see net.hlw5a.TinMan.Contributor.IPerson
	 */
    @Override
	public Iterator<IPerson> getEditors() { throw new UnsupportedOperationException("getEditors() not supported in " + this.getClass().getName()); }
    /**
     * Returns the publisher of this work.
     * @see net.hlw5a.TinMan.Documents.IDocument#getPublisher()
     * @see net.hlw5a.TinMan.Contributor.IPublisher
     */
    @Override
    public IPublisher getPublisher() { return publisher; }
    
    // date fields
    /**
     * unsupported field; not implemented
     * @see net.hlw5a.TinMan.Documents.IDocument#getDay()
     */
    @Override
    public Integer getDay() { throw new UnsupportedOperationException("getDay() not supported in " + this.getClass().getName()); }
    /**
     * unsupported field; not implemented
     * @see net.hlw5a.TinMan.Documents.IDocument#getMonth()
     */
    @Override
    public Integer getMonth() { throw new UnsupportedOperationException("getMonth() not supported in " + this.getClass().getName()); }
    
    /**
     * Returns the publication year of this work.
     * @see net.hlw5a.TinMan.Documents.IDocument#getYear()
     */
    public Integer getYear() { return year; }

    // title fields
    /**
     * Returns the conference title in which this work was published.
     * @see net.hlw5a.TinMan.Documents.IDocument#getPublication()
     */
    @Override
    public String getPublication() { return publication; }
    /**
     * unsupported field; not implemented
     * @see net.hlw5a.TinMan.Documents.IDocument#getVolume()
     */
    @Override
	public String getVolume() { throw new UnsupportedOperationException("getVolume() not supported in " + this.getClass().getName()); } 
    /**
     * unsupported field; not implemented
     * @see net.hlw5a.TinMan.Documents.IDocument#getIssue()
     */
    @Override
	public String getIssue() { throw new UnsupportedOperationException("getIssue() not supported in " + this.getClass().getName()); }
    /**
     * unsupported field; not implemented
     * @see net.hlw5a.TinMan.Documents.IDocument#getEdition()
     */
    @Override
	public String getEdition() { throw new UnsupportedOperationException("getEdition() not supported in " + this.getClass().getName()); }
    /**
     * Returns the title of this work.
     * @see net.hlw5a.TinMan.Documents.IDocument#getTitle()
     */
    @Override
    public String getTitle() { return title; }
    /**
     * Returns the range of pages in the conference proceedings for this work. 
     * @see net.hlw5a.TinMan.Documents.IDocument#getPages()
     */
    @Override
    public String getPages() { return pages; }
    
    // id fields
    public DOI getDOI() { return doi; }
    public ISBN getISBN() { return isbn; }

    public ConferenceProceedings(Map<String, Object> Values)  {
    	super(Values);
    }
}