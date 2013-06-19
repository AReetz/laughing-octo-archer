package net.hlw5a.TinMan.UI;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import net.hlw5a.TinMan.Database.Database;
import net.hlw5a.TinMan.Documents.Document;

public class TinMan extends JPanel implements Runnable, ListSelectionListener {

	private static final long serialVersionUID = -4432964693264108741L;

	private JPanel contentPane;
	private TMTablePane tablePane;
	private TMTableModel tableModel;
	
	@Override
	public void run() {
		tableModel = new TMTableModel();
		TableRowSorter<TMTableModel> tableSorter = new TableRowSorter<TMTableModel>(tableModel);
		tableSorter.setComparator(3, new TMComparatorProceedings());

		tablePane = new TMTablePane(this, tableModel, tableSorter);
		contentPane = new JPanel(new BorderLayout());
		contentPane.add(tablePane, BorderLayout.CENTER);
		contentPane.add(new TMFilterPane(tableSorter), BorderLayout.PAGE_START);
		
		JFrame mainFrame = new JFrame("TinMan");
		mainFrame.setContentPane(contentPane);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			Document doc = Database.getInstance().getDocument((Integer)tableModel.getValueAt(tablePane.getTable().getSelectedRow(), 0));
			JPanel detailPane = TMDetailFactory.createDocumentDetails(doc);
			contentPane.add(detailPane, BorderLayout.PAGE_END);
		}
	}
}
