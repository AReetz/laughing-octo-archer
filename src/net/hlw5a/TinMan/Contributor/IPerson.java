package net.hlw5a.TinMan.Contributor;

import java.util.Iterator;

import net.hlw5a.TinMan.Documents.IDocument;

public interface IPerson {
	
    public Integer getId();
	public String getFirstNames();
	public String getLastName();
    public Iterator<IDocument> getAuthored();
    public Iterator<IDocument> getEdited();
}
