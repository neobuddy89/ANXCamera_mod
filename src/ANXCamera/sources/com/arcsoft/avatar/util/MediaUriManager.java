package com.arcsoft.avatar.util;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

public class MediaUriManager implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: c  reason: collision with root package name */
    private static final int f118c = 100;

    /* renamed from: a  reason: collision with root package name */
    private Context f119a;

    /* renamed from: b  reason: collision with root package name */
    private MediaScannerConnection f120b;

    /* renamed from: d  reason: collision with root package name */
    private List<Uri> f121d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private String f122e;

    public MediaUriManager(Context context) {
        this.f119a = context;
        this.f120b = new MediaScannerConnection(this.f119a, this);
    }

    public void addPath(String str) {
        this.f122e = str;
        this.f120b.connect();
    }

    public void addUri(Uri uri) {
        if (uri != null) {
            this.f121d.add(uri);
        }
    }

    public void addUris(List<Uri> list) {
        if (list != null && !list.isEmpty()) {
            this.f121d.addAll(list);
        }
    }

    public Uri getCurrentMediaUri() {
        if (this.f121d.isEmpty()) {
            return null;
        }
        return this.f121d.get(0);
    }

    public List<Uri> getUris() {
        return this.f121d;
    }

    public boolean isEmpty() {
        List<Uri> list = this.f121d;
        return list == null || list.isEmpty();
    }

    public void onMediaScannerConnected() {
        try {
            this.f120b.scanFile(this.f122e, (String) null);
        } catch (SQLiteFullException e2) {
            e2.printStackTrace();
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        try {
            if (this.f121d.size() > 100) {
                this.f121d.remove(this.f121d.size() - 1);
            }
            this.f121d.add(0, uri);
        } finally {
            this.f120b.disconnect();
        }
    }

    public void release() {
        MediaScannerConnection mediaScannerConnection = this.f120b;
        if (mediaScannerConnection != null && mediaScannerConnection.isConnected()) {
            this.f120b.disconnect();
        }
    }
}
