package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.ChaseCamera;
import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.CameraControl;
import com.jme3.scene.control.CameraControl.ControlDirection;
import com.jme3.system.AppSettings;
import javax.swing.JOptionPane;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        app.setSettings(settings);
        app.start();
    }
    /**
     * To handle with game physics
     */
    private BulletAppState bulletAppState;
    private GameplayControlsAppState gameplayControlsApp;
    private CameraNode camNode;
    
    /*Give acess to all non local nodes */
    private NodesAppState nodesAppState;

    @Override
    public void simpleInitApp() {

        

        // Initialize AppState here
        nodesAppState = new NodesAppState();
        this.stateManager.attach(nodesAppState);
        bulletAppState = new BulletAppState();
        this.stateManager.attach(bulletAppState);

        // Creates game floor
        Geometry floor = new SimpleGeometry().floor(assetManager, new Vector3f(0f, -2f, 10f));
        rootNode.attachChild(floor);
        BoxCollisionShape floorShape = new BoxCollisionShape(new Vector3f(33f, 1f, 33f));
        RigidBodyControl floorPhysics = new RigidBodyControl(floorShape, 0.0f);
        floor.addControl(floorPhysics);
        bulletAppState.getPhysicsSpace().add(floorPhysics);

        // Player
        Spatial model = (Node) assetManager.loadModel("Models/Jaime/Jaime.j3o");
        PlayerControl playerControl = new PlayerControl(model);
        model.setName(UserData.PLAYER);
        model.setLocalScale(1.50f);
        model.setLocalTranslation(0f, 0f, 0f);
        nodesAppState.getPlayerNode().attachChild(model);
        BetterCharacterControl modelPhysics = new BetterCharacterControl(1.4f, 2.8f, 0.1f);
        modelPhysics.setJumpForce(Vector3f.ZERO);
        model.addControl(modelPhysics);
        model.addControl(playerControl);
        bulletAppState.getPhysicsSpace().add(modelPhysics);

        /* CHASE CAMERA SETTINGS
         * 
         flyCam.setEnabled(false);
         ChaseCamera chaseCam = new ChaseCamera(cam, model, inputManager);
         chaseCam.setDragToRotate(false);
         chaseCam.setSmoothMotion(true);
         chaseCam.setTrailingEnabled(true);
         chaseCam.setInvertHorizontalAxis(true);
         chaseCam.setInvertVerticalAxis(true);
         chaseCam.setDefaultDistance(25f);
         chaseCam.setLookAtOffset(new Vector3f(0f,7.5f , 0f));
         chaseCam.setRotationSensitivity(5f);
         chaseCam.setDefaultHorizontalRotation(0f);
         chaseCam.setDefaultVerticalRotation(0f);
         */

        // CameraNode
        flyCam.setEnabled(false);
        camNode = new CameraNode(UserData.CAMERA_NODE, cam);
        camNode.setControlDir(ControlDirection.SpatialToCamera);
        nodesAppState.getPlayerNode().attachChild(camNode);
        camNode.setLocalTranslation(0f, 20f, -5f);
        camNode.lookAt(model.getLocalTranslation(), new Vector3f(0f, 0f, 0f));




        // Frankestein
        Node frankestein = (Node) assetManager.loadModel("Models/Ninja/Ninja.mesh.xml");
        frankestein.scale(0.025f, 0.025f, 0.025f);
        rootNode.attachChild(frankestein);
        UserData.setMeasures(frankestein, new Measures(1f, 2f, 2f));
        frankestein.addControl(new SimpleChaseControl(frankestein, playerControl));
        frankestein.getControl(SimpleChaseControl.class).setChase(true);
        frankestein.setLocalTranslation(0f, 0f, 10f);
        BetterCharacterControl frankesteinPhysics = new BetterCharacterControl(0.9f, 1.8f, 0.1f);
        frankesteinPhysics.setJumpForce(Vector3f.ZERO);
        frankestein.addControl(frankesteinPhysics);
        bulletAppState.getPhysicsSpace().add(frankesteinPhysics);

        gameplayControlsApp = new GameplayControlsAppState();
        this.stateManager.attach(gameplayControlsApp);

        // Adding a light light to make 3d models visible
        PointLight light = new PointLight();
        light.setColor(ColorRGBA.White);
        light.setRadius(Float.POSITIVE_INFINITY);
        light.setPosition(Vector3f.ZERO);
        rootNode.addLight(light);

    }

    @Override
    public void simpleUpdate(float tpf) {

        /*float x = Float.parseFloat(JOptionPane.showInputDialog("x ="));
         float y = Float.parseFloat(JOptionPane.showInputDialog("y ="));
         float z = Float.parseFloat(JOptionPane.showInputDialog("z ="));
         camNode.lookAt(playerNode.getChild(UserData.PLAYER).getLocalTranslation(), 
         new Vector3f(x, y, z));
         JOptionPane.showMessageDialog(null, "There is the result!");
         * 
 
         */    }

    @Override
    public void simpleRender(RenderManager rm) {
    }
}
