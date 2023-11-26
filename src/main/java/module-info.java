module com.example.montyhall {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.montyhall to javafx.fxml;
    exports com.example.montyhall;
}