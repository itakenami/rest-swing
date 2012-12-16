/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui.form;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import swing.model.DefaultModel;

/**
 *
 * @author itakenami
 */
public class Combo extends JComboBox implements FormComponent {
    
    List<Long> list;
    
    public Combo(List<? extends DefaultModel> models, String def){
        
        list = new ArrayList<Long>();
        String[] lst_itens = new String[models.size()];
        int idx = 0;
        
        for (int x=0;x<models.size();x++) {
            DefaultModel dm = models.get(x);
            list.add(dm.getId());
            lst_itens[x] = dm.toString();
            if(lst_itens[x].equals(def)){
                idx = x;
            }
        }
        
        this.setModel(new javax.swing.DefaultComboBoxModel(lst_itens));
        this.setSelectedIndex(idx);
    }

    @Override
    public Object getUserValue() {
        return list.get(this.getSelectedIndex()).toString();
    }
}
