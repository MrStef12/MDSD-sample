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
        
        TaskItem ti = new TaskItem(r, ActionCondition.FORWARD);
        TaskItem ti1 = new TaskItem(r, ActionCondition.FORWARD);
        TaskItem ti2 = new TaskItem(r, ActionCondition.FORWARD);
        
        t.addTask(ti);
        t.addTask(ti1);
        t.addTask(ti2);
        m.addTask(t);
        return m;
    }
    
}
