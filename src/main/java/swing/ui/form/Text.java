/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui.form;

import javax.swing.JTextField;

/**
 *
 * @author itakenami
 */
public class Text extends JTextField implements FormComponent{

    @Override
    public Object getUserValue() {
        return this.getText();
    }

    

    
    
}
