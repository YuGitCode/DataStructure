import java.io.*;
import java.util.*;

public class fileRead {
    private Student[] info = new Student[7000];

    public void fileRead() {
        FileInputStream fileStrm = null;
        InputStreamReader fileRder;
        BufferedReader bufRdr;

        String line, filename;
        int lineNum;
        String fileName = "";
        try {
            fileName = "RandomNames7000.csv";
            fileStrm = new FileInputStream(fileName);
            fileRder = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(fileRder);

            lineNum = 0;
            line = bufRdr.readLine();
            while (line != null) {
                info[lineNum++] = processLine(line);
                line = bufRdr.readLine();
            }
            fileStrm.close();

        } catch (IOException e) {
            if (fileStrm != null) {
                try {
                    fileStrm.close();
                } catch (IOException ex2) {
                    System.out.println("Error in Opening file");
                }
            }
        }

    }

    private Student processLine(String line) {
        String[] StudentInfo = new String[2];
        int id;
        String name;
        Student stdInfo;
        StudentInfo = line.split(",");// split id and name

        if (StudentInfo.length == 2) {
            id = Integer.parseInt(StudentInfo[0]);
            name = StudentInfo[1];
            stdInfo = new Student(id, name);
        } else {
            throw new IllegalArgumentException("line contain invalid amount of Argument");
        }
        return stdInfo;

    }

    public void write() {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        String fileName;
        try {
            fileName = "StudentFile.csv";
            fileStrm = new FileOutputStream(fileName);
            pw = new PrintWriter(fileStrm);
            for (int i = 0; i < info.length; i++) {
                pw.printf(info[i].toString());
            }
            pw.close();
            System.out.println("Student List sorted inside StudentFile");
        } catch (IOException e) {
        }
    }

    public void bubbleSort() {
        boolean sorted;
        int pass = 0;
        Student temp;
        do {
            sorted = true;
            for (int ii = 0; ii <= (info.length - 1 - pass) - 1; ii++) {
                if (info[ii].getId() > info[ii + 1].getId()) {
                    temp = info[ii];// swap the arrays
                    info[ii] = info[ii + 1];
                    info[ii + 1] = temp;
                    sorted = false;

                }

            }
            pass += 1;// pass increment by one if the number cannot be swaped anymore
        } while (!sorted);
    }// bubbleSort()

    // selection sort
    public void selectionSort() {

        int minIndex;
        Student temp;
        for (int nn = 0; nn <= (info.length - 1); nn++) {
            minIndex = nn;
            for (int jj = nn + 1; jj <= (info.length - 1); jj++) {
                if (info[jj].getId() < info[minIndex].getId())// found a slot that contain smaller value and store it
                                                              // index
                {
                    minIndex = jj;
                }
            }

            temp = info[minIndex];// swap the slots values
            info[minIndex] = info[nn];
            info[nn] = temp;
        }

    }// selectionSort()

    // insertion sort
    public void insertionSort() {
        Student temp;
        for (int nn = 1; nn <= (info.length - 1); nn++) {
            int ii;
            ii = nn;
            while ((ii > 0) && (info[ii - 1].getId() > info[ii].getId())) {
                temp = info[ii];
                info[ii] = info[ii - 1];
                info[ii - 1] = temp;
                ii = ii - 1;
            }
        }
    }// insertionSort()

}
