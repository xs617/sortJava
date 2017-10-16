package sort;

public class MergeSort {

    public void doMergeSort(int[] data) {
        recursionMergeSort(data, 0, data.length - 1);
    }

    //前闭后开
    private void recursionMergeSort(int[] data, int start, int end) {
        int middle = start + (end - start) / 2;
        // 前半部分多于两个元素继续分
        if (middle - start > 0) {
            recursionMergeSort(data, start, middle);
        }
        // 后半部分多于两个元素继续分
        if (end - (middle + 1) > 0) {
            recursionMergeSort(data, middle + 1, end);
        }

        merge(data, start, end);
    }

    private void merge(int[] data, int start, int end) {
        int middle = start + (end - start) / 2;
        int size = end - start + 1;
        int[] temp = new int[size];
        int leftIndex = start;
        int rightIndex = middle + 1;
        for (int i = 0; i < size; i++) {
            if (leftIndex > middle) {
                replace(temp, data, i, rightIndex, end);
                break;
            }

            if (rightIndex > end) {
                replace(temp, data, i, leftIndex, middle);
                break;
            }

            if (data[leftIndex] < data[rightIndex]) {
                temp[i] = data[leftIndex];
                leftIndex++;
            } else {
                temp[i] = data[rightIndex];
                rightIndex++;
            }
        }

        replace(data, temp, start, 0, temp.length - 1);
    }

    private void replace(int[] dData, int[] sData, int dStart, int sStart, int sEnd) {
        for (int i = 0; i < sEnd - sStart + 1; i++) {
            dData[dStart + i] = sData[sStart+i];
        }
    }
}
