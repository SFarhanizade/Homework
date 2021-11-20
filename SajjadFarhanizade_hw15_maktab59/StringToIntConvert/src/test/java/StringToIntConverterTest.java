import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntConverterTest {

    @Test
    void testStringToInt(){
        assertEquals(123,StringToIntConverter.convert("123"));
    }
}