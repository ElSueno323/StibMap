/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Model.DataBase;
import Model.Facade;
import Presentation.ControllerFxml;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/window.fxml"));

        Facade fcd = new Facade();
        ControllerFxml ctrl = new ControllerFxml(fcd);
        loader.setController(ctrl);

        Scene scene = new Scene(loader.load());

        stage.setResizable(false);
        stage.setTitle("HE2B ESI - STIB Planner");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

