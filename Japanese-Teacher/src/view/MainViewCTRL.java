
package view;

import handlers.FlashCardHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Patrick
 */
public class MainViewCTRL {
    
    private StageController stageController;
    private FlashCardHandler handler;
    
    @FXML
    private TableView table;
    @FXML
    private TableColumn userCol;
    @FXML
    private TableColumn modeCol;
    @FXML
    private TableColumn pendingCol;
    @FXML
    private Button startBTN;
    @FXML
    private MenuItem manageCardsItem;
    @FXML
    private MenuItem manageUsersItem;
    
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
    private void handleStart() {
        stageController.showGetReadyView();
    }
    
    @FXML
    private void handleManageCards() {
        
    }
    
    @FXML
    private void handleManageUsers() {
        
    }

}
