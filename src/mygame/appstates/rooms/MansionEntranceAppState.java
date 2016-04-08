/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates.rooms;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import mygame.appstates.RoomAppState;
import mygame.javaclasses.Constants;

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
    public static final Vector3f DEFAULT_LEFT_DOOR_POSITION = PrototypeRoom1AppState.DEFAULT_LEFT_DOOR_POS
            .add(0F, 0F, 2F);
    public static final Vector3f DEFAULT_RIGHT_DOOR_POSITION = PrototypeRoom1AppState.DEFAULT_RIGHT_DOOR_POS
            .add(0F, 0F, 2F);

    public MansionEntranceAppState() {
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_SIZE, DEFAULT_POSITION);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        setEnabled(true);
    }

    @Override
    public void OnDisabled() {
        super.OnDisabled();
    }

    @Override
    public void OnEnabled() {
        super.OnEnabled();
    }
}
