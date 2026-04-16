package c2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import b2.t;
import g1.w;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends GLSurfaceView {

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f1597t = 0;

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f1598i;

    /* renamed from: j, reason: collision with root package name */
    public final SensorManager f1599j;

    /* renamed from: k, reason: collision with root package name */
    public final Sensor f1600k;

    /* renamed from: l, reason: collision with root package name */
    public final d f1601l;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f1602m;

    /* renamed from: n, reason: collision with root package name */
    public final j f1603n;

    /* renamed from: o, reason: collision with root package name */
    public SurfaceTexture f1604o;

    /* renamed from: p, reason: collision with root package name */
    public Surface f1605p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1606q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1607r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1608s;

    public l(Context context) {
        super(context, null);
        this.f1598i = new CopyOnWriteArrayList();
        this.f1602m = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f1599j = sensorManager;
        Sensor defaultSensor = w.f3713a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f1600k = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        j jVar = new j();
        this.f1603n = jVar;
        k kVar = new k(this, jVar);
        View.OnTouchListener mVar = new m(context, kVar);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.f1601l = new d(windowManager.getDefaultDisplay(), mVar, kVar);
        this.f1606q = true;
        setEGLContextClientVersion(2);
        setRenderer(kVar);
        setOnTouchListener(mVar);
    }

    public final void a() {
        boolean z8 = this.f1606q && this.f1607r;
        Sensor sensor = this.f1600k;
        if (sensor == null || z8 == this.f1608s) {
            return;
        }
        d dVar = this.f1601l;
        SensorManager sensorManager = this.f1599j;
        if (z8) {
            sensorManager.registerListener(dVar, sensor, 0);
        } else {
            sensorManager.unregisterListener(dVar);
        }
        this.f1608s = z8;
    }

    public a getCameraMotionListener() {
        return this.f1603n;
    }

    public t getVideoFrameMetadataListener() {
        return this.f1603n;
    }

    public Surface getVideoSurface() {
        return this.f1605p;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1602m.post(new a7.a(this, 7));
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        this.f1607r = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.f1607r = true;
        a();
    }

    public void setDefaultStereoMode(int i9) {
        this.f1603n.f1583s = i9;
    }

    public void setUseSensorRotation(boolean z8) {
        this.f1606q = z8;
        a();
    }
}
