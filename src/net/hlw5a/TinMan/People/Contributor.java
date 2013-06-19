package net.hlw5a.TinMan.People;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import net.hlw5a.TinMan.Documents.Document;

public class Contributor {
	
	private Integer id;
	private String firstNames;
    private String lastName;
    private List<Document> authored = new Vector<Document>();
    private List<Document> edited = new Vector<Document>();

    public Integer getId() { return id; }
	public String getFirstNames() { return firstNames; }
	public String getLastName() { return lastName; }
    public Iterator<Document> getAuthored() { return authored.iterator(); }
    public Iterator<Document> getEdited() { return edited.iterator(); }

    public Contributor(Map<String, Object> Values)  {
        this.id = (Integer) Values.get("id");
        this.firstNames = (String)Values.get("firstNames");
        this.lastName = (String)Values.get("lastName");
    }

    public void addAuthored(Document Document)  {
        authored.add(Document);
    }

    public void addEdited(Document Document) {
        edited.add(Document);
    }
    
    @Override
	public boolean equals(Object obj) {
    	if (obj.getClass() != Contributor.class) return false;
		else return ((Contributor)obj).lastName == this.lastName && ((Contributor)obj).firstNames == this.firstNames;
	}
    
	@Override
	public String toString() {
		return lastName + ", " + firstNames;
	}
}

