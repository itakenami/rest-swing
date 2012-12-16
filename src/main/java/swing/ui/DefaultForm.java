/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui;

import client.exception.ValidationError;
import client.exception.ValidationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import swing.model.DefaultModel;
import swing.ui.form.*;

/**
 *
 * @author itakenami
 */
public class DefaultForm extends Form {
    
    private DefaultModel defaultModel;
    private DefaultList defaultList;
    private HashMap<String, FormComponent> campos;
    
    public DefaultForm(DefaultModel defaultModel, DefaultList defaultList) {
        super(defaultList.getFrameContent(), true);
        this.defaultModel = defaultModel;
        this.defaultList = defaultList;
        campos = new HashMap<String, FormComponent>();
        initComponents();
        this.setSize(defaultList.getDefaultFormWidth(), defaultList.getDefaultFormHeight());
        preencherForm();
    }
  
    
    private void preencherForm() {
        
        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        jPanel1.setLayout(layout);
        
        List<ModelField.Field> fields = defaultModel.getViewFields().getListFields();
        
        int py = 25;
        int zy = 20;        
        
        for(int x=0;x<fields.size();x++){
            
            javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
            jLabel1.setText(fields.get(x).header);
            jPanel1.add(jLabel1);
            
            if (fields.get(x).type == ModelField.LISTBOX) {
                
                HashMap<String, Boolean> sel = new HashMap<String, Boolean>();
                
                if (fields.get(x).field!=null){
                    
                    Set<DefaultModel> lista = (Set<DefaultModel>)fields.get(x).field;
                    Iterator<DefaultModel> it = lista.iterator();
                    
                    while(it.hasNext()){
                        sel.put(it.next().toString(), Boolean.TRUE);
                    }
                    
                }
                
                //ListBox cb = new ListBox(defaultModel.getObj(fields.get(x).header),sel);
                ListBoxCheck cb = new ListBoxCheck(defaultModel.getObj(fields.get(x).header),sel);
                javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
                jScrollPane2.setViewportView(cb);
                
                jPanel1.add(jScrollPane2,"height ::90, width ::"+(defaultList.getDefaultFormWidth()-103)+", wrap");
                campos.put(fields.get(x).header, cb);
            }
            if (fields.get(x).type == ModelField.COMBO) {
                Combo cb = new Combo(defaultModel.getObj(fields.get(x).header),fields.get(x).field==null?"":fields.get(x).field.toString());
                jPanel1.add(cb,"wrap");
                campos.put(fields.get(x).header, cb);
            }
            if (fields.get(x).type == ModelField.TEXT) {
                Text txt = new Text();
                txt.setText(fields.get(x).field==null?"":fields.get(x).field.toString());
                jPanel1.add(txt,"wrap");
                campos.put(fields.get(x).header, txt);
            }
            if (fields.get(x).type == ModelField.DATE) {
                Date txt = new Date(this);
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                txt.setText(fields.get(x).field==null?"":sdf.format(fields.get(x).field));
                jPanel1.add(txt,"wrap");
                campos.put(fields.get(x).header, txt);
            }
            
            py+=40;
            zy+=40;
            
        }
        ((JComponent)campos.get(fields.get(0).header)).requestFocusInWindow();
        
    }
    
    public void save(){
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        Set<String> k = campos.keySet();
        
        Iterator<String> it = k.iterator();
        
        while(it.hasNext()){
            String key = it.next();
            map.put(key, campos.get(key).getUserValue());
        }
        
        try{
            defaultModel.save(defaultModel.getId(),map);
            closeForm();
        }catch(ValidationException ex){
            
            StringBuilder sb = new StringBuilder();
            sb.append("Verifique os seguintes erros:\n");
            
            List<ValidationError> err = ex.getErrorList();
            
            for (int x=0;x<err.size()-1;x++) {
                sb.append("   - "+err.get(x).message()+"\n");
            }
            
            JOptionPane.showMessageDialog(defaultList.getFrameContent(), sb.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(defaultList.getFrameContent(), ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jPanel1.setLayout(null);
        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=15 marginheight=5>Informações</body></html>", jScrollPane1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/resource/Actions-document-save-icon.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/resource/Actions-dialog-cancel-icon.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save();
        defaultList.preencherGrid(defaultModel.findStart());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeForm();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
