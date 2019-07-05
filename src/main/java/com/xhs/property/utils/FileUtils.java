package com.xhs.property.utils;

public class FileUtils {

    public static String getFileSuffix(String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        return suffix;
    }
}
