/**
 * I choose this sorting method because it suited the best for this program.
 * It has the time complexity O(n * log n) in every cases.
 * Is a comparison based sorting technique based on Binary Heap data structure.
 * @author Adi Katana
 */
public class HeapSort {

    /**
     * This method sorts the initial array
     * Reorganizes the array by repeatedly extracting the root of the heap and placing it in the “right” position of the sorted array
     * @param A -the array
     */
    public void sort(int A[]) {
        int n = A.length;

        BuildHeap(A, n);
        for (int i = n - 1; i >= 0; i--) {

            int aux = A[0];
            A[0] = A[i];
            A[i] = aux;

            heapify(A, i, 0);
        }
    }

    /**
     * Constructs the whole heap structure (on the entire array), by repeatedly applying heapify. It has O(n) time complexity
     * @param A -the array
     * @param n -length of the array
     */
    public void BuildHeap(int A[], int n) {

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(A, n, i);
    }

    /**
     * “Adds ” the root to 2 left and right children rooted heaps. It applies a bottom-up strategy and it has O(log n) time complexity
     * @param A -the array
     * @param n -length of the array
     * @param i -position of the current parent
     */
    void heapify(int A[], int n, int i) {
        int largest = i; //current parent
        int l = 2 * i + 1; //left child
        int r = 2 * i + 2; //right child

        //left child exists and is greater than parent
        if (l < n && A[l] > A[largest]) {
            largest = l;
        }

        //right child exists and is greater than parent
        if (r < n && A[r] > A[largest]) {
            largest = r;
        }

        //one of the child is greater than the parent, then swap the parent with the corresponding child and apply heapify again
        if (largest != i) {
            int swap = A[i];
            A[i] = A[largest];
            A[largest] = swap;

            heapify(A, n, largest);
        }
    }
}



