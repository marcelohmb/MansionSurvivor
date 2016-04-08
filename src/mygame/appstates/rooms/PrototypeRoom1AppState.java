/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates.rooms;

import mygame.appstates.rooms.MansionEntranceAppState;
import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import mygame.appstates.RoomAppState;
import mygame.appstates.rooms.MainCorridorAppState;
import mygame.controls.DoorControl;
import mygame.javaclasses.Constants;
import mygame.enumerations.Direction;
import mygame.javaclasses.Door;
import mygame.javaclasses.DoorOrientation;
import mygame.enumerations.DoorType;

/**
 *
 * @author GAMEOVER
 */
public class PrototypeRoom1AppState extends RoomAppState {

    public static final Vector3f DEFAULT_LEFT_DOOR_POS = new Vector3f(9f, 0f, 0.1f);
    public static final Vector3f DEFAULT_RIGHT_DOOR_POS = DEFAULT_LEFT_DOOR_POS.add(
            new Vector3f(Door.DEFAULT_DOOR_WIDTH, 0f, 0f));
    protected Door leftMansionEntranceDoor, rightMansionEntranceDoor;
    protected Geometry floor;
    protected RigidBodyControl floorPhysics, playerPhysics;
    protected MansionEntranceAppState mansionEntranceAppState;

    public PrototypeRoom1AppState() {
        super(0f, 0f, 0f, Vector3f.ZERO); // Outdoor measures
    }

    @Override
    public void OnEnabled() {
        super.OnEnabled();
        leftMansionEntranceDoor.setEnabled(true);
        rightMansionEntranceDoor.setEnabled(true);
    }

    @Override
    public void OnDisabled() {
        super.OnDisabled();
        leftMansionEntranceDoor.setEnabled(false);
        rightMansionEntranceDoor.setEnabled(false);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);

        floor = createGameFloor(assetManager, new Vector3f(0f, 0f, 10f));
        nodes.getRootNode().attachChild(nodes.getEnemyNode().getChild(Constants.UserData.FRANKESTEIN));
        this.mansionEntranceAppState = stateManager.getState(MansionEntranceAppState.class);


        DoorOrientation doorOrientation = new DoorOrientation(DoorType.OUTDOOR, Direction.HORIZONTAL);

        // Left door
        leftMansionEntranceDoor = new Door(constructionAssets, DEFAULT_LEFT_DOOR_POS, Direction.HORIZONTAL);
        Spatial leftDoorSpatial = (Spatial) leftMansionEntranceDoor.getPrototypeGeometry().getGeometry();
        DoorControl leftDoorControl = new DoorControl(leftDoorSpatial, doorOrientation, nodes.getPlayerNode(),
                nodes.getDoorsNode(), mansionEntranceAppState,
                MansionEntranceAppState.DEFAULT_LEFT_DOOR_POSITION);
        leftDoorSpatial.addControl(leftDoorControl);


        // Right door
        rightMansionEntranceDoor = new Door(constructionAssets, DEFAULT_RIGHT_DOOR_POS, Direction.HORIZONTAL);
        Spatial rightDoorSpatial = (Spatial) rightMansionEntranceDoor.getPrototypeGeometry().getGeometry();
        DoorControl rightDoorControl = new DoorControl(rightDoorSpatial, doorOrientation, nodes.getPlayerNode(),
                nodes.getDoorsNode(), mansionEntranceAppState,
                MansionEntranceAppState.DEFAULT_RIGHT_DOOR_POSITION);
        rightDoorSpatial.addControl(rightDoorControl);

        setEnabled(true);
    }
}
