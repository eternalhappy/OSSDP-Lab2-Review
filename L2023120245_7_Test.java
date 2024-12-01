// 文件名：L2023120245_7_Test.java

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * 测试用例设计总体原则：
 *
 * 本测试类遵循以下测试用例设计原则：
 * 1. 等价类划分原则：将输入字符串和索引对划分为有效和无效的等价类，通过代表性测试用例覆盖每个类。
 * 2. 边界值分析：测试输入字符串的最小长度（如1），以及没有索引对的情况。
 * 3. 错误推测法：考虑可能存在的特殊情况，如重复的索引对、自环索引对等。
 */

public class L2023120245_7_Test {

    /**
     * 测试目的：验证在只有两个索引对的情况下，函数能正确返回最小字典序字符串。
     * 测试用例：
     * 1. 输入：s = "dcab", pairs = [[0,3],[1,2]]
     *    预期输出："bacd"
     */
    @Test
    @DisplayName("测试用例1：两个索引对的正常情况")
    public void testCase1() {
        Solution7 solution = new Solution7();
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(
            Arrays.asList(0, 3),
            Arrays.asList(1, 2)
        );
        String expected = "bacd";
        String actual = solution.smallestStringWithSwaps(s, pairs);
        assertEquals(expected, actual, "应返回 'bacd'");
    }

    /**
     * 测试目的：验证在多个索引对形成一个连通分量的情况下，函数能正确返回最小字典序字符串。
     * 测试用例：
     * 1. 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
     *    预期输出："abcd"
     */
    @Test
    @DisplayName("测试用例2：多个索引对形成一个连通分量")
    public void testCase2() {
        Solution7 solution = new Solution7();
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(
            Arrays.asList(0, 3),
            Arrays.asList(1, 2),
            Arrays.asList(0, 2)
        );
        String expected = "abcd";
        String actual = solution.smallestStringWithSwaps(s, pairs);
        assertEquals(expected, actual, "应返回 'abcd'");
    }

    /**
     * 测试目的：验证在没有索引对的情况下，函数应返回原始字符串。
     * 测试用例：
     * 1. 输入：s = "a", pairs = []
     *    预期输出："a"
     * 2. 输入：s = "", pairs = []
     *    预期输出：""
     */
    @Test
    @DisplayName("测试用例3：没有索引对的情况")
    public void testCase3() {
        Solution7 solution = new Solution7();
        // 子用例1
        String s1 = "a";
        List<List<Integer>> pairs1 = Arrays.asList();
        String expected1 = "a";
        String actual1 = solution.smallestStringWithSwaps(s1, pairs1);
        assertEquals(expected1, actual1, "应返回 'a'");

        // 子用例2
        String s2 = "";
        List<List<Integer>> pairs2 = Arrays.asList();
        String expected2 = "";
        String actual2 = solution.smallestStringWithSwaps(s2, pairs2);
        assertEquals(expected2, actual2, "应返回空字符串");
    }

    /**
     * 测试目的：验证在存在重复索引对和自环索引对的情况下，函数能正确返回最小字典序字符串。
     * 测试用例：
     * 1. 输入：s = "cba", pairs = [[0,1],[1,2],[0,1]]
     *    预期输出："abc"
     * 2. 输入：s = "aab", pairs = [[0,0],[1,2]]
     *    预期输出："aab"
     */
    @Test
    @DisplayName("测试用例4：存在重复索引对和自环索引对")
    public void testCase4() {
        Solution7 solution = new Solution7();
        // 子用例1
        String s1 = "cba";
        List<List<Integer>> pairs1 = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2),
            Arrays.asList(0, 1) // 重复索引对
        );
        String expected1 = "abc";
        String actual1 = solution.smallestStringWithSwaps(s1, pairs1);
        assertEquals(expected1, actual1, "应返回 'abc'");

        // 子用例2
        String s2 = "aab";
        List<List<Integer>> pairs2 = Arrays.asList(
            Arrays.asList(0, 0), // 自环索引对
            Arrays.asList(1, 2)
        );
        String expected2 = "aab";
        String actual2 = solution.smallestStringWithSwaps(s2, pairs2);
        assertEquals(expected2, actual2, "应返回 'aab'");
    }

    /**
     * 测试目的：验证在最大输入范围下，函数的性能和正确性。
     * 测试用例：
     * 1. 输入：s = "zzz...z"（长度为10^5），pairs = []
     *    预期输出："zzz...z"
     *    （由于长度过长，此处仅描述，实际测试可选用较大的输入）
     */
    @Test
    @DisplayName("测试用例5：大规模输入")
    public void testCase5() {
        Solution7 solution = new Solution7();
        // 这里为了避免资源消耗，使用较大的字符串而非10^5长度
        StringBuilder sb = new StringBuilder();
        int largeSize = 10000; // 可以根据实际情况调整
        for (int i = 0; i < largeSize; i++) {
            sb.append('z');
        }
        String s = sb.toString();
        List<List<Integer>> pairs = Arrays.asList(); // 无索引对
        String expected = s;
        String actual = solution.smallestStringWithSwaps(s, pairs);
        assertEquals(expected, actual, "应返回原始的大规模字符串");
    }

    /**
     * 测试目的：验证函数在索引对覆盖整个字符串时，能否正确排序字符串。
     * 测试用例：
     * 1. 输入：s = "bca", pairs = [[0,1],[1,2],[0,2]]
     *    预期输出："abc"
     */
    @Test
    @DisplayName("测试用例6：索引对覆盖整个字符串")
    public void testCase6() {
        Solution7 solution = new Solution7();
        String s = "bca";
        List<List<Integer>> pairs = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2),
            Arrays.asList(0, 2)
        );
        String expected = "abc";
        String actual = solution.smallestStringWithSwaps(s, pairs);
        assertEquals(expected, actual, "应返回 'abc'");
    }

    /**
     * 测试目的：验证函数在存在多个独立连通分量时，能否分别排序各个分量。
     * 测试用例：
     * 1. 输入：s = "dcab", pairs = [[0,3],[1,2]]
     *    预期输出："bacd"
     * 2. 输入：s = "dcabef", pairs = [[0,3],[1,2],[4,5]]
     *    预期输出："bacdef"
     */
    @Test
    @DisplayName("测试用例7：存在多个独立连通分量")
    public void testCase7() {
        Solution7 solution = new Solution7();
        // 子用例1
        String s1 = "dcab";
        List<List<Integer>> pairs1 = Arrays.asList(
            Arrays.asList(0, 3),
            Arrays.asList(1, 2)
        );
        String expected1 = "bacd";
        String actual1 = solution.smallestStringWithSwaps(s1, pairs1);
        assertEquals(expected1, actual1, "应返回 'bacd'");

        // 子用例2
        String s2 = "dcabef";
        List<List<Integer>> pairs2 = Arrays.asList(
            Arrays.asList(0, 3),
            Arrays.asList(1, 2),
            Arrays.asList(4, 5)
        );
        String expected2 = "bacdef";
        String actual2 = solution.smallestStringWithSwaps(s2, pairs2);
        assertEquals(expected2, actual2, "应返回 'bacdef'");
    }

    /**
     * 测试目的：验证函数在所有字符已经按字典序排列时，保持不变。
     * 测试用例：
     * 1. 输入：s = "abc", pairs = [[0,1],[1,2]]
     *    预期输出："abc"
     */
    @Test
    @DisplayName("测试用例8：字符串已按字典序排列")
    public void testCase8() {
        Solution7 solution = new Solution7();
        String s = "abc";
        List<List<Integer>> pairs = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2)
        );
        String expected = "abc";
        String actual = solution.smallestStringWithSwaps(s, pairs);
        assertEquals(expected, actual, "应保持 'abc' 不变");
    }
}
