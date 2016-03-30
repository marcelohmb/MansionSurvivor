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
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.scene.shape.StripBox;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import mygame.util.Constants;
import mygame.util.Direction;

/**
 *
 * @author GAMEOVER
 */
public class MansionEntranceAppState extends ScenarioAppState {

    float roomWidth = 18f;
    float roomSize = 9f;
    float roomHeight = 50f;
    Vector3f roomLeftExtreme = new Vector3f(0f, 0f, 0f);
    Node room;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);

        playerNode.getChild(Constants.UserData.PLAYER).setLocalTranslation(0f, 0f, 10f);
        room = createRoom(assetManager, roomWidth, roomHeight, roomSize, roomLeftExtreme);
    }
}
