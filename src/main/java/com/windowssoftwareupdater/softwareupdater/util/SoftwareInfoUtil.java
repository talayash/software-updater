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
        final int HEADER_LINE_COUNT = 3;
        List<SoftwareInfo> softwareList = new ArrayList<>();
        String[] lines = output.split("\n");

        for (int index = HEADER_LINE_COUNT; index < lines.length; index++) {
            String line = lines[index].trim();
            if (line.isEmpty())
                continue;

            SoftwareInfo softwareInfo = parseLine(line);
            if (softwareInfo != null) {
                softwareList.add(softwareInfo);
            }
        }
        return softwareList;
    }

    /**
     * Parses a string line and generates a SoftwareInfo object.
     *
     * @param line the string line to be parsed
     * @return a SoftwareInfo object created from the parsed line, or null if the line does not contain enough columns
     */
    private static SoftwareInfo parseLine(String line) {
        String[] columns = line.split("\\s+");
        if (columns.length >= 5) {
            String name = columns[0];
            String version = columns[2];
            String availableVersion = columns[3];
            String source = columns[4];
            return new SoftwareInfo(name, version, availableVersion, source);
        }
        return null;
    }
}