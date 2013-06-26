package net.hlw5a.TinMan.Contributor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import net.hlw5a.TinMan.Documents.IDocument;

public class Person implements IPerson {
	
	private Integer id;
	private String firstNames;
    private String lastName;
    private List<IDocument> authored = new Vector<IDocument>();
    private List<IDocument> edited = new Vector<IDocument>();

    public Integer getId() { return id; }
	public String getFirstNames() { return firstNames; }
	public String getLastName() { return lastName; }
    public Iterator<IDocument> getAuthored() { return authored.iterator(); }
    public Iterator<IDocument> getEdited() { return edited.iterator(); }

    public Person(Map<String, Object> Values)  {
        this.id = (Integer) Values.get("id");
        this.firstNames = (String)Values.get("firstNames");
        this.lastName = (String)Values.get("lastName");
    }

    public void addAuthored(IDocument Document)  {
        authored.add(Document);
    }

    public void addEdited(IDocument Document) {
        edited.add(Document);
    }
    
    @Override
	public boolean equals(Object obj) {
    	if (obj.getClass() != Person.class) return false;
		else return ((Person)obj).lastName == this.lastName && ((Person)obj).firstNames == this.firstNames;
	}
    
	@Override
	public String toString() {
		return lastName + ", " + firstNames;
	}
}

