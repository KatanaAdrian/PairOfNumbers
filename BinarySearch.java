/**
I choose to use the Binary Search because it has the time complexity O(log n).
Searches a sorted array by repeatedly dividing the array in half, then searches the left side if the needed value is less
than the middle element of the array, otherwise it searches in the right side.
This happens recursively until the value is found or the interval is null.
@author Adi Katana
*/

public class BinarySearch {

    /**
     * This method searches for the needed element
     * @param A -the array
     * @param NeededNr -the searched element
     * @param start -position of the first element of the subarray.
     * @param finish - position of the last element of the subarray.
     * @return -returns true if the element is found, false otherwise
     */
    public boolean Search(int A[], int NeededNr, int start, int finish) {
        int middle = (start + finish) / 2;

        if (start <= finish) {
            if (NeededNr == A[middle]) {
                return true;
            }
            else {
                if (NeededNr < A[middle]) {
                    return Search(A, NeededNr, start, middle - 1);
                } else {
                    return Search(A, NeededNr, middle + 1, finish);

                }
            }
        }

        return false;
    }
}