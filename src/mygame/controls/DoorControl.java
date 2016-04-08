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
    private CollisionResults collisionResults;
    private Vector3f rayDirection;
    private Ray ray;
    private RoomAppState nextRoom;
    private Vector3f nextPosition;
    private boolean isCloseToDoor;

    public boolean isCloseToDoor() {
        return isCloseToDoor;
    }

    
    private Node playerNode;
    private Node doorsNode;

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

    public DoorControl(Spatial door, DoorOrientation orientation, Node playerNode,
            Node doorsNode, RoomAppState nextRoom, Vector3f nextPosition) {
        this.spatial = door;
        collisionResults = new CollisionResults();
        setDoorType(orientation.getDoorType());
        setDirection(orientation.getDoorDirection());
        rayDirection = new Vector3f();
        this.playerNode = playerNode;
        this.nextRoom = nextRoom;
        this.isCloseToDoor = false;
        this.doorsNode = doorsNode;

        doorsNode.attachChild(door);

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
                    System.out.println("DOOR: Im' seeing" + collisionResults.getClosestCollision().getGeometry().getName());
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
