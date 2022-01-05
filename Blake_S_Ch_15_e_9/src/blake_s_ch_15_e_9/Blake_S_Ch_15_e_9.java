/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blake_s_ch_15_e_9;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Programming
 */
public class Blake_S_Ch_15_e_9 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        ArrayList<Line> lines = new ArrayList<Line>();
        
        
        btn.setText("Reset");
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600);
        
        root.setOnKeyPressed(e -> {
            double lastx = (lines.size() == 0) ? 300 : lines.get(lines.size() - 1).getEndX();
            double lasty = (lines.size() == 0) ? 300 : lines.get(lines.size() - 1).getEndY();
            double newx;
            double newy;
            
            switch (e.getCode()) {
                case DOWN:
                    if(lasty >= 600)
                        newy = 600;
                    else
                        newy = lasty + 10;
                    
                    lines.add(new Line(lastx, lasty, lastx, newy));
                    break;
                    
                case UP:
                    if(lasty <= 0)
                        newy = 0;
                    else
                        newy = lasty - 10;
                    
                    lines.add(new Line(lastx, lasty, lastx, newy));
                    break;
                    
                case LEFT:
                    if(lastx <= 0)
                        newx = 0;
                    else
                        newx = lastx - 10;
                    
                    lines.add(new Line(lastx, lasty, newx, lasty));
                    break;
                    
                case RIGHT:
                    if(lastx >= 600)
                        newx = 600;
                    else
                        newx = lastx + 10;
                    
                    lines.add(new Line(lastx, lasty, newx, lasty));
                    break;
            }
            
            System.out.println(lines.get(lines.size() - 1).toString());
            root.getChildren().add(lines.get(lines.size() - 1));
        });
        
        btn.setOnAction((ActionEvent event) -> {
            root.getChildren().removeAll(lines.subList(0, lines.size()));
            lines.clear();
        });
        
        root.getChildren().add(btn);
        primaryStage.setTitle("Etch and Sketch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
