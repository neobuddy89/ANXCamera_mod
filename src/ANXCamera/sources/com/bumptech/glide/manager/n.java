package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.c;
import com.bumptech.glide.m;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever */
public class n implements Handler.Callback {
    private static final String Ak = "key";
    @VisibleForTesting
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final String TAG = "RMRetriever";
    private static final a Xd = new m();
    private static final int yk = 1;
    private static final int zk = 2;
    private final a factory;
    private final Handler handler;
    @VisibleForTesting
    final Map<FragmentManager, l> pendingRequestManagerFragments = new HashMap();
    @VisibleForTesting
    final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap();
    private volatile m uk;
    private final ArrayMap<View, Fragment> vk = new ArrayMap<>();
    private final ArrayMap<View, android.app.Fragment> wk = new ArrayMap<>();
    private final Bundle xk = new Bundle();

    /* compiled from: RequestManagerRetriever */
    public interface a {
        @NonNull
        m a(@NonNull c cVar, @NonNull i iVar, @NonNull o oVar, @NonNull Context context);
    }

    public n(@Nullable a aVar) {
        this.factory = aVar == null ? Xd : aVar;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    @Nullable
    private Activity K(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return K(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @NonNull
    private m L(@NonNull Context context) {
        if (this.uk == null) {
            synchronized (this) {
                if (this.uk == null) {
                    this.uk = this.factory.a(c.get(context.getApplicationContext()), new b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.uk;
    }

    @Nullable
    @Deprecated
    private android.app.Fragment a(@NonNull View view, @NonNull Activity activity) {
        this.wk.clear();
        a(activity.getFragmentManager(), this.wk);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById)) {
            fragment = this.wk.get(view);
            if (fragment != null || !(view.getParent() instanceof View)) {
                break;
            }
            view = (View) view.getParent();
        }
        this.wk.clear();
        return fragment;
    }

    @Nullable
    private Fragment a(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.vk.clear();
        a((Collection<Fragment>) fragmentActivity.getSupportFragmentManager().getFragments(), (Map<View, Fragment>) this.vk);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById)) {
            fragment = this.vk.get(view);
            if (fragment != null || !(view.getParent() instanceof View)) {
                break;
            }
            view = (View) view.getParent();
        }
        this.vk.clear();
        return fragment;
    }

    @Deprecated
    @NonNull
    private m a(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        l a2 = a(fragmentManager, fragment, z);
        m fa = a2.fa();
        if (fa != null) {
            return fa;
        }
        m a3 = this.factory.a(c.get(context), a2.ea(), a2.ga(), context);
        a2.a(a3);
        return a3;
    }

    @NonNull
    private m a(@NonNull Context context, @NonNull android.support.v4.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment a2 = a(fragmentManager, fragment, z);
        m fa = a2.fa();
        if (fa != null) {
            return fa;
        }
        m a3 = this.factory.a(c.get(context), a2.ea(), a2.ga(), context);
        a2.a(a3);
        return a3;
    }

    @NonNull
    private SupportRequestManagerFragment a(@NonNull android.support.v4.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment == null) {
            supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(fragmentManager);
            if (supportRequestManagerFragment == null) {
                supportRequestManagerFragment = new SupportRequestManagerFragment();
                supportRequestManagerFragment.a(fragment);
                if (z) {
                    supportRequestManagerFragment.ea().onStart();
                }
                this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment);
                fragmentManager.beginTransaction().add((Fragment) supportRequestManagerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
                this.handler.obtainMessage(2, fragmentManager).sendToTarget();
            }
        }
        return supportRequestManagerFragment;
    }

    @NonNull
    private l a(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        l lVar = (l) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (lVar == null) {
            lVar = this.pendingRequestManagerFragments.get(fragmentManager);
            if (lVar == null) {
                lVar = new l();
                lVar.a(fragment);
                if (z) {
                    lVar.ea().onStart();
                }
                this.pendingRequestManagerFragments.put(fragmentManager, lVar);
                fragmentManager.beginTransaction().add(lVar, FRAGMENT_TAG).commitAllowingStateLoss();
                this.handler.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        return lVar;
    }

    @TargetApi(26)
    @Deprecated
    private void a(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment next : fragmentManager.getFragments()) {
                if (next.getView() != null) {
                    arrayMap.put(next.getView(), next);
                    a(next.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        b(fragmentManager, arrayMap);
    }

    private static void a(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    a((Collection<Fragment>) next.getChildFragmentManager().getFragments(), map);
                }
            }
        }
    }

    @Deprecated
    private void b(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            this.xk.putInt(Ak, i);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.xk, Ak);
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        a(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    @TargetApi(17)
    private static void g(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static boolean h(Activity activity) {
        return !activity.isFinishing();
    }

    @NonNull
    public m b(@NonNull FragmentActivity fragmentActivity) {
        if (l.Kj()) {
            return get(fragmentActivity.getApplicationContext());
        }
        g(fragmentActivity);
        return a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, h(fragmentActivity));
    }

    @TargetApi(17)
    @Deprecated
    @NonNull
    public m c(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (l.Kj() || Build.VERSION.SDK_INT < 17) {
            return get(fragment.getActivity().getApplicationContext());
        } else {
            return a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    @NonNull
    public m c(@NonNull Fragment fragment) {
        i.b(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (l.Kj()) {
            return get(fragment.getActivity().getApplicationContext());
        }
        return a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public SupportRequestManagerFragment c(FragmentActivity fragmentActivity) {
        return a(fragmentActivity.getSupportFragmentManager(), (Fragment) null, h(fragmentActivity));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    @NonNull
    public l e(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, h(activity));
    }

    @NonNull
    public m get(@NonNull Activity activity) {
        if (l.Kj()) {
            return get(activity.getApplicationContext());
        }
        g(activity);
        return a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null, h(activity));
    }

    @NonNull
    public m get(@NonNull Context context) {
        if (context != null) {
            if (l.Lj() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return b((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return get(((ContextWrapper) context).getBaseContext());
                }
            }
            return L(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public m get(@NonNull View view) {
        if (l.Kj()) {
            return get(view.getContext().getApplicationContext());
        }
        i.checkNotNull(view);
        i.b(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity K = K(view.getContext());
        if (K == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (K instanceof FragmentActivity) {
            Fragment a2 = a(view, (FragmentActivity) K);
            return a2 != null ? c(a2) : get(K);
        }
        android.app.Fragment a3 = a(view, K);
        return a3 == null ? get(K) : c(a3);
    }

    public boolean handleMessage(Message message) {
        Object obj;
        int i = message.what;
        Object obj2 = null;
        boolean z = true;
        if (i == 1) {
            obj2 = (FragmentManager) message.obj;
            obj = this.pendingRequestManagerFragments.remove(obj2);
        } else if (i != 2) {
            z = false;
            obj = null;
        } else {
            obj2 = (android.support.v4.app.FragmentManager) message.obj;
            obj = this.pendingSupportRequestManagerFragments.remove(obj2);
        }
        if (z && obj == null && Log.isLoggable(TAG, 5)) {
            Log.w(TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }
}
