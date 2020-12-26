package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage historyStage=null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator" +
                "");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        creatHistroyStage();
    }
    public void creatHistroyStage(){
        historyStage = new Stage();
        historyStage.setTitle("Calculation History");
        historyStage.setAlwaysOnTop(true);
        historyStage.setResizable(false);
        historyStage.initModality(Modality.APPLICATION_MODAL);
    }
    public static Stage getHistoryStage(){
        return historyStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
