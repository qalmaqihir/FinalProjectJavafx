package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class HistoryController {
    @FXML private Button clearButton;
    @FXML private Button clearButtonAll;
    @FXML private ListView historyList;
    public void initializeCalculation(ArrayList<String> calculation_histroy){
        calculation_histroy.forEach((calculation) -> {
            historyList.getItems().add(calculation);
        });
    }
    @FXML
    void clearButtonClicked() {
        //System.out.println("method called");
        historyList.getItems().forEach((calculation)-> historyList.getItems().remove(calculation));

    }

    public void clearAllButtonClicked() {
      historyList.getItems().removeAll();
    }
}
