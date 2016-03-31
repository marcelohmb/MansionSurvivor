/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author GAMEOVER
 */
public class MainCorridorAppState extends ScenarioAppState {

    float roomWidth = 9f;
    float roomSize = 9f;
    float roomHeight = 20f;
    Node room;
    Vector3f roomLeftExtremetiy = new Vector3f(9f, 0f, -9f);

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        room = createARoom(assetManager, roomWidth, roomHeight, roomSize, roomLeftExtremetiy);
    }
}
