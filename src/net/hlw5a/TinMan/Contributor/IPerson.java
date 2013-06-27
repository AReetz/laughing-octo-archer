package net.hlw5a.TinMan.Contributor;

import java.util.Iterator;

import net.hlw5a.TinMan.Documents.IDocument;

public interface IPerson {
	
    Integer getId();
	String getFirstNames();
	String getLastName();
    Iterator<IDocument> getAuthored();
    Iterator<IDocument> getEdited();
}
