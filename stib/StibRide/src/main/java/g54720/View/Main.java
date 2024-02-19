package g54720.View;

import g54720.Model.Model;
import g54720.Presentation.Presenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/view.fxml"));
        Parent fxml = loader.load();

        Model model=new Model();
        ControllerView controllerView=loader.getController();
        Presenter presenter=new Presenter(model,controllerView);
        model.registerObserver(presenter);

        Scene scene=new Scene(fxml);

        stage.setScene(scene);
        stage.setResizable(false);

        presenter.initialize();
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
