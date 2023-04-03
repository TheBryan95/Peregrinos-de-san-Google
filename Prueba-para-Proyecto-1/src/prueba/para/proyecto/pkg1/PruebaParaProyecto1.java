package prueba.para.proyecto.pkg1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PruebaParaProyecto1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Se inician sliders y label que iran en pantalla
        Slider slider = new Slider(0, 200, 100);
        slider.setLayoutX(50);
        Slider slider2 = new Slider(-200, 200, 0);
        slider2.setLayoutX(250);
        slider2.setShowTickMarks(true);
        slider2.setShowTickLabels(true);
        Label l =new Label();
        l.setLayoutX(400);
        //Se inicia la pantalla 
        Group root = new Group(slider,slider2,l);//Se le agregan los sliders y label a root
        Scene scene = new Scene(root,1300,600,Color.LIGHTSKYBLUE);
        Stage stage = new Stage();
        //Actualiza el label cuando se mueve el slider 2
        slider2.setOnMouseReleased(event -> {
            l.setText(""+(int)slider2.getValue());
        });
        //Se dibuja la grua
        MovimientoGrua grua = new MovimientoGrua();
        Group fondo = grua.dibujarGrua();
        Group carro =grua.crearcarroGrua(110);
        Group carro2 =grua.crearSegundoCarroGrua(710);
        root.getChildren().addAll(fondo,carro,carro2);
        //Funcion mover grua
        grua.moverCarro(carro, 600);
        grua.moverCarro(carro2, -600);
        //Nueva manera de crear cajas
        Caja cajita1 = new Caja(100,185,06);
        root.getChildren().add(cajita1.crearCaja());
        Caja cajita2 = new Caja(700,350,23);
        root.getChildren().add(cajita2.crearCaja());
        //Funcion mover caja
        cajita1.moverCaja(600, 0);
        
        cajita2.moverCaja(-600, 0);
        //Funcion que mueve el carro de la grua con el slider
        
        
        //Ciclo que genera un arreglo de 10 numeros aleatorios
        int[] numeros = new int[9];
        ArrayList<Caja> cajas = new ArrayList();
        for (int x=0;x<numeros.length;x++){
          numeros[x] = (int) (Math.random()*99)+1;}

        //Ciclo que dibuja 10 cajas(con la nueva manera) cada una con un numero aleatorio asignado para despues dibujarlo

        for (int x=0,i=90;x<numeros.length;x++){
            System.out.print(""+numeros[x]+", ");
            Caja cajita = new Caja(i, 480, numeros[x]);
            cajas.add(cajita);
            root.getChildren().add(cajita.crearCaja());
            i=i+125;
        }
        //Slider que cambia el tamaño de las cajas al moverlo
        slider.setOnMouseReleased(event -> {
            for (int j = 0; j < numeros.length; j++) {
                    Caja caja = (Caja) cajas.get(j);
                    caja.tamanoCaja(slider.getValue());
                }
        });
        slider2.setOnMousePressed(event -> {
            grua.moverCarro(carro,(int) slider2.getValue());
            cajita1.moverCaja(slider2.getValue(), 0);
            
        });
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
