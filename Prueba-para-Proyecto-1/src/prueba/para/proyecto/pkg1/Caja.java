package prueba.para.proyecto.pkg1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Caja {
    int xinicial,yinicial,numcaja;
    Rectangle fondo= new Rectangle();
    Rectangle borde= new Rectangle();
    
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

        caja.getChildren().addAll(borde,fondo);

        return caja;
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
