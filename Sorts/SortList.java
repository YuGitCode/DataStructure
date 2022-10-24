import java.util.*;

public class SortList {

    public static void main(String[] args) {
        int choice = 0;
        fileRead rder = new fileRead();
        Scanner sc = new Scanner(System.in);
        rder.fileRead();
        System.out.println("Select a Sorting Method\n" + "1.Bubble Sort.\n" + "2.Selection Sort.\n"
                + "3.Insertion Sort.\n" + "Input an Option");

        choice = sc.nextInt();
        switch (choice) {
            case 1:
                rder.bubbleSort();
                break;

            case 2:
                rder.selectionSort();
                break;

            case 3:
                rder.insertionSort();
                break;

            default:
                break;
        }
        rder.write();
        sc.close();

    }

}
