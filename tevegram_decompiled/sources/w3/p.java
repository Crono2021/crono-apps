package w3;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.util.ArrayDeque;
import org.webrtc.PeerConnectionFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends g {

    /* renamed from: r, reason: collision with root package name */
    public static final PorterDuff.Mode f9919r = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    public n f9920j;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuffColorFilter f9921k;

    /* renamed from: l, reason: collision with root package name */
    public ColorFilter f9922l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9923m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9924n;

    /* renamed from: o, reason: collision with root package name */
    public final float[] f9925o;

    /* renamed from: p, reason: collision with root package name */
    public final Matrix f9926p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f9927q;

    public p() {
        this.f9924n = true;
        this.f9925o = new float[9];
        this.f9926p = new Matrix();
        this.f9927q = new Rect();
        n nVar = new n();
        nVar.f9909c = null;
        nVar.f9910d = f9919r;
        nVar.f9908b = new m();
        this.f9920j = nVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f9868i;
        if (drawable == null) {
            return false;
        }
        g0.b.b(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f9927q;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f9922l;
        if (colorFilter == null) {
            colorFilter = this.f9921k;
        }
        Matrix matrix = this.f9926p;
        canvas.getMatrix(matrix);
        float[] fArr = this.f9925o;
        matrix.getValues(fArr);
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[4]);
        float abs3 = Math.abs(fArr[1]);
        float abs4 = Math.abs(fArr[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int width = (int) (rect.width() * abs);
        int min = Math.min(IjkMediaMeta.FF_PROFILE_H264_INTRA, width);
        int min2 = Math.min(IjkMediaMeta.FF_PROFILE_H264_INTRA, (int) (rect.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && com.bumptech.glide.d.F(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        n nVar = this.f9920j;
        Bitmap bitmap = nVar.f9912f;
        if (bitmap == null || min != bitmap.getWidth() || min2 != nVar.f9912f.getHeight()) {
            nVar.f9912f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
            nVar.f9916k = true;
        }
        boolean z8 = this.f9924n;
        n nVar2 = this.f9920j;
        if (!z8) {
            nVar2.f9912f.eraseColor(0);
            Canvas canvas2 = new Canvas(nVar2.f9912f);
            m mVar = nVar2.f9908b;
            mVar.a(mVar.f9899g, m.f9892p, canvas2, min, min2);
        } else if (nVar2.f9916k || nVar2.f9913g != nVar2.f9909c || nVar2.h != nVar2.f9910d || nVar2.f9915j != nVar2.f9911e || nVar2.f9914i != nVar2.f9908b.getRootAlpha()) {
            n nVar3 = this.f9920j;
            nVar3.f9912f.eraseColor(0);
            Canvas canvas3 = new Canvas(nVar3.f9912f);
            m mVar2 = nVar3.f9908b;
            mVar2.a(mVar2.f9899g, m.f9892p, canvas3, min, min2);
            n nVar4 = this.f9920j;
            nVar4.f9913g = nVar4.f9909c;
            nVar4.h = nVar4.f9910d;
            nVar4.f9914i = nVar4.f9908b.getRootAlpha();
            nVar4.f9915j = nVar4.f9911e;
            nVar4.f9916k = false;
        }
        n nVar5 = this.f9920j;
        if (nVar5.f9908b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (nVar5.f9917l == null) {
                Paint paint2 = new Paint();
                nVar5.f9917l = paint2;
                paint2.setFilterBitmap(true);
            }
            nVar5.f9917l.setAlpha(nVar5.f9908b.getRootAlpha());
            nVar5.f9917l.setColorFilter(colorFilter);
            paint = nVar5.f9917l;
        }
        canvas.drawBitmap(nVar5.f9912f, (Rect) null, rect, paint);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f9868i;
        return drawable != null ? g0.a.a(drawable) : this.f9920j.f9908b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f9920j.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f9868i;
        return drawable != null ? g0.b.c(drawable) : this.f9922l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f9868i != null && Build.VERSION.SDK_INT >= 24) {
            return new o(this.f9868i.getConstantState());
        }
        this.f9920j.f9907a = getChangingConfigurations();
        return this.f9920j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f9920j.f9908b.f9900i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f9920j.f9908b.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i9;
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.b.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        n nVar = this.f9920j;
        nVar.f9908b = new m();
        TypedArray g9 = e0.b.g(resources, theme, attributeSet, a.f9845a);
        n nVar2 = this.f9920j;
        m mVar = nVar2.f9908b;
        int i10 = !e0.b.d(xmlPullParser, "tintMode") ? -1 : g9.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i10 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i10 != 5) {
            if (i10 != 9) {
                switch (i10) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        nVar2.f9910d = mode;
        ColorStateList colorStateList = null;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            g9.getValue(1, typedValue);
            int i11 = typedValue.type;
            if (i11 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i11 < 28 || i11 > 31) {
                Resources resources2 = g9.getResources();
                int resourceId = g9.getResourceId(1, 0);
                ThreadLocal threadLocal = e0.c.f2981a;
                try {
                    colorStateList = e0.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e9) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e9);
                }
            } else {
                colorStateList = ColorStateList.valueOf(typedValue.data);
            }
        }
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList2 != null) {
            nVar2.f9909c = colorStateList2;
        }
        boolean z8 = nVar2.f9911e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z8 = g9.getBoolean(5, z8);
        }
        nVar2.f9911e = z8;
        float f9 = mVar.f9901j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f9 = g9.getFloat(7, f9);
        }
        mVar.f9901j = f9;
        float f10 = mVar.f9902k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f10 = g9.getFloat(8, f10);
        }
        mVar.f9902k = f10;
        if (mVar.f9901j <= 0.0f) {
            throw new XmlPullParserException(g9.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f10 <= 0.0f) {
            throw new XmlPullParserException(g9.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        mVar.h = g9.getDimension(3, mVar.h);
        float dimension = g9.getDimension(2, mVar.f9900i);
        mVar.f9900i = dimension;
        if (mVar.h <= 0.0f) {
            throw new XmlPullParserException(g9.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(g9.getPositionDescription() + "<vector> tag requires height > 0");
        }
        float alpha = mVar.getAlpha();
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
            alpha = g9.getFloat(4, alpha);
        }
        mVar.setAlpha(alpha);
        String string = g9.getString(0);
        if (string != null) {
            mVar.f9904m = string;
            mVar.f9906o.put(string, mVar);
        }
        g9.recycle();
        nVar.f9907a = getChangingConfigurations();
        nVar.f9916k = true;
        n nVar3 = this.f9920j;
        m mVar2 = nVar3.f9908b;
        ArrayDeque arrayDeque = new ArrayDeque();
        j jVar = mVar2.f9899g;
        s.d dVar = mVar2.f9906o;
        arrayDeque.push(jVar);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z9 = true;
        for (int i12 = 1; eventType != i12 && (xmlPullParser.getDepth() >= depth || eventType != 3); i12 = 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                j jVar2 = (j) arrayDeque.peek();
                i9 = depth;
                if ("path".equals(name)) {
                    i iVar = new i();
                    iVar.f9870e = 0.0f;
                    iVar.f9872g = 1.0f;
                    iVar.h = 1.0f;
                    iVar.f9873i = 0.0f;
                    iVar.f9874j = 1.0f;
                    iVar.f9875k = 0.0f;
                    Paint.Cap cap = Paint.Cap.BUTT;
                    iVar.f9876l = cap;
                    Paint.Join join = Paint.Join.MITER;
                    iVar.f9877m = join;
                    iVar.f9878n = 4.0f;
                    TypedArray g10 = e0.b.g(resources, theme, attributeSet, a.f9847c);
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                        String string2 = g10.getString(0);
                        if (string2 != null) {
                            iVar.f9890b = string2;
                        }
                        String string3 = g10.getString(2);
                        if (string3 != null) {
                            iVar.f9889a = a.a.m(string3);
                        }
                        iVar.f9871f = e0.b.b(g10, xmlPullParser, theme, "fillColor", 1);
                        float f11 = iVar.h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                            f11 = g10.getFloat(12, f11);
                        }
                        iVar.h = f11;
                        int i13 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? g10.getInt(8, -1) : -1;
                        iVar.f9876l = i13 != 0 ? i13 != 1 ? i13 != 2 ? iVar.f9876l : Paint.Cap.SQUARE : Paint.Cap.ROUND : cap;
                        int i14 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? g10.getInt(9, -1) : -1;
                        iVar.f9877m = i14 != 0 ? i14 != 1 ? i14 != 2 ? iVar.f9877m : Paint.Join.BEVEL : Paint.Join.ROUND : join;
                        float f12 = iVar.f9878n;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                            f12 = g10.getFloat(10, f12);
                        }
                        iVar.f9878n = f12;
                        iVar.f9869d = e0.b.b(g10, xmlPullParser, theme, "strokeColor", 3);
                        float f13 = iVar.f9872g;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                            f13 = g10.getFloat(11, f13);
                        }
                        iVar.f9872g = f13;
                        float f14 = iVar.f9870e;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                            f14 = g10.getFloat(4, f14);
                        }
                        iVar.f9870e = f14;
                        float f15 = iVar.f9874j;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                            f15 = g10.getFloat(6, f15);
                        }
                        iVar.f9874j = f15;
                        float f16 = iVar.f9875k;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                            f16 = g10.getFloat(7, f16);
                        }
                        iVar.f9875k = f16;
                        float f17 = iVar.f9873i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                            f17 = g10.getFloat(5, f17);
                        }
                        iVar.f9873i = f17;
                        int i15 = iVar.f9891c;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                            i15 = g10.getInt(13, i15);
                        }
                        iVar.f9891c = i15;
                    }
                    g10.recycle();
                    jVar2.f9880b.add(iVar);
                    if (iVar.getPathName() != null) {
                        dVar.put(iVar.getPathName(), iVar);
                    }
                    nVar3.f9907a = nVar3.f9907a;
                    z9 = false;
                } else if ("clip-path".equals(name)) {
                    h hVar = new h();
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                        TypedArray g11 = e0.b.g(resources, theme, attributeSet, a.f9848d);
                        String string4 = g11.getString(0);
                        if (string4 != null) {
                            hVar.f9890b = string4;
                        }
                        String string5 = g11.getString(1);
                        if (string5 != null) {
                            hVar.f9889a = a.a.m(string5);
                        }
                        hVar.f9891c = !e0.b.d(xmlPullParser, "fillType") ? 0 : g11.getInt(2, 0);
                        g11.recycle();
                    }
                    jVar2.f9880b.add(hVar);
                    if (hVar.getPathName() != null) {
                        dVar.put(hVar.getPathName(), hVar);
                    }
                    nVar3.f9907a = nVar3.f9907a;
                } else if ("group".equals(name)) {
                    j jVar3 = new j();
                    TypedArray g12 = e0.b.g(resources, theme, attributeSet, a.f9846b);
                    float f18 = jVar3.f9881c;
                    if (e0.b.d(xmlPullParser, "rotation")) {
                        f18 = g12.getFloat(5, f18);
                    }
                    jVar3.f9881c = f18;
                    jVar3.f9882d = g12.getFloat(1, jVar3.f9882d);
                    jVar3.f9883e = g12.getFloat(2, jVar3.f9883e);
                    float f19 = jVar3.f9884f;
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                        f19 = g12.getFloat(3, f19);
                    }
                    jVar3.f9884f = f19;
                    float f20 = jVar3.f9885g;
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                        f20 = g12.getFloat(4, f20);
                    }
                    jVar3.f9885g = f20;
                    float f21 = jVar3.h;
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                        f21 = g12.getFloat(6, f21);
                    }
                    jVar3.h = f21;
                    float f22 = jVar3.f9886i;
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                        f22 = g12.getFloat(7, f22);
                    }
                    jVar3.f9886i = f22;
                    String string6 = g12.getString(0);
                    if (string6 != null) {
                        jVar3.f9888k = string6;
                    }
                    jVar3.c();
                    g12.recycle();
                    jVar2.f9880b.add(jVar3);
                    arrayDeque.push(jVar3);
                    if (jVar3.getGroupName() != null) {
                        dVar.put(jVar3.getGroupName(), jVar3);
                    }
                    nVar3.f9907a = nVar3.f9907a;
                }
            } else {
                i9 = depth;
                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
            depth = i9;
        }
        if (z9) {
            throw new XmlPullParserException("no path defined");
        }
        this.f9921k = a(nVar.f9909c, nVar.f9910d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f9868i;
        return drawable != null ? g0.a.d(drawable) : this.f9920j.f9911e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        n nVar = this.f9920j;
        if (nVar == null) {
            return false;
        }
        m mVar = nVar.f9908b;
        if (mVar.f9905n == null) {
            mVar.f9905n = Boolean.valueOf(mVar.f9899g.a());
        }
        if (mVar.f9905n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f9920j.f9909c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f9923m && super.mutate() == this) {
            n nVar = this.f9920j;
            n nVar2 = new n();
            nVar2.f9909c = null;
            nVar2.f9910d = f9919r;
            if (nVar != null) {
                nVar2.f9907a = nVar.f9907a;
                m mVar = new m(nVar.f9908b);
                nVar2.f9908b = mVar;
                if (nVar.f9908b.f9897e != null) {
                    mVar.f9897e = new Paint(nVar.f9908b.f9897e);
                }
                if (nVar.f9908b.f9896d != null) {
                    nVar2.f9908b.f9896d = new Paint(nVar.f9908b.f9896d);
                }
                nVar2.f9909c = nVar.f9909c;
                nVar2.f9910d = nVar.f9910d;
                nVar2.f9911e = nVar.f9911e;
            }
            this.f9920j = nVar2;
            this.f9923m = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z8;
        PorterDuff.Mode mode;
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        n nVar = this.f9920j;
        ColorStateList colorStateList = nVar.f9909c;
        if (colorStateList == null || (mode = nVar.f9910d) == null) {
            z8 = false;
        } else {
            this.f9921k = a(colorStateList, mode);
            invalidateSelf();
            z8 = true;
        }
        m mVar = nVar.f9908b;
        if (mVar.f9905n == null) {
            mVar.f9905n = Boolean.valueOf(mVar.f9899g.a());
        }
        if (mVar.f9905n.booleanValue()) {
            boolean b9 = nVar.f9908b.f9899g.b(iArr);
            nVar.f9916k |= b9;
            if (b9) {
                invalidateSelf();
                return true;
            }
        }
        return z8;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j5) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j5);
        } else {
            super.scheduleSelf(runnable, j5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.setAlpha(i9);
        } else if (this.f9920j.f9908b.getRootAlpha() != i9) {
            this.f9920j.f9908b.setRootAlpha(i9);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z8) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.a.e(drawable, z8);
        } else {
            this.f9920j.f9911e = z8;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f9922l = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i9) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.b.g(drawable, i9);
        } else {
            setTintList(ColorStateList.valueOf(i9));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.b.h(drawable, colorStateList);
            return;
        }
        n nVar = this.f9920j;
        if (nVar.f9909c != colorStateList) {
            nVar.f9909c = colorStateList;
            this.f9921k = a(colorStateList, nVar.f9910d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.b.i(drawable, mode);
            return;
        }
        n nVar = this.f9920j;
        if (nVar.f9910d != mode) {
            nVar.f9910d = mode;
            this.f9921k = a(nVar.f9909c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.setVisible(z8, z9) : super.setVisible(z8, z9);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public p(n nVar) {
        this.f9924n = true;
        this.f9925o = new float[9];
        this.f9926p = new Matrix();
        this.f9927q = new Rect();
        this.f9920j = nVar;
        this.f9921k = a(nVar.f9909c, nVar.f9910d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }
}
