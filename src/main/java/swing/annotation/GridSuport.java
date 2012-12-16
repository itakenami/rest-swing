/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import swing.model.DefaultModel;

/**
 *
 * @author itakenami
 */
public class GridSuport {
    
    private static GridSuport instance;
    
    private GridSuport(){}
    
    public static GridSuport getInstance(){
        if(instance==null){
            instance = new GridSuport();
        }
        return instance;
    }
    
    public javax.swing.table.DefaultTableModel getGridModel(){
        
        final Class[] classesHeader = {String.class};
        
        return new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },new String[]{""}) {
            Class[] types = classesHeader;
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;//canEdit [columnIndex];
            }
        };
    }
    
    public javax.swing.table.DefaultTableModel getGridModel(DefaultModel classe){
        
        ArrayList<String> titulos = new ArrayList<String>();
        Field[] campos = classe.getClass().getFields();
        
        for(int x=0;x<campos.length;x++){
            if(campos[x].isAnnotationPresent(GridHeader.class)){
                GridHeader gh = campos[x].getAnnotation(GridHeader.class);
                titulos.add(gh.name());
            }
        }
        
        final Class[] classesHeader = new Class[titulos.size()];
        for(int x=0;x<classesHeader.length;x++){
            classesHeader[x] = java.lang.String.class;
        }
        
        return new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },titulos.toArray()) {
            Class[] types = classesHeader;
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;//canEdit [columnIndex];
            }
        };
    }
    
    
    
    public int[] getGridWidth(DefaultModel classe){
        
        ArrayList<Integer> titulos = new ArrayList<Integer>();
        Field[] campos = classe.getClass().getFields();
        
        for(int x=0;x<campos.length;x++){
            if(campos[x].isAnnotationPresent(GridHeader.class)){
                GridHeader gh = campos[x].getAnnotation(GridHeader.class);
                titulos.add(gh.size());
            }
        }
        
        int[] widths = new int[titulos.size()];
        
        for(int x=0;x<widths.length;x++){
            widths[x] = titulos.get(x);
        }
        
        return widths;
        
    }
    
}
