package net.hlw5a.TinMan.Documents;

import java.util.Map;

import net.hlw5a.TinMan.Database.DBBool;
import net.hlw5a.TinMan.Database.DBBoolFactory;

public class DocumentFactory {

    public static Document Create(Map<String, Object> Values)
    {
    	if (DBBoolFactory.Create((String)Values.get("deletionPending")) != DBBool.False) return null;
        DocumentType docType = DocumentType.valueOf((String)Values.get("type"));
        switch (docType)
{           case JournalArticle:
            	return new JournalArticle(Values);
			case Book:
				return new Book(Values);
			case BookSection:
				return new BookSection(Values);
            case ConferenceProceedings:
                return new ConferenceProceedings(Values);
            default:
                return null;
        }
    }

}
