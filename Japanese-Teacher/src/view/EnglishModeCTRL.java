
package view;

import handlers.FlashCardHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author Patrick
 */
public class EnglishModeCTRL {
    
    private StageController stageController;
    private FlashCardHandler handler;
    
    @FXML
    private Label englishWordLB;
    @FXML
    private Text englishDescLB;
    @FXML
    private Label romajiWordLB;
    @FXML
    private Label kanaWordLB;
    @FXML
    private Label kanjiWordLB;
    @FXML
    private Button answeredBTN;
    @FXML
    private Button rightBTN;
    @FXML
    private Button wrongBTN;
    
    
    public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }
    
    public void setHandler(FlashCardHandler handler) {
        this.handler = handler;
    }
    
    @FXML
    private void initialize() {
        
    }
    
    @FXML
    private void handleAnswered() {
        
    }
    
    @FXML
    private void handleRight() {
        
    }
    
    @FXML
    private void handleWrong() {
        
    }

}
