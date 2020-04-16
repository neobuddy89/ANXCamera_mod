package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.a.l;
import com.bumptech.glide.load.b.a.a;
import com.bumptech.glide.load.b.b.e;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.a.o;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.engine.prefill.a;
import com.bumptech.glide.load.engine.prefill.c;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.model.A;
import com.bumptech.glide.load.model.B;
import com.bumptech.glide.load.model.C;
import com.bumptech.glide.load.model.C0151a;
import com.bumptech.glide.load.model.C0153c;
import com.bumptech.glide.load.model.D;
import com.bumptech.glide.load.model.a.b;
import com.bumptech.glide.load.model.a.c;
import com.bumptech.glide.load.model.a.d;
import com.bumptech.glide.load.model.a.e;
import com.bumptech.glide.load.model.a.f;
import com.bumptech.glide.load.model.f;
import com.bumptech.glide.load.model.g;
import com.bumptech.glide.load.model.i;
import com.bumptech.glide.load.model.q;
import com.bumptech.glide.load.model.y;
import com.bumptech.glide.load.model.z;
import com.bumptech.glide.load.resource.bitmap.C0155a;
import com.bumptech.glide.load.resource.bitmap.C0156b;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.request.f;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide */
public class c implements ComponentCallbacks2 {
    private static final String Mb = "image_manager_disk_cache";
    private static volatile c Nb = null;
    private static volatile boolean Ob = false;
    private static final String TAG = "Glide";
    private final d Eb;
    private final o Fb;
    private final a Gb;
    private final e Hb;
    private final n Ib;
    private final com.bumptech.glide.manager.d Jb;
    private final List<m> Kb = new ArrayList();
    private MemoryCategory Lb = MemoryCategory.NORMAL;
    private final b ra;
    private final Registry registry;
    private final Engine wa;

    c(@NonNull Context context, @NonNull Engine engine, @NonNull o oVar, @NonNull d dVar, @NonNull b bVar, @NonNull n nVar, @NonNull com.bumptech.glide.manager.d dVar2, int i, @NonNull f fVar, @NonNull Map<Class<?>, n<?, ?>> map) {
        Context context2 = context;
        o oVar2 = oVar;
        d dVar3 = dVar;
        b bVar2 = bVar;
        this.wa = engine;
        this.Eb = dVar3;
        this.ra = bVar2;
        this.Fb = oVar2;
        this.Ib = nVar;
        this.Jb = dVar2;
        this.Gb = new a(oVar2, dVar3, (DecodeFormat) fVar.getOptions().a(com.bumptech.glide.load.resource.bitmap.o.hj));
        Resources resources = context.getResources();
        this.registry = new Registry();
        this.registry.a((ImageHeaderParser) new m());
        com.bumptech.glide.load.resource.bitmap.o oVar3 = new com.bumptech.glide.load.resource.bitmap.o(this.registry.Hh(), resources.getDisplayMetrics(), dVar3, bVar2);
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, this.registry.Hh(), dVar3, bVar2);
        h<ParcelFileDescriptor, Bitmap> c2 = VideoDecoder.c(dVar);
        i iVar = new i(oVar3);
        x xVar = new x(oVar3, bVar2);
        e eVar = new e(context2);
        y.c cVar = new y.c(resources);
        y.d dVar4 = new y.d(resources);
        y.b bVar3 = new y.b(resources);
        y.a aVar = new y.a(resources);
        com.bumptech.glide.load.resource.bitmap.e eVar2 = new com.bumptech.glide.load.resource.bitmap.e(bVar2);
        com.bumptech.glide.load.b.d.a aVar2 = new com.bumptech.glide.load.b.d.a();
        com.bumptech.glide.load.b.d.d dVar5 = new com.bumptech.glide.load.b.d.d();
        y.b bVar4 = bVar3;
        y.d dVar6 = dVar4;
        y.a aVar3 = aVar;
        Context context3 = context;
        ContentResolver contentResolver = context.getContentResolver();
        com.bumptech.glide.load.b.d.a aVar4 = aVar2;
        com.bumptech.glide.load.b.d.d dVar7 = dVar5;
        this.registry.a(ByteBuffer.class, new com.bumptech.glide.load.model.e()).a(InputStream.class, new z(bVar2)).a(Registry.sc, ByteBuffer.class, Bitmap.class, iVar).a(Registry.sc, InputStream.class, Bitmap.class, xVar).a(Registry.sc, ParcelFileDescriptor.class, Bitmap.class, c2).a(Registry.sc, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.b(dVar)).a(Bitmap.class, Bitmap.class, B.a.getInstance()).a(Registry.sc, Bitmap.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.z()).a(Bitmap.class, eVar2).a(Registry.tc, ByteBuffer.class, BitmapDrawable.class, new C0155a(resources, iVar)).a(Registry.tc, InputStream.class, BitmapDrawable.class, new C0155a(resources, xVar)).a(Registry.tc, ParcelFileDescriptor.class, BitmapDrawable.class, new C0155a(resources, c2)).a(BitmapDrawable.class, new C0156b(dVar3, eVar2)).a(Registry.rc, InputStream.class, com.bumptech.glide.load.resource.gif.b.class, new com.bumptech.glide.load.resource.gif.h(this.registry.Hh(), byteBufferGifDecoder, bVar2)).a(Registry.rc, ByteBuffer.class, com.bumptech.glide.load.resource.gif.b.class, byteBufferGifDecoder).a(com.bumptech.glide.load.resource.gif.b.class, new com.bumptech.glide.load.resource.gif.c()).a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, B.a.getInstance()).a(Registry.sc, com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.f(dVar3)).a(Uri.class, Drawable.class, eVar).a(Uri.class, Bitmap.class, new v(eVar, dVar3)).a((e.a<?>) new a.C0006a()).a(File.class, ByteBuffer.class, new f.b()).a(File.class, InputStream.class, new i.e()).a(File.class, File.class, new com.bumptech.glide.load.b.c.a()).a(File.class, ParcelFileDescriptor.class, new i.b()).a(File.class, File.class, B.a.getInstance()).a((e.a<?>) new l.a(bVar2)).a(Integer.TYPE, InputStream.class, cVar).a(Integer.TYPE, ParcelFileDescriptor.class, bVar4).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar4).a(Integer.class, Uri.class, dVar6).a(Integer.TYPE, AssetFileDescriptor.class, aVar3).a(Integer.class, AssetFileDescriptor.class, aVar3).a(Integer.TYPE, Uri.class, dVar6).a(String.class, InputStream.class, new g.c()).a(Uri.class, InputStream.class, new g.c()).a(String.class, InputStream.class, new A.c()).a(String.class, ParcelFileDescriptor.class, new A.b()).a(String.class, AssetFileDescriptor.class, new A.a()).a(Uri.class, InputStream.class, new c.a()).a(Uri.class, InputStream.class, new C0151a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new C0151a.b(context.getAssets())).a(Uri.class, InputStream.class, new d.a(context3)).a(Uri.class, InputStream.class, new e.a(context3)).a(Uri.class, InputStream.class, new C.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new C.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new C.a(contentResolver)).a(Uri.class, InputStream.class, new D.a()).a(URL.class, InputStream.class, new f.a()).a(Uri.class, File.class, new q.a(context3)).a(com.bumptech.glide.load.model.l.class, InputStream.class, new b.a()).a(byte[].class, ByteBuffer.class, new C0153c.a()).a(byte[].class, InputStream.class, new C0153c.d()).a(Uri.class, Uri.class, B.a.getInstance()).a(Drawable.class, Drawable.class, B.a.getInstance()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.b.b.f()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.b.d.b(resources)).a(Bitmap.class, byte[].class, aVar4).a(Drawable.class, byte[].class, new com.bumptech.glide.load.b.d.c(dVar3, aVar4, dVar7)).a(com.bumptech.glide.load.resource.gif.b.class, byte[].class, dVar7);
        e eVar3 = new e(context, bVar, this.registry, new com.bumptech.glide.request.target.i(), fVar, map, engine, i);
        this.Hb = eVar3;
    }

    @Nullable
    private static a El() {
        try {
            return (a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (InstantiationException e2) {
            c((Exception) e2);
            throw null;
        } catch (IllegalAccessException e3) {
            c((Exception) e3);
            throw null;
        } catch (NoSuchMethodException e4) {
            c((Exception) e4);
            throw null;
        } catch (InvocationTargetException e5) {
            c((Exception) e5);
            throw null;
        }
    }

    @Nullable
    public static File F(@NonNull Context context) {
        return g(context, "image_manager_disk_cache");
    }

    @NonNull
    public static m G(@NonNull Context context) {
        return I(context).get(context);
    }

    private static void H(@NonNull Context context) {
        if (!Ob) {
            Ob = true;
            J(context);
            Ob = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    private static n I(@Nullable Context context) {
        com.bumptech.glide.util.i.b(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).Gh();
    }

    private static void J(@NonNull Context context) {
        b(context, new d());
    }

    @NonNull
    public static m a(@NonNull FragmentActivity fragmentActivity) {
        return I(fragmentActivity).b(fragmentActivity);
    }

    @Deprecated
    @NonNull
    public static m b(@NonNull Fragment fragment) {
        return I(fragment.getActivity()).c(fragment);
    }

    @NonNull
    public static m b(@NonNull android.support.v4.app.Fragment fragment) {
        return I(fragment.getActivity()).c(fragment);
    }

    private static void b(@NonNull Context context, @NonNull d dVar) {
        Context applicationContext = context.getApplicationContext();
        a El = El();
        List<com.bumptech.glide.c.c> emptyList = Collections.emptyList();
        if (El == null || El.Mi()) {
            emptyList = new com.bumptech.glide.c.e(applicationContext).parse();
        }
        if (El != null && !El.Ni().isEmpty()) {
            Set<Class<?>> Ni = El.Ni();
            Iterator<com.bumptech.glide.c.c> it = emptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.c.c next = it.next();
                if (Ni.contains(next.getClass())) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(TAG, 3)) {
            Iterator<com.bumptech.glide.c.c> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d(TAG, "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        dVar.a(El != null ? El.Oi() : null);
        for (com.bumptech.glide.c.c a2 : emptyList) {
            a2.a(applicationContext, dVar);
        }
        if (El != null) {
            El.a(applicationContext, dVar);
        }
        c E = dVar.E(applicationContext);
        for (com.bumptech.glide.c.c a3 : emptyList) {
            a3.a(applicationContext, E, E.registry);
        }
        if (El != null) {
            El.a(applicationContext, E, E.registry);
        }
        applicationContext.registerComponentCallbacks(E);
        Nb = E;
    }

    private static void c(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static m d(@NonNull Activity activity) {
        return I(activity).get(activity);
    }

    @NonNull
    public static m e(@NonNull View view) {
        return I(view.getContext()).get(view);
    }

    @Nullable
    public static File g(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "default disk cache dir is null");
        }
        return null;
    }

    @NonNull
    public static c get(@NonNull Context context) {
        if (Nb == null) {
            synchronized (c.class) {
                if (Nb == null) {
                    H(context);
                }
            }
        }
        return Nb;
    }

    @VisibleForTesting
    public static synchronized void init(@NonNull Context context, @NonNull d dVar) {
        synchronized (c.class) {
            if (Nb != null) {
                tearDown();
            }
            b(context, dVar);
        }
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(c cVar) {
        synchronized (c.class) {
            if (Nb != null) {
                tearDown();
            }
            Nb = cVar;
        }
    }

    @VisibleForTesting
    public static synchronized void tearDown() {
        synchronized (c.class) {
            if (Nb != null) {
                Nb.getContext().getApplicationContext().unregisterComponentCallbacks(Nb);
                Nb.wa.shutdown();
            }
            Nb = null;
        }
    }

    public void Ch() {
        com.bumptech.glide.util.l.Ij();
        this.wa.Ch();
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.d Dh() {
        return this.Eb;
    }

    /* access modifiers changed from: package-private */
    public com.bumptech.glide.manager.d Eh() {
        return this.Jb;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public e Fh() {
        return this.Hb;
    }

    @NonNull
    public n Gh() {
        return this.Ib;
    }

    public void V() {
        com.bumptech.glide.util.l.Jj();
        this.Fb.V();
        this.Eb.V();
        this.ra.V();
    }

    @NonNull
    public MemoryCategory a(@NonNull MemoryCategory memoryCategory) {
        com.bumptech.glide.util.l.Jj();
        this.Fb.a(memoryCategory.getMultiplier());
        this.Eb.a(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.Lb;
        this.Lb = memoryCategory;
        return memoryCategory2;
    }

    public void a(@NonNull c.a... aVarArr) {
        this.Gb.b(aVarArr);
    }

    /* access modifiers changed from: package-private */
    public boolean a(@NonNull com.bumptech.glide.request.target.o<?> oVar) {
        synchronized (this.Kb) {
            for (m e2 : this.Kb) {
                if (e2.e(oVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(m mVar) {
        synchronized (this.Kb) {
            if (!this.Kb.contains(mVar)) {
                this.Kb.add(mVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(m mVar) {
        synchronized (this.Kb) {
            if (this.Kb.contains(mVar)) {
                this.Kb.remove(mVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @NonNull
    public Context getContext() {
        return this.Hb.getBaseContext();
    }

    @NonNull
    public Registry getRegistry() {
        return this.registry;
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.b ka() {
        return this.ra;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        V();
    }

    public void onTrimMemory(int i) {
        trimMemory(i);
    }

    public void trimMemory(int i) {
        com.bumptech.glide.util.l.Jj();
        this.Fb.trimMemory(i);
        this.Eb.trimMemory(i);
        this.ra.trimMemory(i);
    }
}
