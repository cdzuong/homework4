package arrays;

import java.util.Arrays;

/**
 * Class MyArray. Contains an array of integers and methods to manipulate it.
 * Fill in code where needed.
 */
public class MyArray {
    private int[] array;
    private int currentIndex = 0; // current size of the array

    /**
     * Constructor that takes the maximum size
     *
     * @param maxSize the largest number of elements the array can hold
     */
    public MyArray(int maxSize) {
        array = new int[maxSize];
    }


    /**
     * If the array has space, adds a given element to the array and returns true;
     * If the array has no more space, prints an error and returns false.
     *
     * @param elem integer element to add to the array
     * @return true if was able to add the element, and false otherwise
     */
    public boolean addElement(int elem) {
        // FILL IN CODE

        if (currentIndex < array.length) {
            array[currentIndex] = elem;
            currentIndex++;
            return true;
        }
        return false;
    }


    // remember to change this


    /**
     * Return the index of the element of the array that is equal to elem, or -1
     * if not found
     *
     * @param elem integer element
     * @return index of the first occurrence of this element
     */
    public int find(int elem) {
        int index = -1;
        // FILL IN CODE
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == elem) {
                index = i;
            }
        }
        return index;   // remember to change this

    }

    /**
     * Remove the first occurrence of elem in the array. You are not allowed to use
     * extra memory except for one loop variable i.
     *
     * @param elem integer element
     * @return true if removal was successful, and false otherwise
     */
    public boolean remove(int elem) {
        // FILL IN CODE


        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) {
                do {
                    array[i] = array[i + 1];
                    i++;
                } while (i < array.length - 1);
                return true;
            }
        }

        return false;
        // Remove the element at i = index

        // Shift elements after elem to the left


    }

    /**
     * Reverse a given array. You may NOT use  extra memory apart from two int variables.
     */
    public void reverse() {
        int temp;

        for (int i = 0; i < currentIndex / 2; i++) {
            temp = array[i];
            array[i] = array[currentIndex - i - 1];
            array[currentIndex - i - 1] = temp;
        }


        // FILL IN CODE
    }

    /**
     * Returns a string that contains the elements of the array, separated
     * by white space. Example:
     * 4 9 10 2 14
     *
     * @return string that contains elements of the array separated by space
     */
    public String toString() {
        String res = "";
        // FILL IN CODE
        for (int i = 0; i < currentIndex; i++) {
            if (i != currentIndex - 1) {
                res += array[i] + " ";
            } else {
                res += array[i];
            }


        }

        return res;
    }

    /**
     * Remove every other element from the array (remove elements with odd
     * indices). You are allowed to use an extra int[] array (not ArrayList!)
     * inside the method.
     */
    public void removeEveryOtherElement() {
        // FILL IN CODE

            int[] evens = new int[(array.length + 1) / 2];


        int i = 0;
        while (i < evens.length) {
            for (int j = 0; j < array.length; j += 2) {
                evens[i] = array[j];
                i++;
            }
        }


        this.array = evens;
        currentIndex = array.length - 1;

    }

    /**
     * Repeat the array n times.
     * You are allowed to use an extra int[] array of size currentIndex * n.
     * Once you fill this extra array of values, you can point this.array to
     * this new array.
     *
     * @param n how many times to repeat elements
     */
    public void repeat(int n) {
        // FILL IN CODE
        int[] multiply = new int[n * currentIndex];

        int j = 0;
        while (j < multiply.length) {
            for (int i = 0; i < currentIndex; i++) {
                multiply[j] = array[i];
                j++;
            }

        }

        this.array = multiply;
        currentIndex = array.length;


        /*
        int old = array.length;
        int newLength = multiply.length;

        Arrays.copyOf(old, newLength);

        for (int i = 0; i < multiply.length; i++) {
            array[i] = multiply[i];

        }

        */
    }

    /**
     * Return the largest common element between array and otherArray.array.
     * You are not allowed to use an extra array etc (NO extra memory except for
     * loop variable and largestCommonMax).
     *
     * @param otherArray another MyArray reference
     * @return largest common element between this and otherArray
     */
    public int findLargestCommonElement(MyArray otherArray) {
        // FILL IN CODE

        int largestCommonMax = 0;
        if (array.length >= otherArray.array.length) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < otherArray.array.length; j++) {
                    if (array[i] == otherArray.array[j] && array[i] >= largestCommonMax) {
                        largestCommonMax = array[i];
                    }
                }

            }
        } else {
            for (int i = 0; i < otherArray.array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i] == otherArray.array[j] && array[i] >= largestCommonMax) {
                        largestCommonMax = array[i];
                    }
                }

            }
        }


        return largestCommonMax;
    }
}
