package prueba.para.proyecto.pkg1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PruebaParaProyecto1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      //Se inicia la pantalla 
      Group root = new Group();
      Scene scene = new Scene(root,1300,600,Color.LIGHTSKYBLUE);
      Stage stage = new Stage();
      
    
      //Nueva manera de crear cajas
      Caja cajita = new Caja(100,400,06);
      root.getChildren().add(cajita.crearCaja());
      
      cajita.moverCaja(220, 0);
      
      
      //Ciclo que genera un arreglo de 10 numeros aleatorios
      int[] numeros = new int[10];
      for (int x=0;x<numeros.length;x++){
        numeros[x] = (int) (Math.random()*99)+1;}
      
      //Ciclo que dibuja 10 cajas(con la nueva manera) cada una con un numero aleatorio asignado para despues dibujarlo
      
      for (int x=0,i=50;x<numeros.length;x++){
          System.out.print(""+numeros[x]+", ");
          cajita = new Caja(i, 200, numeros[x]);
          root.getChildren().add(cajita.crearCaja());
          i=i+125;
      }
      
      
      //Se inicia la pantalla
      stage.setScene(scene);
      stage.show();
    
    }
    
    public static void main(String[] args) {
        launch(args);
        System.out.println("hola");
        System.out.println("hola lukas");
        System.out.println("Hola Jeremy :D");
    }
    
}
