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
    private final int up = 270;
    private final int left = 180;
    private final int down = 90;
    
    private Robot robot;
    private ActionCondition ac;
    private boolean done;
    
    public TaskItem(Robot robot, ActionCondition ac) {
        this.robot = robot;
        this.ac = ac;
        this.done = false;
    }
    
    public ActionCondition getAction() {
        return ac;
    }
    
    public void executeCommand() {
        //Maybe some general code can be done here.
        
        switch (ac) {
            case FORWARD:
                forward();
                break;
            case TURN:
                turn();
                break;
        }
        
        done = true;
        
    }
    
    public boolean isDone() {
        return done;
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
                break;
            case down:
                robot.getPos().setY(robot.getPos().getY() + 1);
                break;
        }
    }
    
    private void turn() {
        int currentDirection = (int) robot.rotateProperty().get();
        
        switch (currentDirection) {
        case right:
            robot.setRotate(down);
            break;
        case left:
            robot.setRotate(up);
            break;
        case up:
            robot.setRotate(right);
            break;
        case down:
            robot.setRotate(left);
            break;
    }
        
    }
    
    private void backward() {
        
    }
}
