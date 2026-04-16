package i7;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.network.tvgramplayer.ui.LoginActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i0 implements l8.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4891a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f4892b;

    public /* synthetic */ i0(LoginActivity loginActivity, int i9) {
        this.f4891a = i9;
        this.f4892b = loginActivity;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // l8.a
    public final Object a(Object obj, t7.c cVar) {
        int i9 = this.f4891a;
        LoginActivity loginActivity = this.f4892b;
        switch (i9) {
            case 0:
                String str = (String) obj;
                c7.c cVar2 = loginActivity.E;
                if (cVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                cVar2.f1659b.setVisibility(8);
                c7.c cVar3 = loginActivity.E;
                if (cVar3 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((Button) cVar3.f1660c).setEnabled(true);
                switch (str.hashCode()) {
                    case 77848963:
                        if (str.equals("READY")) {
                            loginActivity.finish();
                            break;
                        }
                        break;
                    case 478619173:
                        if (str.equals("WAIT_PASSWORD")) {
                            c7.c cVar4 = loginActivity.E;
                            if (cVar4 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar4.f1663f).setEnabled(false);
                            c7.c cVar5 = loginActivity.E;
                            if (cVar5 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar5.f1661d).setVisibility(8);
                            c7.c cVar6 = loginActivity.E;
                            if (cVar6 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar6.f1662e).setVisibility(0);
                            c7.c cVar7 = loginActivity.E;
                            if (cVar7 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((Button) cVar7.f1660c).setText("Login");
                            c7.c cVar8 = loginActivity.E;
                            if (cVar8 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputEditText) cVar8.h).requestFocus();
                            break;
                        }
                        break;
                    case 1270646276:
                        if (str.equals("WAIT_PHONE")) {
                            c7.c cVar9 = loginActivity.E;
                            if (cVar9 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            cVar9.f1658a.setVisibility(0);
                            c7.c cVar10 = loginActivity.E;
                            if (cVar10 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((LinearLayout) cVar10.f1667k).setVisibility(8);
                            c7.c cVar11 = loginActivity.E;
                            if (cVar11 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar11.f1663f).setEnabled(true);
                            c7.c cVar12 = loginActivity.E;
                            if (cVar12 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar12.f1663f).setVisibility(0);
                            c7.c cVar13 = loginActivity.E;
                            if (cVar13 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar13.f1661d).setVisibility(8);
                            c7.c cVar14 = loginActivity.E;
                            if (cVar14 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar14.f1662e).setVisibility(8);
                            c7.c cVar15 = loginActivity.E;
                            if (cVar15 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((Button) cVar15.f1660c).setText("Next");
                            break;
                        }
                        break;
                    case 1834317099:
                        if (str.equals("WAIT_QR")) {
                            c7.c cVar16 = loginActivity.E;
                            if (cVar16 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            cVar16.f1658a.setVisibility(8);
                            c7.c cVar17 = loginActivity.E;
                            if (cVar17 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((LinearLayout) cVar17.f1667k).setVisibility(0);
                            c7.c cVar18 = loginActivity.E;
                            if (cVar18 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((Button) cVar18.f1660c).setText("Regresar a Teléfono");
                            break;
                        }
                        break;
                    case 1841722999:
                        if (str.equals("WAIT_CODE")) {
                            c7.c cVar19 = loginActivity.E;
                            if (cVar19 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar19.f1663f).setEnabled(false);
                            c7.c cVar20 = loginActivity.E;
                            if (cVar20 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar20.f1661d).setVisibility(0);
                            c7.c cVar21 = loginActivity.E;
                            if (cVar21 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputLayout) cVar21.f1662e).setVisibility(8);
                            c7.c cVar22 = loginActivity.E;
                            if (cVar22 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((Button) cVar22.f1660c).setText("Verify Code");
                            c7.c cVar23 = loginActivity.E;
                            if (cVar23 == null) {
                                b8.i.d("binding");
                                throw null;
                            }
                            ((TextInputEditText) cVar23.f1664g).requestFocus();
                            break;
                        }
                        break;
                }
                return n7.g.f7490c;
            case 1:
                String str2 = (String) obj;
                if (str2 != null) {
                    int i10 = LoginActivity.F;
                    try {
                        v6.b q4 = a.a.q(str2);
                        Bitmap createBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.RGB_565);
                        createBitmap.getClass();
                        for (int i11 = 0; i11 < 500; i11++) {
                            for (int i12 = 0; i12 < 500; i12++) {
                                createBitmap.setPixel(i11, i12, ((q4.f9585l[(i11 / 32) + (q4.f9584k * i12)] >>> (i11 & 31)) & 1) != 0 ? -16777216 : -1);
                            }
                        }
                        c7.c cVar24 = loginActivity.E;
                        if (cVar24 == null) {
                            b8.i.d("binding");
                            throw null;
                        }
                        ((ImageView) cVar24.f1666j).setImageBitmap(createBitmap);
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
                return n7.g.f7490c;
            default:
                String str3 = (String) obj;
                if (str3 != null) {
                    c7.c cVar25 = loginActivity.E;
                    if (cVar25 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    cVar25.f1659b.setText(str3);
                    c7.c cVar26 = loginActivity.E;
                    if (cVar26 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    cVar26.f1659b.setVisibility(0);
                    c7.c cVar27 = loginActivity.E;
                    if (cVar27 == null) {
                        b8.i.d("binding");
                        throw null;
                    }
                    ((Button) cVar27.f1660c).setEnabled(true);
                }
                return n7.g.f7490c;
        }
    }
}
