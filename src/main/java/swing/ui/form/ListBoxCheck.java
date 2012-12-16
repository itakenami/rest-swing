/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import swing.model.DefaultModel;

/**
 *
 * @author itakenami
 */
public class ListBoxCheck extends JTable implements FormComponent {

    List<Long> list;

    public ListBoxCheck(List<? extends DefaultModel> models, HashMap<String, Boolean> def) {
        
        list = new ArrayList<Long>();
        String[] lst_itens = new String[models.size()];
        int[] idx = new int[def.size()];
        int c_idx = 0;

        for (int x = 0; x < models.size(); x++) {
            DefaultModel dm = models.get(x);
            list.add(dm.getId());
            lst_itens[x] = dm.toString();
            if (def.containsKey(lst_itens[x])) {
                idx[c_idx] = x;
                c_idx++;
            }
        }

        
        this.setModel(getData(lst_itens));
        this.getTableHeader().setReorderingAllowed(false);
        this.getColumnModel().getColumn(0).setResizable(false);
        this.getColumnModel().getColumn(0).setMinWidth(20);
        this.getColumnModel().getColumn(0).setMaxWidth(20);
        this.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.getColumnModel().getColumn(1).setResizable(false);
        //this.getColumnModel().getColumn(1).setMinWidth(60);
        //this.getColumnModel().getColumn(1).setMaxWidth(60);
        //this.getColumnModel().getColumn(1).setPreferredWidth(60);

        this.setTableHeader(null);
        
        this.setSelectedIndices(idx);
    }

    private DefaultTableModel getData(String[] nomes) {

        Object[][] itens = new Object[nomes.length][2];

        for (int x = 0; x < itens.length; x++) {
            itens[x][0] = new Boolean(false);
            itens[x][1] = nomes[x];
        }


        return new javax.swing.table.DefaultTableModel(
                itens,
                new String[]{
                    "", ""
                }) {

            Class[] types = new Class[]{
                java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        

    }

    public int[] getSelectedIndices() {
        DefaultTableModel dm = (DefaultTableModel) this.getModel();

        ArrayList<String> selected = new ArrayList();

        for (int x = 0; x < dm.getRowCount(); x++) {
            Boolean sel = (Boolean) dm.getValueAt(x, 0);
            if (sel) {
                selected.add(x + "");
            }
        }

        int[] s = new int[selected.size()];

        for (int x = 0; x < s.length; x++) {
            s[x] = Integer.parseInt(selected.get(x));
        }

        return s;
    }

    public void setSelectedIndices(int[] val) {

        DefaultTableModel dm = (DefaultTableModel) this.getModel();

        for (int x = 0; x < val.length; x++) {
            dm.setValueAt(new Boolean(true), val[x], 0);
        }

    }

    @Override
    public Object getUserValue() {
        int[] idx_selected = this.getSelectedIndices();
        String[] sel = new String[idx_selected.length];
        
        for(int x=0;x<idx_selected.length;x++){
            sel[x] = list.get(idx_selected[x]).toString();
        }
        
        return sel;
    }
}
