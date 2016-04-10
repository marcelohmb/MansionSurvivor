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
        DoorControl doorPlayerUsing = getDoorPlayerIsUsing();
        RoomAppState roomPlayerIs = doorPlayerUsing.getDoorRoomAppState();
        roomPlayerIs.setEnabled(false);
        rootNode.detachChild(playerNode);
        DoorControl nextDoorControl = calculateSymetricDoor(doorPlayerUsing);
        RoomAppState nextRoom = nextDoorControl.getDoorRoomAppState();
        playerNode.getChild(UserData.PLAYER).setLocalTranslation(nextDoorControl.getSpatial().getLocalTranslation());
        rootNode.attachChild(playerNode);
        nextRoom.setEnabled(true);
        doorPlayerUsing.setPlayerUsingDoor(false);
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

    /**
     * Calculate corresponding door based in the orientation of the door
     */
    private DoorControl calculateSymetricDoor(DoorControl door) {

        if (door == null) {
            throw new NullPointerException("calculateSymetricDoor : argumment door is null");
        }

        DoorOrientation doorOrientation = door.getDoorOrienation();
        Vector3f symetricDoorPos = new Vector3f(door.getSpatial().getLocalTranslation().x,
                door.getSpatial().getLocalTranslation().y, door.getSpatial().getLocalTranslation().z);
        
        System.out.println("DEBUG: doorPos =" + door.getSpatial().getLocalTranslation());


        if (doorOrientation.getDoorDirection().equals(Direction.HORIZONTAL)) {
            if (doorOrientation.getDoorType().equals(DoorType.INDOOR)) {
                symetricDoorPos.setZ(symetricDoorPos.z + 0.2f); // test
            } else {
                symetricDoorPos.setZ(symetricDoorPos.z + 0.2f);
            }
        } else {
            if (doorOrientation.getDoorType().equals(DoorType.INDOOR)) {
                symetricDoorPos.setX(symetricDoorPos.x + 0.2f);
            } else {
                symetricDoorPos.setX(symetricDoorPos.x - 0.2f);
            }
        }

        System.out.println("DEBUG: symetricDoorPos =" + symetricDoorPos);

        for (Spatial child : this.rootNode.getChildren()) {
            if (child.getControl(DoorControl.class) != null
                    && child.getLocalTranslation().equals(symetricDoorPos)) {
                return child.getControl(DoorControl.class);
            }
        }
        return null;
    }

    @Override
    public void update(float tpf) {
    }
}
