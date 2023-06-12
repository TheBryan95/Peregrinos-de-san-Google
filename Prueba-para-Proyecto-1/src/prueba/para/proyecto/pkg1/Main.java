package prueba.para.proyecto.pkg1;

import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
     @Override
    public void start(Stage primaryStage) {
        Label l1 = new Label("Menu de ordenamientos Visuales");
        l1.setFont(Font.font("Times New Roman", 14));
        
        l1.setScaleX(2);
        l1.setScaleY(2);
        l1.setStyle("-fx-font-weight: bold;");
        l1.setLayoutX(235);
        l1.setLayoutY(10);
        
        Label l2 = new Label();
        l2.setLayoutX(15);
        l2.setLayoutY(30);
        Button botonInsert = new Button("Insert Sort");
        Button botonBubble = new Button("Bubble Sort");
        Button botonCocktail = new Button("Cocktail Sort");
        Button botonSelection = new Button("Selection Sort");
        
        String imagePath = "menu.jpg";
        Image image = new Image(new File(imagePath).toURI().toString());
        ImageView imageView = new ImageView(image);
        
        botonInsert.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), null)));
        botonInsert.setTextFill(Color.WHITE);
        botonInsert.setFont(Font.font("Times New Roman", 14));
        botonInsert.setLayoutX(230);
        botonInsert.setLayoutY(200);
        botonInsert.setPrefWidth(200);
        botonInsert.setScaleX(2);
        botonInsert.setScaleY(2);
        
        botonBubble.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), null)));
        botonBubble.setTextFill(Color.WHITE);
        botonBubble.setFont(Font.font("Times New Roman", 14));
        botonBubble.setLayoutX(230);
        botonBubble.setLayoutY(350);
        botonBubble.setPrefWidth(200);
        botonBubble.setScaleX(2);
        botonBubble.setScaleY(2);
        
        botonCocktail.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), null)));
        botonCocktail.setTextFill(Color.WHITE);
        botonCocktail.setFont(Font.font("Times New Roman", 14));
        botonCocktail.setLayoutX(230);
        botonCocktail.setLayoutY(500);
        botonCocktail.setPrefWidth(200);
        botonCocktail.setScaleX(2);
        botonCocktail.setScaleY(2);
        
        
        botonSelection.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), null)));
        botonSelection.setTextFill(Color.WHITE);
        botonSelection.setFont(Font.font("Times New Roman", 14));
        botonSelection.setLayoutX(230);
        botonSelection.setLayoutY(650);
        botonSelection.setPrefWidth(200);
        botonSelection.setScaleX(2);
        botonSelection.setScaleY(2);
        
        Group root = new Group(imageView,l1,l2,botonInsert,botonBubble,botonCocktail, botonSelection);
        Scene scene = new Scene(root, 640, 960);
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
        botonSelection.setOnAction((event) -> {
            Seleccion ventana = new Seleccion();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    }