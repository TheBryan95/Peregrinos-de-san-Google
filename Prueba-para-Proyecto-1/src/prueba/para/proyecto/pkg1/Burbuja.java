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
        Label foor = new Label("for (int i = 0; i < n-1; i++)");
        Label segunfoor = new Label("for (int j = 0; j < n-i-1; j++)");
        Label iff = new Label("if (numeros[j] > numeros[j+1])");
        Label primerif = new Label("int temp = numeros[j]");
        Label segunif = new Label("numeros[j] = numeros[j+1]");
        Label tercerif = new Label("numeros[j+1] = temp");
        
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
        root.getChildren().addAll(imageView,text,boton,velo,l,l2,Nombre,Titulo,foor,segunfoor,iff, primerif,segunif,tercerif);
        
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


        segunfoor.setLayoutX(1380);
        segunfoor.setLayoutY(75);
        segunfoor.setScaleX(1.5);
        segunfoor.setScaleY(1.5);


        iff.setLayoutX(1400);
        iff.setLayoutY(100);
        iff.setScaleX(1.5);
        iff.setScaleY(1.5);


        primerif.setLayoutX(1400);
        primerif.setLayoutY(125);
        primerif.setScaleX(1.5);
        primerif.setScaleY(1.5);


        segunif.setLayoutX(1405);
        segunif.setLayoutY(150);
        segunif.setScaleX(1.5);
        segunif.setScaleY(1.5);


        tercerif.setLayoutX(1400);
        tercerif.setLayoutY(175);
        tercerif.setScaleX(1.5);
        tercerif.setScaleY(1.5);


       
        Scene scene = new Scene(root, 1600, 600);
        Stage stage = new Stage();

        
        //Se dibuja la grua
        MovimientoGrua grua = new MovimientoGrua();
        Group fondo = grua.dibujarGrua(scene);
        root.getChildren().add(fondo);


        empezarordenamiento(cajas,cajas2,root,16,1, foor,segunfoor,iff, primerif,segunif,tercerif);
        //boton que genera nuevo arreglo y elimina el anterior de la pantalla
        boton.setOnAction((event) -> {
            root.getChildren().clear();
            
            root.getChildren().addAll(imageView,text,boton,velo,l,l2,Nombre,Titulo,foor,segunfoor,iff, primerif,segunif,tercerif);
            root.getChildren().add(fondo);
            root.getChildren().removeAll(cajas2);
            if (velo.getText().isEmpty()||text.getText().isEmpty() ) {
                velo.setPromptText("Necesita ingresar un valor");
                text.setPromptText("Necesita ingresar un valor");
            } else {
                try {
                    empezarordenamiento(cajas,cajas2,root,Integer.parseInt(text.getText()),Double.parseDouble(velo.getText()),foor,segunfoor,iff, primerif,segunif,tercerif);
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
public void empezarordenamiento(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int largo,double velo, Label foor,Label segunfoor,Label iff,Label primerif,Label segunif,Label tercerif){
     
      int []numeros=numerosaleatorios(largo);
      sinOrdenar(cajas,cajas2,root,numeros);
      j=0;
      SequentialTransition animacion = burbuja(cajas2,root,numeros,velo,foor,segunfoor,iff, primerif,segunif,tercerif);
      animacion.play();
}    

    
public SequentialTransition  burbuja(ArrayList<Group> cajas2,Group root,int[] numeros,double velo, Label foor,Label segunfoor,Label iff,Label primerif,Label segunif,Label tercerif){
         SequentialTransition animacion = new SequentialTransition();
         int n = numeros.length;
         
         for(int i = 0; i < n-1; i++){
            animacion.getChildren().add(cambioColor(foor));
             for (int j = 0; j < n-i-1; j++){
                 animacion.getChildren().add(cambioColor(segunfoor));
                 if (numeros[j] > numeros[j+1]){
                     animacion.getChildren().add(cambioColor(iff));
                     // intercambiar numeros[j] y numeros[j+1]
                    int temp = numeros[j];
                    animacion.getChildren().add(cambioColor(primerif));
                    numeros[j] = numeros[j+1];
                    animacion.getChildren().add(cambioColor(segunif));
                    numeros[j+1] = temp;
                    animacion.getChildren().add(cambioColor(tercerif));
                    
                    
                    TranslateTransition transicionup = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                    transicionup.setByY(-100);
                    TranslateTransition transicion = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                    transicion.setByX(-(67));
                    TranslateTransition transicion2 = new TranslateTransition(Duration.seconds(velo),cajas2.get(j));
                    transicion2.setByX((67));
                    TranslateTransition transiciondown = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                    transiciondown.setByY(100);
                     
                    ParallelTransition pt = new ParallelTransition(transicion,transicion2);
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
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(0.2),new KeyValue(label.styleProperty(), "-fx-background-color: #71abdb;"))));
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(0.2),new KeyValue(label.styleProperty(), "-fx-background-color:white;"))));
    return colorChange;
}
}
