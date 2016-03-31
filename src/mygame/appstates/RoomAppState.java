/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import mygame.util.Constants;

/**
 *
 * @author GAMEOVER
 */
public abstract class RoomAppState extends ScenarioAppState {
    
    protected float roomWidth;
    protected float roomSize;
    protected float roomHeight;
    protected Node room;
    protected Vector3f roomLeftExtreme;
    protected Vector3f roomPlayerPosition;

    public RoomAppState(float roomWidth, float roomHeight, float roomSize,  Vector3f roomLeftExtreme,
            Vector3f playerPos) {
        this.roomWidth = roomWidth;
        this.roomHeight = roomHeight;
        this.roomSize = roomSize;
        this.roomLeftExtreme = roomLeftExtreme;
        this.roomPlayerPosition = playerPos;
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        playerNode.getChild(Constants.UserData.PLAYER).setLocalTranslation(roomPlayerPosition);
        room = createARoom(assetManager, roomWidth, roomHeight, roomSize, roomLeftExtreme);
    }
}
