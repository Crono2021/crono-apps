package com.bumptech.glide;

import a8.p;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EdgeEffect;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.crypto.tink.shaded.protobuf.d1;
import com.google.crypto.tink.shaded.protobuf.e0;
import com.google.crypto.tink.shaded.protobuf.g1;
import com.google.crypto.tink.shaded.protobuf.s1;
import com.google.crypto.tink.shaded.protobuf.z;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import k4.x;
import k8.n;
import n0.b0;
import n0.c0;
import n0.i0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static Method f1752a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1753b = false;

    /* renamed from: c, reason: collision with root package name */
    public static Method f1754c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f1755d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f1756e = true;

    public static long A(long j5, long j9) {
        a.a.f("a", j5);
        a.a.f("b", j9);
        if (j5 == 0) {
            return j9;
        }
        if (j9 == 0) {
            return j5;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j5);
        long j10 = j5 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j9);
        long j11 = j9 >> numberOfTrailingZeros2;
        while (j10 != j11) {
            long j12 = j10 - j11;
            long j13 = (j12 >> 63) & j12;
            long j14 = (j12 - j13) - j13;
            j11 += j13;
            j10 = j14 >> Long.numberOfTrailingZeros(j14);
        }
        return j10 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static ColorStateList B(Context context, TypedArray typedArray, int i9) {
        int resourceId;
        ColorStateList u3;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0 || (u3 = a.a.u(context, resourceId)) == null) ? typedArray.getColorStateList(i9) : u3;
    }

    public static ColorStateList C(Context context, androidx.fragment.app.g gVar, int i9) {
        int resourceId;
        ColorStateList u3;
        TypedArray typedArray = (TypedArray) gVar.f729k;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0 || (u3 = a.a.u(context, resourceId)) == null) ? gVar.O(i9) : u3;
    }

    public static float D(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return r0.e.b(edgeEffect);
        }
        return 0.0f;
    }

    public static Drawable E(Context context, TypedArray typedArray, int i9) {
        int resourceId;
        Drawable I;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0 || (I = android.support.v4.media.session.b.I(context, resourceId)) == null) ? typedArray.getDrawable(i9) : I;
    }

    public static int F(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return g0.c.a(drawable);
        }
        if (!f1755d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", null);
                f1754c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e9) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e9);
            }
            f1755d = true;
        }
        Method method = f1754c;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(drawable, null)).intValue();
        } catch (Exception e10) {
            Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e10);
            f1754c = null;
            return 0;
        }
    }

    public static int G(List list, InputStream inputStream, e4.f fVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new x(inputStream, fVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            try {
                int c9 = ((b4.e) list.get(i9)).c(inputStream, fVar);
                if (c9 != -1) {
                    return c9;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType I(List list, InputStream inputStream, e4.f fVar) {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new x(inputStream, fVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            try {
                ImageHeaderParser$ImageType d9 = ((b4.e) list.get(i9)).d(inputStream);
                inputStream.reset();
                if (d9 != ImageHeaderParser$ImageType.UNKNOWN) {
                    return d9;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType J(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            try {
                ImageHeaderParser$ImageType a9 = ((b4.e) list.get(i9)).a(byteBuffer);
                AtomicReference atomicReference = w4.b.f9930a;
                if (a9 != ImageHeaderParser$ImageType.UNKNOWN) {
                    return a9;
                }
            } catch (Throwable th) {
                AtomicReference atomicReference2 = w4.b.f9930a;
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static int K(int i9) {
        if (i9 == 1) {
            return 0;
        }
        if (i9 == 2) {
            return 1;
        }
        if (i9 == 4) {
            return 2;
        }
        if (i9 == 8) {
            return 3;
        }
        if (i9 == 16) {
            return 4;
        }
        if (i9 == 32) {
            return 5;
        }
        if (i9 == 64) {
            return 6;
        }
        if (i9 == 128) {
            return 7;
        }
        if (i9 == 256) {
            return 8;
        }
        m7.c.n(androidx.activity.g.m(i9, "type needs to be >= FIRST and <= LAST, type="));
        return 0;
    }

    public static boolean L(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static String M(String str, Object... objArr) {
        int indexOf;
        String sb;
        int i9 = 0;
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                sb = "null";
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e9) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for ".concat(str2), (Throwable) e9);
                    StringBuilder r8 = androidx.activity.g.r("<", str2, " threw ");
                    r8.append(e9.getClass().getName());
                    r8.append(">");
                    sb = r8.toString();
                }
            }
            objArr[i10] = sb;
        }
        StringBuilder sb2 = new StringBuilder((objArr.length * 16) + str.length());
        int i11 = 0;
        while (i9 < objArr.length && (indexOf = str.indexOf("%s", i11)) != -1) {
            sb2.append((CharSequence) str, i11, indexOf);
            sb2.append(objArr[i9]);
            i11 = indexOf + 2;
            i9++;
        }
        sb2.append((CharSequence) str, i11, str.length());
        if (i9 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i9]);
            for (int i12 = i9 + 1; i12 < objArr.length; i12++) {
                sb2.append(", ");
                sb2.append(objArr[i12]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    public static int N(Object obj, d1 d1Var, byte[] bArr, int i9, int i10, com.google.crypto.tink.shaded.protobuf.d dVar) {
        int i11 = i9 + 1;
        int i12 = bArr[i9];
        if (i12 < 0) {
            i11 = u(i12, bArr, i11, dVar);
            i12 = dVar.f2213a;
        }
        int i13 = i11;
        if (i12 < 0 || i12 > i10 - i13) {
            throw e0.g();
        }
        int i14 = i13 + i12;
        d1Var.c(obj, bArr, i13, i14, dVar);
        dVar.f2215c = obj;
        return i14;
    }

    public static void O(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static float P(EdgeEffect edgeEffect, float f9, float f10) {
        if (Build.VERSION.SDK_INT >= 31) {
            return r0.e.c(edgeEffect, f9, f10);
        }
        r0.d.a(edgeEffect, f9, f10);
        return f9;
    }

    public static w0.b T(MappedByteBuffer mappedByteBuffer) {
        long j5;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        duplicate.position(duplicate.position() + 4);
        int i9 = duplicate.getShort() & 65535;
        if (i9 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        duplicate.position(duplicate.position() + 6);
        int i10 = 0;
        while (true) {
            if (i10 >= i9) {
                j5 = -1;
                break;
            }
            int i11 = duplicate.getInt();
            duplicate.position(duplicate.position() + 4);
            j5 = duplicate.getInt() & 4294967295L;
            duplicate.position(duplicate.position() + 4);
            if (1835365473 == i11) {
                break;
            }
            i10++;
        }
        if (j5 != -1) {
            duplicate.position(duplicate.position() + ((int) (j5 - duplicate.position())));
            duplicate.position(duplicate.position() + 12);
            long j9 = duplicate.getInt() & 4294967295L;
            for (int i12 = 0; i12 < j9; i12++) {
                int i13 = duplicate.getInt();
                long j10 = duplicate.getInt() & 4294967295L;
                duplicate.getInt();
                if (1164798569 == i13 || 1701669481 == i13) {
                    duplicate.position((int) (j10 + j5));
                    w0.b bVar = new w0.b();
                    duplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int position = duplicate.position() + duplicate.getInt(duplicate.position());
                    bVar.f7134d = duplicate;
                    bVar.f7131a = position;
                    int i14 = position - duplicate.getInt(position);
                    bVar.f7132b = i14;
                    bVar.f7133c = ((ByteBuffer) bVar.f7134d).getShort(i14);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static final String U(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int read = reader.read(cArr);
        while (read >= 0) {
            stringWriter.write(cArr, 0, read);
            read = reader.read(cArr);
        }
        String stringWriter2 = stringWriter.toString();
        stringWriter2.getClass();
        return stringWriter2;
    }

    public static void V(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
        Drawable mutate = f0(drawable).mutate();
        g0.b.h(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    public static void W(f1.a aVar) {
        aVar.f3227k = -3.4028235E38f;
        aVar.f3226j = Integer.MIN_VALUE;
        CharSequence charSequence = aVar.f3218a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                aVar.f3218a = SpannableString.valueOf(charSequence);
            }
            CharSequence charSequence2 = aVar.f3218a;
            charSequence2.getClass();
            Spannable spannable = (Spannable) charSequence2;
            for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                if ((obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan)) {
                    spannable.removeSpan(obj);
                }
            }
        }
    }

    public static float X(float f9, int i9, int i10, int i11) {
        float f10;
        if (f9 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i9 == 0) {
            f10 = i11;
        } else {
            if (i9 != 1) {
                if (i9 != 2) {
                    return -3.4028235E38f;
                }
                return f9;
            }
            f10 = i10;
        }
        return f9 * f10;
    }

    public static long Y(long j5, long j9) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j9) + Long.numberOfLeadingZeros(j9) + Long.numberOfLeadingZeros(~j5) + Long.numberOfLeadingZeros(j5);
        if (numberOfLeadingZeros > 65) {
            return j5 * j9;
        }
        long j10 = ((j5 ^ j9) >>> 63) + Long.MAX_VALUE;
        if (!((numberOfLeadingZeros < 64) | ((j9 == Long.MIN_VALUE) & (j5 < 0)))) {
            long j11 = j5 * j9;
            if (j5 == 0 || j11 / j5 == j9) {
                return j11;
            }
        }
        return j10;
    }

    public static void Z(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = t0.f7209a;
        boolean a9 = b0.a(checkableImageButton);
        boolean z8 = onLongClickListener != null;
        boolean z9 = a9 || z8;
        checkableImageButton.setFocusable(z9);
        checkableImageButton.setClickable(a9);
        checkableImageButton.setPressable(a9);
        checkableImageButton.setLongClickable(z8);
        c0.s(checkableImageButton, z9 ? 1 : 2);
    }

    public static k8.d a(int i9) {
        if (i9 != -2) {
            return i9 != -1 ? i9 != 0 ? i9 != Integer.MAX_VALUE ? new k8.d(i9) : new k8.d(Integer.MAX_VALUE) : new k8.d(0) : new n(1, 2);
        }
        k8.h.f5668a.getClass();
        return new k8.d(k8.g.f5667b);
    }

    public static boolean a0(Drawable drawable, int i9) {
        if (Build.VERSION.SDK_INT >= 23) {
            return g0.c.b(drawable, i9);
        }
        if (!f1753b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f1752a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e9) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e9);
            }
            f1753b = true;
        }
        Method method = f1752a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i9));
                return true;
            } catch (Exception e10) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e10);
                f1752a = null;
            }
        }
        return false;
    }

    public static void b(SpannableStringBuilder spannableStringBuilder, Object obj, int i9, int i10) {
        for (Object obj2 : spannableStringBuilder.getSpans(i9, i10, obj.getClass())) {
            if (spannableStringBuilder.getSpanStart(obj2) == i9 && spannableStringBuilder.getSpanEnd(obj2) == i10 && spannableStringBuilder.getSpanFlags(obj2) == 33) {
                spannableStringBuilder.removeSpan(obj2);
            }
        }
        spannableStringBuilder.setSpan(obj, i9, i10, 33);
    }

    public static void b0(View view, u5.g gVar) {
        m5.a aVar = gVar.f9084i.f9070b;
        if (aVar == null || !aVar.f6648a) {
            return;
        }
        float f9 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = t0.f7209a;
            f9 += i0.i((View) parent);
        }
        u5.f fVar = gVar.f9084i;
        if (fVar.f9079l != f9) {
            fVar.f9079l = f9;
            gVar.q();
        }
    }

    public static void c(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = f0(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                g0.b.h(drawable, colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
                g0.b.h(drawable, ColorStateList.valueOf(colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                g0.b.i(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c0(p pVar, i8.a aVar, i8.a aVar2) {
        try {
            n8.a.g(n7.g.f7490c, c.C(((t7.a) pVar).j(aVar, aVar2)));
        } catch (Throwable th) {
            aVar2.g(new n7.c(th));
            throw th;
        }
    }

    public static void d0(ViewGroup viewGroup, boolean z8) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z8);
        } else if (f1756e) {
            try {
                viewGroup.suppressLayout(z8);
            } catch (NoSuchMethodError unused) {
                f1756e = false;
            }
        }
    }

    public static e8.c e0(int i9, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new e8.c(i9, i10 - 1, 1);
        }
        e8.c cVar = e8.c.f3165l;
        return e8.c.f3165l;
    }

    public static Drawable f0(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 || (drawable instanceof g0.e)) {
            return drawable;
        }
        g0.f fVar = new g0.f();
        fVar.f3647l = fVar.c();
        fVar.h(drawable);
        g0.f.a();
        return fVar;
    }

    public static void g(int i9, int i10, int i11) {
        if (i9 < 0 || i10 > i11) {
            StringBuilder q4 = androidx.activity.g.q("fromIndex: ", i9, ", toIndex: ", i10, ", size: ");
            q4.append(i11);
            throw new IndexOutOfBoundsException(q4.toString());
        }
        if (i9 <= i10) {
            return;
        }
        throw new IllegalArgumentException("fromIndex: " + i9 + " > toIndex: " + i10);
    }

    public static void h(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            h(g0.a.c((InsetDrawable) drawable));
            return;
        }
        if (drawable instanceof g0.f) {
            h(((g0.f) drawable).f3649n);
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            Drawable b9 = g0.a.b(drawableContainerState, i9);
            if (b9 != null) {
                h(b9);
            }
        }
    }

    public static void i(i1.h hVar) {
        if (hVar != null) {
            try {
                hVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int j(int i9, int i10, int i11) {
        if (i10 <= i11) {
            return i9 < i10 ? i10 : i9 > i11 ? i11 : i9;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i11 + " is less than minimum " + i10 + '.');
    }

    public static ImageView.ScaleType k(int i9) {
        return i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 5 ? i9 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static c l(int i9) {
        return i9 != 0 ? i9 != 1 ? new u5.i() : new u5.d() : new u5.i();
    }

    public static int n(byte[] bArr, int i9, com.google.crypto.tink.shaded.protobuf.d dVar) {
        int v8 = v(bArr, i9, dVar);
        int i10 = dVar.f2213a;
        if (i10 < 0) {
            throw e0.e();
        }
        if (i10 > bArr.length - v8) {
            throw e0.g();
        }
        if (i10 == 0) {
            dVar.f2215c = com.google.crypto.tink.shaded.protobuf.j.f2248j;
            return v8;
        }
        dVar.f2215c = com.google.crypto.tink.shaded.protobuf.j.h(v8, i10, bArr);
        return v8 + i10;
    }

    public static int o(byte[] bArr, int i9) {
        return ((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16);
    }

    public static long p(byte[] bArr, int i9) {
        return ((bArr[i9 + 7] & 255) << 56) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16) | ((bArr[i9 + 3] & 255) << 24) | ((bArr[i9 + 4] & 255) << 32) | ((bArr[i9 + 5] & 255) << 40) | ((bArr[i9 + 6] & 255) << 48);
    }

    public static int q(d1 d1Var, int i9, byte[] bArr, int i10, int i11, com.google.crypto.tink.shaded.protobuf.b0 b0Var, com.google.crypto.tink.shaded.protobuf.d dVar) {
        Object i12 = d1Var.i();
        d1 d1Var2 = d1Var;
        byte[] bArr2 = bArr;
        int i13 = i11;
        com.google.crypto.tink.shaded.protobuf.d dVar2 = dVar;
        int N = N(i12, d1Var2, bArr2, i10, i13, dVar2);
        d1Var2.e(i12);
        dVar2.f2215c = i12;
        b0Var.add(i12);
        while (N < i13) {
            com.google.crypto.tink.shaded.protobuf.d dVar3 = dVar2;
            int i14 = i13;
            int v8 = v(bArr2, N, dVar3);
            if (i9 != dVar3.f2213a) {
                break;
            }
            byte[] bArr3 = bArr2;
            d1 d1Var3 = d1Var2;
            Object i15 = d1Var3.i();
            N = N(i15, d1Var3, bArr3, v8, i14, dVar3);
            d1Var2 = d1Var3;
            bArr2 = bArr3;
            i13 = i14;
            dVar2 = dVar3;
            d1Var2.e(i15);
            dVar2.f2215c = i15;
            b0Var.add(i15);
        }
        return N;
    }

    public static int r(byte[] bArr, int i9, com.google.crypto.tink.shaded.protobuf.d dVar) {
        int v8 = v(bArr, i9, dVar);
        int i10 = dVar.f2213a;
        if (i10 < 0) {
            throw e0.e();
        }
        if (i10 == 0) {
            dVar.f2215c = "";
            return v8;
        }
        dVar.f2215c = new String(bArr, v8, i10, com.google.crypto.tink.shaded.protobuf.c0.f2207a);
        return v8 + i10;
    }

    public static int s(byte[] bArr, int i9, com.google.crypto.tink.shaded.protobuf.d dVar) {
        int v8 = v(bArr, i9, dVar);
        int i10 = dVar.f2213a;
        if (i10 < 0) {
            throw e0.e();
        }
        if (i10 == 0) {
            dVar.f2215c = "";
            return v8;
        }
        dVar.f2215c = s1.f2298a.q(v8, i10, bArr);
        return v8 + i10;
    }

    public static int t(int i9, byte[] bArr, int i10, int i11, g1 g1Var, com.google.crypto.tink.shaded.protobuf.d dVar) {
        if ((i9 >>> 3) == 0) {
            throw e0.a();
        }
        int i12 = i9 & 7;
        if (i12 == 0) {
            int x6 = x(bArr, i10, dVar);
            g1Var.d(i9, Long.valueOf(dVar.f2214b));
            return x6;
        }
        if (i12 == 1) {
            g1Var.d(i9, Long.valueOf(p(bArr, i10)));
            return i10 + 8;
        }
        if (i12 == 2) {
            int v8 = v(bArr, i10, dVar);
            int i13 = dVar.f2213a;
            if (i13 < 0) {
                throw e0.e();
            }
            if (i13 > bArr.length - v8) {
                throw e0.g();
            }
            if (i13 == 0) {
                g1Var.d(i9, com.google.crypto.tink.shaded.protobuf.j.f2248j);
            } else {
                g1Var.d(i9, com.google.crypto.tink.shaded.protobuf.j.h(v8, i13, bArr));
            }
            return v8 + i13;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw e0.a();
            }
            g1Var.d(i9, Integer.valueOf(o(bArr, i10)));
            return i10 + 4;
        }
        g1 c9 = g1.c();
        int i14 = (i9 & (-8)) | 4;
        int i15 = 0;
        while (true) {
            if (i10 >= i11) {
                break;
            }
            int v9 = v(bArr, i10, dVar);
            i15 = dVar.f2213a;
            if (i15 == i14) {
                i10 = v9;
                break;
            }
            i10 = t(i15, bArr, v9, i11, c9, dVar);
        }
        if (i10 > i11 || i15 != i14) {
            throw e0.f();
        }
        g1Var.d(i9, c9);
        return i10;
    }

    public static int u(int i9, byte[] bArr, int i10, com.google.crypto.tink.shaded.protobuf.d dVar) {
        int i11 = i9 & 127;
        int i12 = i10 + 1;
        byte b9 = bArr[i10];
        if (b9 >= 0) {
            dVar.f2213a = i11 | (b9 << 7);
            return i12;
        }
        int i13 = i11 | ((b9 & Byte.MAX_VALUE) << 7);
        int i14 = i10 + 2;
        byte b10 = bArr[i12];
        if (b10 >= 0) {
            dVar.f2213a = i13 | (b10 << 14);
            return i14;
        }
        int i15 = i13 | ((b10 & Byte.MAX_VALUE) << 14);
        int i16 = i10 + 3;
        byte b11 = bArr[i14];
        if (b11 >= 0) {
            dVar.f2213a = i15 | (b11 << 21);
            return i16;
        }
        int i17 = i15 | ((b11 & Byte.MAX_VALUE) << 21);
        int i18 = i10 + 4;
        byte b12 = bArr[i16];
        if (b12 >= 0) {
            dVar.f2213a = i17 | (b12 << 28);
            return i18;
        }
        int i19 = i17 | ((b12 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i20 = i18 + 1;
            if (bArr[i18] >= 0) {
                dVar.f2213a = i19;
                return i20;
            }
            i18 = i20;
        }
    }

    public static int v(byte[] bArr, int i9, com.google.crypto.tink.shaded.protobuf.d dVar) {
        int i10 = i9 + 1;
        byte b9 = bArr[i9];
        if (b9 < 0) {
            return u(b9, bArr, i10, dVar);
        }
        dVar.f2213a = b9;
        return i10;
    }

    public static int w(int i9, byte[] bArr, int i10, int i11, com.google.crypto.tink.shaded.protobuf.b0 b0Var, com.google.crypto.tink.shaded.protobuf.d dVar) {
        z zVar = (z) b0Var;
        int v8 = v(bArr, i10, dVar);
        zVar.g(dVar.f2213a);
        while (v8 < i11) {
            int v9 = v(bArr, v8, dVar);
            if (i9 != dVar.f2213a) {
                break;
            }
            v8 = v(bArr, v9, dVar);
            zVar.g(dVar.f2213a);
        }
        return v8;
    }

    public static int x(byte[] bArr, int i9, com.google.crypto.tink.shaded.protobuf.d dVar) {
        int i10 = i9 + 1;
        long j5 = bArr[i9];
        if (j5 >= 0) {
            dVar.f2214b = j5;
            return i10;
        }
        int i11 = i9 + 2;
        byte b9 = bArr[i10];
        long j9 = (j5 & 127) | ((b9 & Byte.MAX_VALUE) << 7);
        int i12 = 7;
        while (b9 < 0) {
            int i13 = i11 + 1;
            i12 += 7;
            j9 |= (r10 & Byte.MAX_VALUE) << i12;
            b9 = bArr[i11];
            i11 = i13;
        }
        dVar.f2214b = j9;
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r8 > 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        if (r8 < 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long y(long r8, long r10, java.math.RoundingMode r12) {
        /*
            r12.getClass()
            long r0 = r8 / r10
            long r2 = r10 * r0
            long r2 = r8 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            goto L53
        L10:
            long r8 = r8 ^ r10
            r7 = 63
            long r8 = r8 >> r7
            int r9 = (int) r8
            r8 = r9 | 1
            int[] r9 = c6.d.f1640a
            int r7 = r12.ordinal()
            r9 = r9[r7]
            switch(r9) {
                case 1: goto L51;
                case 2: goto L53;
                case 3: goto L4c;
                case 4: goto L4e;
                case 5: goto L49;
                case 6: goto L28;
                case 7: goto L28;
                case 8: goto L28;
                default: goto L22;
            }
        L22:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L28:
            long r2 = java.lang.Math.abs(r2)
            long r9 = java.lang.Math.abs(r10)
            long r9 = r9 - r2
            long r2 = r2 - r9
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 != 0) goto L46
            java.math.RoundingMode r9 = java.math.RoundingMode.HALF_UP
            if (r12 == r9) goto L4e
            java.math.RoundingMode r9 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r9) goto L53
            r9 = 1
            long r9 = r9 & r0
            int r11 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r11 == 0) goto L53
            goto L4e
        L46:
            if (r9 <= 0) goto L53
            goto L4e
        L49:
            if (r8 <= 0) goto L53
            goto L4e
        L4c:
            if (r8 >= 0) goto L53
        L4e:
            long r8 = (long) r8
            long r0 = r0 + r8
            return r0
        L51:
            if (r6 != 0) goto L54
        L53:
            return r0
        L54:
            java.lang.ArithmeticException r8 = new java.lang.ArithmeticException
            java.lang.String r9 = "mode was UNNECESSARY, but rounding was necessary"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.d.y(long, long, java.math.RoundingMode):long");
    }

    public static View z(View view, int i9) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View findViewById = viewGroup.getChildAt(i10).findViewById(i9);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }

    public d.a H(g.l lVar, Object obj) {
        return null;
    }

    public abstract Object Q(int i9, Intent intent);

    public abstract void R(t.g gVar, t.g gVar2);

    public abstract void S(t.g gVar, Thread thread);

    public abstract boolean d(t.h hVar, t.d dVar, t.d dVar2);

    public abstract boolean e(t.h hVar, Object obj, Object obj2);

    public abstract boolean f(t.h hVar, t.g gVar, t.g gVar2);

    public abstract Intent m(g.l lVar, Object obj);
}
