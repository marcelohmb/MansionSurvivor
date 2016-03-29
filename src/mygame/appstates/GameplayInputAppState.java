/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import mygame.util.Constants;
import mygame.controls.PlayerControl;

/**
 *
 * @author GAMEOVER
 */
public class GameplayInputAppState extends AbstractAppState {

    /*Gives access to the input of the game */
    private InputManager inputManager;
    /*Indicate if the game is running or if is paused */
    private boolean isRunning;
    /**
     * Gives access to player node (that contains the player and related)
     */
    private Node playerNode;
    /**
     * Give access to the cental app
     */
    private SimpleApplication app;
    /**
     * The player 3d model
     */
    private Spatial player;
    /**
     * Give acess to player physics (used in movement, for example)
     */
    private BetterCharacterControl playerPhysics;
    /**
     * Give access to player spatial and proprieties
     */
    private PlayerControl playerControl;
    /**
     * This is vector is necessary in the algorithm of the player move. With it
     * we can keep state of two buttons that make a diagonal movement
     */
    private Vector3f playerMove = new Vector3f();
    /**
     * Used in debugging
     */
    private FlyByCamera flyCam;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {

        // Receive and set valeus
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        playerNode = (Node) this.app.getRootNode().getChild(Constants.UserData.PLAYER_NODE);
        player = playerNode.getChild(Constants.UserData.PLAYER);
        playerPhysics = player.getControl(BetterCharacterControl.class);
        playerControl = player.getControl(PlayerControl.class);
        isRunning = true;
        flyCam = stateManager.getState(CameraAppState.class).getFlyByCamera();


        //Set mapping
        inputManager = app.getInputManager();
        inputManager.addMapping(Constants.Mapping.UP, new KeyTrigger(KeyInput.KEY_UP),
                new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping(Constants.Mapping.DOWN, new KeyTrigger(KeyInput.KEY_DOWN),
                new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping(Constants.Mapping.LEFT, new KeyTrigger(KeyInput.KEY_LEFT),
                new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping(Constants.Mapping.RIGHT, new KeyTrigger(KeyInput.KEY_RIGHT),
                new KeyTrigger(KeyInput.KEY_D));

        // Add listeners here
        inputManager.addListener(Movement, Constants.Mapping.UP, Constants.Mapping.DOWN,
                Constants.Mapping.LEFT, Constants.Mapping.RIGHT);

    }
    private ActionListener Debugging = new ActionListener() {
        public void onAction(String name, boolean isPressed, float tpf) {
            if (isRunning) {
                // Put verification's of debug input here
            }
        }
    };
    private ActionListener Movement = new ActionListener() {
        public void onAction(String name, boolean isPressed, float tpf) {

            if (isRunning) {
                if (name.equals(Constants.Mapping.RIGHT)) {
                    if (isPressed) {
                        playerMove.setX(playerControl.getSpeed() );
                    } else {
                        playerMove.setX(0f);
                    }
                } else if (name.equals(Constants.Mapping.LEFT)) {
                    if (isPressed) {
                        playerMove.setX(playerControl.getSpeed()* -1f);
                    } else {
                        playerMove.setX(0f);
                    }
                } else if (name.equals(Constants.Mapping.UP)) {
                    if (isPressed) {
                        playerMove.setZ(playerControl.getSpeed()* -1f);
                    } else {
                        playerMove.setZ(0f);
                    }
                } else if (name.equals(Constants.Mapping.DOWN)) {
                    if (isPressed) {
                        playerMove.setZ(playerControl.getSpeed() );
                    } else {
                        playerMove.setZ(0f);
                    }
                }
            }

            playerControl.setWalkDirection(playerMove);

            if (!playerControl.getWalkDirection().equals(Vector3f.ZERO)) {
                playerPhysics.setViewDirection(playerControl.getWalkDirection());
            }

            playerPhysics.setWalkDirection(playerControl.getWalkDirection());
        }
    };
}
