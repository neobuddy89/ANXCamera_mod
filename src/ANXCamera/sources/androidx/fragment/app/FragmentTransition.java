package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FragmentTransition {
    private static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    private static final FragmentTransitionImpl PLATFORM_IMPL = (Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null);
    private static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();

    static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    private FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x012f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00d6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0116  */
    private static void addToFirstInLastOut(BackStackRecord backStackRecord, FragmentTransaction.Op op, SparseArray<FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        FragmentContainerTransition fragmentContainerTransition;
        FragmentContainerTransition fragmentContainerTransition2;
        Fragment fragment;
        FragmentContainerTransition fragmentContainerTransition3;
        FragmentContainerTransition fragmentContainerTransition4;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        BackStackRecord backStackRecord2 = backStackRecord;
        FragmentTransaction.Op op2 = op;
        SparseArray<FragmentContainerTransition> sparseArray2 = sparseArray;
        boolean z11 = z;
        Fragment fragment2 = op2.mFragment;
        if (fragment2 != null) {
            int i = fragment2.mContainerId;
            if (i != 0) {
                int i2 = z11 ? INVERSE_OPS[op2.mCmd] : op2.mCmd;
                boolean z12 = false;
                if (i2 != 1) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            if (z2) {
                                if (fragment2.mHiddenChanged && fragment2.mAdded && fragment2.mHidden) {
                                    z12 = true;
                                }
                                z9 = z12;
                            } else {
                                if (fragment2.mAdded && !fragment2.mHidden) {
                                    z12 = true;
                                }
                                z9 = z12;
                            }
                            z6 = false;
                            z5 = true;
                            z4 = z9;
                            z3 = false;
                        } else if (i2 == 5) {
                            if (z2) {
                                if (fragment2.mHiddenChanged && !fragment2.mHidden && fragment2.mAdded) {
                                    z12 = true;
                                }
                                z10 = z12;
                            } else {
                                z10 = fragment2.mHidden;
                            }
                            z6 = z10;
                            z5 = false;
                            z4 = false;
                            z3 = true;
                        } else if (i2 != 6) {
                            if (i2 != 7) {
                                z6 = false;
                                z5 = false;
                                z4 = false;
                                z3 = false;
                            }
                        }
                        FragmentContainerTransition fragmentContainerTransition5 = sparseArray2.get(i);
                        if (z6) {
                            FragmentContainerTransition ensureContainer = ensureContainer(fragmentContainerTransition5, sparseArray2, i);
                            ensureContainer.lastIn = fragment2;
                            ensureContainer.lastInIsPop = z11;
                            ensureContainer.lastInTransaction = backStackRecord2;
                            fragmentContainerTransition = ensureContainer;
                        } else {
                            fragmentContainerTransition = fragmentContainerTransition5;
                        }
                        if (!z2 || !z3) {
                            fragment = null;
                            fragmentContainerTransition2 = fragmentContainerTransition;
                        } else {
                            if (fragmentContainerTransition != null && fragmentContainerTransition.firstOut == fragment2) {
                                fragmentContainerTransition.firstOut = null;
                            }
                            FragmentManagerImpl fragmentManagerImpl = backStackRecord2.mManager;
                            if (fragment2.mState >= 1 || fragmentManagerImpl.mCurState < 1 || backStackRecord2.mReorderingAllowed) {
                                FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
                                fragment = null;
                                fragmentContainerTransition2 = fragmentContainerTransition;
                            } else {
                                fragmentManagerImpl.makeActive(fragment2);
                                FragmentManagerImpl fragmentManagerImpl3 = fragmentManagerImpl;
                                fragmentContainerTransition2 = fragmentContainerTransition;
                                fragment = null;
                                fragmentManagerImpl.moveToState(fragment2, 1, 0, 0, false);
                            }
                        }
                        if (z4) {
                            fragmentContainerTransition4 = fragmentContainerTransition2;
                            if (fragmentContainerTransition4 == null || fragmentContainerTransition4.firstOut == null) {
                                fragmentContainerTransition3 = ensureContainer(fragmentContainerTransition4, sparseArray2, i);
                                fragmentContainerTransition3.firstOut = fragment2;
                                fragmentContainerTransition3.firstOutIsPop = z11;
                                fragmentContainerTransition3.firstOutTransaction = backStackRecord2;
                                if (!z2 && z5 && fragmentContainerTransition3 != null && fragmentContainerTransition3.lastIn == fragment2) {
                                    fragmentContainerTransition3.lastIn = fragment;
                                    return;
                                }
                                return;
                            }
                        } else {
                            fragmentContainerTransition4 = fragmentContainerTransition2;
                        }
                        fragmentContainerTransition3 = fragmentContainerTransition4;
                        if (!z2) {
                            return;
                        }
                        return;
                    }
                    if (z2) {
                        if (!fragment2.mAdded && fragment2.mView != null && fragment2.mView.getVisibility() == 0 && fragment2.mPostponedAlpha >= 0.0f) {
                            z12 = true;
                        }
                        z8 = z12;
                    } else {
                        if (fragment2.mAdded && !fragment2.mHidden) {
                            z12 = true;
                        }
                        z8 = z12;
                    }
                    z6 = false;
                    z5 = true;
                    z4 = z8;
                    z3 = false;
                    FragmentContainerTransition fragmentContainerTransition52 = sparseArray2.get(i);
                    if (z6) {
                    }
                    if (!z2) {
                    }
                    fragment = null;
                    fragmentContainerTransition2 = fragmentContainerTransition;
                    if (z4) {
                    }
                    fragmentContainerTransition3 = fragmentContainerTransition4;
                    if (!z2) {
                    }
                }
                if (z2) {
                    z7 = fragment2.mIsNewlyAdded;
                } else {
                    if (!fragment2.mAdded && !fragment2.mHidden) {
                        z12 = true;
                    }
                    z7 = z12;
                }
                z6 = z7;
                z5 = false;
                z4 = false;
                z3 = true;
                FragmentContainerTransition fragmentContainerTransition522 = sparseArray2.get(i);
                if (z6) {
                }
                if (!z2) {
                }
                fragment = null;
                fragmentContainerTransition2 = fragmentContainerTransition;
                if (z4) {
                }
                fragmentContainerTransition3 = fragmentContainerTransition4;
                if (!z2) {
                }
            }
        }
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, (FragmentTransaction.Op) backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    private static ArrayMap<String, String> calculateNameOverrides(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (backStackRecord.mSharedElementSourceNames != null) {
                    int size = backStackRecord.mSharedElementSourceNames.size();
                    if (booleanValue) {
                        arrayList4 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList3.get(i5);
                        String str2 = (String) arrayList4.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, (FragmentTransaction.Op) backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.keyAt(i));
                arrayList.add(arrayMap.valueAt(i));
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, (List<View>) null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    private static boolean canHandleAll(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList arrayList;
        SharedElementCallback sharedElementCallback;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String findKeyForValue = findKeyForValue(arrayMap, str);
                    if (findKeyForValue != null) {
                        arrayMap.remove(findKeyForValue);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2))) {
                    String findKeyForValue2 = findKeyForValue(arrayMap, str);
                    if (findKeyForValue2 != null) {
                        arrayMap.put(findKeyForValue2, ViewCompat.getTransitionName(view2));
                    }
                }
            }
        } else {
            retainValues(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList arrayList;
        SharedElementCallback sharedElementCallback;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, fragment.requireView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        } else {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        }
        arrayMap2.retainAll(arrayList);
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    private static FragmentTransitionImpl chooseImpl(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = PLATFORM_IMPL;
        if (fragmentTransitionImpl != null && canHandleAll(fragmentTransitionImpl, arrayList)) {
            return PLATFORM_IMPL;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = SUPPORT_IMPL;
        if (fragmentTransitionImpl2 != null && canHandleAll(fragmentTransitionImpl2, arrayList)) {
            return SUPPORT_IMPL;
        }
        if (PLATFORM_IMPL == null && SUPPORT_IMPL == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList<>();
            View view2 = fragment.getView();
            if (view2 != null) {
                fragmentTransitionImpl.captureTransitioningViews(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                fragmentTransitionImpl.addTargets(obj, arrayList2);
            }
        }
        return arrayList2;
    }

    private static Object configureSharedElementsOrdered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        ArrayList<View> arrayList3 = arrayList;
        Object obj4 = obj;
        Fragment fragment = fragmentContainerTransition2.lastIn;
        Fragment fragment2 = fragmentContainerTransition2.firstOut;
        if (fragment == null) {
            ViewGroup viewGroup2 = viewGroup;
            Fragment fragment3 = fragment2;
            Fragment fragment4 = fragment;
        } else if (fragment2 == null) {
            ViewGroup viewGroup3 = viewGroup;
            Fragment fragment5 = fragment2;
            Fragment fragment6 = fragment;
        } else {
            final boolean z = fragmentContainerTransition2.lastInIsPop;
            Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragmentTransitionImpl2, fragment, fragment2, z);
            ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl2, arrayMap, sharedElementTransition, fragmentContainerTransition2);
            if (arrayMap.isEmpty()) {
                obj3 = null;
            } else {
                arrayList3.addAll(captureOutSharedElements.values());
                obj3 = sharedElementTransition;
            }
            if (obj4 == null && obj2 == null && obj3 == null) {
                return null;
            }
            callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
            if (obj3 != null) {
                Rect rect2 = new Rect();
                fragmentTransitionImpl2.setSharedElementTargets(obj3, view, arrayList3);
                ArrayMap<String, View> arrayMap2 = captureOutSharedElements;
                Rect rect3 = rect2;
                setOutEpicenter(fragmentTransitionImpl, obj3, obj2, captureOutSharedElements, fragmentContainerTransition2.firstOutIsPop, fragmentContainerTransition2.firstOutTransaction);
                if (obj4 != null) {
                    fragmentTransitionImpl2.setEpicenter(obj4, rect3);
                }
                rect = rect3;
            } else {
                ArrayMap<String, View> arrayMap3 = captureOutSharedElements;
                rect = null;
            }
            final Object obj5 = obj3;
            final FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
            final ArrayMap<String, String> arrayMap4 = arrayMap;
            final FragmentContainerTransition fragmentContainerTransition3 = fragmentContainerTransition;
            final ArrayList<View> arrayList4 = arrayList2;
            Object obj6 = obj3;
            final View view2 = view;
            AnonymousClass4 r13 = r0;
            final Fragment fragment7 = fragment;
            final Fragment fragment8 = fragment2;
            boolean z2 = z;
            Fragment fragment9 = fragment2;
            final ArrayList<View> arrayList5 = arrayList;
            Fragment fragment10 = fragment;
            final Object obj7 = obj;
            final Rect rect4 = rect;
            AnonymousClass4 r0 = new Runnable() {
                public void run() {
                    ArrayMap<String, View> captureInSharedElements = FragmentTransition.captureInSharedElements(fragmentTransitionImpl3, arrayMap4, obj5, fragmentContainerTransition3);
                    if (captureInSharedElements != null) {
                        arrayList4.addAll(captureInSharedElements.values());
                        arrayList4.add(view2);
                    }
                    FragmentTransition.callSharedElementStartEnd(fragment7, fragment8, z, captureInSharedElements, false);
                    Object obj = obj5;
                    if (obj != null) {
                        fragmentTransitionImpl3.swapSharedElementTargets(obj, arrayList5, arrayList4);
                        View inEpicenterView = FragmentTransition.getInEpicenterView(captureInSharedElements, fragmentContainerTransition3, obj7, z);
                        if (inEpicenterView != null) {
                            fragmentTransitionImpl3.getBoundsOnScreen(inEpicenterView, rect4);
                        }
                    }
                }
            };
            OneShotPreDrawListener.add(viewGroup, r13);
            return obj6;
        }
        return null;
    }

    private static Object configureSharedElementsReordered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        View view2;
        Rect rect;
        ArrayMap<String, View> arrayMap2;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        View view3 = view;
        ArrayMap<String, String> arrayMap3 = arrayMap;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = fragmentContainerTransition2.lastIn;
        Fragment fragment2 = fragmentContainerTransition2.firstOut;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null) {
            ViewGroup viewGroup2 = viewGroup;
            Fragment fragment3 = fragment2;
        } else if (fragment2 == null) {
            ViewGroup viewGroup3 = viewGroup;
            Fragment fragment4 = fragment2;
        } else {
            boolean z = fragmentContainerTransition2.lastInIsPop;
            Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragmentTransitionImpl2, fragment, fragment2, z);
            ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl2, arrayMap3, sharedElementTransition, fragmentContainerTransition2);
            ArrayMap<String, View> captureInSharedElements = captureInSharedElements(fragmentTransitionImpl2, arrayMap3, sharedElementTransition, fragmentContainerTransition2);
            if (arrayMap.isEmpty()) {
                if (captureOutSharedElements != null) {
                    captureOutSharedElements.clear();
                }
                if (captureInSharedElements != null) {
                    captureInSharedElements.clear();
                }
                obj3 = null;
            } else {
                addSharedElementsWithMatchingNames(arrayList3, captureOutSharedElements, arrayMap.keySet());
                addSharedElementsWithMatchingNames(arrayList4, captureInSharedElements, arrayMap.values());
                obj3 = sharedElementTransition;
            }
            if (obj5 == null && obj2 == null && obj3 == null) {
                return null;
            }
            callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
            if (obj3 != null) {
                arrayList4.add(view3);
                fragmentTransitionImpl2.setSharedElementTargets(obj3, view3, arrayList3);
                obj4 = obj3;
                arrayMap2 = captureInSharedElements;
                ArrayMap<String, View> arrayMap4 = captureOutSharedElements;
                setOutEpicenter(fragmentTransitionImpl, obj3, obj2, captureOutSharedElements, fragmentContainerTransition2.firstOutIsPop, fragmentContainerTransition2.firstOutTransaction);
                Rect rect2 = new Rect();
                View inEpicenterView = getInEpicenterView(arrayMap2, fragmentContainerTransition2, obj5, z);
                if (inEpicenterView != null) {
                    fragmentTransitionImpl2.setEpicenter(obj5, rect2);
                }
                rect = rect2;
                view2 = inEpicenterView;
            } else {
                obj4 = obj3;
                arrayMap2 = captureInSharedElements;
                ArrayMap<String, View> arrayMap5 = captureOutSharedElements;
                rect = null;
                view2 = null;
            }
            final Fragment fragment5 = fragment;
            final Fragment fragment6 = fragment2;
            final boolean z2 = z;
            final ArrayMap<String, View> arrayMap6 = arrayMap2;
            AnonymousClass3 r8 = r0;
            final View view4 = view2;
            boolean z3 = z;
            final FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
            Fragment fragment7 = fragment2;
            final Rect rect3 = rect;
            AnonymousClass3 r0 = new Runnable() {
                public void run() {
                    FragmentTransition.callSharedElementStartEnd(fragment5, fragment6, z2, arrayMap6, false);
                    View view = view4;
                    if (view != null) {
                        fragmentTransitionImpl3.getBoundsOnScreen(view, rect3);
                    }
                }
            };
            OneShotPreDrawListener.add(viewGroup, r8);
            return obj4;
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r2v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    private static void configureTransitionsOrdered(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        ViewGroup viewGroup;
        Object obj;
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        if (fragmentManagerImpl2.mContainer.onHasView()) {
            viewGroup = fragmentManagerImpl2.mContainer.onFindViewById(i);
        } else {
            int i2 = i;
            viewGroup = null;
        }
        if (viewGroup != null) {
            Fragment fragment = fragmentContainerTransition2.lastIn;
            Fragment fragment2 = fragmentContainerTransition2.firstOut;
            FragmentTransitionImpl chooseImpl = chooseImpl(fragment2, fragment);
            if (chooseImpl != null) {
                boolean z = fragmentContainerTransition2.lastInIsPop;
                boolean z2 = fragmentContainerTransition2.firstOutIsPop;
                Object enterTransition = getEnterTransition(chooseImpl, fragment, z);
                Object exitTransition = getExitTransition(chooseImpl, fragment2, z2);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = arrayList;
                Object obj2 = exitTransition;
                Object obj3 = enterTransition;
                boolean z3 = z2;
                boolean z4 = z;
                FragmentTransitionImpl fragmentTransitionImpl = chooseImpl;
                Fragment fragment3 = fragment2;
                Object configureSharedElementsOrdered = configureSharedElementsOrdered(chooseImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList3, arrayList2, obj3, obj2);
                Object obj4 = obj3;
                if (obj4 == null && configureSharedElementsOrdered == null) {
                    obj = obj2;
                    if (obj == null) {
                        return;
                    }
                } else {
                    obj = obj2;
                }
                ArrayList arrayList4 = arrayList3;
                ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(fragmentTransitionImpl, obj, fragment3, arrayList4, view2);
                Object obj5 = (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) ? null : obj;
                fragmentTransitionImpl.addTarget(obj4, view2);
                Object mergeTransitions = mergeTransitions(fragmentTransitionImpl, obj4, obj5, configureSharedElementsOrdered, fragment, fragmentContainerTransition2.lastInIsPop);
                if (mergeTransitions != null) {
                    ArrayList arrayList5 = new ArrayList();
                    fragmentTransitionImpl.scheduleRemoveTargets(mergeTransitions, obj4, arrayList5, obj5, configureEnteringExitingViews, configureSharedElementsOrdered, arrayList2);
                    ArrayList arrayList6 = arrayList4;
                    Object obj6 = obj4;
                    scheduleTargetChange(fragmentTransitionImpl, viewGroup, fragment, view, arrayList2, obj4, arrayList5, obj5, configureEnteringExitingViews);
                    ArrayList arrayList7 = arrayList2;
                    fragmentTransitionImpl.setNameOverridesOrdered(viewGroup, arrayList7, arrayMap2);
                    fragmentTransitionImpl.beginDelayedTransition(viewGroup, mergeTransitions);
                    fragmentTransitionImpl.scheduleNameReset(viewGroup, arrayList7, arrayMap2);
                    return;
                }
                Object obj7 = mergeTransitions;
                ArrayList arrayList8 = arrayList4;
                Object obj8 = obj4;
                ArrayList arrayList9 = arrayList2;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    private static void configureTransitionsReordered(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        ViewGroup viewGroup;
        Object obj;
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        if (fragmentManagerImpl2.mContainer.onHasView()) {
            viewGroup = fragmentManagerImpl2.mContainer.onFindViewById(i);
        } else {
            int i2 = i;
            viewGroup = null;
        }
        if (viewGroup != null) {
            Fragment fragment = fragmentContainerTransition2.lastIn;
            Fragment fragment2 = fragmentContainerTransition2.firstOut;
            FragmentTransitionImpl chooseImpl = chooseImpl(fragment2, fragment);
            if (chooseImpl != null) {
                boolean z = fragmentContainerTransition2.lastInIsPop;
                boolean z2 = fragmentContainerTransition2.firstOutIsPop;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object enterTransition = getEnterTransition(chooseImpl, fragment, z);
                Object exitTransition = getExitTransition(chooseImpl, fragment2, z2);
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = arrayList;
                boolean z3 = z2;
                boolean z4 = z;
                Object obj2 = enterTransition;
                FragmentTransitionImpl fragmentTransitionImpl = chooseImpl;
                Object configureSharedElementsReordered = configureSharedElementsReordered(chooseImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList3, arrayList4, obj2, exitTransition);
                if (obj2 == null && configureSharedElementsReordered == null) {
                    obj = exitTransition;
                    if (obj == null) {
                        return;
                    }
                } else {
                    obj = exitTransition;
                }
                ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(fragmentTransitionImpl, obj, fragment2, arrayList3, view2);
                ArrayList arrayList5 = arrayList4;
                ArrayList<View> configureEnteringExitingViews2 = configureEnteringExitingViews(fragmentTransitionImpl, obj2, fragment, arrayList5, view2);
                setViewVisibility(configureEnteringExitingViews2, 4);
                ArrayList<View> arrayList6 = configureEnteringExitingViews2;
                ArrayList arrayList7 = arrayList5;
                ArrayList<View> arrayList8 = configureEnteringExitingViews;
                Object mergeTransitions = mergeTransitions(fragmentTransitionImpl, obj2, obj, configureSharedElementsReordered, fragment, z4);
                if (mergeTransitions != null) {
                    replaceHide(fragmentTransitionImpl, obj, fragment2, arrayList8);
                    ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList7);
                    Object obj3 = obj;
                    Object obj4 = obj2;
                    fragmentTransitionImpl.scheduleRemoveTargets(mergeTransitions, obj2, arrayList6, obj, arrayList8, configureSharedElementsReordered, arrayList7);
                    fragmentTransitionImpl.beginDelayedTransition(viewGroup, mergeTransitions);
                    fragmentTransitionImpl.setNameOverridesReordered(viewGroup, arrayList3, arrayList7, prepareSetNameOverridesReordered, arrayMap);
                    setViewVisibility(arrayList6, 0);
                    fragmentTransitionImpl.swapSharedElementTargets(configureSharedElementsReordered, arrayList3, arrayList7);
                    return;
                }
                Object obj5 = mergeTransitions;
                Object obj6 = obj;
                Object obj7 = obj2;
                ArrayList<View> arrayList9 = arrayList6;
                ArrayList arrayList10 = arrayList3;
            }
        }
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    private static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    private static Object getEnterTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object getExitTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || backStackRecord.mSharedElementSourceNames == null || backStackRecord.mSharedElementSourceNames.isEmpty()) {
            return null;
        }
        return arrayMap.get(z ? (String) backStackRecord.mSharedElementSourceNames.get(0) : (String) backStackRecord.mSharedElementTargetNames.get(0));
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object mergeTransitions(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || fragment == null)) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        return z2 ? fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3) : fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    private static void replaceHide(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() {
                public void run() {
                    FragmentTransition.setViewVisibility(arrayList, 4);
                }
            });
        }
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    private static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    private static void scheduleTargetChange(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        AnonymousClass2 r0 = new Runnable() {
            public void run() {
                Object obj = obj3;
                if (obj != null) {
                    fragmentTransitionImpl2.removeTarget(obj, view2);
                    arrayList5.addAll(FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl2, obj3, fragment2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        fragmentTransitionImpl2.replaceTargets(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        };
        ViewGroup viewGroup2 = viewGroup;
        OneShotPreDrawListener.add(viewGroup, r0);
    }

    private static void setOutEpicenter(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        if (backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
            View view = arrayMap.get(z ? (String) backStackRecord.mSharedElementTargetNames.get(0) : (String) backStackRecord.mSharedElementSourceNames.get(0));
            fragmentTransitionImpl.setEpicenter(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.setEpicenter(obj2, view);
            }
        }
    }

    static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    static void startTransitions(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                BackStackRecord backStackRecord = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    calculatePopFragments(backStackRecord, sparseArray, z);
                } else {
                    calculateFragments(backStackRecord, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl.mHost.getContext());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    ArrayMap<String, String> calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i, i2);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i4);
                    if (z) {
                        configureTransitionsReordered(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    } else {
                        configureTransitionsOrdered(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    }
                }
            }
        }
    }

    static boolean supportsTransition() {
        return (PLATFORM_IMPL == null && SUPPORT_IMPL == null) ? false : true;
    }
}
