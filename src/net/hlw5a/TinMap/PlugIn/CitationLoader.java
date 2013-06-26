package net.hlw5a.TinMap.PlugIn;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

import net.hlw5a.TinMan.Citations.ICitation;

public class CitationLoader {

	private static Vector<ICitation> citationStyles = new Vector<ICitation>();
	
	public static Vector<ICitation> getCitationStyles() { return citationStyles; }
	
	public static void Load(URL[] urls) {
		
		URLClassLoader loader = null;
		try {
			loader = new URLClassLoader(urls);
			File dir = new File(urls[0].getFile());
			File[] files = dir.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) { return name.endsWith(".class") && !name.endsWith("ICitation.class"); }
			});
			
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				fileName = fileName.substring(0, fileName.length() - 6);
				Class<ICitation> c = (Class<ICitation>) loader.loadClass("net.hlw5a.TinMan.Citations." + fileName);
				citationStyles.add(c.newInstance());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (loader != null)
				try { loader.close(); }
				catch (IOException e) { }
		}
	}
}
