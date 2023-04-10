package prueba.para.proyecto.pkg1;

import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PruebaParaProyecto1 extends Application {

    
    
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
      //Se inicia la pantalla
      
      Group root = new Group();
      
      Scene scene = new Scene(root,1300,600,Color.LIGHTSKYBLUE);
      Stage stage = new Stage();
      
      Ordenamiento a = new Ordenamiento();
      
      a.empezarordenamiento(root);
      
      stage.setScene(scene);
      stage.show(); 
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    
}