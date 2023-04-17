package prueba.para.proyecto.pkg1;

import java.io.File;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PruebaParaProyecto1 extends Application {
    
    ArrayList<Caja> cajas = new ArrayList();
    ArrayList<Group> cajas2 = new ArrayList(); 
    int j;
    Caja cajita;
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();//Se le agregan los elemenos a la pantalla
        //Se inician sliders, label, boton y caja de texto que iran en pantalla
        TextField text = new TextField();
        text.setLayoutX(550);
        text.setPromptText("Numero de Cajas");
        Button boton = new Button("Confirmar");
        boton.setLayoutX(480);
        
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
        root.getChildren().addAll(imageView,text,boton,l,l2);
       
        Scene scene = new Scene(root, 1300, 600);
        Stage stage = new Stage();

        
        //Se dibuja la grua
        MovimientoGrua grua = new MovimientoGrua();
        Group fondo = grua.dibujarGrua(scene);
//        Group carro =grua.crearcarroGrua(110);
//        Group carro2 =grua.crearSegundoCarroGrua(710);
        root.getChildren().add(fondo);
//            root.getChildren().addAll(fondo,carro,carro2);
        //Funcion mover grua
//        grua.moverCarro(carro, 600);
//        grua.moverCarro(carro2, -600);
        //Nueva manera de crear cajas
//        Caja cajita1 = new Caja(100,185,06);
//        Group caji = cajita1.crearCaja();
//        root.getChildren().add(caji);
//        Caja cajita2 = new Caja(700,185,23);
//        Group caji2 = cajita2.crearCaja();
//        root.getChildren().add(caji2);
        //Funcion mover caja
//        ArrayList translate = new ArrayList<>();
//        translate.add(cajita1.moverCaja(caji, 0,150));
//        translate.add(cajita2.moverCaja(caji2, -600, 0));
//        translate.add(cajita1.moverCaja(caji, 600, 0));
//        translate.add(cajita1.moverCaja(caji, 0, -150));
//        cajita1.moverCajaSecuencia(translate);
        
        //Funcion que mueve el carro de la grua con el slider
        
        
        //Ciclo que genera un arreglo de 10 numeros aleatorios
//        int[] numeros = new int[9];
//        for (int x=0;x<numeros.length;x++){
//            numeros[x] = (int) (Math.random()*99)+1;}
//        

        //Prueba funciones ordenamiento
//        Ordenamiento a = new Ordenamiento();
//        a.empezarordenamiento(root,9);

        empezarordenamiento(cajas,cajas2,root,16);
        //boton que genera nuevo arreglo y elimina el anterior de la pantalla
        
        boton.setOnAction((event) -> {
            root.getChildren().clear();
            
            root.getChildren().addAll(imageView,text,boton,l,l2);
            root.getChildren().add(fondo);
//            root.getChildren().addAll(fondo,carro,carro2);
            root.getChildren().removeAll(cajas2);
            empezarordenamiento(cajas,cajas2,root,Integer.parseInt(text.getText()));
//            root.getChildren().removeAll(cajas2);
//            cajas.clear();
//            cajas2.clear();
//
//            int[] numeros2 = new int[Integer.parseInt(text.getText())];
//            for (int x=0;x<numeros2.length;x++){
//              numeros2[x] = (int) (Math.random()*99)+1;}
//
//            //Ciclo que dibuja 10 cajas(con la nueva manera) cada una con un numero aleatorio asignado para despues dibujarlo
//
//            for (int x=0,i=90;x<numeros2.length;x++){
//                System.out.print(""+numeros2[x]+", ");
//                Caja cajita = new Caja(i, 480, numeros2[x]);
//                cajas.add(cajita);
//                Group cajis = cajita.crearCaja();
//                cajas2.add(cajis);
////
//                i=i+125;
//            }
//            root.getChildren().addAll(cajas2);  
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
    

    
public void moverjuntotamaño(double valor){
    for (int j = 0; j < cajas.size(); j++) {
                    Caja caja = (Caja) cajas.get(j);
                    Group cajit = (Group) cajas2.get(j);
                    if (valor<100) {
                        TranslateTransition tt = caja.moverCaja(cajit, -valor*j*1.3, 0);
                        tt.setDuration(Duration.millis(01));
                        tt.play();
                    }
                    else{
                        TranslateTransition tt =caja.moverCaja(cajit, valor*j*1.3, 0);
                        tt.setDuration(Duration.millis(01));
                        tt.play();
                    }
                    caja.tamanoCaja(cajit,valor,j);
                }

}

public int[] numerosaleatorios(int largo){
    int[]numeros = new int[largo];
      for (int x=0;x<numeros.length;x++){
        numeros[x] = (int) (Math.random()*99)+1;
      }
      return numeros;
}
public void empezarordenamiento(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int largo){
     
      int []numeros=numerosaleatorios(largo);
      sinOrdenar(cajas,cajas2,root,numeros);
      j=0;
      SequentialTransition animacion = ordenamiento(cajas2,root,numeros);
//      timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> ordenamiento(cajas,cajas2,root,numeros)));
//      timeline.setCycleCount(numeros.length + 1);
//      timeline.play();
      animacion.play();
}    

    
public SequentialTransition  ordenamiento(ArrayList<Group> cajas2,Group root,int[] numeros){
      SequentialTransition animacion = new SequentialTransition();
      MovimientoGrua grua = new MovimientoGrua();
      Group carro =grua.crearcarroGrua(120-42);
      //Group carro2 =grua.crearSegundoCarroGrua(710);
      root.getChildren().addAll(carro);
        for (int i = 1; i < numeros.length; i++) {
            
            int valorActual = numeros[i];
            int j = i - 1;
            
            
            while (j >= 0 && numeros[j] > valorActual) {
                Group caj = cajas2.get(j);
                Rectangle rect = (Rectangle) caj.getChildren().get(0);
                
                TranslateTransition transicion = new TranslateTransition(Duration.seconds(0.5),cajas2.get(j+1));
                transicion.setByX(-(67));
                
                TranslateTransition transicionup = new TranslateTransition(Duration.seconds(0.5),cajas2.get(j+1));
                transicionup.setByY(-100);
                
                numeros[j + 1] = numeros[j];
                
                TranslateTransition transiciondown = new TranslateTransition(Duration.seconds(0.5),cajas2.get(j+1));
                transiciondown.setByY(100);
                
                
                TranslateTransition transicion2 = new TranslateTransition(Duration.seconds(0.5),cajas2.get(j));
                transicion2.setByX((67));
                
                ParallelTransition pt = new ParallelTransition(transicion,transicion2,grua.moverCarro(carro, (int) (rect.getX()-58.5), (int) (rect.getX()-58.5)+67));
                animacion.getChildren().addAll(transicionup,pt,transiciondown);
             
                Group cajaJ2 = (Group) cajas2.get(j + 1);
                Group cajaI2 = (Group) cajas2.get(j);
                cajas2.set(j + 1, cajaI2);
                cajas2.set(j, cajaJ2);
                j--;
            }
          
            numeros[j + 1] = valorActual;
            

        }
        return animacion;
    





    /*if (j < numeros.length) {  
            int key = numeros[j];  
            Caja caux = cajas.get(key);
            Group caux2 = cajas2.get(key);
            movimientos.add(caux.moverCaja(caux2, 0, -100));
            
            int i = j-1;  
            while ( (i > -1) && ( numeros [i] > key ) ) {
                Caja cc1 = cajas.get(i);
                Group c1 = cajas2.get(i);
                numeros [i+1] = numeros [i];
                i--;  
                movimientos.add(cc1.moverCaja(c1, 0, 100));
            }
            
            numeros[i+1] = key;
            ordenado(cajas,cajas2,root,numeros);
        }
      else{
//          timeline.stop(); 
          
          
      }
      //j++;*/
    }

public void sinOrdenar(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int[]numeros){
    root.getChildren().removeAll(cajas2);
    cajas.clear();
    cajas2.clear();
    
    for (int x=0,i=70;x<numeros.length;x++){
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
    moverjuntotamaño(45);
      //cajita = new Caja(100,400,00);
      
}


public void ordenado(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int[]numeros){
    root.getChildren().removeAll(cajas2);
    cajas.clear();
    cajas2.clear();
//    SequentialTransition st = new SequentialTransition();
//    for (int i = 0; i < movimientos.size(); i++) {
//        st.getChildren().add((TranslateTransition)movimientos.get(i));
//    }
//    st.play();
    for (int x=0,i=70;x<numeros.length;x++){
        //System.out.print(""+numeros[x]+", ");
        cajita = new Caja(i, 480, numeros[x]);
        cajas.add(cajita);
        Group cajis = cajita.crearCaja();
        cajas2.add(cajis);
        i=i+125;
    }
    
    root.getChildren().addAll(cajas2);
    moverjuntotamaño(45);
}

}
