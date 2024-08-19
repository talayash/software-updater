package com.windowssoftwareupdater.softwareupdater.util;

import com.windowssoftwareupdater.softwareupdater.pojo.SoftwareInfo;
import java.util.ArrayList;
import java.util.List;

public class SoftwareInfoUtil {

    /**
     * Parses the output of the 'winget' command and extracts information about installed software.
     *
     * @param output the output string of the 'winget' command
     * @return a list of SoftwareInfo objects representing the installed software
     */
    public static List<SoftwareInfo> parseWingetOutput(String output) {
        List<SoftwareInfo> softwareList = new ArrayList<>();
        String[] lines = output.split("\n");

        boolean dataSectionStarted = false;
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("----")) {
                dataSectionStarted = true;
                continue;
            }
            if (!dataSectionStarted || line.isEmpty() || line.matches("\\d+ upgrades available.")) {
                continue;
            }

            // Parsing logic assumes name and id are separated by two or more spaces
            String[] columns = line.split("\\s{2,}");

            if (columns.length >= 4) {
                String name = columns[0];
                String id = columns[columns.length - 4];
                String currentVersion = columns[columns.length - 3];
                String availableVersion = columns[columns.length - 2];
                String source = columns[columns.length - 1];

                softwareList.add(new SoftwareInfo(name, id, currentVersion, availableVersion, source));
            }
        }
        return softwareList;
    }

}