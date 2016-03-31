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
public class MansionEntranceAppState extends RoomAppState {

    public MansionEntranceAppState() {
        //super(18f, 10f, 9f, Vector3f.ZERO, new Vector3f(0f, 0f, 0f));
        super(18f, 30f, 9f , Vector3f.ZERO, Vector3f.ZERO);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
    }
}
