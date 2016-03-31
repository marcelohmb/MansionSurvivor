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

    public MansionEntranceAppState() {
        super(36f, 20f, 18f, Vector3f.ZERO, new Vector3f(5f, 0f, -5f));
       
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
    }
}
