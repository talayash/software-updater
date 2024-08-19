package com.windowssoftwareupdater.softwareupdater;

import com.windowssoftwareupdater.softwareupdater.cmd.CmdExecutor;
import com.windowssoftwareupdater.softwareupdater.pojo.SoftwareInfo;
import com.windowssoftwareupdater.softwareupdater.util.CmdCommands;
import com.windowssoftwareupdater.softwareupdater.util.SoftwareInfoUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        // Execute command and show output
        String cmdOutput = CmdExecutor.executeCommand(CmdCommands.WINGET_UPGRADE);

        cmdOutput = "Name                     Id                                    Version    Available Source\n" +
                "-------------------------------------------------------------------------------------------------\n" +
                "Microsoft Edge           Microsoft.Edge                       91.0.864.59 91.0.864.64 winget\n" +
                "Visual Studio Code       Microsoft.VisualStudioCode           1.56.2     1.57.0      winget\n" +
                "Discord                  Discord.Discord                      1.0.9003   1.0.9012    winget\n" +
                "7-Zip                    7zip.7zip                            19.00      19.02       winget\n" +
                "Git                      Git.Git                              2.31.1     2.32.0      winget\n" +
                "Node.js                  OpenJS.Nodejs                        14.17.0    14.17.1     winget\n" +
                "Google Chrome            Google.Chrome                        91.0.4472.101 91.0.4472.114 winget\n" +
                "\n" +
                "7 upgrades available.\n";
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