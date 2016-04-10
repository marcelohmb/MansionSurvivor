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
import com.jme3.scene.Spatial;
import mygame.controls.DoorControl;
import mygame.enumerations.Direction;
import mygame.enumerations.DoorType;
import mygame.javaclasses.DoorOrientation;

/**
 *
 * @author GAMEOVER
 */
public class ChangeRoomAppState extends AbstractAppState {

    private Node doorsNode;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        NodesAppState nodesAppState = stateManager.getState(NodesAppState.class);
        this.doorsNode = nodesAppState.getDoorsNode();

    }

    /**
     * Change the room based in the door that player is using
     */
    public void changeRoom() {
        DoorControl doorPlayerUsing = getDoorPlayerIsUsing();
        DoorControl nextDoorControl = calculateSymetricDoor(doorPlayerUsing);
        RoomAppState nextRoom = nextDoorControl.getDoorRoomAppState();
        changeRoom(nextRoom);
        doorPlayerUsing.setPlayerUsingDoor(false);
    }
    
    private DoorControl getDoorPlayerIsUsing(){
        for(Spatial door : doorsNode.getChildren()){
            if(door.getControl(DoorControl.class).isPlayerUsingDoor()){
                return door.getControl(DoorControl.class);
            }
        }
        return null;
    }
    
    
    

    /**
     * Change the room based in the next room to be present*
     */
    private void changeRoom(RoomAppState nextRoom) {
        if (nextRoom == null) {
            throw new NullPointerException("changeRoom: door is null");
        }
        System.out.println("DEBUG: YES, I CHANGED THE ROOMS!");
        
    }

    /**
     * Calculate corresponding door based in the orientation of the door
     */
    private DoorControl calculateSymetricDoor(DoorControl door) {
        
        if(door == null){
            throw new NullPointerException("calculateSymetricDoor : argumment door is null");
        }

        DoorOrientation doorOrientation = door.getDoorOrienation();
        Vector3f symetricDoorPos = new Vector3f(door.getSpatial().getLocalTranslation());

        if (doorOrientation.getDoorDirection().equals(Direction.HORIZONTAL)) {
            if (doorOrientation.getDoorType().equals(DoorType.INDOOR)) {
                symetricDoorPos.add(new Vector3f(0f, 0f, -0.2f));
            } else {
                symetricDoorPos.add(new Vector3f(0f, 0f, 0.2f));
            }
        } else {
            if (doorOrientation.getDoorType().equals(DoorType.INDOOR)) {
                symetricDoorPos.add(new Vector3f(0.2f, 0f, 0f));
            } else {
                symetricDoorPos.add(new Vector3f(0.2f, 0f, 0f));
            }
        }
        
        System.out.println("DEBUG: symetricDoorPos =" + symetricDoorPos);

        for (Spatial child : doorsNode.getChildren()) {
            if (child.getLocalTranslation().equals(symetricDoorPos)) {
                Geometry childGeometry = (Geometry) child;
                return childGeometry.getControl(DoorControl.class);
            }
        }
        return null;
    }

    Integer test = null;
    
    @Override
    public void update(float tpf) {
        
        if(test == null){
            test = new Integer(doorsNode.getChildren().size());
            System.out.println("size = " +  test);
        }
        
        if(doorsNode.getChildren().size() != test){
            test = new Integer(doorsNode.getChildren().size());
            System.out.println("size = " +  test);
        }
        
    }
}
