package com.windowssoftwareupdater.softwareupdater.pojo;

public class SoftwareInfo {
    // Attributes
    private String _name;
    private String _id;
    private String _currentVersion;
    private String _availableVersion;
    private String _source;

    // Constructor
    public SoftwareInfo(String name, String id, String currentVersion, String availableVersion, String source) {
        _name = name;
        _id = id;
        _currentVersion = currentVersion;
        _availableVersion = availableVersion;
        _source = source;
    }

    @Override
    public String toString() {
        return "SoftwareInfo{" +
                "_name='" + _name + '\'' +
                ", _id='" + _id + '\'' +
                ", _currentVersion='" + _currentVersion + '\'' +
                ", _availableVersion='" + _availableVersion + '\'' +
                ", _source='" + _source + '\'' +
                '}';
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_currentVersion() {
        return _currentVersion;
    }

    public void set_currentVersion(String _currentVersion) {
        this._currentVersion = _currentVersion;
    }

    public String get_availableVersion() {
        return _availableVersion;
    }

    public void set_availableVersion(String _availableVersion) {
        this._availableVersion = _availableVersion;
    }

    public String get_source() {
        return _source;
    }

    public void set_source(String _source) {
        this._source = _source;
    }
}
