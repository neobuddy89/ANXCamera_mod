package com.arcsoft.camera.utils;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MediaUriManager */
public class c implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: c  reason: collision with root package name */
    private static final int f161c = 100;

    /* renamed from: a  reason: collision with root package name */
    private Context f162a;

    /* renamed from: b  reason: collision with root package name */
    private MediaScannerConnection f163b;

    /* renamed from: d  reason: collision with root package name */
    private List<Uri> f164d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private String f165e;

    public c(Context context) {
        this.f162a = context;
        this.f163b = new MediaScannerConnection(this.f162a, this);
    }

    public void addPath(String str) {
        this.f165e = str;
        this.f163b.connect();
    }

    public void addUri(Uri uri) {
        if (uri != null) {
            this.f164d.add(uri);
        }
    }

    public void addUris(List<Uri> list) {
        if (list != null && !list.isEmpty()) {
            this.f164d.addAll(list);
        }
    }

    public Uri getCurrentMediaUri() {
        if (this.f164d.isEmpty()) {
            return null;
        }
        return this.f164d.get(0);
    }

    public List<Uri> getUris() {
        return this.f164d;
    }

    public boolean isEmpty() {
        List<Uri> list = this.f164d;
        return list == null || list.isEmpty();
    }

    public void onMediaScannerConnected() {
        try {
            this.f163b.scanFile(this.f165e, (String) null);
        } catch (SQLiteFullException unused) {
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        try {
            if (this.f164d.size() > 100) {
                this.f164d.remove(this.f164d.size() - 1);
            }
            this.f164d.add(0, uri);
        } finally {
            this.f163b.disconnect();
        }
    }

    public void release() {
        MediaScannerConnection mediaScannerConnection = this.f163b;
        if (mediaScannerConnection != null && mediaScannerConnection.isConnected()) {
            this.f163b.disconnect();
        }
    }
}
