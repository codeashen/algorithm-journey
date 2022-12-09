package com.journey.algorithm.common.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@UtilityClass
public class IOUtils {

    public static String classpathFileToString(String name) {
        String result = null;
        URL url = IOUtils.class.getClassLoader().getResource(name);
        if (url != null) {
            try {
                result = org.apache.commons.io.IOUtils.toString(url, StandardCharsets.UTF_8);
            } catch (IOException e) {
            }
        }
        return result;
    }
}
