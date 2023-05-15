package prueba.para.proyecto.pkg1;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MovimientoGrua {
    
    int posx = 0;
    
    public  Group dibujarGrua(Scene scene){
        
//        int largo = (int) scene.getWidth();
        int alto = (int) scene.getHeight();
        Group grua = new Group();
        for (int i = 0,j=alto; i < 5; i++) {
            Line linea = new Line(5, j, 5, j-100);
            linea.setStrokeWidth(7);
            Line linea2 = new Line(55,j,55,j-100);
            linea2.setStrokeWidth(7);
            
            Line diag = new Line(7, j, 53, j-100);
            Line diag2 = new Line(53, j, 7, j-100);
            diag.setStrokeWidth(7);
            diag2.setStrokeWidth(7);
            if (i%2==0) {
                linea.setStroke(Color.RED);
                linea2.setStroke(Color.RED);
                
                diag.setStroke(Color.WHITE);
                diag2.setStroke(Color.WHITE);
            }
            else{
                linea.setStroke(Color.WHITE);
                linea2.setStroke(Color.WHITE);
          
                diag.setStroke(Color.RED);
                diag2.setStroke(Color.RED);
            }
            grua.getChildren().addAll(diag,diag2,linea,linea2);
            j=j-100;
        }
        
        
        for (int i = 0,j=alto; i < 5; i++) {
            Line linea3 = new Line(1300-15, j,1300-15, j-100);
            linea3.setStrokeWidth(7);
            Line linea4 = new Line(1300-65,j,1300-65,j-100);
            linea4.setStrokeWidth(7);
            
            Line diag = new Line(1300-15, j, 1300-65, j-100);
            Line diag2 = new Line(1300-65, j, 1300-15, j-100);
            diag.setStrokeWidth(7);
            diag2.setStrokeWidth(7);
            if (i%2==0) {
                linea3.setStroke(Color.RED);
                linea4.setStroke(Color.RED);
                
                diag.setStroke(Color.WHITE);
                diag2.setStroke(Color.WHITE);
            }
            else{
                linea3.setStroke(Color.WHITE);
                linea4.setStroke(Color.WHITE);
          
                diag.setStroke(Color.RED);
                diag2.setStroke(Color.RED);
            }
            grua.getChildren().addAll(diag,diag2,linea3,linea4);
            j=j-100;
        }
        
        Line linea5= new Line(5, 100, 1300-15, 100);
        linea5.setStrokeWidth(7);
        Line linea6= new Line(55, 140, 1300-65, 140);
        linea6.setStrokeWidth(7);
        grua.getChildren().addAll(linea5,linea6);
        return grua;
    }
    public Group crearcarroGrua(int x){
        Rectangle carro1 = new Rectangle(x, 100, 80, 30);
        carro1.setFill(Color.BLUE);
        carro1.setStroke(Color.BLACK);
        carro1.setStrokeWidth(3);
        Line cuerda = new Line(x+40, 100, x+40, 500);
        cuerda.setStrokeWidth(7);
        Group carro = new Group(cuerda,carro1);
        return carro;
    }
    public Group crearSegundoCarroGrua(int x){
        Rectangle carro2 = new Rectangle(x, 140, 80, 30);
        carro2.setFill(Color.RED);
        carro2.setStroke(Color.BLACK);
        carro2.setStrokeWidth(3);
        Line cuerda2 = new Line(x+40, 155, x+40, 400);
        cuerda2.setStrokeWidth(7);
        Group carrito = new Group(cuerda2,carro2);
        return carrito;
    }

    public TranslateTransition moverCarro(Group carro,int j,double velo){
        TranslateTransition tt = new TranslateTransition(Duration.seconds(velo),carro);
        tt.setByX(((j)-posx)*67);
        posx=j;
        return tt;

        }
}
