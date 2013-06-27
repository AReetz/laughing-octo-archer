package net.hlw5a.TinMan.Documents;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import net.hlw5a.TinMan.Contributor.IPerson;
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
    
    // contributors
    protected List<IPerson> authors = new Vector<IPerson>();
    protected List<IPerson> editors = new Vector<IPerson>();
    protected Publisher publisher;
    
    // titles
    protected String publication;
    protected String volume;
    protected String issue;
    protected String edition;
    protected String title;
    protected String pages;
    
    // ids
    protected DOI doi;
    protected ISBN isbn;
    protected ISSN issn;

    // dates
    protected Integer day;
    protected Integer month;
    protected Integer year;
    
    /**
     * Returns the unique identifier of this document.
     * @see net.hlw5a.TinMan.Documents.IDocument#getId()
     */
    public Integer getId() { return id; }
    
    /**
     * Returns the type of this document.
     * @see net.hlw5a.TinMan.Documents.IDocument#getType()
     * @see net.hlw5a.TinMan.Documents.DocumentType
     */
    public DocumentType getType() { return type; }
    
    public AbstractDocument(Map<String, Object> Values) {
    	this.id = (Integer)Values.get("id");
    	this.type = DocumentType.valueOf((String)Values.get("type"));
    	this.deletionPending = DBBoolFactory.Create((String)Values.get("deletionPending"));
    	this.added = new Date((long)(Integer)Values.get("added") * 1000);
        //this.uuid = UUID.fromString((String)Values.get("uuid"));
        this.note = (String)Values.get("note");
        
        // contributors
        Publisher publisher = new Publisher((String)Values.get("publisher"), (String)Values.get("city"));
        this.publisher = Database.getInstance().addPublisher(publisher.toString(), publisher);
        
        // dates
        this.day = (Integer)Values.get("day");
        this.month = (Integer)Values.get("month");
        this.year = (Integer)Values.get("year");

        // titles
        this.publication = (String)Values.get("publication");
        this.volume = (String)Values.get("volume");
        this.issue = (String)Values.get("issue");
        this.edition = null;
        this.title = (String)Values.get("title");
        this.pages = (String)Values.get("pages");
        //this.chapter = (String)Values.get("chapter");
        
        // IDs
        try { this.doi = new DOI((String)Values.get("doi")); }
        catch (Exception e) { this.doi = DOI.Empty; }
        this.isbn = ISBN.Create((String)Values.get("isbn"));
        this.issn = ISSN.Create((String)Values.get("issn"));
    }
    
    public void addAuthor(Person Author)  {
        authors.add(Author);
    }

    public void addEditor(Person Editor) {
        editors.add(Editor);
    }
}
