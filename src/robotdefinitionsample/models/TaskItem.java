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
    private Robot robot;
    
    public TaskItem(Robot robot) {
        this.robot = robot;
    }
    
    public void executeCommand() {
        // Execute command this should be custom
        // for each taskItem coupled to a robot.
    }
}
