package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    private static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        PathDataEvaluator() {
        }

        PathDataEvaluator(PathParser.PathDataNode[] pathDataNodeArr) {
            this.mNodeArray = pathDataNodeArr;
        }

        public PathParser.PathDataNode[] evaluate(float f2, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                if (!PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
                    this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
                }
                for (int i = 0; i < pathDataNodeArr.length; i++) {
                    this.mNodeArray[i].interpolatePathDataNode(pathDataNodeArr[i], pathDataNodeArr2[i], f2);
                }
                return this.mNodeArray;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private AnimatorInflaterCompat() {
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), (AnimatorSet) null, 0, f2);
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f2) throws XmlPullParserException, IOException {
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AnimatorSet animatorSet2 = animatorSet;
        int depth = xmlPullParser.getDepth();
        ObjectAnimator objectAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i2 = next;
            if (next != 3 || xmlPullParser.getDepth() > depth) {
                if (i2 == 1) {
                    Context context2 = context;
                    break;
                } else if (i2 == 2) {
                    String name = xmlPullParser.getName();
                    boolean z = false;
                    if (name.equals("objectAnimator")) {
                        Context context3 = context;
                        objectAnimator = loadObjectAnimator(context, resources, theme, attributeSet, f2, xmlPullParser);
                    } else if (name.equals("animator")) {
                        Context context4 = context;
                        objectAnimator = loadAnimator(context, resources, theme, attributeSet, (ValueAnimator) null, f2, xmlPullParser);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet3 = new AnimatorSet();
                        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources2, theme2, attributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
                        createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, animatorSet3, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser2, "ordering", 0, 0), f2);
                        obtainAttributes.recycle();
                        Context context5 = context;
                        objectAnimator = animatorSet3;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] loadValues = loadValues(context, resources2, theme2, xmlPullParser2, Xml.asAttributeSet(xmlPullParser));
                        if (loadValues != null && (objectAnimator instanceof ValueAnimator)) {
                            objectAnimator.setValues(loadValues);
                        }
                        z = true;
                    } else {
                        Context context6 = context;
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet2 != null && !z) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(objectAnimator);
                    }
                }
            } else {
                Context context7 = context;
                break;
            }
        }
        if (!(animatorSet2 == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            int i3 = 0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i3] = (Animator) it.next();
                i3++;
            }
            if (i == 0) {
                animatorSet2.playTogether(animatorArr);
            } else {
                animatorSet2.playSequentially(animatorArr);
            }
        }
        return objectAnimator;
    }

    private static Keyframe createNewKeyframe(Keyframe keyframe, float f2) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f2) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f2) : Keyframe.ofObject(f2);
    }

    private static void distributeKeyframes(Keyframe[] keyframeArr, float f2, int i, int i2) {
        float f3 = f2 / ((float) ((i2 - i) + 2));
        for (int i3 = i; i3 <= i2; i3++) {
            keyframeArr[i3].setFraction(keyframeArr[i3 - 1].getFraction() + f3);
        }
    }

    private static void dumpKeyframes(Object[] objArr, String str) {
        if (objArr != null && objArr.length != 0) {
            Log.d(TAG, str);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Keyframe keyframe = objArr[i];
                StringBuilder sb = new StringBuilder();
                sb.append("Keyframe ");
                sb.append(i);
                sb.append(": fraction ");
                Object obj = "null";
                sb.append(keyframe.getFraction() < 0.0f ? obj : Float.valueOf(keyframe.getFraction()));
                sb.append(", , value : ");
                if (keyframe.hasValue()) {
                    obj = keyframe.getValue();
                }
                sb.append(obj);
                Log.d(TAG, sb.toString());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static PropertyValuesHolder getPVH(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        int i4;
        char c2;
        int i5;
        char c3;
        int i6;
        PropertyValuesHolder propertyValuesHolder3;
        TypedArray typedArray2 = typedArray;
        int i7 = i2;
        int i8 = i3;
        String str2 = str;
        TypedValue peekValue = typedArray2.peekValue(i7);
        boolean z = peekValue != null;
        int i9 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray2.peekValue(i8);
        boolean z2 = peekValue2 != null;
        int i10 = z2 ? peekValue2.type : 0;
        int i11 = i;
        int i12 = i11 == 4 ? ((!z || !isColorType(i9)) && (!z2 || !isColorType(i10))) ? 0 : 3 : i11;
        boolean z3 = i12 == 0;
        if (i12 == 2) {
            String string = typedArray2.getString(i7);
            String string2 = typedArray2.getString(i8);
            PathParser.PathDataNode[] createNodesFromPathData = PathParser.createNodesFromPathData(string);
            TypedValue typedValue = peekValue;
            PathParser.PathDataNode[] createNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
                TypedValue typedValue2 = peekValue2;
                i6 = i10;
                propertyValuesHolder3 = null;
            } else {
                if (createNodesFromPathData != null) {
                    PathDataEvaluator pathDataEvaluator = new PathDataEvaluator();
                    if (createNodesFromPathData2 == null) {
                        TypedValue typedValue3 = peekValue2;
                        PathDataEvaluator pathDataEvaluator2 = pathDataEvaluator;
                        i6 = i10;
                        propertyValuesHolder = PropertyValuesHolder.ofObject(str2, pathDataEvaluator2, new Object[]{createNodesFromPathData});
                    } else if (PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                        TypedValue typedValue4 = peekValue2;
                        propertyValuesHolder = PropertyValuesHolder.ofObject(str2, pathDataEvaluator, new Object[]{createNodesFromPathData, createNodesFromPathData2});
                        i6 = i10;
                    } else {
                        TypedValue typedValue5 = peekValue2;
                        PathDataEvaluator pathDataEvaluator3 = pathDataEvaluator;
                        StringBuilder sb = new StringBuilder();
                        int i13 = i10;
                        sb.append(" Can't morph from ");
                        sb.append(string);
                        sb.append(" to ");
                        sb.append(string2);
                        throw new InflateException(sb.toString());
                    }
                } else {
                    TypedValue typedValue6 = peekValue2;
                    i6 = i10;
                    propertyValuesHolder3 = null;
                    if (createNodesFromPathData2 != null) {
                        propertyValuesHolder = PropertyValuesHolder.ofObject(str2, new PathDataEvaluator(), new Object[]{createNodesFromPathData2});
                    }
                }
                int i14 = i3;
                int i15 = i6;
            }
            propertyValuesHolder = propertyValuesHolder3;
            int i142 = i3;
            int i152 = i6;
        } else {
            TypedValue typedValue7 = peekValue;
            TypedValue typedValue8 = peekValue2;
            int i16 = i10;
            ArgbEvaluator argbEvaluator = null;
            if (i12 == 3) {
                argbEvaluator = ArgbEvaluator.getInstance();
            }
            if (!z3) {
                int i17 = i3;
                int i18 = i16;
                if (z) {
                    int dimension = i9 == 5 ? (int) typedArray2.getDimension(i7, 0.0f) : isColorType(i9) ? typedArray2.getColor(i7, 0) : typedArray2.getInt(i7, 0);
                    if (z2) {
                        if (i18 == 5) {
                            i5 = (int) typedArray2.getDimension(i17, 0.0f);
                            c3 = 0;
                        } else if (isColorType(i18)) {
                            c3 = 0;
                            i5 = typedArray2.getColor(i17, 0);
                        } else {
                            c3 = 0;
                            i5 = typedArray2.getInt(i17, 0);
                        }
                        int[] iArr = new int[2];
                        iArr[c3] = dimension;
                        iArr[1] = i5;
                        propertyValuesHolder2 = PropertyValuesHolder.ofInt(str2, iArr);
                    } else {
                        propertyValuesHolder2 = PropertyValuesHolder.ofInt(str2, new int[]{dimension});
                    }
                } else if (z2) {
                    if (i18 == 5) {
                        i4 = (int) typedArray2.getDimension(i17, 0.0f);
                        c2 = 0;
                    } else if (isColorType(i18)) {
                        c2 = 0;
                        i4 = typedArray2.getColor(i17, 0);
                    } else {
                        c2 = 0;
                        i4 = typedArray2.getInt(i17, 0);
                    }
                    int[] iArr2 = new int[1];
                    iArr2[c2] = i4;
                    propertyValuesHolder2 = PropertyValuesHolder.ofInt(str2, iArr2);
                } else {
                    propertyValuesHolder2 = null;
                }
            } else if (z) {
                float dimension2 = i9 == 5 ? typedArray2.getDimension(i7, 0.0f) : typedArray2.getFloat(i7, 0.0f);
                if (z2) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, new float[]{dimension2, i16 == 5 ? typedArray2.getDimension(i3, 0.0f) : typedArray2.getFloat(i3, 0.0f)});
                } else {
                    int i19 = i3;
                    int i20 = i16;
                    propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, new float[]{dimension2});
                }
            } else {
                int i21 = i3;
                propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, new float[]{i16 == 5 ? typedArray2.getDimension(i21, 0.0f) : typedArray2.getFloat(i21, 0.0f)});
            }
            if (!(propertyValuesHolder == null || argbEvaluator == null)) {
                propertyValuesHolder.setEvaluator(argbEvaluator);
            }
        }
        return propertyValuesHolder;
    }

    private static int inferValueTypeFromValues(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = true;
        int i3 = 0;
        boolean z2 = peekValue != null;
        int i4 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        if (peekValue2 == null) {
            z = false;
        }
        if (z) {
            i3 = peekValue2.type;
        }
        return ((!z2 || !isColorType(i4)) && (!z || !isColorType(i3))) ? 0 : 3;
    }

    private static int inferValueTypeOfKeyframe(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        boolean z = false;
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if (peekNamedValue != null) {
            z = true;
        }
        int i = (!z || !isColorType(peekNamedValue.type)) ? 0 : 3;
        obtainAttributes.recycle();
        return i;
    }

    private static boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }

    public static Animator loadAnimator(Context context, int i) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : loadAnimator(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        return loadAnimator(context, resources, theme, i, 1.0f);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int i, float f2) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = resources.getAnimation(i);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, resources, theme, animation, f2);
            if (animation != null) {
                animation.close();
            }
            return createAnimatorFromXml;
        } catch (XmlPullParserException e2) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (IOException e3) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException2.initCause(e3);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, obtainAttributes, obtainAttributes2, f2, xmlPullParser);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe loadKeyframe(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        Keyframe keyframe = null;
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        boolean z = peekNamedValue != null;
        if (i == 4) {
            i = (!z || !isColorType(peekNamedValue.type)) ? 0 : 3;
        }
        if (!z) {
            keyframe = i == 0 ? Keyframe.ofFloat(namedFloat) : Keyframe.ofInt(namedFloat);
        } else if (i == 0) {
            keyframe = Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "value", 0, 0.0f));
        } else if (i == 1 || i == 3) {
            keyframe = Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "value", 0, 0));
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 1, 0);
        if (namedResourceId > 0) {
            keyframe.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        return keyframe;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder loadPvh(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int i2;
        PropertyValuesHolder propertyValuesHolder;
        Object obj;
        int i3;
        float f2;
        ArrayList arrayList;
        Object obj2 = null;
        ArrayList arrayList2 = null;
        int i4 = i;
        while (true) {
            int next = xmlPullParser.next();
            i2 = next;
            if (next == 3 || i2 == 1) {
                Resources resources2 = resources;
                Resources.Theme theme2 = theme;
                XmlPullParser xmlPullParser2 = xmlPullParser;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i4 == 4) {
                    i4 = inferValueTypeOfKeyframe(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                } else {
                    Resources resources3 = resources;
                    Resources.Theme theme3 = theme;
                    XmlPullParser xmlPullParser3 = xmlPullParser;
                }
                Keyframe loadKeyframe = loadKeyframe(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i4, xmlPullParser);
                if (loadKeyframe != null) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(loadKeyframe);
                }
                xmlPullParser.next();
            } else {
                Resources resources4 = resources;
                Resources.Theme theme4 = theme;
                XmlPullParser xmlPullParser4 = xmlPullParser;
            }
        }
        Resources resources22 = resources;
        Resources.Theme theme22 = theme;
        XmlPullParser xmlPullParser22 = xmlPullParser;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i5 = size;
            if (size > 0) {
                Keyframe keyframe = (Keyframe) arrayList2.get(0);
                Keyframe keyframe2 = (Keyframe) arrayList2.get(i5 - 1);
                float fraction = keyframe2.getFraction();
                float f3 = 0.0f;
                if (fraction < 1.0f) {
                    if (fraction < 0.0f) {
                        keyframe2.setFraction(1.0f);
                    } else {
                        arrayList2.add(arrayList2.size(), createNewKeyframe(keyframe2, 1.0f));
                        i5++;
                    }
                }
                float fraction2 = keyframe.getFraction();
                if (fraction2 != 0.0f) {
                    if (fraction2 < 0.0f) {
                        keyframe.setFraction(0.0f);
                    } else {
                        arrayList2.add(0, createNewKeyframe(keyframe, 0.0f));
                        i5++;
                    }
                }
                Keyframe[] keyframeArr = new Keyframe[i5];
                arrayList2.toArray(keyframeArr);
                int i6 = 0;
                while (i6 < i5) {
                    Keyframe keyframe3 = keyframeArr[i6];
                    if (keyframe3.getFraction() >= f3) {
                        obj = obj2;
                        arrayList = arrayList2;
                        i3 = i2;
                        f2 = f3;
                    } else if (i6 == 0) {
                        keyframe3.setFraction(f3);
                        obj = obj2;
                        arrayList = arrayList2;
                        i3 = i2;
                        f2 = f3;
                    } else if (i6 == i5 - 1) {
                        keyframe3.setFraction(1.0f);
                        obj = obj2;
                        arrayList = arrayList2;
                        i3 = i2;
                        f2 = 0.0f;
                    } else {
                        int i7 = i6;
                        obj = obj2;
                        int i8 = i7 + 1;
                        arrayList = arrayList2;
                        int i9 = i6;
                        while (true) {
                            i3 = i2;
                            if (i8 >= i5 - 1) {
                                f2 = 0.0f;
                                break;
                            }
                            f2 = 0.0f;
                            if (keyframeArr[i8].getFraction() >= 0.0f) {
                                break;
                            }
                            i9 = i8;
                            i8++;
                            i2 = i3;
                        }
                        distributeKeyframes(keyframeArr, keyframeArr[i9 + 1].getFraction() - keyframeArr[i7 - 1].getFraction(), i7, i9);
                    }
                    i6++;
                    arrayList2 = arrayList;
                    f3 = f2;
                    i2 = i3;
                    obj2 = obj;
                }
                Object obj3 = obj2;
                ArrayList arrayList3 = arrayList2;
                int i10 = i2;
                PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                if (i4 != 3) {
                    return ofKeyframe;
                }
                ofKeyframe.setEvaluator(ArgbEvaluator.getInstance());
                return ofKeyframe;
            }
            propertyValuesHolder = null;
            ArrayList arrayList4 = arrayList2;
            int i11 = i2;
            String str2 = str;
        } else {
            propertyValuesHolder = null;
            ArrayList arrayList5 = arrayList2;
            int i12 = i2;
            String str3 = str;
        }
        return propertyValuesHolder;
    }

    private static PropertyValuesHolder[] loadValues(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            int i = eventType;
            if (eventType == 3 || i == 1) {
                Resources resources2 = resources;
                Resources.Theme theme2 = theme;
                AttributeSet attributeSet2 = attributeSet;
                PropertyValuesHolder[] propertyValuesHolderArr = null;
            } else if (i != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                    String namedString = TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser2, "propertyName", 3);
                    int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser2, "valueType", 2, 4);
                    int i2 = namedInt;
                    PropertyValuesHolder loadPvh = loadPvh(context, resources, theme, xmlPullParser, namedString, namedInt);
                    if (loadPvh == null) {
                        loadPvh = getPVH(obtainAttributes, i2, 0, 1, namedString);
                    } else {
                        int i3 = i2;
                    }
                    if (loadPvh != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(loadPvh);
                    }
                    obtainAttributes.recycle();
                } else {
                    Resources resources3 = resources;
                    Resources.Theme theme3 = theme;
                    AttributeSet attributeSet3 = attributeSet;
                }
                xmlPullParser.next();
            }
        }
        Resources resources22 = resources;
        Resources.Theme theme22 = theme;
        AttributeSet attributeSet22 = attributeSet;
        PropertyValuesHolder[] propertyValuesHolderArr2 = null;
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr2 = new PropertyValuesHolder[size];
            for (int i4 = 0; i4 < size; i4++) {
                propertyValuesHolderArr2[i4] = (PropertyValuesHolder) arrayList.get(i4);
            }
        }
        return propertyValuesHolderArr2;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long namedInt = (long) TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", 1, 300);
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = inferValueTypeFromValues(typedArray, 5, 6);
            }
            PropertyValuesHolder pvh = getPVH(typedArray, namedInt3, 5, 6, "");
            if (pvh != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{pvh});
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            setupObjectAnimator(valueAnimator, typedArray2, namedInt3, f2, xmlPullParser);
        }
    }

    private static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString != null) {
            String namedString2 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
            String namedString3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
            if (i == 2 || i == 4) {
            }
            if (namedString2 == null && namedString3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            setupPathMotion(PathParser.createPathFromPathData(namedString), objectAnimator, 0.5f * f2, namedString2, namedString3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void setupPathMotion(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        float f3 = 0.0f;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        while (true) {
            f3 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
            if (!pathMeasure.nextContour()) {
                break;
            }
            path2 = path;
        }
        PathMeasure pathMeasure2 = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f3 / f2)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        int i = 0;
        float f4 = f3 / ((float) (min - 1));
        float f5 = 0.0f;
        int i2 = 0;
        while (i2 < min) {
            pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i)).floatValue(), fArr3, (float[]) null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f5 += f4;
            if (i + 1 < arrayList.size() && f5 > ((Float) arrayList.get(i + 1)).floatValue()) {
                i++;
                pathMeasure2.nextContour();
            }
            i2++;
            Path path3 = path;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (str3 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str3, fArr);
        }
        if (str4 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (propertyValuesHolder == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder2});
        } else if (propertyValuesHolder2 == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
        } else {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder, propertyValuesHolder2});
        }
    }
}
