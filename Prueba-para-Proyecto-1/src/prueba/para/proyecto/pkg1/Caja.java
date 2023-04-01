package prueba.para.proyecto.pkg1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

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
        Group dig1=elegirNumDibujar( xinicial+25, yinicial+25, digito1);
        Group dig2=elegirNumDibujar( xinicial+65, yinicial+25, digito2);
        this.dig1= dig1;
        this.dig2= dig2;
        caja.getChildren().addAll(borde,fondo,dig1,dig2);

        return caja;
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
