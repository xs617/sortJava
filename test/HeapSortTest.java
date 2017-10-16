import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import sort.HeapSort;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class HeapSortTest {

    int[] input;
    int[] expect;

    public HeapSortTest(int[] input, int[] expect) {
        this.input = input;
        this.expect = expect;
    }


    @Parameterized.Parameters(name = "{index}")
    public static Iterable<int[][]> getData() {
        return Arrays.asList(new int[][][]
                {
                        {
                                {1}, {1}
                        },
                        {
                                {1, 1}, {1, 1}
                        },
                        {
                                {1, 1, 1, 1}, {1, 1, 1, 1}
                        },
                        {
                                {15, 1}, {1, 15}
                        },
                        {
                                {1, 15}, {1, 15}
                        },
                        {
                                {15, 1, 8}, {1, 8, 15}
                        },
                        {
                                {46, 30, 82, 90, 56, 17, 95, 15},
                                {15, 17, 30, 46, 56, 82, 90, 95}
                        },
                        {
                                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
                                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}
                        },
                        {
                                {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
                        },
                        {
                                {15, 15, 2, 8, 21, 35, 48, 31, 54, 84, 3, 1, 54, 8, 1, 231},
                                {1, 1, 2, 3, 8, 8, 15, 15, 21, 31, 35, 48, 54, 54, 84, 231}
                        }
                });
    }


    @Test
    public void doHeapSort() throws Exception {
        HeapSort heapSort = new HeapSort();
        heapSort.doHeapSort(input);
        assertArrayEquals(input, expect);
    }

}