import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntConverterTest {

    @Test
    void test_String_To_Int(){
        assertEquals(123,StringToIntConverter.convert("123"));
    }

    @Test
    void test_String_To_Int_negative(){
        assertEquals(-123,StringToIntConverter.convert("-123"));
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

    @Test
    void test_invalid_input_contains_characters() {
        try {
            StringToIntConverter.convert("abc");
            fail("Error expected!");
        } catch (IllegalArgumentException e){
            assertEquals("The input shouldn't have any characters except numbers",e.getMessage());
        }
    }

    @Test
    void test_invalid_input_out_of_range(){
        try {
            StringToIntConverter.convert("32768");
            fail("Error expected!");
        } catch (IllegalArgumentException e){
            assertEquals("The number is not within the valid range",e.getMessage());
        }
        try {
            StringToIntConverter.convert("-32768");
            fail("Error expected!");
        } catch (IllegalArgumentException e){
            assertEquals("The number is not within the valid range",e.getMessage());
        }
    }
}