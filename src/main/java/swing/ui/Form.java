/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui;

import javax.swing.JFrame;

/**
 *
 * @author itakenami
 */
public abstract class Form extends javax.swing.JDialog {
    
    public static boolean SHOW;
    
    public Form(JFrame frame, boolean modal){
        super(frame, modal);
    }
    
    public void showForm(){
        if(!DefaultForm.SHOW){
            DefaultForm.SHOW = true;
            setVisible(true);
        }    
    }
    
    public void closeForm(){
        DefaultForm.SHOW = false;
        setVisible(false);
    }
}
