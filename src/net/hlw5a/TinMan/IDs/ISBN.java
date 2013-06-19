package net.hlw5a.TinMan.IDs;

public abstract class ISBN {

    public static ISBN Create(String Number)  {
    	try {
    		Number = Number.replaceAll("[^\\d.]", "");
	        if (Number.length() == 10) return new ISBN10(Number);
	        else if (Number.length() == 13) return new ISBN13(Number);
    	} catch (Exception e1) {
    		try { return new ISBN13("0000000000000"); }
    		catch (Exception e2) { }
    	}
    	return null;
    }
    
    protected String isbn;
    
    public String getISBN() { return isbn; }
}
