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
      
       //El numero 0
      Rectangle rectangulo = new Rectangle(180, 100, 25, 50);
      rectangulo.setFill(Color.TRANSPARENT);
      rectangulo.setStrokeWidth(7);
      rectangulo.setStroke(Color.BLACK);
      
      //Linea dentro del cero
      Line linea = new Line(182, 102, 203, 148);
      linea.setStrokeWidth(7);
      
      //El numero 1
      Line diagonal1 = new Line(225, 115, 233, 100);
      diagonal1.setStrokeWidth(7);
      Line vertical1 = new Line(235, 100, 235, 150);
      vertical1.setStrokeWidth(7);
      
      //El numero 2
      Line linea1_2 = new Line(260,100,275,100);
      linea1_2.setStrokeWidth(7);
      Line linea2_2 = new Line(275,100,275,125);
      linea2_2.setStrokeWidth(7);
      Line linea3_2 = new Line(260,125,275,125);
      linea3_2.setStrokeWidth(7);
      Line linea4_2 = new Line(260,125,260,150);
      linea4_2.setStrokeWidth(7);
      Line linea5_2 = new Line(260,150,275,150);
      linea5_2.setStrokeWidth(7);
      
      //El numero 3
      Line linea1_3 = new Line(300,100,315,100);
      linea1_3.setStrokeWidth(7);
      Line linea2_3 = new Line(300,125,315,125);
      linea2_3.setStrokeWidth(7);
      Line linea3_3 = new Line(300,150,315,150);
      linea3_3.setStrokeWidth(7);
      Line lineaVertical_3 = new Line(315,100,315,150);
      lineaVertical_3.setStrokeWidth(7);
      
      //El Numero 4
      Line linea1_4 = new Line(340,125,355,125);
      linea1_4.setStrokeWidth(7);
      Line linea2_4 = new Line(340,125,340,100);
      linea2_4.setStrokeWidth(7);
      Line lineaVertical_4 = new Line(355,100,355,150);
      lineaVertical_4.setStrokeWidth(7);
      
      //El Numero 5
      Line linea1_5 = new Line(380,100,395,100);
      linea1_5.setStrokeWidth(7);
      Line linea2_5 = new Line(380,100,380,125);
      linea2_5.setStrokeWidth(7);
      Line linea3_5 = new Line(380,125,395,125);
      linea3_5.setStrokeWidth(7);
      Line linea4_5 = new Line(395,125,395,150);
      linea4_5.setStrokeWidth(7);
      Line linea5_5 = new Line(380,150,395,150);
      linea5_5.setStrokeWidth(7);

       //El Numero 6
       Line linea1_6 = new Line(420,100,435,100);
      linea1_6.setStrokeWidth(7);
      Line linea2_6= new Line(420,125,435,125);
      linea2_6.setStrokeWidth(7);
      Line linea3_6 = new Line(420,150,435,150);
      linea3_6.setStrokeWidth(7);
      Line linea4_6 = new Line(435,125,435,150);
      linea4_6.setStrokeWidth(7);
      Line lineaVertical_6 = new Line(420,100,420,150);
      lineaVertical_6.setStrokeWidth(7);
       
      //El numero 7
      Line linea1_7 = new Line(460,100,475,100);
      linea1_7.setStrokeWidth(7);
      Line linea2_7 = new Line(465,125,475,125);
      linea2_7.setStrokeWidth(7);
      Line lineaVertical_7 = new Line(475,100,460,150);
      lineaVertical_7.setStrokeWidth(7);
      
      //El numero 8
       Line linea1_8 = new Line(500,100,515,100);
      linea1_8.setStrokeWidth(7);
      Line linea2_8 = new Line(500,125,515,125);
      linea2_8.setStrokeWidth(7);
      Line linea3_8 = new Line(500,150,515,150);
      linea3_8.setStrokeWidth(7);
      Line lineaVertical_8 = new Line(500,100,500,150);
      lineaVertical_8.setStrokeWidth(7);
      Line lineaVertical2_8 = new Line(515,100,515,150);
      lineaVertical2_8.setStrokeWidth(7);
      
       //El numero 9
      Line linea1_9 = new Line(540,100,555,100);
      linea1_9.setStrokeWidth(7);
      Line linea2_9 = new Line(540,125,555,125);
      linea2_9.setStrokeWidth(7);
      Line linea3_9 = new Line(540,150,555,150);
      linea3_9.setStrokeWidth(7);
      Line lineaVertical_9 = new Line(540,100,540,125);
      lineaVertical_9.setStrokeWidth(7);
      Line lineaVertical2_9 = new Line(555,100,555,150);
      lineaVertical2_9.setStrokeWidth(7);
      
      //Lineas del interior de la caja
      Line diagcaja = new Line(55, 80, 145, 170);
      diagcaja.setStrokeWidth(10);
      diagcaja.setStroke(Color.rgb(255, 181, 103));
      
      Line diagcaja2 = new Line(145, 80, 55, 170);
      diagcaja2.setStrokeWidth(10);
      diagcaja2.setStroke(Color.rgb(255, 181, 103));
      //El resto de la caja
      Rectangle caja = new Rectangle();
      Rectangle bordecaja = new Rectangle();
      caja.setX(50);
      caja.setY(75);
      caja.setWidth(100);
      caja.setHeight(100);
      caja.setFill(Color.rgb(188, 134, 76));
      caja.setStrokeWidth(10);
      caja.setStroke(Color.rgb(255, 181, 103));
      bordecaja.setX(42);
      bordecaja.setY(67);
      bordecaja.setWidth(116);
      bordecaja.setHeight(116);
      bordecaja.setStrokeWidth(5);
      
      //Nueva manera de crear cajas
      Caja cajita = new Caja(100,400,06);
      root.getChildren().add(cajita.crearCaja());
      
      //Ciclo que genera un arreglo de 10 numeros aleatorios
      int[] numeros = new int[10];
      for (int x=0;x<numeros.length;x++){
        numeros[x] = (int) (Math.random()*99)+1;}
      
      //Ciclo que dibuja 10 cajas(con la nueva manera) cada una con un numero aleatorio asignado para despues dibujarlo
      
      /*for (int x=0,i=50;x<numeros.length;x++){
          System.out.print(""+numeros[x]+", ");
          cajita = new Caja(i, 200, numeros[x]);
          root.getChildren().add(cajita.crearCaja());
          i=i+125;
      }*/
      
      
      //Se agregan las lineas y la caja a la pantalla
      root.getChildren().addAll(bordecaja,caja,diagcaja,diagcaja2); //Caja
      root.getChildren().addAll(rectangulo,linea); //Num 0
      root.getChildren().addAll(diagonal1, vertical1);  //Num 1
      root.getChildren().addAll(linea1_2, linea2_2, linea3_2, linea4_2, linea5_2); //Num 2
      root.getChildren().addAll(linea1_3, linea2_3, linea3_3, lineaVertical_3); //Num 3
      root.getChildren().addAll(linea1_4,linea2_4, lineaVertical_4); //Num 4
      root.getChildren().addAll(linea1_5, linea2_5, linea3_5, linea4_5, linea5_5); //Num 5
      root.getChildren().addAll(linea1_6,linea2_6,linea3_6,linea4_6,lineaVertical_6);//Num 6
      root.getChildren().addAll(linea1_7,lineaVertical_7);//Num 7
      root.getChildren().addAll(linea1_8,linea2_8,linea3_8,lineaVertical_8,lineaVertical2_8);//Num 8
     root.getChildren().addAll(linea1_9,linea2_9,linea3_9,lineaVertical_9,lineaVertical2_9);//Num 9
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
