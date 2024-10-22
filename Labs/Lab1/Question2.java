package Lab1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Question2 {
    public static void main(String[] args) {
        //HashSet Implementation
        HashSet<String> hashSet =  new HashSet<>();
        hashSet.add("Kay");
        hashSet.add("Jay");
        hashSet.add("May");
        hashSet.add("Fay");
        hashSet.add("Kay"); //Attempt to duplicate Kay. Note that duplications are not allowed

        System.out.println("Hash set names:");
        Iterator<String> hashIterator = hashSet.iterator();
        while (hashIterator.hasNext()){
            System.out.println(hashIterator.next());
        }

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Kay");
        treeSet.add("Jay");
        treeSet.add("May");
        treeSet.add("Fay");
        treeSet.add("Kay"); //Attempt to duplicate kay. Duplication is not allowed

        System.out.println("\nTree set names:");
        Iterator<String> treeItrerator = treeSet.iterator();
        while (treeItrerator.hasNext()){
            System.out.println(treeItrerator.next());
        }

        /*Hash set does not have any specific order while Tree set always comes in sorted order
         In both tree set and hash set duplications are not allowed as we can see name "Kay" only
         appears once even that it was entered two times
         */
    }
}
