package Lab;

import java.util.LinkedList;
import java.util.ListIterator;

public class Question1 {

    public static void main(String[] args) {
//Q1 (i)
        LinkedList<String>names = new LinkedList<>();
        names.addLast("Kay");
        names.addLast("Jay");
        names.addLast("May");
        names.addLast("Fay");

        System.out.println("Q1 (i) " + names);

//Q1 (ii)
        ListIterator<String> iterator = names.listIterator();
        iterator.next(); //K|JMF
        iterator.next(); //KJ|MF
        iterator.next(); //KJM|F

        iterator.add("Ray");

        System.out.println("Q1 (ii) " + names);

//Q1 (iii)
        iterator.previous(); //KJMR|F
        iterator.previous(); //KJM|RF
        iterator.previous(); //KJ|MRF

        iterator.remove();

        System.out.println("Q1 (iii) "+ names);

//Using an iterator to display the list
//Q2 (iv)
        System.out.println("\nDisplaying list from the beginning");
        iterator = names.listIterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name + "...");
        }

//Displaying list in a reverse order
        System.out.println("\nDisplaying list from the last");
        iterator = names.listIterator(names.size());
        while (iterator.hasPrevious()) {
            String name = iterator.previous();
            System.out.println(name + "...");
        }

        names.addLast("Kay");
        System.out.println("\nDisplaying list from the beginning and adding Kay");
        iterator = names.listIterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name + "...");
        }

    }
    }


