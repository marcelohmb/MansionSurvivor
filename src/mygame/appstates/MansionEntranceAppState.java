/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.collision.shapes.PlaneCollisionShape;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Quad;

/**
 *
 * @author GAMEOVER
 */
public class MansionEntranceAppState extends ScenarioAppState {
    
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        
        player.setLocalTranslation(12f, 2f, -12f);
     
        
        Geometry topWall = createWall(assetManager, 18f, 20f, new Vector3f(0f,10f, 0f), 
                new Vector3f(0f, 0f, 0f));
        
        Geometry leftWall = createWall(assetManager, 9f, 20f, new Vector3f(18f,10f, -9f), 
                new Vector3f(0f, FastMath.DEG_TO_RAD * 90f, 0f)); 
        
        Geometry bottomWall = createWall(assetManager, 18f, 20f, new Vector3f(0f, 10f, -18f),
                new Vector3f(0f, 0f, 0f));
        
        Geometry rightWall = createWall(assetManager, 9f, 20f, new Vector3f(-18f, 10f, -9f),
                new Vector3f(0f, FastMath.DEG_TO_RAD * 90f, 0f));
       
                
             

    } 
}
