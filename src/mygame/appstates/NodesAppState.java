/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.util.Constants;

/**
 *
 * @author GAMEOVER
 */
public class NodesAppState extends AbstractAppState {

    private Node playerNode;
    private Node enemyNode;
    private Node rootNode;
    private Node guiNode;

    // Initialize all exclusive ndoes
    public NodesAppState() {
        playerNode = new Node(Constants.UserData.PLAYER_NODE);
        enemyNode = new Node(Constants.UserData.ENEMY_NODE);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        SimpleApplication simpleApp = (SimpleApplication) app;
        // Get nodes
        rootNode = simpleApp.getRootNode();
        guiNode = simpleApp.getGuiNode();
    }

    public Node getPlayerNode() {
        return playerNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public Node getGuiNode() {
        return guiNode;
    }

    public Node getEnemyNode() {
        return enemyNode;
    }
}
