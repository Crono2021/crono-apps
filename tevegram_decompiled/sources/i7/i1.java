package i7;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Toast;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.PlayerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i1 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4893i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4894j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4895k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4896l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f4897m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f4898n;

    public /* synthetic */ i1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i9) {
        this.f4893i = i9;
        this.f4894j = obj;
        this.f4895k = obj2;
        this.f4896l = obj3;
        this.f4897m = obj4;
        this.f4898n = obj5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        int i10 = this.f4893i;
        Object obj = this.f4898n;
        Object obj2 = this.f4897m;
        Object obj3 = this.f4896l;
        Object obj4 = this.f4895k;
        Object obj5 = this.f4894j;
        switch (i10) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj5;
                i8.w.j(androidx.lifecycle.g0.a(mainActivity), null, new j1(i9, (n.q) obj4, mainActivity, (e7.a) obj3, (String) obj2, (Uri) obj, null), 3);
                break;
            default:
                k7.a aVar = (k7.a) obj5;
                SharedPreferences sharedPreferences = aVar.f5628b;
                c7.f fVar = (c7.f) obj4;
                RadioButton radioButton = (RadioButton) obj3;
                PlayerActivity playerActivity = (PlayerActivity) obj2;
                SharedPreferences sharedPreferences2 = (SharedPreferences) obj;
                int i11 = PlayerActivity.X;
                Integer Z = h8.l.Z(fVar.f1717c.getText().toString());
                sharedPreferences.edit().putInt("min_buffer_ms", Z != null ? Z.intValue() : sharedPreferences.getInt("min_buffer_ms", 15000)).apply();
                Integer Z2 = h8.l.Z(fVar.f1716b.getText().toString());
                sharedPreferences.edit().putInt("max_buffer_ms", Z2 != null ? Z2.intValue() : sharedPreferences.getInt("max_buffer_ms", 50000)).apply();
                Integer Z3 = h8.l.Z(fVar.f1718d.getText().toString());
                sharedPreferences.edit().putInt("playback_buffer_ms", Z3 != null ? Z3.intValue() : sharedPreferences.getInt("playback_buffer_ms", 2500)).apply();
                sharedPreferences.edit().putBoolean("streaming_mode", fVar.f1721g.isChecked()).apply();
                sharedPreferences.edit().putBoolean("use_hw_accel", fVar.f1720f.isChecked()).apply();
                sharedPreferences.edit().putBoolean("use_software_audio", fVar.f1722i.isChecked()).apply();
                sharedPreferences.edit().putBoolean("auto_frame_rate_enabled", fVar.f1719e.isChecked()).apply();
                sharedPreferences.edit().putInt("afr_strategy", radioButton.isChecked() ? 1 : 0).apply();
                sharedPreferences.edit().putBoolean("visualizer_enabled", fVar.f1723j.isChecked()).apply();
                aVar.j(h8.e.o0(fVar.f1715a.getText().toString()));
                playerActivity.C();
                l7.g gVar = playerActivity.S;
                if (gVar != null) {
                    try {
                        l7.c valueOf = l7.c.valueOf(aVar.e());
                        valueOf.getClass();
                        gVar.f6332u = valueOf;
                        gVar.f();
                    } catch (Exception unused) {
                    }
                }
                Log.i("SettingsSave", "💾 AFR Saved: " + aVar.b() + ", Strategy: " + aVar.a() + " (from PlayerActivity)");
                sharedPreferences2.edit().putBoolean("enable_subtitles", fVar.h.isChecked()).apply();
                Toast.makeText(playerActivity, "Ajustes guardados.", 1).show();
                break;
        }
    }
}
