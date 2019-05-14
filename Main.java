/*
 * Given an array of N distinct natural numbers, how many pairs of numbers sum up to a given number S?
 * In order to implement the solution for this problem, after the reading of the number of elements, the sum and the elements of the array,
 * the first step was to sort the array in an ascending order using heapsort.
 * Then, the array was traversed and for each element was calculated the needed number that each element should have as a pair.
 * The needed pair is searched in the array from the next position after the element using binary search and if it was found, a counter
 * is incremented by 1.
 *
 * Input data: number of elements: 5
 *             sum: 3
 *             array's elements: 1, 2, 3, 4, 0
 * Output data: Pairs:(0 , 3)  (1 , 2). There are 2 pairs.
 */

import java.util.Scanner;

/** Find how many pairs of numbers sum up to a given number S from an array with N distinct, natural numbers.
 * @author Adi Katana
 */
public class Main {

    public static void main(String[] args) {

        System.out.print("Introduce the number of elements: ");
        Scanner nr = new Scanner(System.in);
        int elmNr = nr.nextInt();

        int A[] = new int[elmNr];
        int length = A.length;
        int k = 0; //pairs' counter

        System.out.print("Choose a sum: ");
        Scanner Sum = new Scanner(System.in);
        int S = Sum.nextInt();

        System.out.print("Introduce the array's elements: ");
        for (int i = 0; i < elmNr; i++) {
            Scanner elements = new Scanner(System.in);
            A[i] = elements.nextInt();
        }

        //Firstly, the array was sorted in ascending order
        HeapSort ob = new HeapSort();
        ob.sort(A);

        System.out.println();
        System.out.print("Pairs:");

        for (int i = 0; i < length - 1; i++) {

            //Finding the element's pair
            int NeededNr = S - A[i];
            BinarySearch search = new BinarySearch();

            //Searching if the element's pair exists
            if (search.Search(A, NeededNr, i + 1, length)) {
                k++;
                System.out.print("(" + A[i] + " , " + NeededNr + ")  ");
            }
        }

        System.out.println();
        System.out.println("There are " + k + " pairs");

    }
}