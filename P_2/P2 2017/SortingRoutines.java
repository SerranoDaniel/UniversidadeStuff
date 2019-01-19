/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill

    Wu/Otani

    Chapter 11 Sample Program: Sorting algorithms.

    File: SortingRoutines.java
*/

/**
 * <p>
 * This class includes sorting routines
 * as described in Section 11.2.
 *
 * NOTE: This class is for illustration purpose only. Since
 *       the class does not have any instance variables to
 *       maintain, so it's more reasonable to implement this
 *       class an non-instantiable class. This class is
 *       implemented as an instantiable class, however, to
 *       make the method declarations match those given in
 *       the textbook.
 *
 */

class SortingRoutines {


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public SortingRoutines( ) {

    }

//-------------------------------------------------
//      Public Methods:
//
//          int   selectionSort (   int[]      )
//          int   bubbleSort    (   int[]      )
//
//------------------------------------------------

    /**
     * Sorts the passed array using
     * the selection sort method.
     *
     * @param number      an array of int to search
     *
     */
    public void selectionSort(int[] number) {

        int minIndex, length, temp, i;
        length = number.length;

        for (int startIndex = 0; startIndex <= length-2; startIndex++) {

             //each iteration of the for loop is one pass

            minIndex = startIndex;

            //find the smallest in this pass at
            //position minIndex
            for (i = startIndex+1; i <= length-1; i++) {
                if (number[i] < number[minIndex]) minIndex = i;
            }

            //exchange number[startIndex] and number[minIndex]
            temp               = number[startIndex];
            number[startIndex] = number[minIndex];
            number[minIndex]   = temp;

            assert minStart(number, startIndex):
                   "Error: " + number[startIndex] + " at position " +
                   startIndex + " is not the smallest.";
        }

        assert isSorted(number):
               "Error: the final is not sorted";
    }

    /**
     * Sorts the array using
     * the bubble sort method.
     *
     * @param number      an array of int to sort
     *
     */
    public void bubbleSort(int[] number) {

        int     temp, bottom, i;

        boolean exchanged = true;

        bottom = number.length - 1;

        while (exchanged)  {

            exchanged = false;

            for (i = 0; i < bottom; i++) {
                if (number[i] > number[i+1]) {

                    temp        = number[i];   //exchange
                    number[i]   = number[i+1];
                    number[i+1] = temp;

                    exchanged   = true; //exchange is made
                }
            }

            assert maxBottom(number, bottom):
                   "Error: " + number[bottom] + " at position " +
                   bottom + " is not the largest.";

            bottom--;
        }

        assert isSorted(number):
               "Error: the final is not sorted";
    }


    /**
     * Sorts the array using
     * the bubble sort method.
     *
     * @param st      an array of Strings to sort
     *
     */
    public void bubbleSortString(String[] st) {

        String     temp;
        int bottom, i;

        boolean exchanged = true;

        bottom = st.length - 1;

        while (exchanged)  {

            exchanged = false;

            for (i = 0; i < bottom; i++) {
                if (st[i].compareTo(st[i+1]) > 0 ) {

                    temp        = st[i];   //exchange
                    st[i]   = st[i+1];
                    st[i+1] = temp;

                    exchanged   = true; //exchange is made
                }
            }


            assert maxBottomString(st, bottom):
                    "Error: " + st[bottom] + " at position " +
                            bottom + " is not the largest.";

            bottom--;
        }

        assert isSortedString(st):
                "Error: the final is not sorted";
    }

    /**
     * Verifies the element in startIndex has the smallest
     * value among the elements from startIndes to the
     * last index in the array
     *
     * @param number     an array of integers
     * @param startIndex the starting position for checking
     *
     * @return true if the condition is met; otherwise
     *         false
     */
    private boolean minStart(int[] number, int startIndex) {

        for (int i = startIndex+1; i < number.length; i++) {

            if (number[startIndex] > number[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Verifies the element in lastIndex has the largest
     * value among the elements from position 0 to the
     * last index in the array
     *
     * @param number     an array of integers
     * @param lastIndex  the last position for checking
     *
     * @return true if the condition is met; otherwise
     *         false
     */
    private boolean maxBottom(int[] number, int lastIndex) {

        for (int i = 0; i < lastIndex; i++) {

            if (number[lastIndex] < number[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean maxBottomString(String [] st, int lastIndex) {

        for (int i = 0; i < lastIndex; i++) {

            if (st[lastIndex].compareTo(st[i]) < 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * Verifies the array is sorted
     *
     * @param number     an array of integers to check
     *
     * @return true if the array is sorted; otherwise
     *         false
     */
    private boolean isSorted(int[] number) {

        for (int i = 0; i < number.length-1; i++) {

            if (number[i] > number[i+1]) {
                return false;
            }
        }

        return true;
    }

    private boolean isSortedString(String[] st) {

        for (int i = 0; i < st.length-1; i++) {

            if (st[i].compareTo(st[i+1]) >0) {
                return false;
            }
        }

        return true;
    }
}