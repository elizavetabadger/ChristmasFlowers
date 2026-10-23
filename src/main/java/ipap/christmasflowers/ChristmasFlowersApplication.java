package ipap.christmasflowers;
// https://acmp.ru/index.asp?main=task&id_task=504

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChristmasFlowersApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChristmasFlowersApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Расстановка цветочков");
        stage.setScene(scene);
        stage.show();
    }
}
