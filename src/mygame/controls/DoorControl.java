/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.controls;

import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import mygame.appstates.RoomAppState;
import mygame.javaclasses.Constants.UserData;
import mygame.enumerations.Direction;
import mygame.enumerations.DoorType;
import mygame.javaclasses.DoorOrientation;
import mygame.javaclasses.Constants.PlayerOptions;

/**
 *
 * @author GAMEOVER
 */
public class DoorControl extends AbstractControl {

    /**
     * Max distance to be able to enter in the door
     */
    public static final float MAX_DISTANCE = 2f;
    /**
     * Store the results of collision of the ray
     */
    private CollisionResults collisionResults;
    /**
     * Tells at what directino the ray will go
     */
    private Vector3f rayDirection;
    /**
     * Ray that will be dispared in order to detect objects next at door
     */
    private Ray ray;
    /**
     * The player node is the only node that contains things that can enter in
     * the room
     */
    private Node playerNode;
    /**
     * The door node will be filled with DoorControls in order to be used my
     * ChangeRoomAppState
     */
    private Node doorsNode;
    /**
     * Indicate what room this door pertains. Used to load the room
     */
    private RoomAppState myRoomAppState;
    /**
     * Tells to what other side door this door correspond *
     */
    private DoorControl correspondentDoor;

    public DoorControl getCorrespondentDoor() {
        return correspondentDoor;
    }
    
    public void setCorrespondentDoor(DoorControl d){
      spatial.setUserData(UserData.CORRESPONDENT_DOOR, d);
    }

    private void setDoorRoomAppState(RoomAppState room) {
        spatial.setUserData(UserData.ROOM_APP, ray);
    }

    public RoomAppState getDoorRoomAppState() {
        return spatial.getUserData(UserData.ROOM_APP);
    }

    private String getDoorType() {
        return spatial.getUserData(UserData.DOOR_TYPE);
    }

    private void setDoorType(String doorType) {
        spatial.setUserData(UserData.DOOR_TYPE, doorType);
    }

    private String getDirection() {
        return spatial.getUserData(UserData.DIRECTION);
    }

    private void setDirection(String direction) {
        spatial.setUserData(UserData.DIRECTION, direction);
    }
    
    /** Create a door control
     * @param door spatial that the control will be added
     @param doorRoom the room of the current door
     @param doorCorrespondent is the door in the other side of this door
     @param orientation gives the orientation for where the ray will be launched
     @param playerNode receive a reference of the player node in order to check the player pos
     @param doorsNode gives a reference to the doorsNode in order to set this door in there*/
    public DoorControl(Spatial door, RoomAppState doorRoom, DoorControl doorCorrespondent,
            DoorOrientation orientation, Node playerNode, Node doorsNode) {
        this.spatial = door;
        collisionResults = new CollisionResults();
        setDoorType(orientation.getDoorType());
        setDirection(orientation.getDoorDirection());
        setDoorRoomAppState(doorRoom);
        this.playerNode = playerNode;
        this.doorsNode = doorsNode;

        doorsNode.attachChild(door);

        rayDirection = new Vector3f();

        if (getDirection().equals(Direction.HORIZONTAL.toString())) {

            if (getDoorType().equals(DoorType.INDOOR.toString())) {
                rayDirection.setZ(-1f);
            } else {
                rayDirection.setZ(1f);
            }
        } else {
            if (getDoorType().equals(DoorType.INDOOR.toString())) {
                rayDirection.setX(1f);
            } else {
                rayDirection.setZ(-1f);
            }
        }

    }

    @Override
    protected void controlUpdate(float tpf) {
        if (enabled) {
            ray = new Ray(spatial.getLocalTranslation().add(new Vector3f(0f, -1f, 0f)), rayDirection);
            playerNode.collideWith(ray, collisionResults);
            if (collisionResults.getClosestCollision() != null) {
                if (collisionResults.getClosestCollision().getDistance() <= MAX_DISTANCE) {
                    // System.out.println("DOOR: Im' seeing" + collisionResults.getClosestCollision().getGeometry().getName());
                    playerNode.getChild(UserData.PLAYER).getControl(PlayerControl.class).getListOfPlayerOptions()
                            .add(PlayerOptions.OPEN_DOOR);
                }
            }
            collisionResults.clear();
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
}
