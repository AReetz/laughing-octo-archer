package net.hlw5a.TinMan.UI;

import javax.swing.SwingUtilities;

public class TinManStarter {
	public static void main(String[] args) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Tin Man");
		SwingUtilities.invokeLater(new TinMan());
	}
}
