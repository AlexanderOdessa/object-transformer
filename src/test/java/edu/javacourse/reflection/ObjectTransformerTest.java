package edu.javacourse.reflection;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class ObjectTransformerTest {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String expectedResult = "id: 1, name: Семецкий Юрий Михайлович, birth: 06-05-1962 00:00:00";

    @Test
    public void testObjectTransform() throws ParseException {

        Person person = new Person(1L, "Семецкий Юрий Михайлович", sdf.parse("06-05-1962"));

        String transformationResult = ObjectTransformer.tranfsormObject(person);
        assertEquals(expectedResult, transformationResult);

    }

}
