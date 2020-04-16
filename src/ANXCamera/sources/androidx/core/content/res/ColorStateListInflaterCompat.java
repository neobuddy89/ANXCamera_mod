package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.core.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            int next = xmlPullParser.next();
            i = next;
            if (next == 2) {
                break;
            }
        } while (i != 1);
        if (i == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static ColorStateList inflate(Resources resources, int i, Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception e2) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r6v10, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    private static ColorStateList inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AttributeSet attributeSet2 = attributeSet;
        int i = 1;
        int depth = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            int i3 = next;
            if (next == i) {
                Resources resources2 = resources;
                Resources.Theme theme2 = theme;
                int i4 = depth;
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            int i5 = depth2;
            if (depth2 < depth && i3 == 3) {
                Resources resources3 = resources;
                Resources.Theme theme3 = theme;
                int i6 = depth;
                break;
            } else if (i3 != 2 || i5 > depth || !xmlPullParser.getName().equals("item")) {
                Resources resources4 = resources;
                Resources.Theme theme4 = theme;
                depth = depth;
                i = 1;
            } else {
                TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet2, R.styleable.ColorStateListItem);
                int color = obtainAttributes.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                float f2 = 1.0f;
                if (obtainAttributes.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
                    f2 = obtainAttributes.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
                } else if (obtainAttributes.hasValue(R.styleable.ColorStateListItem_alpha)) {
                    f2 = obtainAttributes.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
                }
                obtainAttributes.recycle();
                int i7 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i8 = 0;
                while (i8 < attributeCount) {
                    int i9 = depth;
                    int attributeNameResource = attributeSet2.getAttributeNameResource(i8);
                    TypedArray typedArray = obtainAttributes;
                    if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == R.attr.alpha)) {
                        int i10 = i7 + 1;
                        iArr3[i7] = attributeSet2.getAttributeBooleanValue(i8, false) ? attributeNameResource : -attributeNameResource;
                        i7 = i10;
                    }
                    i8++;
                    depth = i9;
                    obtainAttributes = typedArray;
                }
                int i11 = depth;
                TypedArray typedArray2 = obtainAttributes;
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i7);
                iArr2 = GrowingArrayUtils.append(iArr2, i2, modulateColorAlpha(color, f2));
                iArr = GrowingArrayUtils.append((T[]) iArr, i2, trimStateSet);
                i2++;
                depth = i11;
                i = 1;
            }
        }
        int[] iArr4 = new int[i2];
        int[][] iArr5 = new int[i2][];
        System.arraycopy(iArr2, 0, iArr4, 0, i2);
        System.arraycopy(iArr, 0, iArr5, 0, i2);
        return new ColorStateList(iArr5, iArr4);
    }

    private static int modulateColorAlpha(int i, float f2) {
        return (16777215 & i) | (Math.round(((float) Color.alpha(i)) * f2) << 24);
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
