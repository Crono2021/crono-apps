package g;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z extends androidx.fragment.app.i {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f3639k = 0;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c0 f3640l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f3641m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(c0 c0Var, Context context) {
        super(c0Var);
        this.f3640l = c0Var;
        this.f3641m = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // androidx.fragment.app.i
    public final IntentFilter e() {
        switch (this.f3639k) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // androidx.fragment.app.i
    public final int h() {
        Location location;
        boolean z8;
        long j5;
        Location location2;
        switch (this.f3639k) {
            case 0:
                return ((PowerManager) this.f3641m).isPowerSaveMode() ? 2 : 1;
            default:
                androidx.fragment.app.g gVar = (androidx.fragment.app.g) this.f3641m;
                m0 m0Var = (m0) gVar.f730l;
                LocationManager locationManager = (LocationManager) gVar.f729k;
                if (m0Var.f3584b > System.currentTimeMillis()) {
                    z8 = m0Var.f3583a;
                } else {
                    Context context = (Context) gVar.f728j;
                    Location location3 = null;
                    if (android.support.v4.media.session.b.s(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        try {
                        } catch (Exception e9) {
                            Log.d("TwilightManager", "Failed to get last known location", e9);
                        }
                        if (locationManager.isProviderEnabled("network")) {
                            location2 = locationManager.getLastKnownLocation("network");
                            location = location2;
                        }
                        location2 = null;
                        location = location2;
                    } else {
                        location = null;
                    }
                    if (android.support.v4.media.session.b.s(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                location3 = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e10) {
                            Log.d("TwilightManager", "Failed to get last known location", e10);
                        }
                    }
                    if (location3 == null || location == null ? location3 != null : location3.getTime() > location.getTime()) {
                        location = location3;
                    }
                    if (location != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (l0.f3579d == null) {
                            l0.f3579d = new l0();
                        }
                        l0 l0Var = l0.f3579d;
                        l0Var.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        l0Var.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
                        z8 = l0Var.f3582c == 1;
                        long j9 = l0Var.f3581b;
                        long j10 = l0Var.f3580a;
                        l0Var.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
                        long j11 = l0Var.f3581b;
                        if (j9 == -1 || j10 == -1) {
                            j5 = currentTimeMillis + 43200000;
                        } else {
                            if (currentTimeMillis > j10) {
                                j9 = j11;
                            } else if (currentTimeMillis > j9) {
                                j9 = j10;
                            }
                            j5 = j9 + 60000;
                        }
                        m0Var.f3583a = z8;
                        m0Var.f3584b = j5;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i9 = Calendar.getInstance().get(11);
                        if (i9 < 6 || i9 >= 22) {
                            z8 = true;
                        }
                    }
                }
                return z8 ? 2 : 1;
        }
    }

    @Override // androidx.fragment.app.i
    public final void m() {
        switch (this.f3639k) {
            case 0:
                this.f3640l.n(true, true);
                break;
            default:
                this.f3640l.n(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(c0 c0Var, androidx.fragment.app.g gVar) {
        super(c0Var);
        this.f3640l = c0Var;
        this.f3641m = gVar;
    }
}
