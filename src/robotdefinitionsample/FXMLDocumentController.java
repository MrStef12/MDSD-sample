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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.models.Mission;
import robotdefinitionsample.models.MissionGenerator;
import robotdefinitionsample.models.Obstacle;
import robotdefinitionsample.models.Robot;
import robotdefinitionsample.models.Shelf;
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
    
    private List<Robot> robots;
    private List<Obstacle> obstacles;
    private List<Shelf> shelfs;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        robots = new ArrayList<>();
        obstacles = new ArrayList<>();
        shelfs = new ArrayList<>();
        MissionGenerator generator = new MissionGenerator();
        
        Shelf s1 = new Shelf("Shelf1", new Vector2(2,0));
        Obstacle o1 = new Obstacle("Pole", new Vector2(2, 2), new Vector2(1,1));
        
        Image image = new Image(getClass().getResourceAsStream("robot.png"));
        Robot r = new Robot("", new Vector2(0,0));
        r.setGraphic(new ImageView(image));
        r.setMission(generator.Robot1(r));

        robots.add(r);
        obstacles.add(o1);
        shelfs.add(s1);
        
        grid.add(r, r.getPos().getX(), r.getPos().getY());
        grid.add(o1, o1.getPos().getX(), o1.getPos().getY());
        grid.add(s1, s1.getPos().getX(), s1.getPos().getY());
        
    }

    
    private void tick() {
        for (Robot r : robots) {
            r.execute(grid);
            grid.getChildren().remove(r);
            grid.add(r, r.getPos().getX(), r.getPos().getY());
        }
    }

    @FXML
    private void onClick(ActionEvent event) {
        tick();
    }
    
}
