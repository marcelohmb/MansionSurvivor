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
import com.jme3.math.Quaternion;
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
    private boolean showPos = true;

    public Spatial getTarget() {
        return target;
    }

    public void setTarget(Spatial value) {
        target = value;
    }

    public FlyByCamera getFlyByCamera() {
        return flyCam;
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        SimpleApplication simpleApp = (SimpleApplication) app;
        cam = simpleApp.getCamera();
        flyCam = simpleApp.getFlyByCamera();
        flyCam.setEnabled(false);
        cam.setRotation(new Quaternion(1f, 0f, 0f, 1f));


    }

    @Override
    public void update(float tpf) {

        if (!flyCam.isEnabled()) { // This verification is only checked in stage of development

            if (target != null) {
                if (target.getName().equals(Constants.UserData.PLAYER)) {

                    cam.setLocation(new Vector3f(target.getLocalTranslation().getX(), 20f,
                            target.getLocalTranslation().getZ()));
                    cam.lookAt(target.getLocalTranslation(), new Vector3f(0f, 0f, -1f));
                    if (showPos) {
                        System.out.println("CAMERA LOCATION = " + cam.getLocation());
                        System.out.println("CAMERA LOOK AT =" + target.getLocalTranslation());
                    }
                }
            }

        }

    }
}
