package net.hlw5a.TinMan.Citations;

import net.hlw5a.TinMan.Documents.IDocument;

public interface ICitation {
	
	public String createCitation(IDocument document);
	public String createShortCitation(IDocument document);
	public String getName();
}
