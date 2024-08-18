package com.windowssoftwareupdater.softwareupdater.pojo;

public class SoftwareInfo {
    String name;
    String currentVersion;
    String availableVersion;
    String source;

    public SoftwareInfo(String name, String currentVersion, String availableVersion, String source) {
        this.name = name;
        this.currentVersion = currentVersion;
        this.availableVersion = availableVersion;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Current Version: " + currentVersion +
                ", Available Version: " + availableVersion + ", Source: " + source;
    }
}