package com.windowssoftwareupdater.softwareupdater.util;

import com.windowssoftwareupdater.softwareupdater.pojo.SoftwareInfo;
import java.util.ArrayList;
import java.util.List;

public class SoftwareInfoUtil {

    /**
     * Parses the output of the Winget command to extract software information.
     *
     * @param output the string output from the Winget command containing details about available software upgrades
     * @return a list of {@link SoftwareInfo} objects containing the parsed software information
     */
    public static List<SoftwareInfo> parseWingetOutput(String output) {
        List<SoftwareInfo> softwareList = new ArrayList<>();
        String[] lines = output.split("\n");

        boolean inDataSection = false;

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("----")) {
                inDataSection = true;
                continue;
            }

            if (!inDataSection || line.isEmpty() || line.matches("\\d+ upgrades available.")) {
                continue;
            }

            if (line.contains("The following packages have an upgrade available")) {
                inDataSection = false;  // stop processing the normal section
                continue;
            }
            parseAndAddSoftwareInfo(line, softwareList);
        }
        return softwareList;
    }

    /**
     * Parses a line of software information and adds it to the provided list of software info objects.
     *
     * @param line the string containing software information with columns separated by two or more spaces
     * @param softwareList the list to which the parsed {@link SoftwareInfo} object will be added
     */
    private static void parseAndAddSoftwareInfo(String line, List<SoftwareInfo> softwareList) {
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
}