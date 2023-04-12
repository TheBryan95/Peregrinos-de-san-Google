/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.para.proyecto.pkg1;

import java.util.ArrayList;
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
   ArrayList<Caja> cajas = new ArrayList();
   ArrayList<Group> cajas2 = new ArrayList();
   Caja cajita;

    
public void nuevoarreglo(Group root,int largo){
    root.getChildren().removeAll(cajas2);
    cajas2.clear();
    cajas.clear();
    numerosaleatorios(largo);
    sinOrdenar(root);
    j=0;
    timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> ordenamiento(root)));
    timeline.setCycleCount(numeros.length + 1);
    timeline.play();

}   
public void numerosaleatorios(int largo){
    numeros = new int[largo];
      for (int x=0;x<numeros.length;x++){
        numeros[x] = (int) (Math.random()*99)+1;
      }
}
public void empezarordenamiento(Group root,int largo){
      numerosaleatorios(largo);
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
    root.getChildren().removeAll(cajas2);
    cajas.clear();
    cajas2.clear();
    for (int x=0,i=90;x<numeros.length;x++){
            //System.out.print(""+numeros[x]+", ");
            cajita = new Caja(i, 480, numeros[x]);
            cajas.add(cajita);
            Group cajis = cajita.crearCaja();
            cajas2.add(cajis);

            i=i+125;
//          cajita = new Caja(i, 200, numeros[x]);
//          
//          root.getChildren().add(cajita.crearCaja());
//          i=i+125;
        }
    root.getChildren().addAll(cajas2);
      //cajita = new Caja(100,400,00);
      
}

public void ordenado(Group root){
    cajas.clear();
    cajas2.clear();
    for (int x=0,i=90;x<numeros.length;x++){
        //System.out.print(""+numeros[x]+", ");
        cajita = new Caja(i, 350, numeros[x]);
        cajas.add(cajita);
        Group cajis = cajita.crearCaja();
        cajas2.add(cajis);
        i=i+125;
    }
    root.getChildren().addAll(cajas2);
}

}
