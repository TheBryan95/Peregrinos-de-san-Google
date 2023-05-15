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
import javax.crypto.AEADBadTagException;

public class Burbuja extends Stage {
    
    ArrayList<Caja> cajas = new ArrayList();
    ArrayList<Group> cajas2 = new ArrayList(); 
    double [] posx = new double[99];
    int j;
    Caja cajita;
    TextField velo = new TextField();
    
    public Burbuja() {
        Label Nombre = new Label("Ordenamiento Burbuja");
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
        root.getChildren().addAll(imageView,text,boton,velo,l,l2,Nombre,Titulo,foor,primer,segundo,wile,primerwile,segunwile,finall);
        
        Nombre.setLayoutX(40);
        Nombre.setScaleX(1.5);
        Nombre.setScaleY(1.5);
        Nombre.setStyle("-fx-font-weight: bold;");
        
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


        empezarordenamiento(cajas,cajas2,root,16,1, foor,primer,segundo, wile,primerwile,segunwile,finall);
        //boton que genera nuevo arreglo y elimina el anterior de la pantalla
        boton.setOnAction((event) -> {
            root.getChildren().clear();
            
            root.getChildren().addAll(imageView,text,boton,velo,l,l2,Nombre,Titulo,foor,primer,segundo,wile,primerwile,segunwile,finall);
            root.getChildren().add(fondo);
            root.getChildren().removeAll(cajas2);
            if (velo.getText().isEmpty()||text.getText().isEmpty() ) {
                velo.setPromptText("Necesita ingresar un valor");
                text.setPromptText("Necesita ingresar un valor");
            } else {
                try {
                    empezarordenamiento(cajas,cajas2,root,Integer.parseInt(text.getText()),Double.parseDouble(velo.getText()) ,foor,primer,segundo, wile,primerwile,segunwile,finall);
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
public void empezarordenamiento(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int largo,double velo, Label foor, Label primer, Label segundo, Label wile, Label primerwile, Label segunwile, Label finall){
     
      int []numeros=numerosaleatorios(largo);
      sinOrdenar(cajas,cajas2,root,numeros);
      j=0;
      SequentialTransition animacion = burbuja(cajas2,root,numeros,velo);
      animacion.play();
}    

    
public SequentialTransition  burbuja(ArrayList<Group> cajas2,Group root,int[] numeros,double velo){
        SequentialTransition animacion = new SequentialTransition();
        MovimientoGrua grua = new MovimientoGrua();
        Group carro = grua.crearcarroGrua(78);
        root.getChildren().addAll(carro);
         int n = numeros.length;
         for(int i = 0; i < n-1; i++){
             for (int j = 0; j < n-i-1; j++){
                 if (numeros[j] > numeros[j+1]){
                     // intercambiar numeros[j] y numeros[j+1]
                    int temp = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = temp;
                    
                    TranslateTransition transicionup = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                     transicionup.setByY(-100);
                     TranslateTransition transicion = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                     transicion.setByX(-(67));
                     TranslateTransition transicion2 = new TranslateTransition(Duration.seconds(velo),cajas2.get(j));
                     transicion2.setByX((67));
                     TranslateTransition transiciondown = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                     transiciondown.setByY(100);
                     
                     ParallelTransition pt = new ParallelTransition(transicion,transicion2,grua.moverCarro(carro, j+1,velo));
                     animacion.getChildren().addAll(transicionup,pt,transiciondown);
                     Group cajaJ2 = (Group) cajas2.get(j + 1);
                     Group cajaI2 = (Group) cajas2.get(j);
                     cajas2.set(j + 1, cajaI2);
                     cajas2.set(j, cajaJ2);
                 }
             }
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
