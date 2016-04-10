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

    public static final Vector3f ENTRANCE_DOOR_POS = new Vector3f(9f, 0f, 0.1f);
    protected Door mansionEntranceDoor;
    protected DoorControl entranceDoorControl;
    protected Geometry floor;
    protected RigidBodyControl floorPhysics;

    public Geometry getDoor() {
        return mansionEntranceDoor.getPrototypeGeometry().getGeometry();
    }

    public DoorControl getEntranceDoorControl() {
        return entranceDoorControl;
    }

    public PrototypeRoom1AppState() {
        super(0f, 0f, 0f, Vector3f.ZERO); // Outdoor measures
    }

    @Override
    public void OnEnabled() {
        super.OnEnabled();
        mansionEntranceDoor.setEnabled(true);
    }

    @Override
    public void OnDisabled() {
        super.OnDisabled();
        mansionEntranceDoor.setEnabled(false);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);

        floor = createGameFloor(assetManager, new Vector3f(0f, 0f, 10f));
        nodes.getRootNode().attachChild(nodes.getEnemyNode().getChild(Constants.UserData.FRANKESTEIN));


        DoorOrientation doorOrientation = new DoorOrientation(DoorType.OUTDOOR, Direction.HORIZONTAL);
        boolean doubleDoor = true;

        // Left door
        mansionEntranceDoor = new Door(constructionAssets, ENTRANCE_DOOR_POS, Direction.HORIZONTAL, doubleDoor);
        Geometry entranceDoorGeometry = mansionEntranceDoor.getPrototypeGeometry().getGeometry();
        DoorControl entranceSymetricDoor = stateManager.getState(MansionEntranceAppState.class).getCountryardDoor();
        entranceDoorControl = new DoorControl(entranceDoorGeometry, this, entranceSymetricDoor, doorOrientation,
                nodes.getPlayerNode());
        entranceDoorGeometry.addControl(entranceDoorControl);

        setEnabled(true);
    }
}
