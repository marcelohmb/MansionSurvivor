/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.PlaneCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.scene.shape.StripBox;

/**
 *
 * @author GAMEOVER
 */
public class ScenarioAppState extends AbstractAppState {

    protected static NodesAppState nodes;
    protected static AppStateManager stateManager;
    protected static BulletAppState bulletAppState;
    protected static AssetManager assetManager;
    protected Node playerNode;
    public static final Vector3f FLOOR_MEASURES = new Vector3f(200F, 0f, 200f);

    public ScenarioAppState() {
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        SimpleApplication simpleApp = (SimpleApplication) app;
        nodes = stateManager.getState(NodesAppState.class);
        bulletAppState = stateManager.getState(BulletAppState.class);
        ScenarioAppState.stateManager = stateManager;
        assetManager = simpleApp.getAssetManager();
        playerNode = nodes.getPlayerNode();
    }

    protected static Geometry createAFloor(AssetManager assetManager, Vector3f pos) {
        Box floorBox = new Box(FLOOR_MEASURES.x, FLOOR_MEASURES.y,FLOOR_MEASURES.z);
        Geometry floor = new Geometry("floor", floorBox);
        Material orangeMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        orangeMat.setColor("Color", ColorRGBA.Orange);
        floor.setMaterial(orangeMat);
        floor.setLocalTranslation(pos);
        BoxCollisionShape floorShape = new BoxCollisionShape(new Vector3f(FLOOR_MEASURES.x, 
                FLOOR_MEASURES.y, FLOOR_MEASURES.z));
        RigidBodyControl floorPhysics = new RigidBodyControl(floorShape, 0.0f);
        floor.addControl(floorPhysics);
        bulletAppState.getPhysicsSpace().add(floorPhysics);
        nodes.getRootNode().attachChild(floor);
        return floor;
    }

    protected static Geometry createWall(AssetManager assetManager, float width, float height, Vector3f pos, Vector3f r) {

        Box wallShape = new Box(width / 2, height / 2, 0f);
        Geometry wall = new Geometry("wall", wallShape);
        Material wallMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        wallMat.setColor("Color", ColorRGBA.White);
        wall.setMaterial(wallMat);
        wall.setLocalTranslation(pos.add(new Vector3f(width / 2, height / 2, 0f)));
        wall.rotate(r.x, r.y, r.z);
        BoxCollisionShape wallCollisionShape = new BoxCollisionShape(new Vector3f(width / 2, height / 2, 0f));
        RigidBodyControl wallPhysics = new RigidBodyControl(wallCollisionShape, 0.0f);
        wall.addControl(wallPhysics);
        bulletAppState.getPhysicsSpace().add(wallPhysics);
        nodes.getRootNode().attachChild(wall);
        return wall;
    }
    
    protected static Geometry createRoom(AssetManager assetManager, float width, float height, float size, Vector3f pos){
        Box roomShape = new Box(width,height,size);
        Geometry room = new Geometry("room", roomShape);
        room.setLocalTranslation(Vector3f.ZERO);
        Material roomMat = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        roomMat.setColor("Color", ColorRGBA.White);
        room.setMaterial(roomMat);
        room.setLocalTranslation(pos);
        BoxCollisionShape roomCollisionShape = new BoxCollisionShape(new Vector3f(width, height, size));
        RigidBodyControl roomPhysics = new RigidBodyControl(roomCollisionShape, 0.0f);
        room.addControl(roomPhysics);
        bulletAppState.getPhysicsSpace().add(roomPhysics);
        nodes.getRootNode().attachChild(room);
        return room;
    }
    
    
}
