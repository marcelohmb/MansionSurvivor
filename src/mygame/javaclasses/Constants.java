/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.javaclasses;

import mygame.appstates.ScenarioAppState;

/**
 *
 * @author GAMEOVER
 */
public final class Constants {

    public static final class UserData {

        public static final String SPEED = "speed";
        public static final String CHASE = "chase";
        public static final String MEASURES = "measures";
        public static final String PLAYER_NODE = "playerNode";
        public static final String PLAYER = "player";
        public static final String WALK_DIRECTION = "walkDirection";
        public static final String CAMERA_NODE = "cameraNode";
        public static final String ENEMY_NODE = "enemyNode";
        public static final String FRANKESTEIN = "frankestein";
        public static final String DOOR_TYPE = "doorType";
        public static final String DIRECTION = "direction";
        public static final String LEFT_WALL = "leftWall";
        public static final String RIGHT_WALL = "rightWall";
        public static final String TOP_WALL = "topWall";
        public static final String BOTTOM_WALL = "bottomWall";
        public static final String DOORS_NODE = "doorsNode";
        public static final String PLAYER_ACTIONS = "playerActions";
        public static final String PLAYER_OPTIONS = "playerOptions";
        public static final String ROOM_APP = "roomApp";
        public static final String CORRESPONDENT_DOOR = "correspondentDoor";
        public static final String PLAYER_USING_DOOR = "playerUsingDoor";
        public static final String DOOR_ORIENTATION = "doorOrientation";
    }

    public static final class Mapping {

        public static final String UP = "up";
        public static final String DOWN = "down";
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
        public static final String RETURN = "return";
    }

    /**
     * Constants that are important outside of the method where they are
     */
    public static final class GlobalValues {

    }
    
    public static final class PlayerActions{
        public static final String OPEN_DOOR = "openDoor";
    }
    
    public static final class PlayerOptions{
        public static final String OPEN_DOOR = "openDoor";
    }
}
