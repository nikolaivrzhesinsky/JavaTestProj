package temp;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> operations= new ArrayList<>();
        operations.add("Cook");
        operations.add("Refactor");
        operations.add("deploy");

        Worker worker= new Worker("Vasya",operations);

        Iterator iterator= worker.getIterator();

        System.out.println("Worker name: "+worker.getName());
        System.out.print("Workers ability: ");

        while (iterator.hasNext()){
            System.out.print(iterator.next().toString()+" ");
        }
    }
}
