/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

/**
 *
 * @author ditlev
 */
class TaskItem {
    
    //Direction values
    private final int right = 0;
    private final int up = 90;
    private final int left = 180;
    private final int down = 270;
    
    private Robot robot;
    private ActionCondition ac;
    
    public TaskItem(Robot robot, ActionCondition ac) {
        this.robot = robot;
        this.ac = ac;
    }
    
    public ActionCondition getAction() {
        return ac;
    }
    
    public void executeCommand() {
        //Maybe some general code can be done here.
        
        switch (ac) {
            case PICKUP:
                forward();
                break;
            case TURN:
                turn();
                break;
        }
        
        
    }
    
    private void forward() {
       
        int currentDirection = (int) robot.rotateProperty().get();
        
        switch (currentDirection) {
            case right:
                robot.getPos().setX(robot.getPos().getX() + 1);
                break;
            case left:
                robot.getPos().setX(robot.getPos().getX() - 1);
                break;
            case up:
                robot.getPos().setY(robot.getPos().getY() -1);
            case down:
                robot.getPos().setY(robot.getPos().getY() + 1);
                break;
        }
    }
    
    private void turn() {
        int currentDirection = (int) robot.rotateProperty().get();
        
        
        
    }
    
    private void backward() {
        
    }
}
