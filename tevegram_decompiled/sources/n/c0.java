package n;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class c0 {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f6815d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6816a = 2;

    /* renamed from: b, reason: collision with root package name */
    public View f6817b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6818c;

    public c0(EditText editText) {
        this.f6817b = editText;
        this.f6818c = new i7.x(editText);
    }

    public KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((m1.b) ((i7.x) this.f6818c).f5179j).getClass();
        if (keyListener instanceof x0.e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new x0.e(keyListener);
    }

    public void b(AttributeSet attributeSet, int i9) {
        switch (this.f6816a) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f6817b;
                androidx.fragment.app.g g02 = androidx.fragment.app.g.g0(absSeekBar.getContext(), attributeSet, f6815d, i9);
                Drawable R = g02.R(0);
                if (R != null) {
                    if (R instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) R;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i10 = 0; i10 < numberOfFrames; i10++) {
                            Drawable e9 = e(animationDrawable.getFrame(i10), true);
                            e9.setLevel(10000);
                            animationDrawable2.addFrame(e9, animationDrawable.getDuration(i10));
                        }
                        animationDrawable2.setLevel(10000);
                        R = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(R);
                }
                Drawable R2 = g02.R(1);
                if (R2 != null) {
                    absSeekBar.setProgressDrawable(e(R2, false));
                }
                g02.i0();
                return;
            default:
                TypedArray obtainStyledAttributes = ((EditText) this.f6817b).getContext().obtainStyledAttributes(attributeSet, f.a.f3173i, i9, 0);
                try {
                    boolean z8 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
                    obtainStyledAttributes.recycle();
                    d(z8);
                    return;
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public x0.b c(InputConnection inputConnection, EditorInfo editorInfo) {
        i7.x xVar = (i7.x) this.f6818c;
        if (inputConnection == null) {
            xVar.getClass();
            inputConnection = null;
        } else {
            m1.b bVar = (m1.b) xVar.f5179j;
            bVar.getClass();
            if (!(inputConnection instanceof x0.b)) {
                inputConnection = new x0.b((EditText) bVar.f6510j, inputConnection, editorInfo);
            }
        }
        return (x0.b) inputConnection;
    }

    public void d(boolean z8) {
        x0.h hVar = (x0.h) ((m1.b) ((i7.x) this.f6818c).f5179j).f6511k;
        if (hVar.f10037k != z8) {
            if (hVar.f10036j != null) {
                androidx.emoji2.text.l a9 = androidx.emoji2.text.l.a();
                l3 l3Var = hVar.f10036j;
                a9.getClass();
                android.support.v4.media.session.b.r(l3Var, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a9.f625a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a9.f626b.remove(l3Var);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            hVar.f10037k = z8;
            if (z8) {
                x0.h.a(hVar.f10035i, androidx.emoji2.text.l.a().b());
            }
        }
    }

    public Drawable e(Drawable drawable, boolean z8) {
        if (drawable instanceof g0.f) {
            g0.f fVar = (g0.f) drawable;
            Drawable drawable2 = fVar.f3649n;
            if (drawable2 != null) {
                fVar.h(e(drawable2, z8));
                return drawable;
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i9 = 0; i9 < numberOfLayers; i9++) {
                    int id = layerDrawable.getId(i9);
                    drawableArr[i9] = e(layerDrawable.getDrawable(i9), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    layerDrawable2.setId(i10, layerDrawable.getId(i10));
                    if (Build.VERSION.SDK_INT >= 23) {
                        b0.a(layerDrawable, layerDrawable2, i10);
                    }
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f6818c) == null) {
                    this.f6818c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z8 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public c0(AbsSeekBar absSeekBar) {
        this.f6817b = absSeekBar;
    }

    public /* synthetic */ c0() {
    }
}
