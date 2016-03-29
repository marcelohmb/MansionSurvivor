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
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.scene.shape.StripBox;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import mygame.util.Constants;

/**
 *
 * @author GAMEOVER
 */
public class MansionEntranceAppState extends ScenarioAppState {

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);

        playerNode.getChild(Constants.UserData.PLAYER).setLocalTranslation(0f, 0f, 10f);
        
        float width = 18f;
        float size = 9f;
        float height = 50f;
        
        Geometry mansionEntrance = createRoom(assetManager, width, height, size, new Vector3f(0f, 0f, 5f));

      


        /*
        Geometry topWall = createWall(assetManager, 18f, 20f, new Vector3f(0f, 10f, 0f),
                new Vector3f(0f, 0f, 0f));

        Geometry leftWall = createWall(assetManager, 9f, 20f, new Vector3f(18f, 10f, -9f),
                new Vector3f(0f, FastMath.DEG_TO_RAD * 90f, 0f));

        Geometry bottomWall = createWall(assetManager, 18f, 20f, new Vector3f(0f, 10f, -18f),
                new Vector3f(0f, 0f, 0f));

        Geometry rightWall = createWall(assetManager, 9f, 20f, new Vector3f(-18f, 10f, -9f),
                new Vector3f(0f, FastMath.DEG_TO_RAD * 90f, 0f));

                */


    }
}
