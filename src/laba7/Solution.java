package laba7;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<String> findLCS(String pStr1, String pStr2) {
        int n = pStr1.length();
        int m = pStr2.length();

        int[][] lcsLengths = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pStr1.charAt(i - 1) == pStr2.charAt(j - 1)) {
                    lcsLengths[i][j] = lcsLengths[i - 1][j - 1] + 1;
                } else {
                    lcsLengths[i][j] = Math.max(lcsLengths[i - 1][j], lcsLengths[i][j - 1]);
                }
            }
        }

        Set<String> res = new HashSet<>();
        backtrack(pStr1, pStr2, n, m, lcsLengths, new StringBuilder(), res);

        return res;
    }

    private static void backtrack(String pStr1, String pStr2, int pRowIdx, int pColIdx,
                                  int[][] pLcsLengths, StringBuilder pCur, Set<String> pRes) {

        if (pRowIdx == 0 || pColIdx == 0) {
            pRes.add(pCur.reverse().toString());
            pCur.reverse();
            return;
        }

        if (pStr1.charAt(pRowIdx - 1) == pStr2.charAt(pColIdx - 1)) {
            pCur.append(pStr1.charAt(pRowIdx - 1));
            backtrack(pStr1, pStr2, pRowIdx - 1, pColIdx - 1, pLcsLengths, pCur, pRes);
            pCur.deleteCharAt(pCur.length() - 1);
        } else {
            if (pLcsLengths[pRowIdx - 1][pColIdx] >= pLcsLengths[pRowIdx][pColIdx - 1]) {
                backtrack(pStr1, pStr2, pRowIdx - 1, pColIdx, pLcsLengths, pCur, pRes);
            }
            if (pLcsLengths[pRowIdx][pColIdx - 1] >= pLcsLengths[pRowIdx - 1][pColIdx]) {
                backtrack(pStr1, pStr2, pRowIdx, pColIdx - 1, pLcsLengths, pCur, pRes);
            }
        }
    }
}
