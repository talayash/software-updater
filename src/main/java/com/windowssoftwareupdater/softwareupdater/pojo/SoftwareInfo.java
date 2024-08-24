package com.windowssoftwareupdater.softwareupdater.pojo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SoftwareInfo {
    // Attributes as JavaFX properties
    private final SimpleStringProperty name;
    private final SimpleStringProperty id;
    private final SimpleStringProperty currentVersion;
    private final SimpleStringProperty availableVersion;
    private final SimpleStringProperty source;
    private final SimpleBooleanProperty selected;

    // Constructor
    public SoftwareInfo(String name, String id, String currentVersion, String availableVersion, String source) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.currentVersion = new SimpleStringProperty(currentVersion);
        this.availableVersion = new SimpleStringProperty(availableVersion);
        this.source = new SimpleStringProperty(source);
        this.selected = new SimpleBooleanProperty(false);  // Default not selected
    }

    // Getters and setters for JavaFX properties
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getCurrentVersion() {
        return currentVersion.get();
    }

    public StringProperty currentVersionProperty() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion.set(currentVersion);
    }

    public String getAvailableVersion() {
        return availableVersion.get();
    }

    public StringProperty availableVersionProperty() {
        return availableVersion;
    }

    public void setAvailableVersion(String availableVersion) {
        this.availableVersion.set(availableVersion);
    }

    public String getSource() {
        return source.get();
    }

    public StringProperty sourceProperty() {
        return source;
    }

    public void setSource(String source) {
        this.source.set(source);
    }

    public boolean isSelected() {
        return selected.get();
    }

    public SimpleBooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    @Override
    public String toString() {
        return "SoftwareInfo{" +
                "name='" + name.get() + '\'' +
                ", id='" + id.get() + '\'' +
                ", currentVersion='" + currentVersion.get() + '\'' +
                ", availableVersion='" + availableVersion.get() + '\'' +
                ", source='" + source.get() + '\'' +
                ", selected=" + selected.get() +
                '}';
    }
}
