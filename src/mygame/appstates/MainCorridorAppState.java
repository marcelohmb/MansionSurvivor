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
public class MainCorridorAppState extends RoomAppState {

    private static final float DEFAULT_WIDTH = 18f;
    private static final float DEFAULT_HEIGHT = 20f;
    private static final float DEFAULT_SIZE = 36;
    private static final Vector3f DEFAULT_LOCATION = new Vector3f(18f,0f,18f);

    
    public MainCorridorAppState() {
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_SIZE, DEFAULT_LOCATION , DEFAULT_LOCATION.add(new Vector3f(DEFAULT_WIDTH / 2f, 0f, -DEFAULT_SIZE / 2f)));
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
    }
}
