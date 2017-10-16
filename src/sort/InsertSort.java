package sort;

public class InsertSort {
    public void doInsertSort(int[] data) {
        int swopPosition;
        for (int i = 1; i < data.length; i++) {
            swopPosition = i;
            for (int r = i - 1; r >= 0; r--) {
                if (data[swopPosition] < data[r]) {
                    int temp = data[swopPosition];
                    data[swopPosition] = data[r];
                    data[r] = temp;
                    swopPosition = r;
                }else{
                    break;
                }
            }
        }
    }

}
