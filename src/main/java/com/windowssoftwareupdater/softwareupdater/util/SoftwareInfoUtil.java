package com.windowssoftwareupdater.softwareupdater.util;

import com.windowssoftwareupdater.softwareupdater.pojo.SoftwareInfo;

import java.util.ArrayList;
import java.util.List;

public class SoftwareInfoUtil {
    public static List<SoftwareInfo> parseWingetOutput(String output) {
        List<SoftwareInfo> softwareList = new ArrayList<>();
        String[] lines = output.split("\n");

        // Iterate over each line after the header row
        for (int i = 3; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) continue;

            String[] columns = line.split("\\s+");

            if (columns.length >= 5) {
                // Extract the fields assuming the format
                String name = columns[0];
                String version = columns[2];
                String availableVersion = columns[3];
                String source = columns[4];

                softwareList.add(new SoftwareInfo(name, version, availableVersion, source));
            }
        }
        return softwareList;
    }
}