package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangedArrayList {
    public static void main(String[] args) {

      Integer[] massive = {1, 2, 3, 4, 5, 6};
        ArrayList massiveList;
        massiveList = new ArrayList(Arrays.asList(massive));
        for (Object integer : massiveList) {

            System.out.print( " " + "\t " + integer);
        }
    }

}
