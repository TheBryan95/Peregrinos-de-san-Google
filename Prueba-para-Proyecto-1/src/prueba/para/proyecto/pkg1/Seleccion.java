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
        backButton.setOnAction(event -> {
            ((Stage) backButton.getScene().getWindow()).close();
        });
        backButton.setLayoutX(1250);
        
        velo.setLayoutX(750);
        velo.setPromptText("Velocidad");
        
        Label l =new Label();
        l.setLayoutX(400);
        Label l2 = new Label();
        l2.setLayoutX(650);

        //Se inicia la pantalla 
        String imagePath = "fondonuevo.jpg";
        Image image = new Image(new File(imagePath).toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1300);
        imageView.setFitHeight(600);
        imageView.setPreserveRatio(true);
        
        String imagePath1 = "yoda.png";
        Image image1 = new Image(new File(imagePath1).toURI().toString());
        ImageView imageView1 = new ImageView(image1);
        imageView1.setX(900);
        imageView1.setY(260);
        
        root.getChildren().addAll(imageView,imageView1, Nombre,Titulo,foor,minIndex, segunfoor, iff, minIndex2, temp, arr_minIndex, arr_i, backButton);
        
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

//        //Se dibuja la grua
//        MovimientoGrua grua = new MovimientoGrua();
//        Group fondo = grua.dibujarGrua(scene);
//        root.getChildren().add(fondo);
        
        empezarordenamiento(cajas, cajas2, root, 6, 0.5);
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
public void empezarordenamiento(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int largo,double velo){
     
      int []numeros=numerosaleatorios(largo);
      sinOrdenar(cajas,cajas2,root,numeros);
      j=0;
      animacion = seleccion(cajas,cajas2,root,numeros,velo);
      animacion.play();
}

public SequentialTransition seleccion(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int[] numeros,double velo){

        ParallelTransition pt = new ParallelTransition();
        for (int k = 0; k< numeros.length; k++) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(2), cajas2.get(k));
            tt.setByX(290);
            pt.getChildren().add(tt);
        }
        animacion.getChildren().add(pt);
        int minimo = cajas.get(0).numcaja;
        int indiceminimo = 0;
        SequentialTransition rotacion = new SequentialTransition();
        
            
            for (int i = numeros.length-1; i >= 0; i--) {
                for (int k = 0; k<= i; k++) {
                    if (cajas.get(k).numcaja<minimo) {
                            minimo = cajas.get(k).numcaja;  
                            indiceminimo=k;
                        }
                }
                if (i==indiceminimo) {
                    RotateTransition rt = new RotateTransition(Duration.seconds(1),cajas2.get(i));
                    rt.setByAngle(-45);
                    TranslateTransition moveradelante = new TranslateTransition(Duration.seconds(1),cajas2.get(i));
                    moveradelante.setByX(100-i*-35);
                    moveradelante.setByY(-100-i*35);

                    ParallelTransition pt2 = new ParallelTransition();
                    for (int k = 0; k< i; k++) {
                        TranslateTransition tt = new TranslateTransition(Duration.seconds(2), cajas2.get(k));
                        tt.setByX(55);
                        pt2.getChildren().add(tt);
                    }
                    rotacion.getChildren().addAll(rt,moveradelante,pt2);
                }
                else{
                    RotateTransition rt = new RotateTransition(Duration.seconds(1),cajas2.get(i));
                    rt.setByAngle(45);
                    TranslateTransition moveradelante = new TranslateTransition(Duration.seconds(1),cajas2.get(i));
                    moveradelante.setByX(100-i*-35);
                    moveradelante.setByY(100-i*-35);

                    ParallelTransition pt2 = new ParallelTransition();
                    for (int k = 0; k< i; k++) {
                        TranslateTransition tt = new TranslateTransition(Duration.seconds(2), cajas2.get(k));
                        tt.setByX(55);
                        pt2.getChildren().add(tt);
                    }
                    rotacion.getChildren().addAll(rt,moveradelante,pt2);
                }
            }
<<<<<<< HEAD
            //////////////////////////////////////////////////
            
            TranslateTransition moveradelante = new TranslateTransition(Duration.seconds(1),cajas2.get(indiceminimo));
            moveradelante.setByX(-100-indiceminimo*35);
            moveradelante.setByY(100-indiceminimo*-35);

            RotateTransition rt = new RotateTransition(Duration.seconds(1),cajas2.get(indiceminimo));
            rt.setByAngle(45);

            TranslateTransition moveratras = new TranslateTransition(Duration.seconds(1),cajas2.get(indiceminimo));
            moveratras.setByX(-55*numeros.length);

            rotacion.getChildren().addAll(moveradelante,rt,moveratras);
                    
            for (int i = 0; i <=numeros.length-1; i++) {
                    if (i!=indiceminimo) {
                        moveradelante = new TranslateTransition(Duration.seconds(1),cajas2.get(i));
                        moveradelante.setByX(-100-i*35);
                        moveradelante.setByY(-100-i*35);
                        
                        rt = new RotateTransition(Duration.seconds(1),cajas2.get(i));
                        rt.setByAngle(-45);
                        
                        moveratras = new TranslateTransition(Duration.seconds(1),cajas2.get(i));
                        moveratras.setByX(-55*(numeros.length-(i+1)));
                        
                        rotacion.getChildren().addAll(moveradelante,rt,moveratras);
                    }
                    else{
                        moveratras = new TranslateTransition(Duration.seconds(1),cajas2.get(i+1));
                        moveratras.setByX(-55*(numeros.length-(i+1)));
                    }
                    
                
            }
        
=======
            if (i==indiceminimo) {
                RotateTransition rt = new RotateTransition(Duration.seconds(1),cajas2.get(i));
                rt.setByAngle(-45);
                TranslateTransition moveradelante = new TranslateTransition(Duration.seconds(1),cajas2.get(i));
                moveradelante.setByX(100-i*-35);
                moveradelante.setByY(-100-i*35);
                

                ParallelTransition pt2 = new ParallelTransition();
                for (int k = 0; k< i; k++) {
                    TranslateTransition tt = new TranslateTransition(Duration.seconds(2), cajas2.get(k));
                    tt.setByX(55);
                    pt2.getChildren().add(tt);
                }
                rotacion.getChildren().addAll(rt,moveradelante,pt2);
            }
            else{
                TranslateTransition moveradelante = new TranslateTransition(Duration.seconds(1),cajas2.get(i));//Mueve la caja despues de la separacion
                moveradelante.setByX((200-i*-50));

                ParallelTransition pt2 = new ParallelTransition();
             
                for (int k = 0; k< i; k++) {
                    TranslateTransition tt = new TranslateTransition(Duration.seconds(1), cajas2.get(k));
                    tt.setByX(55);
                    pt2.getChildren().add(tt);
                }
                rotacion.getChildren().addAll(moveradelante,pt2);
            }
            
            
            
        }
>>>>>>> parent of dd0829b (Merge remote-tracking branch 'origin/Jeremy' into Bryan)
        animacion.getChildren().add(rotacion);
        
        
//        for (int i = 0; i < n - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < n; j++) {
//                if (numeros[j] < numeros[minIndex]) {
//                    minIndex = j;
//                    
//                }
//            }
//            
//            // Intercambia el elemento mínimo encontrado con el primer elemento sin ordenar
//           
//            int temp = numeros[minIndex];
//            numeros[minIndex] = numeros[i];
//            numeros[i] = temp;
//        }
    return animacion;
}

public void sinOrdenar(ArrayList<Caja> cajas,ArrayList<Group> cajas2,Group root,int[]numeros){
    root.getChildren().removeAll(cajas2);
    cajas.clear();
    cajas2.clear();
    Caja grande = new Caja(50, 50, 25);
    Group trensito = grande.crearTren();
    
    
    for (int x=0,i=50;x<numeros.length;x++){
            cajita = new Caja(i, 280, numeros[x]);
            cajas.add(cajita);
            Group cajis = cajita.crearVagon();
            cajas2.add(cajis);

            i=i+145;
        }
    cajas2.add(trensito);
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

