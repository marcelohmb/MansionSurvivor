/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;

/**
 *
 * @author GAMEOVER
 */
public class ChangeRoomAppState extends AbstractAppState {

    private Node doorsNode;
    private GameplayInputAppState gameplayInputAppState;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        gameplayInputAppState = stateManager.getState(GameplayInputAppState.class);
        NodesAppState nodesAppState = stateManager.getState(NodesAppState.class);
        this.doorsNode = nodesAppState.getDoorsNode();

    }

    public void changeRoom(RoomAppState actual, RoomAppState next) {
        System.out.println("DEBUG: YES, I CHANGED THE ROOMS!");
    }

    @Override
    public void update(float tpf) {

    }
}
