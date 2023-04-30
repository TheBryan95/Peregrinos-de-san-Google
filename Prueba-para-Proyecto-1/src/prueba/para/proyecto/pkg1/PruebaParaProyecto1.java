package prueba.para.proyecto.pkg1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PruebaParaProyecto1 extends Application {
    
    ArrayList<Caja> cajas = new ArrayList();
    ArrayList<Group> cajas2 = new ArrayList(); 
    int j;
    Caja cajita;
    SequentialTransition Labels = new SequentialTransition();
    
    int indice =0;
    @Override
    public void start(Stage primaryStage) {
        
        Label Titulo = new Label("Algoritmo");
        Label foor = new Label("for (int i = 1; i < n; ++i)");
        Label primer = new Label("int key = arr[i];");
        Label segundo = new Label("int j = i - 1;");
        Label wile = new Label("while (j >= 0 && arr[j] > key)");
        Label primerwile = new Label("arr[j + 1] = arr[j];");
        Label segunwile = new Label("j = j - 1;");
        Label finall = new Label("arr[j + 1] = key;");
        
        Group root = new Group();//Se le agregan los elemenos a la pantalla
        //Se inician sliders, label, boton y caja de texto que iran en pantalla
        TextField text = new TextField();
        text.setLayoutX(550);
        text.setPromptText("Numero de Cajas");
        Button boton = new Button("Confirmar");
        boton.setLayoutX(480);
        
        Button boton2 = new Button("Empezar");
        boton2.setLayoutX(200);
        
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
        
        root.getChildren().addAll(imageView,text,boton,l,l2,Titulo,foor,primer,segundo,wile,primerwile,segunwile,finall,boton2);
        
        Titulo.setLayoutX(1350);
        Titulo.setScaleX(1.5);
        Titulo.setScaleY(1.5);
        Titulo.setStyle("-fx-font-weight: bold;");
    
    
        foor.setLayoutX(1350);
        foor.setLayoutY(50);
        foor.setScaleX(1.5);
        foor.setScaleY(1.5);


        primer.setLayoutX(1380);
        primer.setLayoutY(75);
        primer.setScaleX(1.5);
        primer.setScaleY(1.5);


        segundo.setLayoutX(1375);
        segundo.setLayoutY(100);
        segundo.setScaleX(1.5);
        segundo.setScaleY(1.5);


        wile.setLayoutX(1400);
        wile.setLayoutY(125);
        wile.setScaleX(1.5);
        wile.setScaleY(1.5);


        primerwile.setLayoutX(1400);
        primerwile.setLayoutY(150);
        primerwile.setScaleX(1.5);
        primerwile.setScaleY(1.5);


        segunwile.setLayoutX(1390);
        segunwile.setLayoutY(175);
        segunwile.setScaleX(1.5);
        segunwile.setScaleY(1.5);


        finall.setLayoutX(1340);
        finall.setLayoutY(200);
        finall.setScaleX(1.5);
        finall.setScaleY(1.5);
       
        Scene scene = new Scene(root, 1600, 600);
        Stage stage = new Stage();

        
        //Se dibuja la grua
        MovimientoGrua grua = new MovimientoGrua();
        Group fondo = grua.dibujarGrua(scene);
        root.getChildren().add(fondo);


        empezarordenamiento(cajas,cajas2,root,3, foor,primer,segundo, wile,primerwile,segunwile,finall,boton2);
        //boton que genera nuevo arreglo y elimina el anterior de la pantalla
        boton.setOnAction((event) -> {
            root.getChildren().clear();
            
            root.getChildren().addAll(imageView,text,boton,l,l2,Titulo,foor,primer,segundo,wile,primerwile,segunwile,finall,boton2); ////////////
            root.getChildren().add(fondo);
            root.getChildren().removeAll(cajas2);
            empezarordenamiento(cajas,cajas2,root,Integer.parseInt(text.getText()), foor,primer,segundo, wile,primerwile,segunwile,finall,boton2);
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
public static void burbuja(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                // intercambiar arr[j] y arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

public static void cocktail(int[] arr) {
    boolean swapped = true;
    int start = 0;
    int end = arr.length - 1;

    while (swapped) {
        swapped = false;

        // Pasada hacia adelante
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[i + 1]) {
                // intercambiar arr[i] y arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swapped = true;
            }
        }
        if (!swapped) {
            break;
        }

        // Actualizar el extremo derecho
        end--;

        // Pasada hacia atrás
        for (int i = end-1; i >= start; i--) {
            if (arr[i] > arr[i + 1]) {
                // intercambiar arr[i] y arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swapped = true;
            }
        }

        // Actualizar el extremo izquierdo
        start++;
    }
}


public void empezarordenamiento(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int largo, Label foor, Label primer, Label segundo, Label wile, Label primerwile, Label segunwile, Label finall,Button boton2){
     
      int []numeros=numerosaleatorios(largo);
      sinOrdenar(cajas,cajas2,root,numeros);
      j=0;
      SequentialTransition animacion = ordenamiento(cajas2,root,numeros, foor,primer,segundo, wile,primerwile,segunwile,finall);
      
      boton2.setOnAction((event) -> {
            animacion.play();
            Labels.play(); 
            animacion.play();
        });
      

      if (indice == numeros.length){
          Labels.stop();
      }
      
}    

    
public SequentialTransition  ordenamiento(ArrayList<Group> cajas2,Group root,int[] numeros, Label foor, Label primer, Label segundo, Label wile, Label primerwile, Label segunwile, Label finall){
      SequentialTransition animacion = new SequentialTransition();
      MovimientoGrua grua = new MovimientoGrua();
      Group carro =grua.crearcarroGrua(78);
      root.getChildren().addAll(carro);
      
        for (int i = 1; i < numeros.length; i++) {
            Labels.getChildren().add(cambioColor(foor));
            Labels.getChildren().add(cambioColor2(foor));
            
            int valorActual = numeros[i];
            Labels.getChildren().add(cambioColor(primer));
            Labels.getChildren().add(cambioColor2(primer));
            int j = i - 1;
            Labels.getChildren().add(cambioColor(segundo));
            Labels.getChildren().add(cambioColor2(segundo));
            
            
            while (j >= 0 && numeros[j] > valorActual) { //
                Labels.getChildren().add(cambioColor(wile));
                
                Group caj = cajas2.get(j);
                Rectangle rect = (Rectangle) caj.getChildren().get(0);
                
                TranslateTransition transicion = new TranslateTransition(Duration.seconds(1),cajas2.get(j+1));
                transicion.setByX(-(67));
                
                TranslateTransition transicionup = new TranslateTransition(Duration.seconds(1),cajas2.get(j+1));
                transicionup.setByY(-100);
                Labels.getChildren().add(cambioColor2(wile));
                
                
                numeros[j + 1] = numeros[j]; 
                Labels.getChildren().add(cambioColor(primerwile));
                
                TranslateTransition transiciondown = new TranslateTransition(Duration.seconds(1),cajas2.get(j+1));
                transiciondown.setByY(100);
                
                
                TranslateTransition transicion2 = new TranslateTransition(Duration.seconds(1),cajas2.get(j));
                transicion2.setByX((67));
                Labels.getChildren().add(cambioColor2(primerwile));
                
                ParallelTransition pt = new ParallelTransition(transicion,transicion2,grua.moverCarro(carro, (int) (rect.getX())));
                
                animacion.getChildren().addAll(transicionup,pt,transiciondown);
             
                Group cajaJ2 = (Group) cajas2.get(j + 1);
                Group cajaI2 = (Group) cajas2.get(j);
                cajas2.set(j + 1, cajaI2);
                cajas2.set(j, cajaJ2);
                
                j--;
                Labels.getChildren().add(cambioColor(segunwile));
                Labels.getChildren().add(cambioColor2(segunwile));
            }
          
            numeros[j + 1] = valorActual;//
            Labels.getChildren().add(cambioColor(finall));
            Labels.getChildren().add(cambioColor2(finall));
            indice++;
    
        }
        return animacion;
        
    }


public void sinOrdenar(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int[]numeros){
    root.getChildren().removeAll(cajas2);
    cajas.clear();
    cajas2.clear();
    
    for (int x=0,i=70;x<numeros.length;x++){
            cajita = new Caja(i, 480, numeros[x]);
            cajas.add(cajita);
            Group cajis = cajita.crearCaja();
            cajas2.add(cajis);

            i=i+125;
        }
    
    root.getChildren().addAll(cajas2);
    moverjuntotamaño(45);
}




public Transition cambioColor(Label label){
    SequentialTransition colorChange = new SequentialTransition(label);
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(0.2),new KeyValue(label.styleProperty(), "-fx-background-color: #71abdb;"))));
    //colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(0.5),new KeyValue(label.styleProperty(), "-fx-background-color:white;"))));
    return colorChange;
}

public Transition cambioColor2(Label label){
    SequentialTransition colorChange = new SequentialTransition(label);
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(0.2),new KeyValue(label.styleProperty(), "-fx-background-color:white;"))));
    return colorChange;
}

}
