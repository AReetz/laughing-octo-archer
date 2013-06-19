package net.hlw5a.TinMan.IDs;

import java.net.MalformedURLException;
import java.net.URL;

public class DOI {
    public static DOI Empty = new DOI("10.0000/0");

    public static DOI Create(String Number) {
        return new DOI(Number);
    }

	private String doi;
    private Integer registry;
    private Integer registrant;
    private String suffix;
    private URL url;

    public String getDoi() { return doi; }
	public String getSuffix() { return suffix; }
	public Integer getRegistry() { return registry; }
	public Integer getRegistrant() { return registrant; }
	public URL getUrl() { return url; }
	
    public DOI (String Address) {
    	String[] cmp = Address.split("[./]", 3);
        doi = Address;
        registry = Integer.parseInt(cmp[0]);
        registrant = Integer.parseInt(cmp[1]);
        suffix = cmp[2];
        try { url = new URL("http://dx.doi.org/" + this.doi); }
        catch (MalformedURLException e) { }
    }
}