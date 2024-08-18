package com.windowssoftwareupdater.softwareupdater.util;

public class CmdCommands {
    // Attributes
    public static final String WINGET_UPGRADE = "winget upgrade";
    public static final String WINGET_UPGRADE_ALL = "winget upgrade --all";
    public static final String VERSION = "--version";
    public static final String CMD_EXE = "cmd.exe";
    public static final String C = "/c";

    /**
     * Updates a specific version of a software using the Windows command line utility WINGET.
     * Example: "winget upgrade discord --version 0.15.2"
     *
     * @param softwareName the name of the software to update
     * @param targetVersion the target version to update to
     * @return the command to execute for updating the specific version of the software
     */
    public static String updateSpecificVersion(String softwareName, String targetVersion) {
        return WINGET_UPGRADE + " " + softwareName + VERSION + " " + targetVersion;
    }
}
