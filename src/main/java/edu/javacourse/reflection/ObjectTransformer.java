package edu.javacourse.reflection;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class ObjectTransformer {

    public static String tranfsormObject(Object object) {
        StringBuilder sb = new StringBuilder();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();

            field.setAccessible(true);

            sb.append(fieldName);
            sb.append(": ");
            try {
                Object fieldValue = field.get(object);
                if (fieldValue instanceof Date) {
                    sb.append(sdf.format(fieldValue));
                } else {
                    sb.append(fieldValue.toString());
                }
            } catch (IllegalAccessException e) {
                System.out.println("ERROR: Cannot net value for field " + fieldName + ". Reason: " + e.getMessage());
                sb.append("{error}");
            }

            if (i < fields.length - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

}
