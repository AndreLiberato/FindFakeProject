package Project.FindFakeNews.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;

public class MainController implements Initializable {
  @FXML
  private Label thresholdPercentage;
  @FXML
  private Slider thresholdSlider;
  
    
    @Override
  public void initialize(URL location, ResourceBundle resources) {
    

      thresholdSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
        thresholdPercentage.setText(Double.toString(newValue.intValue()+'%'));
    });

  }
}