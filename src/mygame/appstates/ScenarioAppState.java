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
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

/**
 *
 * @author GAMEOVER
 */
public class ScenarioAppState extends AbstractAppState {

    protected NodesAppState nodes;
    protected AppStateManager stateManager;
    protected BulletAppState bulletAppState;
    protected AssetManager assetManager;
    protected Spatial player;

    public ScenarioAppState() {
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        SimpleApplication simpleApp = (SimpleApplication) app;
        nodes = stateManager.getState(NodesAppState.class);
        bulletAppState = stateManager.getState(BulletAppState.class);
        this.stateManager = stateManager;
        assetManager = simpleApp.getAssetManager();
        player = nodes.getPlayerNode();
    }
    
     public static Geometry createAFloor(AssetManager assetManager,Vector3f pos){
        Box floorBox = new Box(33f, 1f, 33f);
        Geometry floor = new Geometry("floor", floorBox);
        Material orangeMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        orangeMat.setColor("Color", ColorRGBA.Orange);
        floor.setMaterial(orangeMat);    
        floor.setLocalTranslation(pos);
        return floor;
    }
}
