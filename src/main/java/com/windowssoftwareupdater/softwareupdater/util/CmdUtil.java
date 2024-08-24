package com.windowssoftwareupdater.softwareupdater.util;

public class CmdUtil {
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

    /**
     * Returns mock data of upgradeable software stored in a formatted string.
     * The mock data includes the columns "Name", "Id", "Version", "Available", and "Source".
     * Each row represents an upgradeable software with its respective information.
     *
     * @return a formatted string containing the mock data of upgradeable software
     */
    public static String wingetUpgradeMockData() {
        return "Name                                    Id                              Version     Available   Source\n" +
                "--------------------------------------------------------------------------------------------------------\n" +
                "Microsoft Edge                          Microsoft.Edge                  114.0.1823  115.0.1901  winget\n" +
                "PowerToys                               Microsoft.PowerToys             0.65.0      0.68.0      winget\n" +
                "Visual Studio Code                      Microsoft.VisualStudioCode      1.78.2      1.79.1      winget\n" +
                "Spotify                                 Spotify.Spotify                 1.2.11      1.2.14      winget\n" +
                "Zoom                                    Zoom.Zoom                       5.14.2      5.15.3      winget\n" +
                "Notepad++                               Notepad++.Notepad++             8.5.2       8.5.3       winget\n" +
                "Git                                     Git.Git                         2.39.0      2.40.0      winget\n" +
                "7-Zip                                   7zip.7zip                       22.01       23.00       winget\n" +
                "\n";
    }
}
