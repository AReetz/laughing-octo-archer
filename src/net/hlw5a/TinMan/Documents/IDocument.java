package net.hlw5a.TinMan.Documents;

import java.util.Iterator;

import net.hlw5a.TinMan.Contributor.IPerson;
import net.hlw5a.TinMan.Contributor.IPublisher;

public interface IDocument {
	
    Integer getId();
    DocumentType getType();
    Iterator<IPerson> getAuthors();
    Iterator<IPerson> getEditors();
    IPublisher getPublisher();
    Integer getDay();
    Integer getMonth();
    Integer getYear();
    String getPublication();
    String getVolume();
    String getIssue();
    String getEdition();
    String getTitle();
    String getPages();
}
