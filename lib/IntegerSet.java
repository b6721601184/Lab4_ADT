package lib;
import java.util.ArrayList;
import java.util.Collections;

/**
 * ADT that represents a set of integers. It stores the integers in an ArrayList with each integer being non repetitive and in ascending order
 */
public class IntegerSet {
    private ArrayList<Integer> Integer = new ArrayList<>();

    // Rep Invariant (RI):
    //  - s must not contain duplicate integers.
    //  - The integers in s must be sorted in ascending order.
    //
    // Abstraction Function (AF):
    //  - AF(s) = the set of integers in the arrayList Integer.

    public IntegerSet() {
        Integer = new ArrayList<>();
        checkrep();
    }


/**
 * Representation invariant:
 * - data is non-null
 * - data contains strictly increasing integers (no duplicates, sorted ascending)
 */
    private void checkrep() {
        if (Integer == null) {
            throw new RuntimeException("Data list cannot be null");
        }

        for (int i = 0; i < Integer.size() - 1; i++) {
            if (Integer.get(i) >= Integer.get(i + 1)) {
                throw new RuntimeException("List must be strictly increasing (sorted, no duplicates)");
            }
        }
    }

    
    /**
     * Sorts the elements in the set in ascending order.
     */
    private void sort() {
        Collections.sort(Integer);
        checkrep();
    }

    /**
     * Adds an integer to the set.
     * @param x the integer to add
     * @effects adds x to this set if x is not already in this set
     */
    public void add(int x) {
        if(Integer.contains(x)) return;
        Integer.add(x);
        sort();
        checkrep();
    }


    /**
     * Removes an integer from the set.
     * @param x the integer to remove
     * @effects removes x from this set if x is in this set
     */
    public void remove(int x) {
        Integer.remove((Integer) x);
        checkrep();
    }

    /**
     * Checks if the set contains a given integer.
     * @param x the integer to search for
     * @return true if this set contains x, false otherwise
     */
    public boolean contains(int x) {
        return Integer.contains(x);
    }

    /**
     * Returns the number of elements in the set.
     * @return the size of the set
     */

    public int size() {
        return Integer.size();
    }

    /**
     * @return a string representation of the set
     */
    @Override
    public String toString() {
        return Integer.toString();
    }
}

