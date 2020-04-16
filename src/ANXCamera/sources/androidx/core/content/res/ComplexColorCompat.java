package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.android.camera.statistic.MistatsConstants;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i) {
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = i;
    }

    private static ComplexColorCompat createFromXml(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int i2;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            int next = xml.next();
            i2 = next;
            if (next == 2) {
                break;
            }
        } while (i2 != 1);
        if (i2 == 2) {
            String name = xml.getName();
            char c2 = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c2 = 0;
                }
            } else if (name.equals(MistatsConstants.Manual.GRADIENT)) {
                c2 = 1;
            }
            if (c2 == 0) {
                return from(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
            }
            if (c2 == 1) {
                return from(GradientColorInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        throw new XmlPullParserException("No start tag found");
    }

    static ComplexColorCompat from(int i) {
        return new ComplexColorCompat((Shader) null, (ColorStateList) null, i);
    }

    static ComplexColorCompat from(ColorStateList colorStateList) {
        return new ComplexColorCompat((Shader) null, colorStateList, colorStateList.getDefaultColor());
    }

    static ComplexColorCompat from(Shader shader) {
        return new ComplexColorCompat(shader, (ColorStateList) null, 0);
    }

    public static ComplexColorCompat inflate(Resources resources, int i, Resources.Theme theme) {
        try {
            return createFromXml(resources, i, theme);
        } catch (Exception e2) {
            Log.e(LOG_TAG, "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        return this.mShader != null;
    }

    public boolean isStateful() {
        if (this.mShader == null) {
            ColorStateList colorStateList = this.mColorStateList;
            return colorStateList != null && colorStateList.isStateful();
        }
    }

    public boolean onStateChanged(int[] iArr) {
        if (!isStateful()) {
            return false;
        }
        ColorStateList colorStateList = this.mColorStateList;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState == this.mColor) {
            return false;
        }
        this.mColor = colorForState;
        return true;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public boolean willDraw() {
        return isGradient() || this.mColor != 0;
    }
}
