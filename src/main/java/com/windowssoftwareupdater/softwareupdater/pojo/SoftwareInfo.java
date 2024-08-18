package com.windowssoftwareupdater.softwareupdater.pojo;

public class SoftwareInfo {
    // Attributes
    private String name;
    private String currentVersion;
    private String availableVersion;
    private String source;

    // Constructor
    public SoftwareInfo(String name, String currentVersion, String availableVersion, String source) {
        this.name = name;
        this.currentVersion = currentVersion;
        this.availableVersion = availableVersion;
        this.source = source;
    }

    // To String
    @Override
    public String toString() {
        return "Name: " + name + ", Current Version: " + currentVersion +
                ", Available Version: " + availableVersion + ", Source: " + source;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getAvailableVersion() {
        return availableVersion;
    }

    public void setAvailableVersion(String availableVersion) {
        this.availableVersion = availableVersion;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}