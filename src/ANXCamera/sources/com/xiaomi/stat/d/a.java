package com.xiaomi.stat.d;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f457a = "AES";

    /* renamed from: b  reason: collision with root package name */
    private static final String f458b = "AES/CBC/PKCS5Padding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f459c = "AES";

    /* renamed from: d  reason: collision with root package name */
    private static final String f460d = "BC";

    /* renamed from: e  reason: collision with root package name */
    private static String f461e = "cfbsdfgsdfxccvd1";

    /* renamed from: f  reason: collision with root package name */
    private static KeyGenerator f462f;
    private static Cipher g;

    static {
        try {
            f462f = KeyGenerator.getInstance("AES");
            f462f.init(128);
            g = Cipher.getInstance(f458b);
        } catch (Exception e2) {
            k.b("AES", "AesUtils e", e2);
        }
    }

    public static String a(String str, byte[] bArr) {
        try {
            g.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(f461e.getBytes()));
            return new String(g.doFinal(a(str)));
        } catch (Exception e2) {
            k.b("AES", "decrypt exception:", e2);
            return null;
        }
    }

    public static byte[] a() {
        return f462f.generateKey().getEncoded();
    }

    public static byte[] a(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            g.init(1, new SecretKeySpec(a(str), "AES"), new IvParameterSpec(f461e.getBytes()));
            return g.doFinal(bArr);
        } catch (Exception e2) {
            k.b("AES", "encrypt exception:", e2);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            g.init(1, secretKeySpec, new IvParameterSpec(f461e.getBytes()));
            return g.doFinal(bArr);
        } catch (Exception e2) {
            k.b("AES", "encrypt exception:", e2);
            return null;
        }
    }
}
