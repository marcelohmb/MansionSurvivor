/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;

/**
 *
 * @author GAMEOVER
 */
public class AnimalCagesAppState extends RoomAppState {

    public static final float DEFAULT_WIDTH = 36F;
    public static final float DEFAULT_HEIGHT = 20F;
    public static final float DEFAULT_SIZE = 18f;
    public static final Vector3f DEFAULT_POSITION = OfficeAppState.DEFAULT_POSITION
            .add(new Vector3f(0f, 0f, -OfficeAppState.DEFAULT_SIZE));
    public static final Vector3f DEFAULT_PLAYER_POSITION = Vector3f.ZERO;

    public AnimalCagesAppState() {
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_SIZE, DEFAULT_POSITION, DEFAULT_PLAYER_POSITION);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
    }
}
