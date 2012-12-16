/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.model;

import client.exception.ValidationException;
import java.util.HashMap;
import java.util.List;
import swing.ui.ModelField;

/**
 *
 * @author itakenami
 */
public interface DefaultModel<T> {
    
    public List<T> findStart();
    public T findById(Long id);
    public T save(Long id, HashMap<String, Object> map) throws ValidationException;
    public boolean delete(Long id);
    public List<T> filterGrid(String filter);
    
    public ModelField getGridFields();
    public ModelField getViewFields();
    public Long getId();
    
    @Override
    public String toString();
    public List<? extends DefaultModel> getObj(String campo);
    
}
