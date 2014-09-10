
package view;

import handlers.FlashCardHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Patrick
 */
public class PlayWrapperViewCTRL {
    
    private StageController stageController;
    private FlashCardHandler handler;
    
    @FXML
    private Label modeLb;
    @FXML
    private Button backBTN;
    
    public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }
    
    public void setHandler(FlashCardHandler handler) {
        this.handler = handler;
    }
    
    @FXML
    private void initialize() {
        
    }
    
    public void setMode(String mode) {
        switch(mode) {
            default:
                modeLb.setText("English mode");
                break;
        }
    }
    
    @FXML
    private void handleBack() {
        stageController.showMainView();
    }

}
