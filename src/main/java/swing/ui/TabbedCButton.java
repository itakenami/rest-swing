/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ui;

/**
 *
 * @author itakenami
 */
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 * User: Halil KARAKOSE Date: Jan 18, 2009 Time: 8:43:25 PM
 */
public class TabbedCButton extends JTabbedPane {
    
    private ImageIcon IMG_NORMAL = new ImageIcon(getClass().getClassLoader().getResource("swing/resource/stop_hover.png"));
    private ImageIcon IMG_LIGHT = new ImageIcon(getClass().getClassLoader().getResource("swing/resource/stop.png"));
    

    public TabbedCButton() {}
    
    
    
    public void addTab(String title, Icon icon, Component component, String tip, boolean close) {
        super.addTab(title, icon, component, tip);
        int count = this.getTabCount() - 1;
        setTabComponentAt(count, new CloseButtonTab(component, title, icon, close));
    }

    @Override
    public void addTab(String title, Icon icon, Component component, String tip) {
        addTab(title, icon, component, tip, true);
    }

    @Override
    public void addTab(String title, Icon icon, Component component) {
        addTab(title, icon, component, null);
    }

    @Override
    public void addTab(String title, Component component) {
        addTab(title, null, component);
    }
    
    public void addTab(String title, Component component, boolean close) {
        addTab(title, null, component, null, close);
    }
    
    public class CloseTab {
        
    }

    public class CloseButtonTab extends JPanel {

        private Component tab;
        private boolean close;

        public CloseButtonTab(final Component tab, String title, Icon icon, boolean close) {
            
            this.close = close;
            this.tab = tab;
            
            setOpaque(false);
            FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 2, 4);
            setLayout(flowLayout);
            setVisible(true);

            JLabel jLabel = new JLabel(title);
            jLabel.setIcon(icon);

            if (close) {
                JButton button = new JButton("");
                button.setIcon(IMG_NORMAL);
                button.setBorder(null);
                button.setContentAreaFilled(false);
                button.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JTabbedPane tabbedPane = (JTabbedPane) getParent().getParent();
                        if(tabbedPane.getTabCount() >1){
                            tabbedPane.remove(tab);
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        JButton button = (JButton) e.getSource();
                        button.setIcon(IMG_LIGHT);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        JButton button = (JButton) e.getSource();
                        button.setIcon(IMG_NORMAL);
                    }
                });
                add(button);
            }
            add(jLabel);
        }
    }
}
