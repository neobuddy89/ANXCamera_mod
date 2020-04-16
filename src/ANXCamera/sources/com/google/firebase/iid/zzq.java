package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.firebase_messaging.zzm;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final class zzq {
    zzq() {
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0096=Splitter:B:31:0x0096, B:19:0x0057=Splitter:B:19:0x0057} */
    private final zzs zza(Context context, String str, zzs zzs, boolean z) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing ID to properties file");
        }
        Properties properties = new Properties();
        properties.setProperty("id", zzs.zza());
        properties.setProperty("cre", String.valueOf(zzs.zzb));
        File zze = zze(context, str);
        try {
            zze.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(zze, "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    channel.lock();
                    if (z && channel.size() > 0) {
                        channel.position(0);
                        zzs zza = zza(channel);
                        if (channel != null) {
                            channel.close();
                        }
                        randomAccessFile.close();
                        return zza;
                    }
                } catch (zzt | IOException e2) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 58);
                        sb.append("Tried reading ID before writing new one, but failed with: ");
                        sb.append(valueOf);
                        Log.d("FirebaseInstanceId", sb.toString());
                    }
                } catch (Throwable th) {
                    if (channel != null) {
                        channel.close();
                    }
                    throw th;
                }
                channel.truncate(0);
                properties.store(Channels.newOutputStream(channel), (String) null);
                if (channel != null) {
                    channel.close();
                }
                randomAccessFile.close();
                return zzs;
            } catch (Throwable th2) {
                randomAccessFile.close();
                throw th2;
            }
        } catch (IOException e3) {
            String valueOf2 = String.valueOf(e3);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
            sb2.append("Failed to write key: ");
            sb2.append(valueOf2);
            Log.w("FirebaseInstanceId", sb2.toString());
            return null;
        } catch (Throwable th3) {
            zzm.zza(th2, th3);
        }
    }

    private static zzs zza(SharedPreferences sharedPreferences, String str) throws zzt {
        long zzb = zzb(sharedPreferences, str);
        String string = sharedPreferences.getString(zzat.zza(str, "id"), (String) null);
        if (string == null) {
            String string2 = sharedPreferences.getString(zzat.zza(str, "|P|"), (String) null);
            if (string2 == null) {
                return null;
            }
            string = zzai.zza(zza(string2));
        }
        return new zzs(string, zzb);
    }

    private final zzs zza(File file) throws zzt, IOException {
        FileChannel channel;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            channel = fileInputStream.getChannel();
            channel.lock(0, Long.MAX_VALUE, true);
            zzs zza = zza(channel);
            if (channel != null) {
                channel.close();
            }
            fileInputStream.close();
            return zza;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzm.zza(th, th2);
            }
            throw th;
        }
        throw th;
    }

    private static zzs zza(FileChannel fileChannel) throws zzt, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        try {
            long parseLong = Long.parseLong(properties.getProperty("cre"));
            String property = properties.getProperty("id");
            if (property == null) {
                String property2 = properties.getProperty("pub");
                if (property2 != null) {
                    property = zzai.zza(zza(property2));
                } else {
                    throw new zzt("Invalid properties file");
                }
            }
            return new zzs(property, parseLong);
        } catch (NumberFormatException e2) {
            throw new zzt((Exception) e2);
        }
    }

    private static PublicKey zza(String str) throws zzt {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzt((Exception) e2);
            }
        } catch (IllegalArgumentException e3) {
            throw new zzt((Exception) e3);
        }
    }

    static void zza(Context context) {
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final void zza(Context context, String str, zzs zzs) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzs.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzt e2) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(zzat.zza(str, "id"), zzs.zza());
        edit.putString(zzat.zza(str, "cre"), String.valueOf(zzs.zzb));
        edit.commit();
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzat.zza(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e2) {
            return 0;
        }
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private final zzs zzc(Context context, String str) throws zzt {
        try {
            zzs zzd = zzd(context, str);
            if (zzd != null) {
                zza(context, str, zzd);
                return zzd;
            }
            e = null;
            try {
                zzs zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza, false);
                    return zza;
                }
            } catch (zzt e2) {
                e = e2;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (zzt e3) {
            e = e3;
        }
    }

    private final zzs zzd(Context context, String str) throws zzt {
        File zze = zze(context, str);
        if (!zze.exists()) {
            return null;
        }
        try {
            return zza(zze);
        } catch (zzt | IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
                sb.append("Failed to read ID from file, retrying: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return zza(zze);
            } catch (IOException e3) {
                String valueOf2 = String.valueOf(e3);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new zzt((Exception) e3);
            }
        }
    }

    private static File zze(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return new File(zzb(context), str2);
    }

    /* access modifiers changed from: package-private */
    public final zzs zza(Context context, String str) throws zzt {
        zzs zzc = zzc(context, str);
        return zzc != null ? zzc : zzb(context, str);
    }

    /* access modifiers changed from: package-private */
    public final zzs zzb(Context context, String str) {
        zzs zzs = new zzs(zzai.zza(zzb.zza().getPublic()), System.currentTimeMillis());
        zzs zza = zza(context, str, zzs, true);
        if (zza == null || zza.equals(zzs)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Generated new key");
            }
            zza(context, str, zzs);
            return zzs;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
        }
        return zza;
    }
}
