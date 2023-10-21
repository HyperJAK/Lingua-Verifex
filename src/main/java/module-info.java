module com.app.theoryofcompproj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.app.theoryofcompproj to javafx.fxml;
    exports com.app.theoryofcompproj;
}