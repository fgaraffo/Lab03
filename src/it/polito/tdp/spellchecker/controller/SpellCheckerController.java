/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {

    private Model model;
    private String [] parole;
	
    @FXML // fx:id="boxLingua"
    private ComboBox<String> boxLingua; // Value injected by FXMLLoader
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInput"
    private TextArea txtInput; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearTxt"
    private Button btnClearTxt; // Value injected by FXMLLoader

    @FXML // fx:id="txtStatus"
    private Label txtStatus; // Value injected by FXMLLoader

    @FXML // fx:id="txtPerformance"
    private Label txtPerformance; // Value injected by FXMLLoader

    @FXML
    void doActivation(ActionEvent event) {

    	txtInput.clear();
    	txtInput.setDisable(false);
    	txtResult.setDisable(false);
    	btnSpellCheck.setDisable(false);
    	btnClearTxt.setDisable(false);
    	txtStatus.setDisable(false);
    	txtPerformance.setDisable(false);
    	   	
    	
    }
    
    @FXML
    void doClear(ActionEvent event) {
    	
    	txtResult.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    	if (txtInput.getText().length()==0)
    	{
    		txtStatus.setText("ERRORE: Inserire delle parole.");
    		return;
    	}
    	
    	String input = txtInput.getText().toLowerCase();
    	input = input.replaceAll("[^a-zA-Z ]", "");

    	System.out.println(input);
    	parole = input.split(" ");
    	
    	ArrayList<String> res = model.controllo(parole);
    	
    	txtResult.appendText(res.toString());
    	txtStatus.setText(String.format("The text contains %d errors", 0));    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert boxLingua != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'SpellChecker.fxml'.";
    	assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearTxt != null : "fx:id=\"btnClearTxt\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtStatus != null : "fx:id=\"txtStatus\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtPerformance != null : "fx:id=\"txtPerformance\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }

	public void setModel(Model m) {
		
		txtInput.setDisable(true);
		txtInput.setText("Selezionare una lingua");

		txtResult.setDisable(true);
		boxLingua.getItems().addAll("English", "Italian");

		btnSpellCheck.setDisable(true);
		btnClearTxt.setDisable(true);

		txtStatus.setText("");
		txtPerformance.setText("");

		this.model = m;
		
	}
}
