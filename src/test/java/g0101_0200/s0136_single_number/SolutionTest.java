package g0101_0200.s0136_single_number;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void singleNumber() {
        assertThat(new Solution().singleNumber(new int[] {2, 2, 1}), equalTo(1));
    }
}