package net.hlw5a.TinMan.Documents;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import net.hlw5a.TinMan.Contributor.Person;
import net.hlw5a.TinMan.Contributor.Publisher;
import net.hlw5a.TinMan.Database.DBBool;
import net.hlw5a.TinMan.Database.DBBoolFactory;
import net.hlw5a.TinMan.Database.Database;
import net.hlw5a.TinMan.IDs.DOI;
import net.hlw5a.TinMan.IDs.ISBN;
import net.hlw5a.TinMan.IDs.ISSN;

public abstract class AbstractDocument implements IDocument {
	
	// Mendeley
	protected Integer id;
	protected DocumentType type;
	protected DBBool deletionPending;
    protected UUID uuid;
    protected DBBool confirmed;
    protected DBBool deduplicated;
    protected DBBool favorite;
    protected DBBool read;
    protected DBBool onlyReference;
    protected Date added;
    protected Date modified;
    protected String note;
    
    // people
    protected List<Person> authors = new Vector<Person>();
    protected List<Person> editors = new Vector<Person>();
    protected Publisher publisher;
    
    // title
    protected String title;
    protected String chapter;
    protected String publication;
    protected String pages;
    protected String volume;
    protected String issue;
    
    // ids
    protected DOI doi;
    protected ISBN isbn;
    protected ISSN issn;

    protected Integer day;
    protected Integer month;
    protected Integer year;
    
    public Integer getId() { return id; }
    public DocumentType getType() { return type; }
    
    public AbstractDocument(Map<String, Object> Values) {
    	this.id = (Integer)Values.get("id");
    	this.deletionPending = DBBoolFactory.Create((String)Values.get("deletionPending"));
        //this.uuid = UUID.fromString((String)Values.get("uuid"));
        this.type = DocumentType.valueOf((String)Values.get("type"));
        this.note = (String)Values.get("note");
        this.title = (String)Values.get("title");
        this.chapter = (String)Values.get("chapter");
        this.added = new Date((long)(Integer)Values.get("added") * 1000);
        try { this.doi = new DOI((String)Values.get("doi")); }
        catch (Exception e) { this.doi = DOI.Empty; }
        this.isbn = ISBN.Create((String)Values.get("isbn"));
        this.issn = ISSN.Create((String)Values.get("issn"));
        this.issue = (String)Values.get("issue");
        this.pages = (String)Values.get("pages");
        this.publication = (String)Values.get("publication");
        Publisher publisher = new Publisher((String)Values.get("publisher"), (String)Values.get("city"));
        this.publisher = Database.getInstance().addPublisher(publisher.toString(), publisher);
        this.volume = (String)Values.get("volume");
        this.year = (Integer)Values.get("year");
    }
    
    public void addAuthor(Person Author)  {
        authors.add(Author);
    }

    public void addEditor(Person Editor) {
        editors.add(Editor);
    }
}
