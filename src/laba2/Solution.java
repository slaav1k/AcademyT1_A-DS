package laba2;

import java.util.List;

public class Solution {
    public static Result findMinMax(List<Integer> pLst) {
        int n = pLst.size();

        int startPos = (n % 2 != 0) ? 1 : 2;

        Result tmp = initMinMax(pLst, n);
        int min = tmp.min();
        int max = tmp.max();


        int tmpMin, tmpMax;

        for (int i = startPos; i < n - 1; i += 2) {
            tmp = getSortedPair(pLst.get(i), pLst.get(i + 1));
            tmpMax = tmp.max();
            tmpMin = tmp.min();

            if (min > tmpMin) min = tmpMin;
            if (max < tmpMax) max = tmpMax;
        }

        return new Result(min, max);
    }

    private static Result initMinMax(List<Integer> pLst, int pN) {
        int tmpFirst = pLst.get(0);
        if (pN % 2 != 0) return new Result(tmpFirst, tmpFirst);
        return getSortedPair(tmpFirst, pLst.get(1));

    }

    private static Result getSortedPair(int pA, int pB) {
        if (pA > pB) return new Result(pB, pA);
        return new Result(pA, pB);
    }
}
