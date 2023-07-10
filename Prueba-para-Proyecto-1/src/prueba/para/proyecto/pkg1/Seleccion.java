package prueba.para.proyecto.pkg1;

import java.io.File;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Seleccion extends  Stage{
    ArrayList<Caja> cajas = new ArrayList();
    ArrayList<Group> cajas2 = new ArrayList(); 
    int j;
    Caja cajita;
    TextField velo = new TextField();
    SequentialTransition animacion = new SequentialTransition();
    
    public Seleccion(){
        Label Nombre = new Label("Ordenamiento Seleccion");
        Label Titulo = new Label("Algoritmo");
        Label foor = new Label("for (int i = 0; i < n - 1; i++)");
        Label minIndex = new Label("int minIndex = i;");
        Label segunfoor = new Label("for (int j = i + 1; j < n; j++)");
        Label iff = new Label("if (arr[j] < arr[minIndex])");
        Label minIndex2 = new Label("minIndex = j;");
        Label temp = new Label("int temp = arr[minIndex];");
        Label arr_minIndex = new Label("arr[minIndex] = arr[i];");
        Label arr_i = new Label(" arr[i] = temp;");
        
        Group root = new Group();//Se le agregan los elemenos a la pantalla
        //Se inician sliders, label, boton y caja de texto que iran en pantalla
        TextField text = new TextField();
        text.setLayoutX(550);
        text.setPromptText("Numero de Cajas");
        Button boton = new Button("Confirmar");
        boton.setLayoutX(480);
        
        Button boton2 = new Button("Empezar");
        boton2.setLayoutX(300);
        
        Button backButton = new Button("Cerrar");
        backButton.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(10), null)));
        backButton.setTextFill(Color.WHITE);
        backButton.setScaleX(1.5);
        backButton.setScaleY(1.5);
        backButton.setOnAction(event -> {
            ((Stage) backButton.getScene().getWindow()).close();
        });
        backButton.setLayoutX(1530);
        backButton.setLayoutY(10);
        
        velo.setLayoutX(750);
        velo.setPromptText("Velocidad");
        
        Label l =new Label();
        l.setLayoutX(400);
        Label l2 = new Label();
        l2.setLayoutX(650);

        //Se inicia la pantalla 
        String imagePath = "fondonuevoalargado.jpg";
        Image image = new Image(new File(imagePath).toURI().toString());
        ImageView imageView = new ImageView(image);
        
        String imagePath1 = "yoda.png";
        Image image1 = new Image(new File(imagePath1).toURI().toString());
        ImageView imageView1 = new ImageView(image1);
        imageView1.setX(1100);
        imageView1.setY(220);
        
        root.getChildren().addAll(imageView,Nombre,Titulo,foor,minIndex, segunfoor, iff, minIndex2, temp, arr_minIndex, arr_i, backButton, imageView1);
        
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

        minIndex.setLayoutX(1370);
        minIndex.setLayoutY(75);
        minIndex.setScaleX(1.5);
        minIndex.setScaleY(1.5);

        segunfoor.setLayoutX(1382);
        segunfoor.setLayoutY(100);
        segunfoor.setScaleX(1.5);
        segunfoor.setScaleY(1.5);

        iff.setLayoutX(1400);
        iff.setLayoutY(125);
        iff.setScaleX(1.5);
        iff.setScaleY(1.5);

        minIndex2.setLayoutX(1410);
        minIndex2.setLayoutY(150);
        minIndex2.setScaleX(1.5);
        minIndex2.setScaleY(1.5);

        temp.setLayoutX(1380);
        temp.setLayoutY(175);
        temp.setScaleX(1.5);
        temp.setScaleY(1.5);

        arr_minIndex.setLayoutX(1374);
        arr_minIndex.setLayoutY(200);
        arr_minIndex.setScaleX(1.5);
        arr_minIndex.setScaleY(1.5);
        
        arr_i.setLayoutX(1360);
        arr_i.setLayoutY(225);
        arr_i.setScaleX(1.5);
        arr_i.setScaleY(1.5);
       
        Scene scene = new Scene(root, 1600, 600);
        Stage stage = new Stage();
        
        empezarordenamiento(cajas, cajas2, root, 16, 0.5, foor, minIndex, segunfoor, iff, minIndex2, temp, arr_minIndex, arr_i);
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
public void empezarordenamiento(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int largo,double velo, Label foor,Label minIndex,Label segunfoor, Label iff,Label minIndex2,Label temp, Label arr_minIndex, Label arr_i){
     
      int []numeros=numerosaleatorios(largo);
      sinOrdenar(cajas,cajas2,root,numeros);
      j=0;
      animacion = seleccion(cajas,cajas2,root,numeros,velo, foor, minIndex, segunfoor, iff, minIndex2, temp, arr_minIndex, arr_i);
      animacion.play();
}

public SequentialTransition seleccion(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int[] numeros,double velo, Label foor,Label minIndex,Label segunfoor, Label iff,Label minIndex2,Label temp, Label arr_minIndex, Label arr_i){
    //Cajas para que sirvan de locomotora
        Caja grande = new Caja(1064, 130, 00);
        Group locomotora = grande.crearTren();
        grande.tamanoCaja(locomotora, 30,1);
        
        Caja grande2 = new Caja(1875, 282, 00);
        Group locomotora2 = grande2.crearTren();
        grande2.tamanoCaja(locomotora2, 30, 1);
        
        Caja grande3 = new Caja(-7, 282, 00);
        Group locomotora3 = grande3.crearTren();
        grande2.tamanoCaja(locomotora3, 30, 1);
        
        root.getChildren().addAll(locomotora,locomotora2,locomotora3);
        
        //Se mueven todas de donde se crearon al cruce
        ParallelTransition pt = new ParallelTransition();
        
        for (int k = 0; k< numeros.length; k++) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cajas2.get(k));
            tt.setByX(40);
            TranslateTransition movilocomo3 = new TranslateTransition(Duration.seconds(1), locomotora3);
            movilocomo3.setByX(40);
            pt.getChildren().add(tt);
            pt.getChildren().add(movilocomo3);
        }
        RotateTransition rtloco = new RotateTransition(Duration.seconds(0),locomotora);
        rtloco.setByAngle(-45);
         pt.getChildren().add(rtloco);
        animacion.getChildren().add( pt);
        
        int n = cajas.size();
        for (int i = 0; i < n; i++) {
            animacion.getChildren().add(cambioColor(foor, velo));
            animacion.getChildren().add(cambioColor(minIndex, velo));
            int minimo = cajas.get(0).numcaja;
            int indiceminimo = 0;
            SequentialTransition rotacion = new SequentialTransition();

            //se busca el minimo en esta iteracion
            for (int k = 0; k<=cajas.size()-1; k++) {
                animacion.getChildren().add(cambioColor(segunfoor, velo));
                if (cajas.get(k).numcaja<minimo) {
                        animacion.getChildren().add(cambioColor(iff, velo));
                         animacion.getChildren().add(cambioColor(minIndex2, velo));
                        minimo = cajas.get(k).numcaja;
                        indiceminimo=k;
                    }
            }
            
            //INTENTO LOCOMOTORA 1
            TranslateTransition movilocomo2 = new TranslateTransition(Duration.seconds(1), locomotora2);
            movilocomo2.setByX(-900);
            rotacion.getChildren().add(movilocomo2);  
               
            //Se mueve la seccion en frente del minimo
            ParallelTransition pt2 = new ParallelTransition();
            int contador = 0;
            for (int k = cajas.size()-1; k>indiceminimo; k--) {
                TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cajas2.get(k));
                tt.setByX(900);
                pt2.getChildren().add(tt);
                contador++;
            }
            
            movilocomo2 = new TranslateTransition(Duration.seconds(1), locomotora2);
            movilocomo2.setByX(900);
            pt2.getChildren().add(movilocomo2);
            
            rotacion.getChildren().addAll( pt2);

            //Se mueve lo demas dejando el minimo para rotar
            
            pt2 = new ParallelTransition();
            for (int k = indiceminimo; k>=0; k--) {
                TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cajas2.get(k));
                tt.setByX(55*contador);
                TranslateTransition movilocomo3 = new TranslateTransition(Duration.seconds(1), locomotora3);
                movilocomo3.setByX(55*contador);
                pt2.getChildren().add(tt);
                pt2.getChildren().add(movilocomo3);
            }
            rotacion.getChildren().addAll(pt2);
            //el elemento menor se hacen las animaciones para que se mueva hacia arriba
             
            TranslateTransition moverdiag2loc = new TranslateTransition(Duration.seconds(1), locomotora);
            moverdiag2loc.setByX(-115);
            moverdiag2loc.setByY(115);
            
            RotateTransition rt = new RotateTransition(Duration.seconds(1),cajas2.get(indiceminimo));
            rt.setByAngle(-45);
            
            ParallelTransition arriba = new ParallelTransition();
            TranslateTransition moveradelante = new TranslateTransition(Duration.seconds(1),cajas2.get(indiceminimo));
            moveradelante.setByX(115);
            moveradelante.setByY(-115);
            arriba.getChildren().add(moveradelante);
            animacion.getChildren().add(cambioColor2(temp, velo)); 
            
            TranslateTransition moverdiagloc = new TranslateTransition(Duration.seconds(1), locomotora);
            moverdiagloc.setByX(115);
            moverdiagloc.setByY(-115);
            arriba.getChildren().add(moverdiagloc);
            
            rotacion.getChildren().addAll(moverdiag2loc,rt,arriba);
            
            //Vuelve el segmento que estaba delante al minimo para enganchar al que estaba detras del minimo
            
            ParallelTransition pt4 = new ParallelTransition();
            for (int k = cajas.size()-1; k>indiceminimo; k--) {
                TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cajas2.get(k));
                tt.setByX(-900+(contador-1)*55);
                pt4.getChildren().add(tt);
            }
            movilocomo2 = new TranslateTransition(Duration.seconds(1), locomotora2);
            movilocomo2.setByX(-900+(contador-1)*55);
            pt4.getChildren().add(movilocomo2);
            rotacion.getChildren().addAll(pt4);
            //Mueve todas las cajas juntas hacia adelante
            pt2 = new ParallelTransition();
            for (int k = 0; k< indiceminimo; k++) {
                TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cajas2.get(k));
                tt.setByX((900)-(contador-1)*55);
                pt2.getChildren().add(tt);
            }
            for (int k = cajas.size()-1; k>indiceminimo; k--) {
                TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cajas2.get(k));
                tt.setByX(900-(contador-1)*55);
                pt2.getChildren().add(tt);
            }
            movilocomo2 = new TranslateTransition(Duration.seconds(1), locomotora2);
            movilocomo2.setByX(900-(contador-1)*55);
            pt2.getChildren().add(movilocomo2);
            rotacion.getChildren().addAll(pt2);
            
            
            //El elemento menor que esta arriba baja y queda ordenado
            ParallelTransition diags = new ParallelTransition();
            moverdiag2loc = new TranslateTransition(Duration.seconds(1), locomotora);
            moverdiag2loc.setByX(-115);
            moverdiag2loc.setByY(115);
            
            moveradelante = new TranslateTransition(Duration.seconds(1),cajas2.get(indiceminimo));
            moveradelante.setByX(-115);
            moveradelante.setByY(115);
 
            diags.getChildren().addAll(moveradelante,moverdiag2loc);
            animacion.getChildren().add(cambioColor2(temp, velo));
            
            ParallelTransition diags2 = new ParallelTransition();
            rt = new RotateTransition(Duration.seconds(1),cajas2.get(indiceminimo));
            rt.setByAngle(45);
            moverdiag2loc = new TranslateTransition(Duration.seconds(1), locomotora);
            moverdiag2loc.setByX(115);
            moverdiag2loc.setByY(-115);
            ParallelTransition ajustarloco3 = new ParallelTransition();
            TranslateTransition movilocomo3 = new TranslateTransition(Duration.seconds(1), locomotora3);
            movilocomo3.setByX(770-(contador-1)*55);
            ajustarloco3.getChildren().add(movilocomo3);
            
            diags2.getChildren().addAll(rt,moverdiag2loc, movilocomo3);
            
            ParallelTransition atrass = new ParallelTransition();
            TranslateTransition moveratras = new TranslateTransition(Duration.seconds(1),cajas2.get(indiceminimo));
            moveratras.setByX(-900+55*(i));
            TranslateTransition atraslocomo3 = new TranslateTransition(Duration.seconds(1), locomotora3);
            atraslocomo3.setByX(-900+55*(i));
            atrass.getChildren().addAll(moveratras, atraslocomo3);
            rotacion.getChildren().addAll(diags,diags2, atrass);
            
            
            //Se elimina del arreglo el menor para asi poder tratar lo que queda como otro arreglo
            
            cajas.remove(indiceminimo);
            cajas2.remove(indiceminimo);
            
            //Se mueven todos los demas hacia atras para volver a buscar el menor
            ParallelTransition pt3 = new ParallelTransition();
            pt3 = new ParallelTransition();
            for (int j = 0; j <=cajas.size()-1; j++) {
                    moveratras = new TranslateTransition(Duration.seconds(1),cajas2.get(j));
                    moveratras.setByX(-900);
                    pt3.getChildren().add(moveratras);
            }
            movilocomo2 = new TranslateTransition(Duration.seconds(1), locomotora2);
            movilocomo2.setByX(-900);
            pt3.getChildren().add(movilocomo2);
            rotacion.getChildren().add(pt3);
            
            movilocomo2 = new TranslateTransition(Duration.seconds(1), locomotora2);
            movilocomo2.setByX(900);
            rotacion.getChildren().add(movilocomo2);
            animacion.getChildren().add(rotacion);
            animacion.getChildren().add(cambioColor3(temp, velo));
            animacion.getChildren().add(cambioColor(arr_minIndex, velo));
            animacion.getChildren().add(cambioColor(arr_i, velo)); 
    }
        
    return animacion;
}


public void sinOrdenar(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int[]numeros){
    root.getChildren().removeAll(cajas2);
    cajas.clear();
    cajas2.clear();

    for (int x=0,i=50;x<numeros.length;x++){
            cajita = new Caja(i, 282, numeros[x]);
            cajas.add(cajita);
            Group cajis = cajita.crearVagon();
            cajas2.add(cajis);

            i=i+145;
        }
    root.getChildren().addAll(cajas2);
    moverjuntotamaño(30);
}

public void moverjuntotamaño(double valor){
    for (int j = 0; j < cajas.size(); j++) {
                    Caja caja = (Caja) cajas.get(j);
                    Group cajit = (Group) cajas2.get(j);
                    if (valor<100) {
                        TranslateTransition tt = caja.moverCaja(cajit, -valor*j*3,0);
                        tt.setDuration(Duration.millis(01));
                        tt.play();
                    }
                    else{
                        TranslateTransition tt =caja.moverCaja(cajit, valor*j*3, 0);
                        tt.setDuration(Duration.millis(01));
                        tt.play();
                    }
                    caja.tamanoCaja(cajit,valor,j);
                }
}

public Transition cambioColor(Label label,double velo){
    SequentialTransition colorChange = new SequentialTransition(label);
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(velo/5),new KeyValue(label.styleProperty(), "-fx-background-color: #71abdb;"))));
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(velo/5),new KeyValue(label.styleProperty(), "-fx-background-color:#fcd793;"))));
    return colorChange;
}
public Transition cambioColor2(Label label,double velo){
    SequentialTransition colorChange = new SequentialTransition(label);
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(velo/5),new KeyValue(label.styleProperty(), "-fx-background-color: #71abdb;"))));
    return colorChange;
}
public Transition cambioColor3(Label label,double velo){
    SequentialTransition colorChange = new SequentialTransition(label);
    colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(velo/5),new KeyValue(label.styleProperty(), "-fx-background-color:#fcd793;"))));
    return colorChange;
}

}


