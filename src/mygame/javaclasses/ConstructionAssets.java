/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.javaclasses;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.scene.Node;

/**
 *
 * @author GAMEOVER
 */
public class ConstructionAssets {

    private Node rootNode;
    private AssetManager assetManager;
    private BulletAppState bulletAppState;

    public Node getRootNode() {
        return rootNode;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public BulletAppState getBulletAppState() {
        return bulletAppState;
    }
    
    public ConstructionAssets(Node rootNode, AssetManager assetManager, BulletAppState bulletAppState){
        this.rootNode = rootNode;
        this.assetManager = assetManager;
        this.bulletAppState = bulletAppState;
    }
}
