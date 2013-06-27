package net.hlw5a.TinMan.PlugIn;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.hlw5a.TinMan.Citations.ICitation;

public class CitationLoader {

	private static Map<String, ICitation> citationStyles = new HashMap<String, ICitation>();
	
	public static ICitation getCitationStyle(String name) { return citationStyles.get(name); } 
	public static Iterator<ICitation> getCitationStyles() { return citationStyles.values().iterator(); }
	
	public static void Load(URL url) {
		
		URLClassLoader loader = new URLClassLoader(new URL[] { url });
		File dir = new File(url.getFile());
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) { return name.endsWith(".class") && !name.equals("ICitation.class"); }
		});
		
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			fileName = fileName.substring(0, fileName.length() - 6);
			try {
				Class<? extends ICitation> citationClass = (Class<? extends ICitation>)loader.loadClass("net.hlw5a.TinMan.Citations." + fileName).asSubclass(ICitation.class);
				ICitation citationStyle = citationClass.newInstance();
				citationStyles.put(citationStyle.getName(), citationStyle);
			}
			catch (ClassNotFoundException e) { e.printStackTrace(); }
			catch (InstantiationException e) { e.printStackTrace(); }
			catch (IllegalAccessException e) { e.printStackTrace(); }
		}
		try { loader.close(); }
		catch (IOException e) { e.printStackTrace(); }
	}
}
