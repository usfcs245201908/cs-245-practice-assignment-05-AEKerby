class QuickSort implements SortingAlgorithm {
    public void sort(int[] array) {

        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] arr, int left, int right) {
        int p = partition(arr, left, right);

        // Recursively Call on Left Part of Array
        if (left < p - 1) {
            quickSort(arr, left, p - 1);
        }
        // Recursively Call on Right Part of Array
        if (right > p) {
            quickSort(arr, p, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        // First Element Is Pivot
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i <= j) {
            // Find Number Greater Than Pivot
            while (arr[i] < pivot) {
                ++i;
            }
            // Find Number Less Than Pivot
            while (arr[j] > pivot) {
                --j;
            }
            // Swap Their Values
            if (i <= j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return i;
    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
