package net.hlw5a.TinMan.UI;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import net.hlw5a.TinMan.Citations.ICitation;
import net.hlw5a.TinMan.Database.Database;
import net.hlw5a.TinMan.Documents.AbstractDocument;
import net.hlw5a.TinMap.PlugIn.CitationLoader;

public class TinMan extends JPanel implements Runnable, ListSelectionListener {

	private static final long serialVersionUID = -4432964693264108741L;

	private JPanel contentPane;
	private TMTablePane tablePane;
	private TMTableModel tableModel;
	
	@Override
	public void run() {
		
		try {
			URL[] urls = new URL[] { new URL("file:///Users/Adrian/Documents/Source Code/laughing-octo-archer/bin/net/hlw5a/TinMan/Citations/") };
			CitationLoader.Load(urls);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		tableModel = new TMTableModel();
		TableRowSorter<TMTableModel> tableSorter = new TableRowSorter<TMTableModel>(tableModel);
		tableSorter.setComparator(3, new TMComparatorProceedings());

		tablePane = new TMTablePane(this, tableModel, tableSorter);
		contentPane = new JPanel(new BorderLayout());
		contentPane.add(tablePane, BorderLayout.CENTER);
		contentPane.add(new TMFilterPane(tableSorter), BorderLayout.PAGE_START);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Citation styles");
		menuBar.add(menu);
		Iterator<ICitation> iter = CitationLoader.getCitationStyles().iterator();
		while (iter.hasNext()) {
			JMenuItem  menuItem = new JMenuItem(iter.next().getName());
			menu.add(menuItem);
		}

		JFrame mainFrame = new JFrame("TinMan");
		mainFrame.setContentPane(contentPane);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setJMenuBar(menuBar);
        mainFrame.setTitle("TinMan");
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setExtendedState(mainFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        mainFrame.addWindowListener(new WindowAdapter() {
        	public void windowClosed(WindowEvent e) { }
        });
	}
	
	public void valueChanged(ListSelectionEvent arg0) {
		if (arg0.getValueIsAdjusting()) {
			JTable table = tablePane.getTable();
			AbstractDocument doc = Database.getInstance().getDocument((Integer)table.getValueAt(table.getSelectedRow(), 0));
			JPanel lastDetailPane = TMDetailFactory.getLastPanel();
			JPanel detailPane = TMDetailFactory.createDocumentDetails(doc);
			if (lastDetailPane != detailPane) contentPane.remove(lastDetailPane);
			contentPane.add(detailPane, BorderLayout.PAGE_END);
		}
	}
}
