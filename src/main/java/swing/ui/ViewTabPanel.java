/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui;

import java.util.Iterator;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import swing.annotation.GridSuport;
import swing.model.DefaultModel;

/**
 *
 * @author itakenami
 */
public class ViewTabPanel extends JPanel {
    
    
    javax.swing.JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
    javax.swing.JTable jTable3 = new javax.swing.JTable();
    
    public ViewTabPanel(Set<DefaultModel> models){
        
        super();
        
        //jTable3.setColumnSelectionAllowed(true);
        jTable3.setRowHeight(24);
        jTable3.setShowGrid(true);
        jTable3.setShowVerticalLines(false);
        jTable3.getTableHeader().setResizingAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);


        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE).addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE).addContainerGap()));

        loadData(models);
    }
    
    
    public void loadData(Set<DefaultModel> models) {

        Iterator<DefaultModel> it = models.iterator();

        if (it.hasNext()) {
            
            DefaultModel mdl = it.next();

            //jTable3.setModel(mdl.getGridFields().getGridModel());
            jTable3.setModel(GridSuport.getInstance().getGridModel(mdl));
            //int[] width = mdl.getGridFields().getWidth();
            int[] width = GridSuport.getInstance().getGridWidth(mdl);

            for (int x = 0; x < width.length; x++) {
                jTable3.getColumnModel().getColumn(x).setMinWidth(width[x]);
                jTable3.getColumnModel().getColumn(x).setPreferredWidth(width[x]);
            }

            DefaultTableModel aModel = (DefaultTableModel) jTable3.getModel();

            
            Iterator<DefaultModel> it2 = models.iterator();

            while (it2.hasNext()) {
                
                DefaultModel mdl2 = it2.next();

                String[] fields = mdl2.getGridFields().getFields();
                String[] objects = new String[fields.length];

                //objects[0] = mdl.getId().toString();
                for (int y = 0; y < fields.length; y++) {
                    objects[y] = fields[y];
                }

                aModel.addRow(objects);
                
            }   
                
            
        }else{
            jTable3.setModel(GridSuport.getInstance().getGridModel());
        }






    }

        
    
}
