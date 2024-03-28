/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pr_1_10;

/**
 *
 * @author andre
 */


public class Pr_1_10 {

    public static void main(String[] args) {
        try {
            FileSearcher fileSearcher = new FileSearcher();
            String result = fileSearcher.search("d:\\Work\\MIREA", ".docx");
            FileProcessor.displayResults(result);
        } catch (Exception e) {
            FileProcessor.displayError("Error during file search: " + e.getMessage());
        }
    }
}