package Lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Question4 {
    public static void main(String[] args) {
        // Define the path to the file
        File file = new File("C:/Users/oracle/Desktop/hamlet.txt");

        // Create TreeSet and HashSet to store the words
        TreeSet<String> treeSet = new TreeSet<>();
        HashSet<String> hashSet = new HashSet<>();
        HashMap<String, Set<Integer>> wordMap = new HashMap<>();

        try {
            Scanner scanner = new Scanner(file);
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                // Split line into words using non-word characters as delimiters
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        treeSet.add(word);
                        hashSet.add(word);
                        wordMap.computeIfAbsent(word, k -> new HashSet<>()).add(lineNumber);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        // Output words and size from TreeSet
        System.out.println("Words in TreeSet:");
        printTreeSet(treeSet);
        System.out.println("Total unique words in TreeSet: " + treeSet.size());

        // Output words and size from HashSet
        System.out.println("\nWords in HashSet:");
        printSet(hashSet);
        System.out.println("Total unique words in HashSet: " + hashSet.size());

        // Search for a specific word in the map and display line numbers
        String searchWord = "to";
        if (wordMap.containsKey(searchWord)) {
            System.out.println("The word \"" + searchWord + "\" appears on lines: " + wordMap.get(searchWord));
        } else {
            System.out.println("The word \"" + searchWord + "\" does not appear in the text.");
        }
    }

    private static void printSet(HashSet<String> set) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void printTreeSet(TreeSet<String> set) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}

