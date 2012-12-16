/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JList;
import swing.model.DefaultModel;

/**
 *
 * @author itakenami
 */
public class ListBox extends JList implements FormComponent {
    
    List<Long> list;
    
    public ListBox(List<? extends DefaultModel> models, HashMap<String, Boolean> def){
        
        list = new ArrayList<Long>();
        String[] lst_itens = new String[models.size()];
        int[] idx = new int[def.size()];
        int c_idx=0;
        
        for (int x=0;x<models.size();x++) {
            DefaultModel dm = models.get(x);
            list.add(dm.getId());
            lst_itens[x] = dm.toString();
            if (def.containsKey(lst_itens[x])){
                idx[c_idx] = x;
                c_idx++;
            }
        }
        
        this.setModel(new javax.swing.DefaultComboBoxModel(lst_itens));
        this.setSelectedIndices(idx);
    }
    
    /*
    public String[] getValue(){
        
        int[] idx_selected = this.getSelectedIndices();
        String[] sel = new String[idx_selected.length];
        
        for(int x=0;x<idx_selected.length;x++){
            sel[x] = list.get(idx_selected[x]).toString();
        }
        
        return sel;
    }*/

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
