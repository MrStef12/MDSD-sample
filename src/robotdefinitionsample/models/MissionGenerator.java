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
public class MissionGenerator {
    
    
    public Mission Robot1(Robot r) {
        Mission m = new Mission();
        Task t = new Task("asd");
        
        t.addTask(new TaskItem(r, ActionCondition.FORWARD));
        t.addTask(new TaskItem(r, ActionCondition.FORWARD));
        t.addTask(new TaskItem(r, ActionCondition.TURN_CW));
        t.addTask(new TaskItem(r, ActionCondition.FORWARD).setSpeed(4));
        t.addTask(new TaskItem(r, ActionCondition.TURN_CCW));
        t.addTask(new TaskItem(r, ActionCondition.BACKWARD));
        m.addTask(t);
        return m;
    }
    
}
