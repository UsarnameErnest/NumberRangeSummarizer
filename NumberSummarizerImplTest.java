import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

public class NumberSummarizerImplTest {

    @Test
    public void testCollect() {
        NumberSummarizerImpl nr = new NumberSummarizerImpl();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actual = nr.collect(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSummarizeCollection() {
        NumberSummarizerImpl nr = new NumberSummarizerImpl();
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = nr.summarizeCollection(input);
        assertEquals(expected, actual);
    }
}


    

    

