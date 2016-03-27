/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import mygame.appstates.CameraAppState;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import mygame.util.Constants;
import mygame.util.Measures;
import mygame.controls.PlayerControl;
import mygame.controls.SimpleChaseControl;

/**
 *
 * @author GAMEOVER
 */
public class CharactersAppState extends AbstractAppState {
    
    private AssetManager assetManager;
    private BulletAppState bulletAppState;
    private NodesAppState nodesAppState;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        SimpleApplication simpleApp = (SimpleApplication) app;
        assetManager = simpleApp.getAssetManager();
        bulletAppState = stateManager.getState(BulletAppState.class);
        nodesAppState = stateManager.getState(NodesAppState.class);
        
        // Player
        Spatial player = (Node) assetManager.loadModel("Models/Jaime/Jaime.j3o");
        PlayerControl playerControl = new PlayerControl(player);
        player.setName(Constants.UserData.PLAYER);
        player.setLocalScale(1.50f);
        player.setLocalTranslation(0f, 0f, 0f);
        BetterCharacterControl playerPhysics = new BetterCharacterControl(1.4f, 2.8f, 0.1f);
        playerPhysics.setJumpForce(Vector3f.ZERO);
        player.addControl(playerPhysics);
        player.addControl(playerControl);
        bulletAppState.getPhysicsSpace().add(playerPhysics);
        nodesAppState.getPlayerNode().attachChild(player);
        nodesAppState.getRootNode().attachChild(nodesAppState.getPlayerNode()); // Use this to show things in scene
        CameraAppState cameraAppState = stateManager.getState(CameraAppState.class);
        cameraAppState.setTarget(player);

        // Frankestein
        Node frankestein = (Node) assetManager.loadModel("Models/Ninja/Ninja.mesh.xml");
        frankestein.setName(Constants.UserData.FRANKESTEIN);
        frankestein.scale(0.025f, 0.025f, 0.025f);
        Measures.setMeasures(frankestein, new Measures(1f, 2f, 2f));
        frankestein.addControl(new SimpleChaseControl(frankestein, playerControl));
        frankestein.getControl(SimpleChaseControl.class).setChase(true);
        frankestein.setLocalTranslation(0f, 0f, 10f);
        BetterCharacterControl frankesteinPhysics = new BetterCharacterControl(0.9f, 1.8f, 0.1f);
        frankesteinPhysics.setJumpForce(Vector3f.ZERO);
        frankestein.addControl(frankesteinPhysics);
        bulletAppState.getPhysicsSpace().add(frankesteinPhysics);
        nodesAppState.getEnemyNode().attachChild(frankestein);
    }
}