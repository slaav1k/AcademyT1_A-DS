package laba7.tests;

import laba7.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class LCSFinderTest {

    @Test
    public void testFindLCSExampleFromTask() {
        String s1 = "ABDEFADRFG";
        String s2 = "DAFERG";

        Set<String> expected = new HashSet<>(Arrays.asList(
                "DAFG", "AFRG", "AERG", "DFRG", "DERG", "DARG"
        ));

        Set<String> res = Solution.findLCS(s1, s2);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testFindLCSEmptyFirstString() {
        String s1 = "";
        String s2 = "DAFERG";

        Set<String> expected = new HashSet<>(Arrays.asList(""));

        Set<String> res = Solution.findLCS(s1, s2);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testFindLCSEmptyBothStrings() {
        String s1 = "";
        String s2 = "";

        Set<String> expected = new HashSet<>(Arrays.asList(""));

        Set<String> res = Solution.findLCS(s1, s2);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testFindLCSNoCommonCharacters() {
        String s1 = "ABC";
        String s2 = "XYZ";

        Set<String> expected = new HashSet<>(Arrays.asList(""));

        Set<String> res = Solution.findLCS(s1, s2);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testFindLCSIdenticalStrings() {
        String s1 = "TEST";
        String s2 = "TEST";

        Set<String> expected = new HashSet<>(Arrays.asList("TEST"));

        Set<String> res = Solution.findLCS(s1, s2);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testFindLCSSingleMatch() {
        String s1 = "A";
        String s2 = "A";

        Set<String> expected = new HashSet<>(Arrays.asList("A"));

        Set<String> res = Solution.findLCS(s1, s2);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testFindLCSMultipleEqualPaths() {
        String s1 = "ABA";
        String s2 = "BAB";

        Set<String> expected = new HashSet<>(Arrays.asList("AB", "BA"));

        Set<String> res = Solution.findLCS(s1, s2);

        Assert.assertEquals(res, expected);
    }

    @Test
    public void testFindLCSSubstring() {
        String s1 = "ABCDEFG";
        String s2 = "BCD";

        Set<String> expected = new HashSet<>(Arrays.asList("BCD"));

        Set<String> res = Solution.findLCS(s1, s2);

        Assert.assertEquals(res, expected);
    }
}