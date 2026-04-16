package c2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f1546a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f1547b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f1548c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f1549d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    public final Display f1550e;

    /* renamed from: f, reason: collision with root package name */
    public final c[] f1551f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1552g;

    public d(Display display, c... cVarArr) {
        this.f1550e = display;
        this.f1551f = cVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i9;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f1546a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f1550e.getRotation();
        float[] fArr3 = this.f1547b;
        if (rotation != 0) {
            int i10 = 129;
            if (rotation != 1) {
                i9 = 130;
                if (rotation != 2) {
                    if (rotation != 3) {
                        androidx.fragment.app.a.l();
                        return;
                    } else {
                        i10 = 130;
                        i9 = 1;
                    }
                }
            } else {
                i10 = 2;
                i9 = 129;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i10, i9, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, 131, fArr3);
        float[] fArr4 = this.f1549d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f9 = fArr4[2];
        Matrix.rotateM(fArr2, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        boolean z8 = this.f1552g;
        float[] fArr5 = this.f1548c;
        if (!z8) {
            b2.b.e(fArr5, fArr2);
            this.f1552g = true;
        }
        System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr2, 0, fArr3, 0, fArr5, 0);
        for (int i11 = 0; i11 < 2; i11++) {
            this.f1551f[i11].a(fArr2, f9);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i9) {
    }
}
