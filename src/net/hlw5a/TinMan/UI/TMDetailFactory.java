package net.hlw5a.TinMan.UI;

import javax.swing.JPanel;

import net.hlw5a.TinMan.Documents.ConferenceProceedings;
import net.hlw5a.TinMan.Documents.Document;

public class TMDetailFactory {
	
	private static TMDetailProceedings conferenceProceedings = new TMDetailProceedings();
	
	public static JPanel createDocumentDetails(Document document) {
		switch (document.getType()) {
		case Book:
			break;
		case BookSection:
			break;
		case ComputerProgram:
			break;
		case ConferenceProceedings:
			conferenceProceedings.setDocument((ConferenceProceedings)document);
			return conferenceProceedings;
		case EncyclopaediaArticle:
			break;
		case Generic:
			break;
		case JournalArticle:
			break;
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
		return null;
	}
}
