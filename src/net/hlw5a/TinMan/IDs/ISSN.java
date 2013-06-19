package net.hlw5a.TinMan.IDs;

public class ISSN {
	
    public static ISSN Create(String Number)  {
    	try {
    		Number = Number.replaceAll("[^\\d.]", "");
    		return new ISSN(Number);
    	} catch (Exception e) {
    		try { return new ISSN("00000000"); }
    		catch (Exception e1) { }
    	}
    	return null;
    }

    private String issn;
    
    public String getISSN() { return issn; }

    private ISSN(String Number) throws Exception {
        if (Number.length() != 8) throw new Exception("Invalid ISSN length.");
        Integer control = 0;
        for (int i = 0; i < 7; i++) control += (Integer.getInteger(Number.substring(i, 1)) * (8 - i));
        control %= 11;
        if (Number.substring(7, 1) != ((control == 0) ? "0" : (control == 1) ? "X" : (11 - control))) throw new Exception("Invalid ISSN check digit.");
        this.issn = Number;
    }
}