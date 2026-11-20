import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 测试用例采用等价类划分和边界值分析。按项数、运算符和结果类型划分，
 * 覆盖单项、多项、正负号、正负结果、零与整数。边界用例覆盖值为 10 的
 * 分子与分母，以及 10 项表达式。每个用例都检查完整的最简分数字符串。
 */
public class L2024130094_10_Test {
    private final Solution10 solution = new Solution10();

    // 测试省略起始正号的单项。用例：1/2 → 1/2。
    @Test
    void singlePositiveFraction() {
        assertEquals("1/2", solution.fractionAddition("1/2"));
    }

    // 测试读取起始负号。用例：-1/2 → -1/2。
    @Test
    void singleNegativeFraction() {
        assertEquals("-1/2", solution.fractionAddition("-1/2"));
    }

    // 测试加法处理和异分母约分。用例：1/6+1/3 → 1/2。
    @Test
    void addsAndReducesFractions() {
        assertEquals("1/2", solution.fractionAddition("1/6+1/3"));
    }

    // 测试减法和负数结果的格式。用例：1/3-1/2 → -1/6。
    @Test
    void subtractsAndReturnsNegativeResult() {
        assertEquals("-1/6", solution.fractionAddition("1/3-1/2"));
    }

    // 测试两项相消时零的表示。用例：-1/2+1/2 → 0/1。
    @Test
    void cancellationReturnsZeroOverOne() {
        assertEquals("0/1", solution.fractionAddition("-1/2+1/2"));
    }

    // 测试中间和为零时仍会读取后续项。用例：-1/2+1/2+1/3 → 1/3。
    @Test
    void continuesAfterIntermediateCancellation() {
        assertEquals("1/3", solution.fractionAddition("-1/2+1/2+1/3"));
    }

    // 测试非零整数结果保留分母 1。用例：1/2+1/2 → 1/1。
    @Test
    void integerResultKeepsDenominatorOne() {
        assertEquals("1/1", solution.fractionAddition("1/2+1/2"));
    }

    // 测试分子和分母取上界时能完整读取两位数字。用例：10/7-1/10 → 93/70。
    @Test
    void parsesTwoDigitNumeratorAndDenominator() {
        assertEquals("93/70", solution.fractionAddition("10/7-1/10"));
    }

    // 测试项数上限，并覆盖中间分母超过 int 范围的情况。用例：10 个 9/10 相加 → 9/1。
    @Test
    void handlesTenFractionsWithLargeIntermediateDenominator() {
        String expression = "9/10+9/10+9/10+9/10+9/10+9/10+9/10+9/10+9/10+9/10";
        assertEquals("9/1", solution.fractionAddition(expression));
    }

    // 测试连续两次减法得到负整数。用例：-1/2-1/2 → -1/1。
    @Test
    void subtractsTwiceReturnsNegativeInteger() {
        assertEquals("-1/1", solution.fractionAddition("-1/2-1/2"));
    }

    // 测试分母为 1 的整数输入直接保留分母 1。用例：2/1 → 2/1。
    @Test
    void integerInputKeepsDenominatorOne() {
        assertEquals("2/1", solution.fractionAddition("2/1"));
    }

    // 测试负整数结果保留分母 1。用例：-2/1 → -2/1。
    @Test
    void negativeIntegerKeepsDenominatorOne() {
        assertEquals("-2/1", solution.fractionAddition("-2/1"));
    }
}
