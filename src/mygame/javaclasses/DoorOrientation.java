/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.javaclasses;

import mygame.enumerations.DoorType;
import mygame.enumerations.Direction;

/**
 *
 * @author GAMEOVER
 */
public class DoorOrientation {
   
    private String doorType;
    private String doorDirection;
    
    public DoorOrientation(DoorType doorType, Direction doorDirection){
       this.doorType = doorType.toString();
       this.doorDirection = doorDirection.toString();
    }
    
    public String getDoorType(){
        return doorType;
    }
    
    public String getDoorDirection(){
        return doorDirection;
    }
}
