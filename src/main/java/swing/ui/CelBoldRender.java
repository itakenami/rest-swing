/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author itakenami
 */
public class CelBoldRender extends DefaultTableCellRenderer {

    /**
     *      */
    private Font fontePadrao = new Font(Font.SANS_SERIF, Font.BOLD, 12);

    /**
     * @see
     * javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable,
     * java.lang.Object, boolean, boolean, int, int)
     */
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(
                table,
                value,
                isSelected,
                hasFocus,
                row,
                column);

        c.setFont(this.fontePadrao);
        //c.setForeground(Color.blue);
        //c.setBackground(Color.white);

        return c;
    }
}
