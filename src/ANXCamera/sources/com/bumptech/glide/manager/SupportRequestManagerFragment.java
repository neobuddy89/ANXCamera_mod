package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.m;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    private static final String TAG = "SupportRMFragment";
    private final a ba;
    private final o ca;
    private final Set<SupportRequestManagerFragment> da;
    @Nullable
    private m ea;
    @Nullable
    private SupportRequestManagerFragment fa;
    @Nullable
    private Fragment ga;

    private class a implements o {
        a() {
        }

        @NonNull
        public Set<m> W() {
            Set<SupportRequestManagerFragment> da = SupportRequestManagerFragment.this.da();
            HashSet hashSet = new HashSet(da.size());
            for (SupportRequestManagerFragment next : da) {
                if (next.fa() != null) {
                    hashSet.add(next.fa());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new a());
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(@NonNull a aVar) {
        this.ca = new a();
        this.da = new HashSet();
        this.ba = aVar;
    }

    private void a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.da.add(supportRequestManagerFragment);
    }

    private void b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.da.remove(supportRequestManagerFragment);
    }

    private void d(@NonNull FragmentActivity fragmentActivity) {
        vl();
        this.fa = c.get(fragmentActivity).Gh().c(fragmentActivity);
        if (!equals(this.fa)) {
            this.fa.a(this);
        }
    }

    private boolean d(@NonNull Fragment fragment) {
        Fragment ul = ul();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(ul)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @Nullable
    private Fragment ul() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.ga;
    }

    private void vl() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.fa;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.b(this);
            this.fa = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(@Nullable Fragment fragment) {
        this.ga = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            d(fragment.getActivity());
        }
    }

    public void a(@Nullable m mVar) {
        this.ea = mVar;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Set<SupportRequestManagerFragment> da() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.fa;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.da);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.fa.da()) {
            if (d(next.ul())) {
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

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            d(getActivity());
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
        this.ga = null;
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
