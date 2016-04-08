/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import mygame.appstates.rooms.PrototypeRoom1AppState;
import mygame.appstates.rooms.MaintenanceRoom;
import mygame.appstates.rooms.MainCorridorAppState;
import mygame.appstates.rooms.OfficeAppState;
import mygame.appstates.rooms.MansionEntranceAppState;
import mygame.appstates.rooms.PowerGeneratorRoomAppState;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import mygame.appstates.rooms.AnimalCagesAppState;
import mygame.controls.DoorControl;
import mygame.controls.PlayerControl;
import mygame.javaclasses.Constants.UserData;
import mygame.tests.LightForAllEnvironment;

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

        MansionEntranceAppState mansionEntranceAppState = new MansionEntranceAppState();
        this.stateManager.attach(mansionEntranceAppState);

        LightForAllEnvironment lightForAllEnvironment = new LightForAllEnvironment();
        this.stateManager.attach(lightForAllEnvironment);
        
        ChangeRoomAppState changeRoomAppState = new ChangeRoomAppState();
        this.stateManager.attach(changeRoomAppState);
        
        gameplayInputAppState = new GameplayInputAppState();
        this.stateManager.attach(gameplayInputAppState);

        MainCorridorAppState mainCorridorAppState = new MainCorridorAppState();
        this.stateManager.attach(mainCorridorAppState);

        OfficeAppState officeAppState = new OfficeAppState();
        this.stateManager.attach(officeAppState);

        AnimalCagesAppState animalCagesAppState = new AnimalCagesAppState();
        this.stateManager.attach(animalCagesAppState);

        MaintenanceRoom maintenanceRoom = new MaintenanceRoom();
        this.stateManager.attach(maintenanceRoom);

        PowerGeneratorRoomAppState powerGeneratorRoomAppState = new PowerGeneratorRoomAppState();
        this.stateManager.attach(powerGeneratorRoomAppState);





    }

    public void loadScenarios() {
    }

    @Override
    public void update(float tpf) {
    }
}
