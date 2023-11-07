package mainPackage;

public class NumberSort {

    static void sort(int[] array, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            sort(array, first, mid);
            sort(array, mid + 1, last);
            merge(array, first, mid, last);
        }
    }

    static void merge(int[] array, int first, int mid, int last) {
        int leftLength = mid - first + 1;
        int rightLength = last - mid;

        int[] Left = new int[leftLength];
        int[] Right = new int[rightLength];

        if (leftLength >= 0) {
            System.arraycopy(array, first, Left, 0, leftLength);
        }

        if (rightLength >= 0) {
            System.arraycopy(array, mid + 1, Right, 0, rightLength);
        }

        int leftCount = 0;
        int rightCount = 0;
        int arrayCount = first;

        while (leftCount < leftLength && rightCount < rightLength) {
            if (Left[leftCount] <= Right[rightCount]) {
                array[arrayCount] = Left[leftCount];
                leftCount = leftCount + 1;
            }
            else {
                array[arrayCount] = Right[rightCount];
                rightCount = rightCount + 1;
            }
            arrayCount = arrayCount + 1;
        }

        while (leftCount < leftLength) {
            array[arrayCount] = Left[leftCount];
            leftCount = leftCount + 1;
            arrayCount = arrayCount + 1;
        }

        while (rightCount < rightLength) {
            array[arrayCount] = Right[rightCount];
            rightCount = rightCount + 1;
            arrayCount = arrayCount + 1;
        }
    }
}
