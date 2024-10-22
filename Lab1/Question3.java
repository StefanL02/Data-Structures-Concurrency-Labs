package Lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class Question3 {
    public static void main(String[] args) {
        // Define the path to the file
        File file = new File("C:/Users/oracle/Desktop/hamlet.txt");

        // Create TreeSet and HashSet to store the words
        TreeSet<String> treeSet = new TreeSet<>();
        HashSet<String> hashSet = new HashSet<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split line into words using non-word characters as delimiters
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        treeSet.add(word.toLowerCase());
                        hashSet.add(word.toLowerCase());
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

        /*Tree Set will sort words alphabetically
          Hash Set will display words randomly
          Both sets will give us same number of words.
          Both sets will prevent duplicate words
         */
    }}
