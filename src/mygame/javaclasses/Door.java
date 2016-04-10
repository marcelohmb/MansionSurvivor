/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.javaclasses;

import mygame.enumerations.Direction;
import com.jme3.asset.AssetManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import mygame.appstates.RoomAppState;
import mygame.controls.DoorControl;
import mygame.interfaces.IEnable;

/**
 *
 * @author GAMEOVER
 */
public class Door implements IEnable {

    private Wall prototypeGeometry;
    private boolean enabled;
    
    
    public Wall getPrototypeGeometry() {
        return prototypeGeometry;
    }
    public static final float DEFAULT_DOOR_WIDTH = 2.5F;
    public static final float DEFAULT_DOOR_HEIGHT = 5f;

    public Door(ConstructionAssets constructionAssets, Vector3f position, Direction dir) {
        prototypeGeometry = new Wall(constructionAssets, DEFAULT_DOOR_WIDTH, DEFAULT_DOOR_HEIGHT, position, dir);
        prototypeGeometry.getGeometry().getMaterial().setColor("Color", ColorRGBA.Brown);
    }
    
    public Door(ConstructionAssets constructionAssets, Vector3f position, Direction dir, boolean doubleDoors) {
        float customWidth;
        if(doubleDoors){
            customWidth = DEFAULT_DOOR_WIDTH * 2f;
        }
        else{
            customWidth = DEFAULT_DOOR_WIDTH;
        }
        prototypeGeometry = new Wall(constructionAssets, customWidth, DEFAULT_DOOR_HEIGHT, position, dir);
        prototypeGeometry.getGeometry().getMaterial().setColor("Color", ColorRGBA.Brown);
    }    
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
        if(enabled){
            prototypeGeometry.setEnabled(true);
        }
        else{
            prototypeGeometry.setEnabled(false);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }
}
