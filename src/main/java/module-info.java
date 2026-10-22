module ipap.christmasflowers {
    requires javafx.controls;
    requires javafx.fxml;


    opens ipap.christmasflowers to javafx.fxml;
    exports ipap.christmasflowers;
}