/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import mygame.controls.PlayerControl;
import mygame.util.Constants;

/**
 *
 * @author GAMEOVER
 */
public class PrototypeRoom1AppState extends ScenarioAppState {

    protected Geometry floor;
    protected RigidBodyControl floorPhysics, playerPhysics;
    

    public PrototypeRoom1AppState() {
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);     

        
        floor = createGameFloor(assetManager, new Vector3f(0f, 0f, 10f));
                
        nodes.getRootNode().attachChild(nodes.getEnemyNode().getChild(Constants.UserData.FRANKESTEIN));
        
        PointLight light = new PointLight();
        light.setColor(ColorRGBA.White);
        light.setRadius(Float.POSITIVE_INFINITY);
        light.setPosition(Vector3f.ZERO);
        nodes.getRootNode().addLight(light);
    }
}
