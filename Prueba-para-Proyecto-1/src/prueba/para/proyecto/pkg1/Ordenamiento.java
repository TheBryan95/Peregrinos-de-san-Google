/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.para.proyecto.pkg1;

import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Ordenamiento {
   int[] numeros;
   Timeline timeline; 
   int j;
   Caja cajita;

    
    
public void empezarordenamiento(Group root){
    numeros = new int[10];
      for (int x=0;x<numeros.length;x++){
        numeros[x] = (int) (Math.random()*99)+1;}
      
      sinOrdenar(root);
      j=0;
      
      timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> ordenamiento(root)));
      timeline.setCycleCount(numeros.length + 1);
      timeline.play();
      
}    

    
public void ordenamiento(Group root){
      if (j < numeros.length) {  
            int key = numeros[j];  
            int i = j-1;  
            while ( (i > -1) && ( numeros [i] > key ) ) {
                numeros [i+1] = numeros [i];
                i--;  
            }
            numeros[i+1] = key;
            ordenado(root);
        }
      else{
          timeline.stop();
          
      }
      j++;
      
    }

public void sinOrdenar(Group root){
    for (int x=0,i=50;x<numeros.length;x++){
          System.out.print(""+numeros[x]+", ");
          cajita = new Caja(i, 200, numeros[x]);
          
          root.getChildren().add(cajita.crearCaja());
          i=i+125;
      }
      cajita = new Caja(100,400,00);

}

public void ordenado(Group root){
    for (int x=0,i=50;x<numeros.length;x++){
        System.out.print(""+numeros[x]+", ");
        cajita = new Caja(i, 350, numeros[x]);
          
        root.getChildren().add(cajita.crearCaja());
        i=i+125;
    }
}

}
