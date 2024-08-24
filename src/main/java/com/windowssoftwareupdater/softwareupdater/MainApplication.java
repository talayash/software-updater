package com.windowssoftwareupdater.softwareupdater;

import com.windowssoftwareupdater.softwareupdater.cmd.CmdExecutor;
import com.windowssoftwareupdater.softwareupdater.pojo.SoftwareInfo;
import com.windowssoftwareupdater.softwareupdater.util.CmdUtil;
import com.windowssoftwareupdater.softwareupdater.util.SoftwareInfoUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load environment variables
        Dotenv dotenv = Dotenv.configure().filename(".env.local").load();
        boolean mockData = Boolean.parseBoolean(dotenv.get("MOCK_DATA"));

        // Execute command and get output
        String cmdOutput = mockData ? CmdUtil.wingetUpgradeMockData() : CmdExecutor.executeCommand(CmdUtil.WINGET_UPGRADE);
        List<SoftwareInfo> softwareList = SoftwareInfoUtil.parseWingetOutput(cmdOutput);

        // Convert list to ObservableList for JavaFX TableView
        ObservableList<SoftwareInfo> observableSoftwareList = FXCollections.observableArrayList(softwareList);

        // Create TableView and columns
        TableView<SoftwareInfo> tableView = new TableView<>();
        tableView.setEditable(true);  // Enable editing of table rows

        // Create and configure the select column with checkboxes
        TableColumn<SoftwareInfo, Boolean> selectColumn = new TableColumn<>("Select");
        selectColumn.setCellValueFactory(param -> param.getValue().selectedProperty());
        selectColumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectColumn));
        selectColumn.setEditable(true);  // Allow editing checkboxes

        // Configure other table columns
        TableColumn<SoftwareInfo, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());

        TableColumn<SoftwareInfo, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(param -> param.getValue().idProperty());

        TableColumn<SoftwareInfo, String> currentVersionColumn = new TableColumn<>("Current Version");
        currentVersionColumn.setCellValueFactory(param -> param.getValue().currentVersionProperty());

        TableColumn<SoftwareInfo, String> availableVersionColumn = new TableColumn<>("Available Version");
        availableVersionColumn.setCellValueFactory(param -> param.getValue().availableVersionProperty());

        TableColumn<SoftwareInfo, String> sourceColumn = new TableColumn<>("Source");
        sourceColumn.setCellValueFactory(param -> param.getValue().sourceProperty());

        // Add columns to the table
        tableView.getColumns().addAll(selectColumn, nameColumn, idColumn, currentVersionColumn, availableVersionColumn, sourceColumn);
        tableView.setItems(observableSoftwareList);

        // Create a button to process selected items
        Button processButton = new Button("Update");
        processButton.setOnAction(e -> updateSelectedSoftware(tableView));

        // Layout setup
        VBox vbox = new VBox();
        Label titleLabel = new Label("Software Updater");
        vbox.getChildren().addAll(titleLabel, tableView, processButton);

        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Software Updater");
        stage.show();
    }

    // Method to process selected items
    private void updateSelectedSoftware(TableView<SoftwareInfo> tableView) {
        // Initialize a list and add selected software programs
        List<SoftwareInfo> selectedItems = new ArrayList<>();
        for (SoftwareInfo softwareInfo : tableView.getItems()) {
            if (softwareInfo.isSelected()) {
                selectedItems.add(softwareInfo);
            }
        }
        System.out.println("Selected items: " + selectedItems);
        // Handle update here for each software
    }

    public static void main(String[] args) {
        launch(args);
    }
}