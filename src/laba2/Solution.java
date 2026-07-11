package laba2;

import java.util.List;

public class Solution {
    public static Result findMinMax(List<Integer> pLst) {
        int n = pLst.size();
        int startPos;
        int min;
        int max;

        int tmpFirst = pLst.get(0);

        if (n % 2 != 0) {
            min = tmpFirst;
            max = tmpFirst;
            startPos = 1;
        } else {
            int tmpSecond = pLst.get(1);
            if (tmpFirst > tmpSecond) {
                max = tmpFirst;
                min = tmpSecond;
            } else {
                max = tmpSecond;
                min = tmpFirst;
            }
            startPos = 2;
        }

        int tmpMin, tmpMax, tmp;

        for (int i = startPos; i < n - 1; i += 2) {
            tmpMin = pLst.get(i);
            tmpMax = pLst.get(i + 1);

            if (tmpMax < tmpMin) {
                tmp = tmpMax;
                tmpMax = tmpMin;
                tmpMin = tmp;
            }

            if (min > tmpMin) min = tmpMin;
            if (max < tmpMax) max = tmpMax;
        }

        return new Result(min, max);
    }
}
