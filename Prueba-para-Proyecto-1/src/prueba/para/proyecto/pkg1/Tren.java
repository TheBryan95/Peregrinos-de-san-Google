/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.para.proyecto.pkg1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author iturr
 */
public class Tren {
    
     public Group crearTren(){
        
        Group tren = new Group();

        Rectangle vagon = new Rectangle(140,75 , Color.DARKRED);
        
        Rectangle borde = new Rectangle();
        
        vagon.setX(50);
        vagon.setY(50);
        
        borde.setX(50-8);
        borde.setY(50-8);
        borde.setWidth(156);
        borde.setHeight(91);
        borde.setStrokeWidth(5);

        // Crear los círculos negros en la parte superior del vagón
        Circle circulo1 = new Circle(15, Color.BLACK);
        Circle circulo2 = new Circle(15, Color.BLACK);
        
        circulo1.setCenterX(80);
        circulo2.setCenterX(160);
        circulo1.setCenterY(85);
        circulo2.setCenterY(85);
        // Crear el triángulo amarillo en la parte delantera del vagón
        
        Polygon triangulo = new Polygon();
        triangulo.getPoints().addAll(
                198.0, 47.0,
                198.0, 128.0,
                270.0, 89.0
        );
        triangulo.setFill(Color.YELLOW);
        
        triangulo.setStroke(Color.BLACK);
        triangulo.setStrokeWidth(7);
        
       
        
        
        tren.getChildren().addAll(borde,vagon, circulo1, circulo2, triangulo);

        return tren;
    }
     

}
