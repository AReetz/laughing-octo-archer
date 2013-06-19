package net.hlw5a.TinMan.UI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TMTableCellRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 2320494697464233880L;

	public TMTableCellRenderer() {
        setOpaque(true);
    }
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JLabel cmp = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		cmp.setBorder(new EmptyBorder(6, 12, 6, 12));
		if (row % 2 == 0) cmp.setBackground(Color.WHITE);
		else cmp.setBackground(new Color(223, 223, 255));
		if (isSelected) {
			cmp.setFont(Styles.fontBold);
			cmp.setForeground(Color.BLACK);
		}
		else {
			cmp.setFont(Styles.fontPlain);
		}
		return cmp;
	}

}
