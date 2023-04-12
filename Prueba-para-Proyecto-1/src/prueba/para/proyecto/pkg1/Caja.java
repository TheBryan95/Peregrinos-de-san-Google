package prueba.para.proyecto.pkg1;

import java.util.ArrayList;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Caja {
    int xinicial,yinicial,numcaja;
    Rectangle fondo= new Rectangle();
    Rectangle borde= new Rectangle();
    Group dig1 = new Group();
    Group dig2= new Group();
    public Caja(int xinicial, int yinicial, int numcaja) {
        this.xinicial = xinicial;
        this.yinicial = yinicial;
        this.numcaja = numcaja;
    }
    //Funcion que retorna el grupo de objetos que hacen la caja para poder agregarla a la pantalla como un solo objeto Group
    public Group crearCaja(){
        
        Group caja = new Group();

        fondo.setX(xinicial);
        fondo.setY(yinicial);
        fondo.setWidth(100);
        fondo.setHeight(100);
        fondo.setFill(Color.rgb(188, 134, 76));
        fondo.setStrokeWidth(10);
        fondo.setStroke(Color.rgb(255, 181, 103));


        borde.setX(xinicial-8);
        borde.setY(yinicial-8);
        borde.setWidth(116);
        borde.setHeight(116);
        borde.setStrokeWidth(5);
        
        int digito1=numcaja/10;
        int digito2=numcaja%10;
        this.dig1=elegirNumDibujar( xinicial+25, yinicial+25, digito1);
        this.dig2=elegirNumDibujar( xinicial+65, yinicial+25, digito2);
        
        caja.getChildren().addAll(borde,fondo,dig1,dig2);

        return caja;
    }
    
    //Funcion que cambia el tamaño de una caja
    public void tamanoCaja(Group caja,double tamano,int j){
        ParallelTransition pt = new ParallelTransition();
        tamano=tamano/100;
        ScaleTransition st = new ScaleTransition(Duration.seconds(1),caja);
        
        st.setToX(tamano);
        st.setToY(tamano);
        pt.getChildren().add(st);
        pt.play();
       
        
    }
    
    public TranslateTransition moverCaja(Group caja,double x,double y){
        TranslateTransition tt = new TranslateTransition(Duration.millis(1000),caja);
        tt.setByX(x);
        tt.setByY(y);
//        tt.play();
        
        return tt;
    }
    public void moverCajaSecuencia(ArrayList<TranslateTransition> secuencia){
        SequentialTransition st = new SequentialTransition();
        for (int i = 0; i < secuencia.size(); i++) {
            st.getChildren().add(secuencia.get(i));
        }
        st.play();
    }
    
    public Group elegirNumDibujar(int xinicial,int yinicial,int digito){
        switch (digito) {
            case 0 -> {
                Group cero=Dibujar0( xinicial, yinicial);
                return cero;
            }
            case 1 ->{
                Group uno=Dibujar1(xinicial, yinicial);
                return uno;
            }
            case 2 -> {
                Group dos = Dibujar2( xinicial, yinicial);
                return dos;
            }
            case 3 -> {
                Group tres =Dibujar3( xinicial, yinicial);
                return tres;
            }
            case 4 -> {
                Group cuatro =Dibujar4( xinicial, yinicial);
                return cuatro;
            }
            case 5 -> {
                Group cinco =Dibujar5( xinicial, yinicial);
                return cinco;
            }
            case 6 -> {
                Group seis =Dibujar6( xinicial, yinicial);
                return seis;
            }
            case 7 -> {
                Group siete =Dibujar7( xinicial, yinicial);
                return siete;
            }
            case 8 -> {
                Group ocho =Dibujar8( xinicial, yinicial);
                return ocho;
            }
            case 9 -> {
                Group nueve =Dibujar9( xinicial, yinicial);
                return nueve;
            }
            
            default -> throw new AssertionError();
        }
    }
    public Group Dibujar0(int xinicial,int yinicial){
        Group cero = new Group();
        xinicial-=2;
        Rectangle rectangulo = new Rectangle(xinicial, yinicial, 20, 50);
        rectangulo.setFill(Color.TRANSPARENT);
        rectangulo.setStrokeWidth(7);
        rectangulo.setStroke(Color.BLACK);
        Line linea = new Line(xinicial+2, yinicial+2, xinicial+19, yinicial+46);
        linea.setStrokeWidth(7);
        cero.getChildren().addAll(rectangulo,linea);
        return cero;
    }
    public Group Dibujar1(int xinicial,int yinicial){
        Group uno = new Group();
        xinicial+=5;  
        Line diagonal1 = new Line(xinicial-10, yinicial+15, xinicial-1, yinicial);
        diagonal1.setStrokeWidth(7);
        Line vertical1 = new Line(xinicial, yinicial, xinicial, yinicial+50);
        vertical1.setStrokeWidth(7);
        uno.getChildren().addAll(vertical1,diagonal1);
        return uno;
    }
    
    public Group Dibujar2(int xinicial,int yinicial){
        Group dos = new Group();
        Line linea1_2 = new Line(xinicial,yinicial,xinicial+15,yinicial);
        linea1_2.setStrokeWidth(7);
        Line linea2_2 = new Line(xinicial+15,yinicial,xinicial+15,yinicial+25);
        linea2_2.setStrokeWidth(7);
        Line linea3_2 = new Line(xinicial,yinicial+25,xinicial+15,yinicial+25);
        linea3_2.setStrokeWidth(7);
        Line linea4_2 = new Line(xinicial,yinicial+25,xinicial,yinicial+50);
        linea4_2.setStrokeWidth(7);
        Line linea5_2 = new Line(xinicial,yinicial+50,xinicial+15,yinicial+50);
        linea5_2.setStrokeWidth(7);
        dos.getChildren().addAll(linea1_2, linea2_2, linea3_2, linea4_2, linea5_2);
        return dos;
    }   

    public Group Dibujar3(int xinicial,int yinicial){
        Group tres = new Group();
        Line linea1_3 = new Line(xinicial,yinicial,xinicial+15,yinicial);
        linea1_3.setStrokeWidth(7);
        Line linea2_3 = new Line(xinicial,yinicial+25,xinicial+15,yinicial+25);
        linea2_3.setStrokeWidth(7);
        Line linea3_3 = new Line(xinicial,yinicial+50,xinicial+15,yinicial+50);
        linea3_3.setStrokeWidth(7);
        Line lineaVertical_3 = new Line(xinicial+15,yinicial,xinicial+15,yinicial+50);
        lineaVertical_3.setStrokeWidth(7);
        tres.getChildren().addAll(linea1_3, linea2_3, linea3_3, lineaVertical_3);
        return tres;
    }

    public Group Dibujar4(int xinicial,int yinicial){
        Group cuatro = new Group();
        Line linea1_4 = new Line(xinicial,yinicial+25,xinicial+15,yinicial+25);
        linea1_4.setStrokeWidth(7);
        Line linea2_4 = new Line(xinicial,yinicial+25,xinicial,yinicial);
        linea2_4.setStrokeWidth(7);
        Line lineaVertical_4 = new Line(xinicial+15,yinicial,xinicial+15,yinicial+50);
        lineaVertical_4.setStrokeWidth(7);
        cuatro.getChildren().addAll(linea1_4,linea2_4, lineaVertical_4);
        return cuatro;
    }

    public Group Dibujar5(int xinicial,int yinicial){
        Group cinco = new Group();
        Line linea1_5 = new Line(xinicial,yinicial,xinicial+15,yinicial);
        linea1_5.setStrokeWidth(7);
        Line linea2_5 = new Line(xinicial,yinicial,xinicial,yinicial+25);
        linea2_5.setStrokeWidth(7);
        Line linea3_5 = new Line(xinicial,yinicial+25,xinicial+15,yinicial+25);
        linea3_5.setStrokeWidth(7);
        Line linea4_5 = new Line(xinicial+15,yinicial+25,xinicial+15,yinicial+50);
        linea4_5.setStrokeWidth(7);
        Line linea5_5 = new Line(xinicial,yinicial+50,xinicial+15,yinicial+50);
        linea5_5.setStrokeWidth(7);
        cinco.getChildren().addAll(linea1_5, linea2_5, linea3_5, linea4_5, linea5_5);
        return cinco;
    }

    public Group Dibujar6(int xinicial,int yinicial){
        Group seis = new Group();
        Line linea1_6 = new Line(xinicial,yinicial,xinicial+15,yinicial);
        linea1_6.setStrokeWidth(7);
        Line linea2_6= new Line(xinicial,yinicial+25,xinicial+15,yinicial+25);
        linea2_6.setStrokeWidth(7);
        Line linea3_6 = new Line(xinicial,yinicial+50,xinicial+15,yinicial+50);
        linea3_6.setStrokeWidth(7);
        Line linea4_6 = new Line(xinicial+15,yinicial+25,xinicial+15,yinicial+50);
        linea4_6.setStrokeWidth(7);
        Line lineaVertical_6 = new Line(xinicial,yinicial,xinicial,yinicial+50);
        lineaVertical_6.setStrokeWidth(7);
        seis.getChildren().addAll(linea1_6,linea2_6,linea3_6,linea4_6,lineaVertical_6);
        return seis;
    }
    
    public Group Dibujar7 (int xinicial, int yinicial){
        Group siete = new Group();
        Line linea1_7 = new Line(xinicial,yinicial,xinicial+20,yinicial);
        linea1_7.setStrokeWidth(7);
        Line linea2_7 = new Line(xinicial+10,yinicial+25,xinicial+20,yinicial+25);
        linea2_7.setStrokeWidth(7);
        Line lineaVertical_7 = new Line(xinicial+20,yinicial,xinicial,yinicial+50);
        lineaVertical_7.setStrokeWidth(7);
        siete.getChildren().addAll(linea1_7,lineaVertical_7);
        return siete;
    }
    
    public Group Dibujar8(int xinicial,int yinicial){
        Group ocho = new Group();
        Line linea1_8 = new Line(xinicial,yinicial,xinicial+15,yinicial);
        linea1_8.setStrokeWidth(7);
        Line linea2_8 = new Line(xinicial,yinicial+25,xinicial+15,yinicial+25);
        linea2_8.setStrokeWidth(7);
        Line linea3_8 = new Line(xinicial,yinicial+50,xinicial+15,yinicial+50);
        linea3_8.setStrokeWidth(7);
        Line lineaVertical_8 = new Line(xinicial,yinicial,xinicial,yinicial+50);
        lineaVertical_8.setStrokeWidth(7);
        Line lineaVertical2_8 = new Line(xinicial+15,yinicial,xinicial+15,yinicial+50);
        lineaVertical2_8.setStrokeWidth(7);
        ocho.getChildren().addAll(linea1_8,linea2_8,linea3_8,lineaVertical_8,lineaVertical2_8);
        return ocho;
    }

    public Group Dibujar9(int xinicial,int yinicial){
        Group nueve= new Group();
        Line linea1_9 = new Line(xinicial,yinicial,xinicial+15,yinicial);
        linea1_9.setStrokeWidth(7);
        Line linea2_9 = new Line(xinicial,yinicial+25,xinicial+15,yinicial+25);
        linea2_9.setStrokeWidth(7);
        Line linea3_9 = new Line(xinicial,yinicial+50,xinicial+15,yinicial+50);
        linea3_9.setStrokeWidth(7);
        Line lineaVertical_9 = new Line(xinicial,yinicial,xinicial,yinicial+25);
        lineaVertical_9.setStrokeWidth(7);
        Line lineaVertical2_9 = new Line(xinicial+15,yinicial,xinicial+15,yinicial+50);
        lineaVertical2_9.setStrokeWidth(7);
        nueve.getChildren().addAll(linea1_9,linea2_9,linea3_9,lineaVertical_9,lineaVertical2_9);
        return nueve;
    }
    
    public int getXinicial() {
        return xinicial;
    }

    public void setXinicial(int xinicial) {
        this.xinicial = xinicial;
    }
    public void setYinicial(int yinicial) {
        this.yinicial = yinicial;
    }
    
    public int getYinicial() {
        return yinicial;
    }
    
    public int getNumcaja() {
        return numcaja;
    }

    public void setNumcaja(int numcaja) {
        this.numcaja = numcaja;
    }
    @Override
    public String toString() {
        return "Caja{" + "xinicial=" + xinicial + ", yinicial=" + yinicial + '}';
    }
}
