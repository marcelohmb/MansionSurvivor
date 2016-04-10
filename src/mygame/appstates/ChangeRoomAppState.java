/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.SceneGraphVisitor;
import com.jme3.scene.Spatial;
import mygame.controls.DoorControl;
import mygame.enumerations.Direction;
import mygame.enumerations.DoorType;
import mygame.javaclasses.Constants;
import mygame.javaclasses.Constants.UserData;
import mygame.javaclasses.DoorOrientation;

/**
 *
 * @author GAMEOVER
 */
public class ChangeRoomAppState extends AbstractAppState {

    private Node rootNode;
    private Node playerNode;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        NodesAppState nodesAppState = stateManager.getState(NodesAppState.class);
        this.rootNode = nodesAppState.getRootNode();
        this.playerNode = nodesAppState.getPlayerNode();
    }

    /**
     * Change the room based in the door that player is using
     */
    public void changeRoom() {
        DoorControl playerUsingDoor = getDoorPlayerIsUsing();
        RoomAppState currentRoom = playerUsingDoor.getDoorRoomAppState();
        RoomAppState nextRoom = playerUsingDoor.getSymetricDoor().getDoorRoomAppState();
        
        playerUsingDoor.setEnabled(false);
        
        currentRoom.setEnabled(false);
        rootNode.detachChild(playerNode);
        nextRoom.setEnabled(true);
        rootNode.attachChild(playerNode);
       
        
    }
    
  
    

    private DoorControl getDoorPlayerIsUsing() {
        for (Spatial child : this.rootNode.getChildren()) {
            if (child.getControl(DoorControl.class) != null) {
                if (child.getControl(DoorControl.class).isPlayerUsingDoor()) {
                    return child.getControl(DoorControl.class);
                }
            }
        }
        return null;
    }


    @Override
    public void update(float tpf) {
    }
}
