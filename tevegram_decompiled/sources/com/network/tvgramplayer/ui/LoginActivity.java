package com.network.tvgramplayer.ui;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.lifecycle.g0;
import b8.i;
import c7.c;
import com.bumptech.glide.d;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.ui.LoginActivity;
import g.l;
import h7.k0;
import i7.b;
import i7.j0;
import i8.w;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class LoginActivity extends l {
    public static final /* synthetic */ int F = 0;
    public c E;

    @Override // g.l, androidx.activity.n, c0.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r7.c cVar = null;
        View inflate = getLayoutInflater().inflate(2131558431, (ViewGroup) null, false);
        int i9 = 2131361930;
        Button button = (Button) d.z(inflate, 2131361930);
        if (button != null) {
            i9 = 2131361969;
            TextInputLayout textInputLayout = (TextInputLayout) d.z(inflate, 2131361969);
            if (textInputLayout != null) {
                i9 = 2131362019;
                TextInputEditText textInputEditText = (TextInputEditText) d.z(inflate, 2131362019);
                if (textInputEditText != null) {
                    i9 = 2131362024;
                    TextInputEditText textInputEditText2 = (TextInputEditText) d.z(inflate, 2131362024);
                    if (textInputEditText2 != null) {
                        i9 = 2131362025;
                        TextInputEditText textInputEditText3 = (TextInputEditText) d.z(inflate, 2131362025);
                        if (textInputEditText3 != null) {
                            i9 = 2131362133;
                            ImageView imageView = (ImageView) d.z(inflate, 2131362133);
                            if (imageView != null) {
                                i9 = 2131362155;
                                LinearLayout linearLayout = (LinearLayout) d.z(inflate, 2131362155);
                                if (linearLayout != null) {
                                    i9 = 2131362158;
                                    LinearLayout linearLayout2 = (LinearLayout) d.z(inflate, 2131362158);
                                    if (linearLayout2 != null) {
                                        i9 = 2131362275;
                                        TextInputLayout textInputLayout2 = (TextInputLayout) d.z(inflate, 2131362275);
                                        if (textInputLayout2 != null) {
                                            i9 = 2131362281;
                                            TextInputLayout textInputLayout3 = (TextInputLayout) d.z(inflate, 2131362281);
                                            if (textInputLayout3 != null) {
                                                i9 = 2131362302;
                                                RadioGroup radioGroup = (RadioGroup) d.z(inflate, 2131362302);
                                                if (radioGroup != null) {
                                                    i9 = 2131362306;
                                                    RadioButton radioButton = (RadioButton) d.z(inflate, 2131362306);
                                                    if (radioButton != null) {
                                                        i9 = 2131362307;
                                                        RadioButton radioButton2 = (RadioButton) d.z(inflate, 2131362307);
                                                        if (radioButton2 != null) {
                                                            i9 = 2131362440;
                                                            TextView textView = (TextView) d.z(inflate, 2131362440);
                                                            if (textView != null) {
                                                                LinearLayout linearLayout3 = (LinearLayout) inflate;
                                                                this.E = new c(linearLayout3, button, textInputLayout, textInputEditText, textInputEditText2, textInputEditText3, imageView, linearLayout, linearLayout2, textInputLayout2, textInputLayout3, radioGroup, radioButton, radioButton2, textView);
                                                                setContentView(linearLayout3);
                                                                Application application = getApplication();
                                                                application.getClass();
                                                                final k0 a9 = ((TvgramApplication) application).a();
                                                                w.j(g0.a(this), null, new j0(a9, this, cVar, 0), 3);
                                                                w.j(g0.a(this), null, new j0(a9, this, cVar, 1), 3);
                                                                w.j(g0.a(this), null, new j0(a9, this, cVar, 2), 3);
                                                                c cVar2 = this.E;
                                                                if (cVar2 == null) {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                                ((RadioGroup) cVar2.f1668l).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: i7.h0
                                                                    @Override // android.widget.RadioGroup.OnCheckedChangeListener
                                                                    public final void onCheckedChanged(RadioGroup radioGroup2, int i10) {
                                                                        LoginActivity loginActivity = LoginActivity.this;
                                                                        c7.c cVar3 = loginActivity.E;
                                                                        if (cVar3 == null) {
                                                                            b8.i.d("binding");
                                                                            throw null;
                                                                        }
                                                                        if (i10 == ((RadioButton) cVar3.f1670n).getId()) {
                                                                            h7.k0 k0Var = a9;
                                                                            k0Var.f4136f.e(null);
                                                                            k0Var.h.e(null);
                                                                            Client client = k0Var.f4141l;
                                                                            if (client != null) {
                                                                                client.send(new TdApi.RequestQrCodeAuthentication(new long[0]), new h7.f(k0Var, 9));
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        c7.c cVar4 = loginActivity.E;
                                                                        if (cVar4 == null) {
                                                                            b8.i.d("binding");
                                                                            throw null;
                                                                        }
                                                                        cVar4.f1658a.setVisibility(0);
                                                                        c7.c cVar5 = loginActivity.E;
                                                                        if (cVar5 == null) {
                                                                            b8.i.d("binding");
                                                                            throw null;
                                                                        }
                                                                        ((LinearLayout) cVar5.f1667k).setVisibility(8);
                                                                        c7.c cVar6 = loginActivity.E;
                                                                        if (cVar6 != null) {
                                                                            ((Button) cVar6.f1660c).setText("Next");
                                                                        } else {
                                                                            b8.i.d("binding");
                                                                            throw null;
                                                                        }
                                                                    }
                                                                });
                                                                c cVar3 = this.E;
                                                                if (cVar3 != null) {
                                                                    ((Button) cVar3.f1660c).setOnClickListener(new b(this, 4, a9));
                                                                    return;
                                                                } else {
                                                                    i.d("binding");
                                                                    throw null;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        m7.c.o("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i9)));
    }
}
