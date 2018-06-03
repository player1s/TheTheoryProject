import Controller.SystemController;
import Mediator.ModelManager;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainScene;

public class MainApp extends Application {

    @Override
    public void start(Stage stage)  {
        ModelManager model = new ModelManager();
        MainScene gui = new MainScene();
        SystemController systemController = new SystemController(model, gui);
        gui.start(stage);
    }

    public static void main(String args[]) {
        launch(args);
    }

}