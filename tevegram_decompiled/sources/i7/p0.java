package i7;

import android.widget.EditText;
import android.widget.RadioButton;
import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class p0 implements a8.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ RadioButton f5016i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ RadioButton f5017j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ EditText f5018k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ EditText f5019l;

    public /* synthetic */ p0(RadioButton radioButton, RadioButton radioButton2, EditText editText, EditText editText2) {
        this.f5016i = radioButton;
        this.f5017j = radioButton2;
        this.f5018k = editText;
        this.f5019l = editText2;
    }

    @Override // a8.a
    public final Object d() {
        int i9 = MainActivity.X;
        boolean z8 = this.f5016i.isChecked() || this.f5017j.isChecked();
        boolean z9 = !z8;
        EditText editText = this.f5018k;
        editText.setEnabled(z9);
        EditText editText2 = this.f5019l;
        editText2.setEnabled(z9);
        editText.setAlpha(z8 ? 0.5f : 1.0f);
        editText2.setAlpha(z8 ? 0.5f : 1.0f);
        return n7.g.f7490c;
    }
}
