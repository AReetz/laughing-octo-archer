package net.hlw5a.TinMan.UI;

import javax.swing.JPanel;

import net.hlw5a.TinMan.Documents.ConferenceProceedings;
import net.hlw5a.TinMan.Documents.IDocument;
import net.hlw5a.TinMan.Documents.JournalArticle;
import net.hlw5a.TinMan.UI.DocumentDetails.TMDetailJournalArticle;
import net.hlw5a.TinMan.UI.DocumentDetails.TMDetailProceedings;

public class TMDetailFactory {
	
	private static TMDetailProceedings conferenceProceedings = new TMDetailProceedings();
	private static TMDetailJournalArticle journalArticle = new TMDetailJournalArticle();
	
	private static JPanel lastPanel;
	
	public static JPanel getLastPanel() { return lastPanel; }
	
	public static JPanel createDocumentDetails(IDocument document) {
		switch (document.getType()) {
		case Book:
			break;
		case BookSection:
			break;
		case ComputerProgram:
			break;
		case ConferenceProceedings:			
			conferenceProceedings.setDocument((ConferenceProceedings)document);
			lastPanel = conferenceProceedings;
		case EncyclopaediaArticle:
			break;
		case Generic:
			break;
		case JournalArticle:
			journalArticle.setDocument((JournalArticle)document);
			lastPanel = journalArticle;
		case MagazineArticle:
			break;
		case Patent:
			break;
		case Report:
			break;
		case Thesis:
			break;
		case WebPage:
			break;
		}
		return lastPanel;
	}
}
