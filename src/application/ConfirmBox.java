package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {
	
	static boolean answer;

	public static boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		noButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		Label emptyLabel = new Label("");
		
		VBox top = new VBox();
		top.setAlignment(Pos.BASELINE_CENTER);
		top.getChildren().add(label);
		
		StackPane center = new StackPane();
		center.getChildren().add(emptyLabel);
		
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BASELINE_CENTER);
		bottom.setSpacing(10);
		bottom.getChildren().addAll(yesButton, noButton);
		
		BorderPane layout = new BorderPane();
		layout.setPadding(new Insets(7.5, 5, 5, 5));
		layout.setTop(top);
		layout.setBottom(bottom);
		layout.setCenter(center);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
	
}
