module com.application {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.application to javafx.fxml;

    exports com.application;
    exports com.application.Database;
    exports com.application.Modelos;
    exports com.application.Telas;

    opens com.application.Telas;
}
