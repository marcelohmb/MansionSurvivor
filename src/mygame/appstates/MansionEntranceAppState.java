/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import mygame.util.Constants;
/**
 *
 * @author GAMEOVER
 */
public class MansionEntranceAppState extends RoomAppState {
    
    
    public static final float DEFAULT_WIDTH = 36f;
    public static final float DEFAULT_HEIGHT = 20f;
    public static final float DEFAULT_SIZE = 18f;
    public static final Vector3f DEFAULT_POSITION = Vector3f.ZERO;
    public static final Vector3f DEFAULT_PLAYER_POSITION = new Vector3f(5f, 0f, -5f);

    public MansionEntranceAppState() {
       super(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_SIZE, DEFAULT_POSITION, DEFAULT_PLAYER_POSITION);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
    }
}
