/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author itakenami
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GridHeader { 
    String name();
    int size();
}
