import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntConverterTest {

    @Test
    void test_String_To_Int(){
        assertEquals(123,StringToIntConverter.convert("123"));
    }

    @Test
    void test_invalid_input_empty_string(){
        try {
            StringToIntConverter.convert("");
            fail("Error expected!");
        } catch (IllegalArgumentException e){
            assertEquals("The input shouldn't be empty",e.getMessage());
        }
    }

    @Test
    void test_invalid_input_contains_space() {
        try {
            StringToIntConverter.convert("1 2 3");
            fail("Error expected!");
        } catch (IllegalArgumentException e){
            assertEquals("The input shouldn't have any space",e.getMessage());
        }
    }
}