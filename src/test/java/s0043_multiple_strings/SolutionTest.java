package s0043_multiple_strings;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void multiplyStrings() {
        assertThat(new Solution().multiply("2", "3"), equalTo("6"));
    }
}