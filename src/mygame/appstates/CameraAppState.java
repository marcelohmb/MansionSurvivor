/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.appstates;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.input.FlyByCamera;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Spatial;
import mygame.util.Constants;

/**
 *
 * @author GAMEOVER
 */
public class CameraAppState extends AbstractAppState {

    private Camera cam;
    private FlyByCamera flyCam;
    private Spatial target;

    public Spatial getTarget() {
        return target;
    }

    public void setTarget(Spatial value) {
        target = value;
    }


    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        SimpleApplication simpleApp = (SimpleApplication) app;
        cam = simpleApp.getCamera();
        flyCam = simpleApp.getFlyByCamera();
        flyCam.setEnabled(false);
    }

    @Override
    public void update(float tpf) {
        if (target != null) {
            if (target.getName().equals(Constants.UserData.PLAYER)) {
                cam.setLocation(target.getLocalTranslation().add(new Vector3f(0f, 20f, 0f)));
                cam.lookAt(target.getLocalTranslation(), Vector3f.ZERO);
            }
        }
    }
}
