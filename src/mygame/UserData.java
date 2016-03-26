/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.scene.Spatial;

/**
 *
 * @author GAMEOVER
 */
public class UserData {
    public static final String SPEED = "speed"; 
    public static final String CHASE = "chase";
    public static final String MEASURES = "measures";
    public static final String PLAYER_NODE = "playerNode";
    public static final String PLAYER = "player";
    public static final String WALK_DIRECTION = "walkDirection";
    public static final String CAMERA_NODE = "cameraNode";
    
    public static void setMeasures(Spatial s, Measures m){
        s.setUserData(UserData.MEASURES, m);
    }
    
}
