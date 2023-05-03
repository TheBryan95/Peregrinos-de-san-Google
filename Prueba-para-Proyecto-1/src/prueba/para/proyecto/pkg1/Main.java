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
        
        l1.setScaleX(1);
        l1.setScaleY(1);
        l1.setStyle("-fx-font-weight: bold;");
        l1.setLayoutX(7);
        
        Label l2 = new Label();
        l2.setLayoutX(15);
        l2.setLayoutY(30);
        Button botonInsert = new Button("Insert Sort");
        Button botonBubble = new Button("Bubble Sort");
        Button botonCocktail = new Button("Cocktail Sort");
        
        botonInsert.setLayoutX(50);
        botonInsert.setLayoutY(60);
        
        botonInsert.setPrefWidth(100);
        botonBubble.setLayoutX(50);
        botonBubble.setLayoutY(100);
        botonBubble.setPrefWidth(100);
        
        botonCocktail.setLayoutX(50);
        botonCocktail.setLayoutY(140);
        botonCocktail.setPrefWidth(100);
        
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