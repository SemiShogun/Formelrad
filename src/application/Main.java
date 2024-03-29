package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Formelrad Application
 * 
 * @author Raphael Suter und Jamie Lam
 * @version 01.11.2019
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();

			// Creating an image
			Image image = new Image(getClass().getResourceAsStream("formelradelektronik.gif"));
			ImageView imageView = new ImageView(image);
			imageView.setX(10);
			imageView.setY(10);
			imageView.setFitHeight(300);
			imageView.setFitWidth(300);
			imageView.setPreserveRatio(true);
			root.getChildren().add(imageView);

			Label lbleistung = new Label("Leistung:");
			lbleistung.relocate(10, 285);
			lbleistung.setFont(Font.font(15));
			root.getChildren().add(lbleistung);

			TextField txLeistung = new TextField();
			txLeistung.relocate(100, 285);
			txLeistung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txLeistung);

			Label lblSpannung = new Label("Spannung:");
			lblSpannung.relocate(10, 325);
			lblSpannung.setFont(Font.font(15));
			root.getChildren().add(lblSpannung);

			TextField txSpannung = new TextField();
			txSpannung.relocate(100, 325);
			txSpannung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txSpannung);

			Label lblStrom = new Label("Strom:");
			lblStrom.relocate(10, 365);
			lblStrom.setFont(Font.font(15));
			root.getChildren().add(lblStrom);

			TextField txStrom = new TextField();
			txStrom.relocate(100, 365);
			txStrom.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txStrom);

			Label lblWiderstand = new Label("Widerstand:");
			lblWiderstand.relocate(10, 405);
			lblWiderstand.setFont(Font.font(15));
			root.getChildren().add(lblWiderstand);

			TextField txWiderstand = new TextField();
			txWiderstand.relocate(100, 405);
			txWiderstand.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txWiderstand);

			Button btnBerechnen = new Button();
			btnBerechnen.relocate(100, 445);
			btnBerechnen.setText("Berechnen");
			root.getChildren().add(btnBerechnen);

			btnBerechnen.setOnAction(e -> {
				double power = 0.0;
				double tension = 0.0;
				double current = 0.0;
				double resistence = 0.0;
				if (txLeistung.getText().isEmpty() == false) {
					power = Double.parseDouble(txLeistung.getText());
				}
				if (txSpannung.getText().isEmpty() == false) {
					tension = Double.parseDouble(txSpannung.getText());
				}
				if (txStrom.getText().isEmpty() == false) {
					current = Double.parseDouble(txStrom.getText());
				}
				if (txWiderstand.getText().isEmpty() == false) {
					resistence = Double.parseDouble(txWiderstand.getText());
				}
				Calculator myCalculator = new Calculator(power, tension, current, resistence);

				if (power == 0.0) {
					txLeistung.setStyle("-fx-text-fill: red;");
				} else {
					txLeistung.setStyle("-fx-text-fill: black;");
				}
				
				if (tension == 0.0) {
					txSpannung.setStyle("-fx-text-fill: red;");
				} else {
					txSpannung.setStyle("-fx-text-fill: black;");
				}
				
				if (current == 0.0) {
					txStrom.setStyle("-fx-text-fill: red;");
				} else {
					txStrom.setStyle("-fx-text-fill: black;");
				}
				
				if (resistence == 0.0) {
					txWiderstand.setStyle("-fx-text-fill: red;");
				} else {
					txWiderstand.setStyle("-fx-text-fill: black;");
				}

				txLeistung.setText(Double.toString(myCalculator.getLeistung()));
				txSpannung.setText(Double.toString(myCalculator.getSpannung()));
				txStrom.setText(Double.toString(myCalculator.getStrom()));
				txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
			});

			Scene scene = new Scene(root, 330, 490);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Formelrad");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
