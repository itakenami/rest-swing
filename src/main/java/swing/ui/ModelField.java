package swing.ui;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itakenami
 */
public class ModelField {
    
    public static final int TEXT = 1;
    public static final int COMBO = 2;
    public static final int LISTBOX = 3;
    public static final int DATE = 4;
    
    private List<Field> fields;
    
    public class Field {
        
        String header;
        Object field;
        int type;
        
        public Field(String header, Object field, int type){
            this.header = header;
            this.field = field;
            this.type = type;
        }
        public Field(String header, Object field){
            this.header = header;
            this.field = field;
            this.type = TEXT;
        }
    }
    
    public int getPreferedHeight(){
        int val = 145;
        for (Field field : fields) {
            if(field.type==LISTBOX){
                val+=100;
            }else{
                val+=38;
            }
        }
        return val;
    }
    
    public ModelField(){
        fields = new ArrayList<ModelField.Field>();
    }
    
    public void addField(String header, Object field){
        fields.add(new Field(header,field));
    }
    
    public void addField(String header, Object field, int type){
        fields.add(new Field(header,field,type));
    }
    
    public void addField(Object field){
        fields.add(new Field("",field));
    }
    
    public String[] getFields(){
        String[] flds = new String[fields.size()];
        for(int x=0;x<flds.length;x++){
            flds[x] = fields.get(x).field==null?"":fields.get(x).field.toString();
        }
        return flds;
    }
    
    
    public List<Field> getListFields(){
        return fields;
    }
    
    
    
    
}


