/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 * @author GAMEOVER
 */
public class SimpleGeometry {
    public Geometry floor(AssetManager assetManager,Vector3f pos){
        Box floorBox = new Box(33f, 1f, 33f);
        Geometry floor = new Geometry("floor", floorBox);
        Material orangeMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        orangeMat.setColor("Color", ColorRGBA.Orange);
        floor.setMaterial(orangeMat);    
        floor.setLocalTranslation(pos);
        return floor;
    }
}
