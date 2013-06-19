package net.hlw5a.TinMan.UI;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class TMTablePane extends JScrollPane {

	private static final long serialVersionUID = -5605867361545476393L;
	
	private JTable table;
	
	public TMTablePane(TinMan tinMan, TMTableModel tableModel, TableRowSorter<TMTableModel> tableSorter) {
		final TMTableCellRenderer renderer = new TMTableCellRenderer();
		table = new JTable(tableModel) {
			public TableCellRenderer getCellRenderer(int row, int column) {
		        return renderer;
		    }
		};
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(30);
		table.setDefaultRenderer(Object.class, new TMTableCellRenderer());
		table.setRowSorter(tableSorter);
		table.setFillsViewportHeight(true);
		table.getSelectionModel().addListSelectionListener(tinMan);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.setViewportView(table);
	}
	
	public JTable getTable() { return table; }
}
