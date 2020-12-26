package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private Button histButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button divButton;

    @FXML
    private Button modButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button multButton;

    @FXML
    private Button sinButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button plusButton;

    @FXML
    private Button cosButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button zeroButton;

    @FXML
    private Button ansButton;

    @FXML
    private Button equalsButton;

    @FXML
    private Button tanButton;

    @FXML
    private Button decimalButton;

    @FXML
    private Label expression;

    @FXML
    private Label ansLabel;

    private ArrayList<String> calculation_histroy= new ArrayList<>();
    public void addCalculation(String expression, String result){
        this.calculation_histroy.add(expression + " = "+ result);
    }
    public Label getExpression() {
        return expression;
    }
    public Label getAnsLabel(){
        return ansLabel;
    }
    public void setAnsLabel(String newResult){
        this.ansLabel.setText("= "+ newResult);
    }
    public void deleteLast(){
        if(!getExpression().getText().isEmpty()){
            StringBuilder text = new StringBuilder(getExpression().getText());
            text.deleteCharAt(text.length()-1);
            getExpression().setText(text.toString());
        }
    }

    public void openHistoryWindow(){
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/sample/history.fxml"));
            Parent root=loader.load();
            Main.getHistoryStage().setScene(new Scene(root));

            HistoryController historyController= loader.getController();
            historyController.initializeCalculation(calculation_histroy);

            Main.getHistoryStage().show();
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
    @FXML
    void handlieButtonPressed(ActionEvent event) {
        Button button= (Button)event.getSource();
        String buttonText= button.getText();
//        insertNumber(buttonText);
        switch(buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "0":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            case "Sin":
            case "Cos":
            case "Tan":
                insertOperator(buttonText);
                break;
            case "Clear":
                clearExpression();
                break;
            case "=":
                double result= Evaluate.evaluate(this.getExpression().getText());
                addCalculation(this.getExpression().getText(),String.valueOf(result));
                setAnsLabel(String.valueOf(result));
                break;
            case "Delete":
                deleteLast();
                break;
            case "Hist":
                openHistoryWindow();
                break;
        }
    }
    public void insertNumber(String number){
        expression.setText(expression.getText()+number);
    }

    public void insertOperator(String operator){
        expression.setText(expression.getText()+" "+operator + " ");
    }
    public void clearExpression(){
        expression.setText("");
    }

}
