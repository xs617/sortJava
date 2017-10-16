package sort;


public class QuickSort {
    private final int FRONT_DIRECTION = 1;
    private final int BACK_DIRECTION = -1;

    public void doQuickSort(int[] data) {
        if (data.length == 0){
            return;
        }
        recursionSort(data, 0, data.length - 1);
    }
    //小于等于在左边，大于在右边
    private void recursionSort(int[] data, int start, int end) {
        int front = start, back = end;
        int middleValue = data[front];
        int direction = FRONT_DIRECTION;
        while (front < back) {
            switch (direction) {
                case FRONT_DIRECTION:
                    if (data[front] > middleValue) {
                        if (data[back] <= middleValue) {
                            exchange(data, front, back);
                            front++;
                        } else {
                            direction = BACK_DIRECTION;
                        }
                    } else {
                        front++;
                    }
                    break;
                case BACK_DIRECTION:
                    if (data[back] <= middleValue) {
                        if (data[front] > middleValue) {
                            exchange(data, front, back);
                            back--;
                        } else {
                            direction = FRONT_DIRECTION;
                        }
                    } else {
                        back--;
                    }
                    break;
            }
        }
        //此时back == front
        if (data[front] < middleValue) {
            if (front > start) {
                exchange(data, front, start);
                recursionSort(data, start, front);
            }
            if (end > (front + 1)) {
                recursionSort(data, front + 1, end);
            }
        } else {
            if (front - 1 > start) {
                exchange(data, front - 1, start);
                recursionSort(data, start, front - 1);
            }
            if (end > front) {
                recursionSort(data, front, end);
            }
        }

    }

    private void exchange(int[] data, int pa, int pb) {
        int temp = data[pa];
        data[pa] = data[pb];
        data[pb] = temp;
    }
}
