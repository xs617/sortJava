package sort;

public class HeapSort{

    public void doHeapSort(int[]data){
        int end = data.length - 1;
        while (end >0){
            buildBigHeap(data,end);
            exchangeRootAndEnd(data,0,end);
            end --;
        }
    }

    private void buildBigHeap(int[] data,int end){
        while (end > 0){
            adjustBranches(data,end);
            end --;
        }
    }

    private void adjustBranches(int[] data,int leafPosition){
        int branchPostion =  (leafPosition + 1) /2 -1;
        if (data[leafPosition] > data[branchPostion]){
            int temp = data[leafPosition];
            data[leafPosition] = data[branchPostion];
            data[branchPostion] = temp;
        }
    }

    private void exchangeRootAndEnd(int[] data,int root,int end){
        int temp = data[root];
        data[root] = data[end];
        data[end] = temp;
    }

}
