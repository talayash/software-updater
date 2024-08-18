package com.windowssoftwareupdater.softwareupdater;

import com.windowssoftwareupdater.softwareupdater.cmd.CmdExecutor;
import com.windowssoftwareupdater.softwareupdater.pojo.SoftwareInfo;
import com.windowssoftwareupdater.softwareupdater.util.SoftwareInfoUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        // Execute command and show output
        String cmdOutput = CmdExecutor.executeCommand("winget upgrade");
        List<SoftwareInfo> softwareList = SoftwareInfoUtil.parseWingetOutput(cmdOutput);

        StringBuilder displayText = new StringBuilder();
        for (SoftwareInfo software : softwareList) {
            displayText.append(software.toString()).append("\n");
        }

        textArea.setText(displayText.toString());

        Scene scene = new Scene(textArea, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Software Updater");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}