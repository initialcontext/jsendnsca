package com.googlecode.jsendnsca.utils;

public class ByteArrayUtils {

    public static void writeFixedString(byte[] dest, String value, int offset, int fixedSize) {
        System.arraycopy(getFixedSizeBytes(fixedSize, value), 0, dest, offset, fixedSize);
    }

    public static void writeShort(byte[] dest, short value, int offset) {
        System.arraycopy(ByteArrayUtils.shortToByteArray(value), 0, dest, offset, 2);
    }

    public static void writeInteger(byte[] dest, int value, int offset) {
        System.arraycopy(ByteArrayUtils.intToByteArray(value), 0, dest, offset, 4);
    }

    public static byte[] getFixedSizeBytes(int fixedSize, String value) {
        final byte[] myBytes = new byte[fixedSize];
        
        if (value.length() > fixedSize) {
            value = value.substring(0, fixedSize);
        }
        
        System.arraycopy(value.getBytes(), 0, myBytes, 0, value.getBytes().length);
        return myBytes;
    }

    public static byte[] intToByteArray(int value) {
        final byte[] data = new byte[4];

        for (int i = 0; i < data.length; i++) {
            int offset = (data.length - 1 - i) * 8;
            data[i] = (byte) ((value >>> offset) & 0xFF);
        }

        return data;
    }

    public static byte[] shortToByteArray(short value) {
        final byte[] data = new byte[2];

        for (int i = 0; i < data.length; i++) {
            int offset = (data.length - 1 - i) * 8;
            data[i] = (byte) ((value >>> offset) & 0xFF);
        }

        return data;
    }
}