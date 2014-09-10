
package view;

import handlers.FlashCardHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Patrick
 */
public class GetReadyViewCTRL {
    
    private StageController stageController;
    private FlashCardHandler handler;
    
    @FXML
    private ComboBox userCB;
    @FXML
    private ComboBox<String> modeCB;
    @FXML
    private Button startBTN;
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
        ObservableList<String> modes = FXCollections.observableArrayList();
        modes.add("English mode");
        
        modeCB.setItems(modes);
        modeCB.getSelectionModel().select(0);
    }
    
    @FXML
    private void handleStart() {
        String selMode = modeCB.getSelectionModel().getSelectedItem();
        stageController.showPlayView(selMode);
    }
    
    @FXML
    private void handleBack() {
        stageController.showMainView();
    }

}
