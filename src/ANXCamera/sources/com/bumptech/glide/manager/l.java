package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.m;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* compiled from: RequestManagerFragment */
public class l extends Fragment {
    private static final String TAG = "RMFragment";
    private final a ba;
    private final o ca;
    private final Set<l> da;
    @Nullable
    private m ea;
    @Nullable
    private l fa;
    @Nullable
    private Fragment ga;

    /* compiled from: RequestManagerFragment */
    private class a implements o {
        a() {
        }

        @NonNull
        public Set<m> W() {
            Set<l> da = l.this.da();
            HashSet hashSet = new HashSet(da.size());
            for (l next : da) {
                if (next.fa() != null) {
                    hashSet.add(next.fa());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + l.this + "}";
        }
    }

    public l() {
        this(new a());
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    l(@NonNull a aVar) {
        this.ca = new a();
        this.da = new HashSet();
        this.ba = aVar;
    }

    private void a(l lVar) {
        this.da.add(lVar);
    }

    private void b(l lVar) {
        this.da.remove(lVar);
    }

    @TargetApi(17)
    private boolean d(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void f(@NonNull Activity activity) {
        vl();
        this.fa = c.get(activity).Gh().e(activity);
        if (!equals(this.fa)) {
            this.fa.a(this);
        }
    }

    @Nullable
    @TargetApi(17)
    private Fragment ul() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.ga;
    }

    private void vl() {
        l lVar = this.fa;
        if (lVar != null) {
            lVar.b(this);
            this.fa = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(@Nullable Fragment fragment) {
        this.ga = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            f(fragment.getActivity());
        }
    }

    public void a(@Nullable m mVar) {
        this.ea = mVar;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(17)
    @NonNull
    public Set<l> da() {
        if (equals(this.fa)) {
            return Collections.unmodifiableSet(this.da);
        }
        if (this.fa == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (l next : this.fa.da()) {
            if (d(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public a ea() {
        return this.ba;
    }

    @Nullable
    public m fa() {
        return this.ea;
    }

    @NonNull
    public o ga() {
        return this.ca;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            f(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.ba.onDestroy();
        vl();
    }

    public void onDetach() {
        super.onDetach();
        vl();
    }

    public void onStart() {
        super.onStart();
        this.ba.onStart();
    }

    public void onStop() {
        super.onStop();
        this.ba.onStop();
    }

    public String toString() {
        return super.toString() + "{parent=" + ul() + "}";
    }
}
