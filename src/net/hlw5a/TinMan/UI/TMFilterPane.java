package net.hlw5a.TinMan.UI;

import java.util.regex.PatternSyntaxException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import net.hlw5a.TinMan.Database.DatabaseAdaptor;

public class TMFilterPane extends JPanel {
	
	private static final long serialVersionUID = -8549399059010390532L;

	private JComboBox filterCategory;
	private JTextField filterText;
	private TableRowSorter<TMTableModel> tableRowSorter;
	
	public TMFilterPane(TableRowSorter<TMTableModel> tableRowSorter) {
		this.tableRowSorter = tableRowSorter;
		filterText = new JTextField();
		filterText.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) { createNewFilter(); }
			public void insertUpdate(DocumentEvent e) { createNewFilter(); }
			public void changedUpdate(DocumentEvent arg0) { createNewFilter(); }
		});
		JLabel filterLabel1 = new JLabel("Filter text:", SwingConstants.TRAILING);
		filterLabel1.setLabelFor(filterText);
		filterCategory = new JComboBox(DatabaseAdaptor.columnNames);
		JLabel filterLabel2 = new JLabel("Filter category:", SwingConstants.TRAILING);
		filterLabel2.setLabelFor(filterCategory);		
		this.setLayout(new SpringLayout());
		this.add(filterLabel1);
		this.add(filterText);
		this.add(filterLabel2);
		this.add(filterCategory);
		SpringUtilities.makeCompactGrid(this, 2, 2, 6, 6, 6, 6);
	}
	
	public void setFilter(String text, String category) {
		filterText.setText(text);
	}
	
	private void createNewFilter() {
		RowFilter<TMTableModel, Object> rf = null;
		try {
            rf = RowFilter.regexFilter(filterText.getText(), filterCategory.getSelectedIndex());
        } catch (PatternSyntaxException e) {
            return;
        }
		tableRowSorter.setRowFilter(rf);
	}
}
