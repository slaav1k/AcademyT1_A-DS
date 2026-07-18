package laba2;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Integer> lst = List.of(1, 2, 3, 4, 5);
        System.out.println(Solution.findMinMax(lst));
    }
}
