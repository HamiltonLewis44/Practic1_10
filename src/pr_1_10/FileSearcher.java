/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr_1_10;

/**
 *
 * @author andre
 */
import java.io.File;

public class FileSearcher {
    public String search(String rootPath, String extension) {
        StringBuilder result = new StringBuilder();

        File file = new File(rootPath);
        if (!file.exists() || !file.isDirectory()) {
            FileProcessor.displayError("Invalid path: " + rootPath);
            return "";
        }

        File[] files = file.listFiles();
        if (files == null) {
            FileProcessor.displayError("Failed to access the files in the given path: " + rootPath);
            return "";
        }

        for (File entry : files) {
            if (entry.isDirectory()) {
                result.append(createFolderLine(entry.getPath())).append(System.lineSeparator());
                result.append(searchDirectory(entry, extension)).append(System.lineSeparator());
            } else {
                if (entry.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                    result.append(createFileLine(entry.getPath(), entry.length())).append(System.lineSeparator());
                }
            }
        }

        return result.toString();
    }

    private String searchDirectory(File dir, String extension) {
        StringBuilder result = new StringBuilder();
        File[] files = dir.listFiles();
        if (files == null) {
            FileProcessor.displayError("Failed to access the files in the directory: " + dir.getPath());
            return "";
        }

        for (File entry : files) {
            if (entry.isDirectory()) {
                result.append(createFolderLine(entry.getPath())).append(System.lineSeparator());
                result.append(searchDirectory(entry, extension)).append(System.lineSeparator());
            } else {
                if (entry.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                    result.append(createFileLine(entry.getPath(), entry.length())).append(System.lineSeparator());
                }
            }
        }

        return result.toString();
    }

    private String createFolderLine(String folderPath) {
        return folderPath + File.separator + " [Folder]";
    }

    private String createFileLine(String filePath, long fileSize) {
        return filePath + "  " + fileSize + " bytes";
    }
}
