package application;
	
import java.beans.PropertyDescriptor;

import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanProperty;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Interface extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Model model = new Model();
			ObservableList<PropertySheet.Item> list = FXCollections.observableArrayList();
			
			for(PropertyDescriptor i : model.getPropertyDescriptors()) {
				list.add(new BeanProperty(model, i));
			}
			
			PropertySheet propertySheet = new PropertySheet(list);
			root.getChildren().add(propertySheet);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void lancer(String[] args) {
		launch(args);
	}
}
