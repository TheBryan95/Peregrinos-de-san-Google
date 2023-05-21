package prueba.para.proyecto.pkg1;

import java.io.File;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Cocktail extends Stage {
    
    ArrayList<Caja> cajas = new ArrayList();
    ArrayList<Group> cajas2 = new ArrayList(); 
    double [] posx = new double[99];
    int j;
    Caja cajita;
    TextField velo = new TextField();
    public Cocktail() {
        
        Label Titulo = new Label("Algoritmo");

        Label wile = new Label("while (swapped)");
        Label swaped = new Label("swapped = false;");

        //A LA DERECHA
        Label foor = new Label("for (int i = start; i < end; i++)");
        Label iff = new Label("if (arr[i] > arr[i + 1])");
        Label primeriff = new Label("int temp = arr[i];");
        Label seguniff = new Label("arr[i] = arr[i+1];");
        Label terceriff = new Label("arr[i+1] = temp;");
        Label swaped2 = new Label("swapped = true;");

        //CORROBORAR
        Label ifSwaped = new Label("if (!swapped)");
        Label breakk = new Label("break;");

        //LE QUITA 1 AL FINAL
        Label end = new Label("end--");


        //A LA IZQUIERDA
        Label segunfoor = new Label("for (int i = end-1; i >= start; i--)");
        Label iff2 = new Label("if (arr[i] > arr[i + 1])");
        Label primeriff2 = new Label("int temp = arr[i];");
        Label seguniff2 = new Label("arr[i] = arr[i+1];");
        Label terceriff2 = new Label("arr[i+1] = temp;");
        Label swaped3 = new Label("swapped = true;");

        //LE QUITA UNO AL INICIO

        Label start = new Label("start++;");
        Titulo.setLayoutX(1350);
        Titulo.setScaleX(1.5);
        Titulo.setScaleY(1.5);
        Titulo.setStyle("-fx-font-weight: bold;");
    
    
        wile.setLayoutX(1350);
        wile.setLayoutY(50);
        wile.setScaleX(1.5);
        wile.setScaleY(1.5);


        swaped.setLayoutX(1380);
        swaped.setLayoutY(75);
        swaped.setScaleX(1.5);
        swaped.setScaleY(1.5);


        foor.setLayoutX(1375);
        foor.setLayoutY(100);
        foor.setScaleX(1.5);
        foor.setScaleY(1.5);


        iff.setLayoutX(1400);
        iff.setLayoutY(125);
        iff.setScaleX(1.5);
        iff.setScaleY(1.5);


        primeriff.setLayoutX(1390);
        primeriff.setLayoutY(150);
        primeriff.setScaleX(1.5);
        primeriff.setScaleY(1.5);


        seguniff.setLayoutX(1340);
        seguniff.setLayoutY(175);
        seguniff.setScaleX(1.5);
        seguniff.setScaleY(1.5);
        
        terceriff.setLayoutX(1340);
        terceriff.setLayoutY(200);
        terceriff.setScaleX(1.5);
        terceriff.setScaleY(1.5);
        
        swaped2.setLayoutX(1340);
        swaped2.setLayoutY(225);
        swaped2.setScaleX(1.5);
        swaped2.setScaleY(1.5);
        
        ifSwaped.setLayoutX(1340);
        ifSwaped.setLayoutY(250);
        ifSwaped.setScaleX(1.5);
        ifSwaped.setScaleY(1.5);
        
        breakk.setLayoutX(1340);
        breakk.setLayoutY(275);
        breakk.setScaleX(1.5);
        breakk.setScaleY(1.5);
        
        end.setLayoutX(1340);
        end.setLayoutY(300);
        end.setScaleX(1.5);
        end.setScaleY(1.5);
        
        segunfoor.setLayoutX(1340);
        segunfoor.setLayoutY(325);
        segunfoor.setScaleX(1.5);
        segunfoor.setScaleY(1.5);
        
        iff2.setLayoutX(1340);
        iff2.setLayoutY(350);
        iff2.setScaleX(1.5);
        iff2.setScaleY(1.5);
        
        primeriff2.setLayoutX(1340);
        primeriff2.setLayoutY(375);
        primeriff2.setScaleX(1.5);
        primeriff2.setScaleY(1.5);
        
        seguniff2.setLayoutX(1340);
        seguniff2.setLayoutY(400);
        seguniff2.setScaleX(1.5);
        seguniff2.setScaleY(1.5);
        
        terceriff2.setLayoutX(1340);
        terceriff2.setLayoutY(425);
        terceriff2.setScaleX(1.5);
        terceriff2.setScaleY(1.5);
        
        swaped3.setLayoutX(1340);
        swaped3.setLayoutY(450);
        swaped3.setScaleX(1.5);
        swaped3.setScaleY(1.5);
        
        start.setLayoutX(1340);
        start.setLayoutY(475);
        start.setScaleX(1.5);
        start.setScaleY(1.5);

        
        Group root = new Group();//Se le agregan los elemenos a la pantalla
        //Se inician sliders, label, boton y caja de texto que iran en pantalla
        TextField text = new TextField();
        text.setLayoutX(550);
        text.setPromptText("Numero de Cajas");
        Button boton = new Button("Confirmar");
        boton.setLayoutX(480);
        
        velo.setLayoutX(750);
        velo.setPromptText("Velocidad");
        
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
        root.getChildren().addAll(imageView,text,boton,velo,l,l2,Titulo, wile, swaped, foor, iff, primeriff, seguniff, terceriff, swaped2, ifSwaped, breakk, end, segunfoor, iff2, primeriff2,seguniff2, terceriff2, swaped3, start);
        Scene scene = new Scene(root, 1600, 600);
        Stage stage = new Stage();

        
        //Se dibuja la grua
        MovimientoGrua grua = new MovimientoGrua();
        Group fondo = grua.dibujarGrua(scene);
        root.getChildren().add(fondo);


        empezarordenamiento(cajas,cajas2,root,16,1, Titulo, wile, swaped, foor, iff, primeriff, seguniff, terceriff, swaped2, ifSwaped, breakk, end, segunfoor, iff2, primeriff2,seguniff2, terceriff2, swaped3, start);
        //boton que genera nuevo arreglo y elimina el anterior de la pantalla
        boton.setOnAction((event) -> {
            root.getChildren().clear();
            
            root.getChildren().addAll(imageView,text,boton,velo,l,l2,Titulo, wile, swaped, foor, iff, primeriff, seguniff, terceriff, swaped2, ifSwaped, breakk, end, segunfoor, iff2, primeriff2,seguniff2, terceriff2, swaped3, start); ////////////
            root.getChildren().add(fondo);
            root.getChildren().removeAll(cajas2);
            if (velo.getText().isEmpty()||text.getText().isEmpty() ) {
                velo.setPromptText("Necesita ingresar un valor");
                text.setPromptText("Necesita ingresar un valor");
            } else {
                try {
                empezarordenamiento(cajas,cajas2,root,Integer.parseInt(text.getText()),Double.parseDouble(velo.getText()), Titulo, wile, swaped, foor, iff, primeriff, seguniff, terceriff, swaped2, ifSwaped, breakk, end, segunfoor, iff2, primeriff2,seguniff2, terceriff2, swaped3, start);
                } catch (NumberFormatException e) {
                    Label error = new Label("Error necesita ser un numero");
                    error.setLayoutX(550);
                    error.setLayoutY(50);
                    root.getChildren().add(error);
                }
            }
            
        });
        
            
        //Se inicia la pantalla
        stage.setScene(scene);
        stage.show();

    }

    
public int[] numerosaleatorios(int largo){
    int[]numeros = new int[largo];
      for (int x=0;x<numeros.length;x++){
        numeros[x] = (int) (Math.random()*99)+1;
      }
      return numeros;
}
public void empezarordenamiento(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int largo,double velo, Label Titulo, Label wile, Label swaped, Label foor, Label iff, Label primeriff, Label seguniff, Label terceriff, Label swaped2, Label ifSwaped, Label breakk, Label end, Label segunfoor, Label iff2, Label primeriff2,Label seguniff2, Label terceriff2, Label swaped3, Label start){
     
      int []numeros=numerosaleatorios(largo);
      sinOrdenar(cajas,cajas2,root,numeros);
      j=0;
      
      SequentialTransition animacion = cocktail(numeros,cajas2,root,velo);
      animacion.play();
}  
    
    
    public SequentialTransition cocktail(int[] arr, ArrayList<Group> cajas2,Group root,double velo) {
        SequentialTransition animacion = new SequentialTransition();
        MovimientoGrua grua = new MovimientoGrua();
        Group carro = grua.crearcarroGrua(78);
        root.getChildren().addAll(carro);
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

                    TranslateTransition transicion = new TranslateTransition(Duration.seconds(velo),cajas2.get(i+1));
                    transicion.setByX(-(67));

                    TranslateTransition transicionup = new TranslateTransition(Duration.seconds(velo),cajas2.get(i+1));
                    transicionup.setByY(-100);

                    TranslateTransition transiciondown = new TranslateTransition(Duration.seconds(velo),cajas2.get(i+1));
                    transiciondown.setByY(100);

                    TranslateTransition transicion2 = new TranslateTransition(Duration.seconds(velo),cajas2.get(i));
                    transicion2.setByX((67));

                    ParallelTransition pt = new ParallelTransition(transicion,transicion2,grua.moverCarro(carro, i+1,velo));

                    animacion.getChildren().addAll(transicionup,pt,transiciondown);

                    Group cajaJ2 = (Group) cajas2.get(i + 1);
                    Group cajaI2 = (Group) cajas2.get(i);
                    cajas2.set(i + 1, cajaI2);
                    cajas2.set(i, cajaJ2);
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
                    TranslateTransition transicion = new TranslateTransition(Duration.seconds(velo),cajas2.get(i+1));
                    transicion.setByX(-(67));

                    TranslateTransition transicionup = new TranslateTransition(Duration.seconds(velo),cajas2.get(i+1));
                    transicionup.setByY(-100);

                    TranslateTransition transiciondown = new TranslateTransition(Duration.seconds(velo),cajas2.get(i+1));
                    transiciondown.setByY(100);

                    TranslateTransition transicion2 = new TranslateTransition(Duration.seconds(velo),cajas2.get(i));
                    transicion2.setByX(67);

                    ParallelTransition pt = new ParallelTransition(transicion,transicion2);

                    animacion.getChildren().addAll(transicionup,pt,transiciondown);

                    Group cajaJ2 = (Group) cajas2.get(i + 1);
                    Group cajaI2 = (Group) cajas2.get(i);
                    cajas2.set(i + 1, cajaI2);
                    cajas2.set(i, cajaJ2);
                }

            }
            // Actualizar el extremo izquierdo
            start++;
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
public void moverjuntotamaño(double valor){
    
    
    for (int j = 0; j < cajas.size(); j++) {
                    Caja caja = (Caja) cajas.get(j);
                    Group cajit = (Group) cajas2.get(j);
                    if (valor<100) {
                        TranslateTransition tt = caja.moverCaja(cajit, -valor*j*1.3,0);
                        posx[j]=valor*j*1.3;
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
public SequentialTransition cambioColor(Label label){
    SequentialTransition colorChange = new SequentialTransition(label);
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(0.5),new KeyValue(label.styleProperty(), "-fx-background-color: #71abdb;"))));
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(0.5),new KeyValue(label.styleProperty(), "-fx-background-color:white;"))));
    return colorChange;
}
    
    
}
