package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;


public class Main extends Application {
	
	Button button1, button2, button3, button4;
	Scene scene1, scene2;
	Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setOnCloseRequest(e ->{
			e.consume();
			closeProgram();
		});
		primaryStage.setTitle("HelloFX Window");
		scene1 = makeScene1(window);
		scene2 = makeScene2(window);
		
		window.setScene(scene1);
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Scene makeScene1(Stage window) {
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.BASELINE_CENTER);
		
		Label label1 = new Label("\"Hello there!\" - Joseph Stambaugh");
		label1.setFont(Font.font("Comic Sans", 20));
		button1 = new Button("Go to scene two");
		button1.setFont(Font.font("Comic Sans", 15));
		button1.setOnMouseClicked(e -> window.setScene(scene2));
		
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 400, 400);
		return scene1;
		
	}
	
	public Scene makeScene2(Stage window) {
		VBox layout2 = new VBox(20);
		layout2.setAlignment(Pos.BASELINE_CENTER);
		
		Label label2 = new Label("\"That's my line!\" - Obi-Wan Kenobi");
		label2.setFont(Font.font("Comic Sans", 20));
		button2 = new Button("Go to scene one");
		button2.setFont(Font.font("Comic Sans", 15));
		button2.setOnMouseClicked(e -> window.setScene(scene1));
		
		button3 = new Button("Don't click me!");
		button3.setFont(Font.font("Comic Sans", 15));
		button3.setTextFill(Color.RED);
		button3.setOnMouseClicked(e -> AlertBox.display("ALERT", "I told you not to click me!"));
		
		button4 = new Button("Definity don't click me");
		button4.setFont(Font.font("Comic Sans", 15));
		button4.setTextFill(Color.DARKRED);
		button4.setOnMouseClicked(e ->{
			System.out.println("Wrong move");
			window.close();
	});
		
		layout2.getChildren().addAll(label2, button2, button3, button4);
		scene2 = new Scene(layout2, 500, 500);
		return scene2;
	}
	
	private void closeProgram() {
		boolean answer = ConfirmBox.display("Close Program", "Are you sure you want to exit?");
		if (answer) {
			window.close();
		}
	}
}
