/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.interfaces.IMoveable;
import robotdefinitionsample.models.Obstacle;
import robotdefinitionsample.models.Robot;
import robotdefinitionsample.models.Pickupable;
import robotdefinitionsample.models.Vector2;

/**
 *
 * @author ditlev
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private GridPane grid;
    @FXML
    private Button Tick;
    
    private List<IMoveable> movables;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movables = new ArrayList<>();
        MissionGenerator generator = new MissionGenerator();
        
        Pickupable s1 = new Pickupable("Shelf1", new Vector2(2,0));
        s1.addProperty("Weight", 100);
        Obstacle o1 = new Obstacle("Pole", new Vector2(2, 2), new Vector2(1,1));
        
        Image image = new Image(getClass().getResourceAsStream("robot.png"));
        Robot r1 = new Robot("Robot1", new Vector2(0,0), generator.Robot1(grid));
        r1.setGraphic(new ImageView(image));
        Robot r2 = new Robot("Robot2", new Vector2(0,1), generator.Robot2(grid));
        r2.setGraphic(new ImageView(image));
        
//        Robot r2 = new Robot("Robert", new Vector2(4, 0));
//        r2.setGraphic(new ImageView(image));
//        r2.setMission(generator.Robot2(r2, grid));

        movables.add(r1);
        movables.add(r2);
        movables.add(s1);
        movables.add(o1);
        
        grid.add(r1, r1.getPos().getX(), r1.getPos().getY());
        grid.add(r2, r2.getPos().getX(), r2.getPos().getY());
        grid.add(o1, o1.getPos().getX(), o1.getPos().getY());
        grid.add(s1, s1.getPos().getX(), s1.getPos().getY());
        
    }

    
    private void tick() {
        for (IMoveable m : movables) {
            m.execute(grid);
            m.move(grid);
        }
    }

    @FXML
    private void onClick(ActionEvent event) {
        tick();
    }
    
}
