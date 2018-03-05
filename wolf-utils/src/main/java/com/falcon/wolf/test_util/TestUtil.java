package com.falcon.wolf.test_util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *  TestUtil provides solution the objects fields assertation.
 *  It works with reflection.
 */

public final class TestUtil {
    private TestUtil() {
    }

    public static void verifyObjectFieldsEquals(Object expected, Object actual, String... excludeFields) {
        verifyObjectFieldsEquals(expected, actual, true, excludeFields);
    }

    public static void verifyObjectFieldsEquals(Object expected, Object actual, boolean errorOnMissingField, String... excludeFields) {
        assertNotNull(actual);
        try {
            for (Field field : Arrays.stream(FieldUtils.getAllFields(expected.getClass()))
                    .filter(field -> !Modifier.isStatic(field.getModifiers())).collect(Collectors.toList())) {
                verifyField(expected, actual, errorOnMissingField, field, excludeFields);
            }
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void verifyField(Object expected, Object actual, boolean errorOnMissingField, Field field, String[] excludeFields) throws IllegalAccessException {
        if (ArrayUtils.contains(excludeFields, field.getName())) {
            return;
        }
        field.setAccessible(true);
        Field actualField = FieldUtils.getField(actual.getClass(), field.getName(), true);
        if (actualField == null) {
            if (!errorOnMissingField) {
                return;
            }
            throw new IllegalStateException("Field not found: " + field.getName() + ", class: " + actual.getClass());
        }
        actualField.setAccessible(true);
        assertEquals("Fields not equals: " + actualField + ", " + field, field.get(expected), actualField.get(actual));
    }
}
