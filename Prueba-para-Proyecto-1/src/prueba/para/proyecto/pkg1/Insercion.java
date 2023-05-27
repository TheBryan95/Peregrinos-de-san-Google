package prueba.para.proyecto.pkg1;

import java.io.File;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
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

public class Insercion extends Stage {
    
    ArrayList<Caja> cajas = new ArrayList();
    ArrayList<Group> cajas2 = new ArrayList(); 
    int j;
    Caja cajita;
    int indice =0;
    TextField velo = new TextField();
    
    public Insercion() {
        Label Nombre = new Label("Ordenamiento Inserción");
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
        boton2.setLayoutX(300);
        
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
        
        root.getChildren().addAll(imageView,text,boton,velo,l,l2,Nombre,Titulo,foor,primer,segundo,wile,primerwile,segunwile,finall,boton2);
        
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


        empezarordenamiento(cajas,cajas2,root,16,1, foor,primer,segundo, wile,primerwile,segunwile,finall,boton2);
        //boton que genera nuevo arreglo y elimina el anterior de la pantalla
        boton.setOnAction((event) -> {
            root.getChildren().clear();
            
            root.getChildren().addAll(imageView,text,boton,velo,l,l2,Nombre,Titulo,foor,primer,segundo,wile,primerwile,segunwile,finall,boton2); ////////////
            root.getChildren().add(fondo);
            root.getChildren().removeAll(cajas2);
            if (velo.getText().isEmpty()||text.getText().isEmpty() ) {
                velo.setPromptText("Necesita ingresar un valor");
                text.setPromptText("Necesita ingresar un valor");
            } else {
                try {
                    empezarordenamiento(cajas,cajas2,root,Integer.parseInt(text.getText()),Double.parseDouble(velo.getText()), foor,primer,segundo, wile,primerwile,segunwile,finall,boton2);
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


public void empezarordenamiento(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int largo,double velo, Label foor, Label primer, Label segundo, Label wile, Label primerwile, Label segunwile, Label finall,Button boton2){
     
      int []numeros=numerosaleatorios(largo);
      sinOrdenar(cajas,cajas2,root,numeros);
      j=0;
      SequentialTransition animacion = insercion(cajas2,root,numeros,velo, foor,primer,segundo, wile,primerwile,segunwile,finall);
      boton2.setOnAction((event) -> {
            animacion.play();
        });
      
      if (indice == numeros.length){
          animacion.stop();
      }
}  
    
public SequentialTransition  insercion (ArrayList<Group> cajas2,Group root,int[] numeros,double velo, Label foor, Label primer, Label segundo, Label wile, Label primerwile, Label segunwile, Label finall){
      SequentialTransition animacion = new SequentialTransition();
      MovimientoGrua grua = new MovimientoGrua();
      Group carro = grua.crearcarroGrua(78);
      MovimientoGrua grua2 = new MovimientoGrua();
      Group carro2 = grua2.crearSegundoCarroGrua(78);
      root.getChildren().addAll(carro,carro2);
      
        for (int i = 1; i < numeros.length; i++) {
            animacion.getChildren().add(cambioColor(foor,velo));
            
            
            int valorActual = numeros[i];
            animacion.getChildren().add(cambioColor(primer,velo));
            
            
            int j = i - 1;
            animacion.getChildren().add(cambioColor(segundo,velo));
            
            
            while (j >= 0 && numeros[j] > valorActual) { 
                animacion.getChildren().add(cambioColor(wile,velo));
               
                
                TranslateTransition transicion = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                transicion.setByX(-(67));
                
                TranslateTransition transicionup = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                transicionup.setByY(-100);
                
                
                numeros[j + 1] = numeros[j]; 
                animacion.getChildren().add(cambioColor(primerwile,velo));
                animacion.getChildren().add(cambioColor2(segunwile,velo));
                
                TranslateTransition transiciondown = new TranslateTransition(Duration.seconds(velo),cajas2.get(j+1));
                transiciondown.setByY(100);
                
                
                TranslateTransition transicion2 = new TranslateTransition(Duration.seconds(velo),cajas2.get(j));
                transicion2.setByX((67));
               
                
                animacion.getChildren().addAll(grua.moverCarro(carro, j, velo),grua2.moverCarro(carro2, j+1, velo));
                ParallelTransition pt = new ParallelTransition(transicion,transicion2,grua.moverCarro(carro, j+1,velo),grua2.moverCarro(carro2, j, velo));
                ParallelTransition pt2 = new ParallelTransition(transicionup,grua2.cambiarLinea(carro2,-0.45,98,velo));
                animacion.getChildren().addAll(grua2.cambiarLinea(carro2,0.45,98,velo),pt2,grua2.moverCarro(carro2, j, velo),pt);
                ParallelTransition pt3 = new ParallelTransition(grua2.cambiarLinea(carro2,0.45,98,velo),transiciondown);
                animacion.getChildren().addAll(cambioColor3(segunwile,velo),pt3,grua2.cambiarLinea(carro2,-0.45,98,velo));
                
                Group cajaJ2 = (Group) cajas2.get(j + 1);
                Group cajaI2 = (Group) cajas2.get(j);
                cajas2.set(j + 1, cajaI2);
                cajas2.set(j, cajaJ2);
                

                j--;
            }
          
            animacion.getChildren().add(cambioColor(finall,velo));
            numeros[j + 1] = valorActual;
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




public Transition cambioColor(Label label,double velo){
    SequentialTransition colorChange = new SequentialTransition(label);
    
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(velo/5),new KeyValue(label.styleProperty(), "-fx-background-color: #71abdb;"))));
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(velo/5),new KeyValue(label.styleProperty(), "-fx-background-color:white;"))));
    return colorChange;
}
public Transition cambioColor2(Label label,double velo){
    SequentialTransition colorChange = new SequentialTransition(label);
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(velo/5),new KeyValue(label.styleProperty(), "-fx-background-color: #71abdb;"))));
    return colorChange;
}
public Transition cambioColor3(Label label,double velo){
    SequentialTransition colorChange = new SequentialTransition(label);
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(velo/5),new KeyValue(label.styleProperty(), "-fx-background-color:white;"))));
    return colorChange;
}

}
