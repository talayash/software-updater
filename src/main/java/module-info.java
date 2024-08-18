module com.windowssoftwareupdater.softwareupdater {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.windowssoftwareupdater.softwareupdater to javafx.fxml;
    exports com.windowssoftwareupdater.softwareupdater;
}