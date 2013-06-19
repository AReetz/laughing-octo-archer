package net.hlw5a.TinMan.UI;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import net.hlw5a.TinMan.Database.DatabaseAdaptor;

public class TMTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -5752108346523728390L;
	private Vector<Vector<Object>> data = DatabaseAdaptor.getData();

	@Override
	public String getColumnName(int columnIndex) {
        return DatabaseAdaptor.columnNames[columnIndex];
    }
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return DatabaseAdaptor.columnClasses[columnIndex];
	}
	
	@Override
	public int getColumnCount() {
		return DatabaseAdaptor.columnClasses.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.elementAt(rowIndex).elementAt(columnIndex);
	}
}
