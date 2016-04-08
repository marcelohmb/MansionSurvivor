/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.javaclasses;

import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.Savable;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author GAMEOVER
 * Allows set the array list in spatial user data
 */
public class MyArrayList<T> extends ArrayList<T> implements Savable {

    public void write(JmeExporter ex) throws IOException {
    }

    public void read(JmeImporter im) throws IOException {

    }

    
}
