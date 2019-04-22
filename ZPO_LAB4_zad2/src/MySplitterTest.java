import static org.junit.jupiter.api.Assertions.*;
import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

class MySplitterTest {

    private static final String INPUT_STRING_1 = "Ala ma kota";
    private static final int INPUT_LENGTH_1 = 4;
    private static final String INPUT_STRING_2 = "abcd";
    private static final int INPUT_LENGTH_2 = 2;
    private static final String INPUT_STRING_3 = "";
    private static final int INPUT_LENGTH_3 = 3;

    @Test
    public void shouldThrowCorrectException1(){
        Exception exception1 = assertThrows(IllegalArgumentException.class,
                ()-> MySplitter.split(null, 1));
        assertEquals("the given string can not be equal to null", exception1.getMessage());
    }

    @Test
    public void shouldThrowCorrectException2(){
        Exception exception2 = assertThrows(IllegalArgumentException.class,
                ()-> MySplitter.split("not null string", 0));
        assertEquals("length must be greater than zero", exception2.getMessage());
    }

    @Test
    public void shouldReturnCorrectValues1(){
        assertEquals(MySplitter.split(INPUT_STRING_1, INPUT_LENGTH_1),
                Splitter.fixedLength(INPUT_LENGTH_1).splitToList(INPUT_STRING_1),
                "List given from MySplitter have to be identical to " +
                        "list from Google Guava Splitter");
    }

    @Test
    public void shouldReturnCorrectValues2(){
        assertEquals(MySplitter.split(INPUT_STRING_2, INPUT_LENGTH_2),
                Splitter.fixedLength(INPUT_LENGTH_2).splitToList(INPUT_STRING_2),
                "List given from MySplitter have to be identical to " +
                        "list from Google Guava Splitter");
    }

    @Test
    public void shouldReturnCorrectValues3(){
        assertEquals(MySplitter.split(INPUT_STRING_3, INPUT_LENGTH_3),
                Splitter.fixedLength(INPUT_LENGTH_3).splitToList(INPUT_STRING_3),
                "List given from MySplitter have to be identical to " +
                        "list from Google Guava Splitter");
    }
}
