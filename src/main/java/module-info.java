module com.application.bibli_sapien {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.application.bibli_sapien to javafx.fxml;
    exports com.application.bibli_sapien;
}
