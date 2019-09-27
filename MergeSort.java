class MergeSort implements SortingAlgorithm {
    public void sort(int[] array) {

        mergeSort(array);
    }

    public void mergeSort(int[] arr) {

        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;

        // Create Left Sub Array
        int[] leftArr = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        // Create Right Sub Array
        int[] rightArr = new int[arr.length - mid];
        for (int i = mid; i < arr.length; i++) {
            rightArr[i - mid] = arr[i];
        }
        // Keep Splitting "Left Array"
        mergeSort(leftArr);
        // Keep Splitting "Right Array"
        mergeSort(rightArr);
        // Combine All "Single Arrays"
        merge(arr, leftArr, rightArr);
    }

    public void merge(int[] targetArr, int[] leftArr, int[] rightArr) {

        int l = 0, r = 0, t = 0;

        // Compare Left and Right Array Values
        // Then Rewrite Initial Array With Lower Value
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] < rightArr[r]) {
                targetArr[t++] = leftArr[l++];
            } else {
                targetArr[t++] = rightArr[r++];
            }
        }

        // Copy Remaining Elements of leftArr
        while (l < leftArr.length) {
            targetArr[t++] = leftArr[l++];
        }

        // Copy Remaining Alements of rightArr
        while (r < rightArr.length) {
            targetArr[t++] = rightArr[r++];
        }
    }
}
