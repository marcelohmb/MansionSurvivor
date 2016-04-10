/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.javaclasses;

import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.Savable;
import java.io.IOException;
import mygame.enumerations.DoorType;
import mygame.enumerations.Direction;

/**
 *
 * @author GAMEOVER
 */
public class DoorOrientation implements Savable{
   
    private DoorType doorType;
    private Direction doorDirection;
    
    public DoorOrientation(DoorType doorType, Direction doorDirection){
       this.doorType = doorType;
       this.doorDirection = doorDirection;
    }
    
    public DoorOrientation(DoorOrientation doorOrientation){
        this.doorType = doorOrientation.getDoorType();
        this.doorDirection = doorOrientation.getDoorDirection();
    }
    
    public DoorType getDoorType(){
        return doorType;
    }
    
    public Direction getDoorDirection(){
        return doorDirection;
    }

    public void write(JmeExporter ex) throws IOException {

    }

    public void read(JmeImporter im) throws IOException {

    }
}
