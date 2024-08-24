module com.windowssoftwareupdater.softwareupdater {
    requires javafx.controls;
    requires javafx.fxml;
    requires io.github.cdimascio.dotenv.java;


    opens com.windowssoftwareupdater.softwareupdater to javafx.fxml;
    exports com.windowssoftwareupdater.softwareupdater;
}