package view;

import handlers.FlashCardHandler;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Patrick
 */
public class StageController extends Application {

    private Stage primaryStage;

    private FlashCardHandler handler;

    public StageController(FlashCardHandler handler) {
        this.handler = handler;
    }

    public StageController() {
    }

    public void launchGUI(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Japanese Teacher");
        this.primaryStage.setResizable(false);
//        this.primaryStage.setMaxWidth(1024);
//        this.primaryStage.setMaxHeight(768);
//        this.primaryStage.setMinWidth(1024);
//        this.primaryStage.setMinHeight(768);
        showMainView();
        this.primaryStage.show();
    }

    public void showMainView() {
        try {
            //Load fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StageController.class.getResource("MainView.fxml"));
            BorderPane page = (BorderPane) loader.load();

            //Set scene
            Scene scene = new Scene(page);
            this.primaryStage.setScene(scene);

            //Init controller
            MainViewCTRL controller = loader.getController();
            controller.setStageController(this);
            controller.setHandler(handler);
        } catch (IOException ex) {
            Logger.getLogger(StageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showPlayView(String mode) {
        try {
            //Load fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StageController.class.getResource("PlayWrapperView.fxml"));
            BorderPane page = (BorderPane) loader.load();
            
            FXMLLoader loader1;
            AnchorPane page1;

            switch (mode) {
                default:
                    loader1 = new FXMLLoader();
                    loader1.setLocation(StageController.class.getResource("EnglishMode.fxml"));
                    page1 = (AnchorPane) loader1.load();
                    break;
            }

            //Set scene
            Scene scene = new Scene(page);
            page.setCenter(page1);
            this.primaryStage.setScene(scene);

            //Init controller
            PlayWrapperViewCTRL controller = loader.getController();
            controller.setStageController(this);
            controller.setHandler(handler);
            controller.setMode(mode);
            
            EnglishModeCTRL controller1 = loader1.getController();
            
        } catch (IOException ex) {
            Logger.getLogger(StageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showGetReadyView() {
        try {
            //Load fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StageController.class.getResource("GetReadyView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            //Set scene
            Scene scene = new Scene(page);
            this.primaryStage.setScene(scene);

            //Init controller
            GetReadyViewCTRL controller = loader.getController();
            controller.setStageController(this);
            controller.setHandler(handler);
        } catch (IOException ex) {
            Logger.getLogger(StageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
