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
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author GAMEOVER
 */
public class BeginGameAppState extends AbstractAppState {

    PrototypeRoom1AppState prototypeRoom1AppState;
    NodesAppState nodesAppState;
    CharactersAppState charactersAppState;
    AppStateManager stateManager;
    GameplayInputAppState gameplayInputAppState;
    CameraAppState cameraAppState;
    AssetManager assetManager;
    BulletAppState bulletAppState;

    public BeginGameAppState() {
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.stateManager = stateManager;
        SimpleApplication simpleApp = (SimpleApplication) app;
        assetManager = simpleApp.getAssetManager();

        bulletAppState = new BulletAppState();
        this.stateManager.attach(bulletAppState);

        nodesAppState = new NodesAppState();
        this.stateManager.attach(nodesAppState);

        charactersAppState = new CharactersAppState();
        this.stateManager.attach(charactersAppState);
        
        cameraAppState = new CameraAppState();
        this.stateManager.attach(cameraAppState);
            
        prototypeRoom1AppState = new PrototypeRoom1AppState();
        this.stateManager.attach(prototypeRoom1AppState);
        
        //MansionEntranceAppState mansionEntranceAppState = new MansionEntranceAppState();
        //this.stateManager.attach(mansionEntranceAppState);
        
        MainCorridorAppState mainCorridorAppState = new MainCorridorAppState();
        this.stateManager.attach(mainCorridorAppState);

        gameplayInputAppState = new GameplayInputAppState();
        this.stateManager.attach(gameplayInputAppState);
        
    }
    
    

    @Override
    public void update(float tpf) {

    }
}
