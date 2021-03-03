package week4;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Dancer {

    private final String name;
    private final String gender;

    Dancer(String gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}

public class TestDancer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SimpleQueue<Dancer> mDancerQ = new SimpleQueue<>();
        SimpleQueue<Dancer> fDancerQ = new SimpleQueue<>();

        mDancerQ.createQueue();
        fDancerQ.createQueue();

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] details = data.split("\\s+");
                String gender = details[0];
                String name = details[1] + " " + details[2];

                if (details[0].equals("M")) {

                    mDancerQ.enqueue(new Dancer(gender, name));
                } else {
                    fDancerQ.enqueue(new Dancer(gender, name));
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        while ((!mDancerQ.isEmpty()) && (!fDancerQ.isEmpty())) {
            System.out.println("Female dancer is: " + (fDancerQ.dequeue()).getName() + " and the male dancer is: " + mDancerQ.dequeue().getName());
        }
        if ((!mDancerQ.isEmpty()) && (fDancerQ.isEmpty())) {
            System.out.println("The person waiting to dance is " + mDancerQ.front().getName());
            System.out.println("The number of persons waiting to dance is " + mDancerQ.size());
        }
        if ((mDancerQ.isEmpty()) && (!fDancerQ.isEmpty())) {
            System.out.println("The person waiting to dance is " + fDancerQ.front().getName());
            System.out.println("The number of persons waiting to dance is " + fDancerQ.size());
        }

    }

}
