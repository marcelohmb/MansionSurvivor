/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import java.util.Vector;

/**
 *
 * @author GAMEOVER
 */
public class PlayerControl extends AbstractControl {
    
    private static final float DEFAULT_SPEED = 2f;

    private void setSpeed(float speed) {
        spatial.setUserData(UserData.SPEED, speed);
    }

    public float getSpeed() {
        return spatial.getUserData(UserData.SPEED);
    }
    
    public void setWalkDirection(Vector3f walkDirection){
        spatial.setUserData(UserData.WALK_DIRECTION, walkDirection);
    }
    
    public Vector3f getWalkDirection(){
        return spatial.getUserData(UserData.WALK_DIRECTION);
    }

    
    public PlayerControl(Spatial s) {
        this.spatial = s;
        setSpeed(DEFAULT_SPEED);
        setWalkDirection(Vector3f.ZERO);
        
    }

    @Override
    protected void controlUpdate(float tpf) {
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }


}
