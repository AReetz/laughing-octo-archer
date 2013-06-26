package net.hlw5a.TinMan.Citations;

import net.hlw5a.TinMan.Documents.ConferenceProceedings;

public interface ICitation {
	
	public String createCitation(ConferenceProceedings document);
	public String createShortCitation(ConferenceProceedings document);
	public String getName();
}
