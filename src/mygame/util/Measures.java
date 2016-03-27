/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.util;

import mygame.util.Constants;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.Savable;
import com.jme3.scene.Spatial;
import java.io.IOException;

/**
 *
 * @author GAMEOVER
 */
public class Measures implements Savable {

    private float x, y, z;

    public Measures(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void setMeasures(Spatial s, Measures m) {
        s.setUserData(Constants.UserData.MEASURES, m);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void write(JmeExporter ex) throws IOException {
    }

    public void read(JmeImporter im) throws IOException {
    }
}
