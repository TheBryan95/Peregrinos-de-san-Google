package prueba.para.proyecto.pkg1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
     @Override
    public void start(Stage primaryStage) {
        Label l1 = new Label("Menu de ordenamientos Visuales");
        l1.setLayoutX(15);
        Label l2 = new Label();
        l2.setLayoutX(15);
        l2.setLayoutY(30);
        Button botonInsert = new Button("Insert Sort");
        Button botonBubble = new Button("Bubble Sort");
        Button botonCocktail = new Button("Cocktail Sort");
        botonInsert.setLayoutX(70);
        botonInsert.setLayoutY(60);
        botonBubble.setLayoutX(70);
        botonBubble.setLayoutY(100);
        botonCocktail.setLayoutX(70);
        botonCocktail.setLayoutY(140);
        Group root = new Group(l1,l2,botonInsert,botonBubble,botonCocktail);
        Scene scene = new Scene(root, 200, 200);
        scene.setFill(Color.LIGHTSKYBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
        botonInsert.setOnAction((event) -> {
            Insercion ventana = new Insercion();
        });
        botonBubble.setOnAction((event) -> {
            Burbuja ventana = new Burbuja();
        });
        botonCocktail.setOnAction((event) -> {
            Cocktail ventana = new Cocktail();
        });
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
        
        
    }