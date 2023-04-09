package prueba.para.proyecto.pkg1;

import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PruebaParaProyecto1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();//Se le agregan los elemenos a la pantalla
        //Se inician sliders, label, boton y caja de texto que iran en pantalla
        TextField text = new TextField();
        text.setLayoutX(550);
        text.setPromptText("Numero de Cajas");
        Button boton = new Button("Confirmar");
        boton.setLayoutX(480);
        Slider slider = new Slider(20, 200, 100);
        slider.setLayoutX(50);
        Slider slider2 = new Slider(-200, 200, 0);
        slider2.setLayoutX(250);
        slider2.setShowTickMarks(true);
        slider2.setShowTickLabels(true);
        Label l =new Label();
        l.setLayoutX(400);
        Label l2 = new Label();
        l2.setLayoutX(650);
        //Se inicia la pantalla 
        String imagePath = "ciudad.jpg";
        Image image = new Image(new File(imagePath).toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1300);
        imageView.setFitHeight(600);
        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);
        root.getChildren().add(text);
        root.getChildren().add(boton);
        root.getChildren().add(slider);
        root.getChildren().add(slider2);
        root.getChildren().add(l);
        root.getChildren().add(l2);
        Scene scene = new Scene(root, 1300, 600);
        Stage stage = new Stage();

        //Actualiza el label cuando se mueve el slider 2
        slider2.setOnMouseReleased(event -> {
            l.setText(""+(int)slider2.getValue());
        });
        //Se dibuja la grua
        MovimientoGrua grua = new MovimientoGrua();
        Group fondo = grua.dibujarGrua(scene);
        Group carro =grua.crearcarroGrua(110);
        Group carro2 =grua.crearSegundoCarroGrua(710);
        root.getChildren().addAll(fondo,carro,carro2);
        //Funcion mover grua
        grua.moverCarro(carro, 600);
        grua.moverCarro(carro2, -600);
        //Nueva manera de crear cajas
        Caja cajita1 = new Caja(100,185,06);
        Group caji = cajita1.crearCaja();
        root.getChildren().add(caji);
        Caja cajita2 = new Caja(700,350,23);
        Group caji2 = cajita2.crearCaja();
        root.getChildren().add(caji2);
        //Funcion mover caja
        cajita1.moverCaja(caji,600, 0);
        cajita2.moverCaja(caji2,-600, 0);
        //Funcion que mueve el carro de la grua con el slider
        
        
        //Ciclo que genera un arreglo de 10 numeros aleatorios
        int[] numeros = new int[9];
        ArrayList<Caja> cajas = new ArrayList();
        ArrayList<Group> cajas2 = new ArrayList();
        for (int x=0;x<numeros.length;x++){
          numeros[x] = (int) (Math.random()*99)+1;}

        //Ciclo que dibuja 10 cajas(con la nueva manera) cada una con un numero aleatorio asignado para despues dibujarlo
        
        for (int x=0,i=90;x<numeros.length;x++){
            System.out.print(""+numeros[x]+", ");
            Caja cajita = new Caja(i, 480, numeros[x]);
            cajas.add(cajita);
            Group cajis = cajita.crearCaja();
            cajas2.add(cajis);
            
            i=i+125;
        }
        root.getChildren().addAll(cajas2);//Se agrega todo el arreglo de cajas a la pantalla  para poder eliminarla con un boton
        //boton que genera nuevo arreglo y elimina el anterior de la pantalla
        boton.setOnAction((event) -> {
            root.getChildren().removeAll(cajas2);
            cajas.clear();
            cajas2.clear();
            int[] numeros2 = new int[Integer.parseInt(text.getText())];
            for (int x=0;x<numeros2.length;x++){
              numeros2[x] = (int) (Math.random()*99)+1;}

            //Ciclo que dibuja 10 cajas(con la nueva manera) cada una con un numero aleatorio asignado para despues dibujarlo

            for (int x=0,i=90;x<numeros2.length;x++){
                System.out.print(""+numeros2[x]+", ");
                Caja cajita = new Caja(i, 480, numeros2[x]);
                cajas.add(cajita);
                Group cajis = cajita.crearCaja();
                cajas2.add(cajis);

                i=i+125;
            }
            root.getChildren().addAll(cajas2);  
        });
        
        //Slider que cambia el tamaño de las cajas al moverlo
        slider.setOnMouseReleased(event -> {
            for (int j = 0; j < numeros.length; j++) {
                    Caja caja = (Caja) cajas.get(j);
                    Group cajit = (Group) cajas2.get(j);
                    if (slider.getValue()<100) {
                        caja.moverCaja(cajit, -slider.getValue()*j/2, 0);
                    }
                    else{
                        caja.moverCaja(cajit, slider.getValue()*j/2, 0);
                    }
                    
                    
                    caja.tamanoCaja(cajit,slider.getValue());
                }
        });
        //Slider de prueba para probar movimiento de caja
        slider2.setOnMousePressed(event -> {
            grua.moverCarro(carro,(int) slider2.getValue());
            cajita1.moverCaja(caji,slider2.getValue(), 0);
            
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
