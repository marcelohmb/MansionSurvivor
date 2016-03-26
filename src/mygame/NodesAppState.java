/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;

/**
 *
 * @author GAMEOVER
 */
public class NodesAppState extends AbstractAppState {

    private Node playerNode;
    private SimpleApplication app;
    private Node rootNode;
    private Node guiNode;
    
    // Initialize all exclusive ndoes
    public NodesAppState(){
        playerNode = new Node(UserData.PLAYER_NODE);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;

        // Get nodes
        rootNode = this.app.getRootNode();
        guiNode = this.app.getGuiNode();

        // Attach nodes in root node or gui node
        rootNode.attachChild(playerNode);



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
}
