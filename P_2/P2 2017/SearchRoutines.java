/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill

    Wu/Otani

    Chapter 11 Sample Program: Search algorithms.

    File: SearchRoutines.java
*/


/**
 * This class includes linear and binary search routines
 * as described in Section 11.1.
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

class SearchRoutines {

//----------------------------------
//    Data Members
//----------------------------------

    /**
     * A constant to represent unsuccessful search
     */
    public static final int NOT_FOUND = -1;


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public SearchRoutines( ) {

    }

//-------------------------------------------------
//      Public Methods:
//
//          int   linearSearch   (   int[], int      )
//          int   binarySearch   (   int[], int      )
//
//------------------------------------------------

    /**
     * Searches a specified int value in the array using
     * the linear search method.
     *
     * @param number      an array of int to search
     * @param searchValue the value to search in the array
     *
     * @return index to the found value; NOT_FOUND if not found
     */
    public int linearSearch (int[] number, int searchValue) {
        
        int  loc   = 0;

        while (loc < number.length  &&
                 number[loc] != searchValue) {

            loc++;
        }

        if (loc == number.length) { //Not found

            return NOT_FOUND;
        }
        else {

            return loc;              //Found, return the position
        }
    }


    /**
     * Searches a specified int value in the array using
     * the binary search method.
     *
     * @param number      an array of int to search
     * @param searchValue the value to search in the array
     *
     * @return index to the found value; NOT_FOUND if not found
     */
    public int binarySearch (int[] number, int searchValue) {
        int  low      = 0,
             high     = number.length - 1,
             mid      = (low + high) / 2;

        while ( low <= high && number[mid] != searchValue ) {

                System.out.println(mid);

            if (number[mid] < searchValue) {

                low = mid + 1;
            }
            else  { //number[mid] > searchValue

                high = mid - 1;
            }

            mid  = (low + high) / 2;
        }

        if ( low > high) {

            mid = NOT_FOUND;
        }

        return mid;
    }
}