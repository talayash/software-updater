package com.windowssoftwareupdater.softwareupdater.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static com.windowssoftwareupdater.softwareupdater.util.CmdCommands.C;
import static com.windowssoftwareupdater.softwareupdater.util.CmdCommands.CMD_EXE;

public class CmdExecutor {

    /**
     * Executes a command using the Windows command line utility CMD.
     *
     * @param command the command to execute
     * @return the output of the command as a string
     */
    public static String executeCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(CMD_EXE, C, command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            return readProcessOutput(process);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Reads the output of a process and returns it as a string.
     *
     * @param process the process whose output needs to be read
     * @return the output of the process as a string
     * @throws InterruptedException if the thread is interrupted while waiting for the process to complete
     * @throws IOException if an I/O error occurs while reading the process output
     */
    private static String readProcessOutput(Process process) throws InterruptedException, IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }
        process.waitFor();
        return output.toString();
    }
}