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
    private static Label pasoActual;
    private static int[] numeros;
    private static Timeline timeline;
    private static int j;
    private static Caja cajita;
    private static Group root;
    
    
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
      PathTransition transition = new PathTransition();
      
      //Se inicia la pantalla
      pasoActual = new Label("");
      
      Button empezar = new Button("Empezar");
      empezar.setOnAction(event -> empezarordenamiento());
      
      root = new Group(pasoActual, empezar);
      pasoActual.setLayoutY(550);
      pasoActual.setLayoutX(550);
      pasoActual.setScaleY(3);
      pasoActual.setScaleX(3);
      Scene scene = new Scene(root,1300,600,Color.LIGHTSKYBLUE);
      Stage stage = new Stage();

      
      stage.setScene(scene);
      stage.show();
      
      
              
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    
public void empezarordenamiento(){
    numeros = new int[10];
      for (int x=0;x<numeros.length;x++){
        numeros[x] = (int) (Math.random()*99)+1;}
      
      sinOrdenar();
      j=0;
      
      timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> ordenamiento()));
      timeline.setCycleCount(numeros.length + 1);
      timeline.play();
      
}    

    
public void ordenamiento(){
    pasoActual.setText("El que empieza: " + Arrays.toString(numeros));
      if (j < numeros.length) {  
            int key = numeros[j];  
            int i = j-1;  
            while ( (i > -1) && ( numeros [i] > key ) ) {
                numeros [i+1] = numeros [i];
                i--;  
            }
            numeros[i+1] = key;
            pasoActual.setText("Cambios: " + Arrays.toString(numeros));
            ordenado();
        }
      else{
          pasoActual.setText("Final: " + Arrays.toString(numeros));
          timeline.stop();
          
      }
      j++;
      
    }

public void sinOrdenar(){
    for (int x=0,i=50;x<numeros.length;x++){
          //System.out.print(""+numeros[x]+", ");
          cajita = new Caja(i, 200, numeros[x]);
          
          root.getChildren().add(cajita.crearCaja());
          i=i+125;
      }
      cajita = new Caja(100,400,00);

}

public void ordenado(){
    for (int x=0,i=50;x<numeros.length;x++){
        //System.out.print(""+numeros[x]+", ");
        cajita = new Caja(i, 350, numeros[x]);
          
        root.getChildren().add(cajita.crearCaja());
        i=i+125;
    }
}

}

