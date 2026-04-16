package com.network.tvgramplayer.ui;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.d;
import b8.i;
import com.bumptech.glide.b;
import com.bumptech.glide.k;
import com.google.android.material.datepicker.n;
import com.network.tvgramplayer.ui.ImageViewerActivity;
import g.l;
import h7.k0;
import h8.m;
import n7.e;
import tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class ImageViewerActivity extends l {
    public static final /* synthetic */ int I = 0;
    public ImageView E;
    public ProgressBar F;
    public TextView G;
    public final e H = new e(new d(this, 3));

    @Override // g.l, androidx.activity.n, c0.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558429);
        getWindow().getDecorView().setSystemUiVisibility(5894);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        View findViewById = findViewById(2131362282);
        findViewById.getClass();
        this.E = (ImageView) findViewById;
        View findViewById2 = findViewById(2131362290);
        findViewById2.getClass();
        this.F = (ProgressBar) findViewById2;
        View findViewById3 = findViewById(2131362500);
        findViewById3.getClass();
        this.G = (TextView) findViewById3;
        ImageView imageView = this.E;
        if (imageView == null) {
            i.d("photoView");
            throw null;
        }
        imageView.setOnClickListener(new n(this, 2));
        String stringExtra = getIntent().getStringExtra(IjkMediaMetadataRetriever.METADATA_KEY_TITLE);
        if (stringExtra == null || stringExtra.length() == 0) {
            TextView textView = this.G;
            if (textView == null) {
                i.d("txtImageTitle");
                throw null;
            }
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.G;
            if (textView2 == null) {
                i.d("txtImageTitle");
                throw null;
            }
            textView2.setText(stringExtra);
            TextView textView3 = this.G;
            if (textView3 == null) {
                i.d("txtImageTitle");
                throw null;
            }
            textView3.setVisibility(0);
        }
        String stringExtra2 = getIntent().getStringExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        int intExtra = getIntent().getIntExtra("file_id", 0);
        ProgressBar progressBar = this.F;
        if (progressBar == null) {
            i.d("progressBar");
            throw null;
        }
        progressBar.setVisibility(0);
        if (stringExtra2 != null && (m.f0(stringExtra2, "http://", false) || m.f0(stringExtra2, "https://", false))) {
            s(stringExtra2);
            return;
        }
        e eVar = this.H;
        if (intExtra != 0) {
            k0 k0Var = (k0) eVar.a();
            final int i9 = 0;
            k0Var.c(intExtra, new a8.l(this) { // from class: i7.s

                /* renamed from: j, reason: collision with root package name */
                public final /* synthetic */ ImageViewerActivity f5099j;

                {
                    this.f5099j = this;
                }

                @Override // a8.l
                public final Object a(Object obj) {
                    int i10 = i9;
                    final ImageViewerActivity imageViewerActivity = this.f5099j;
                    final String str = (String) obj;
                    switch (i10) {
                        case 0:
                            int i11 = ImageViewerActivity.I;
                            final int i12 = 1;
                            imageViewerActivity.runOnUiThread(new Runnable() { // from class: i7.t
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i13 = i12;
                                    ImageViewerActivity imageViewerActivity2 = imageViewerActivity;
                                    String str2 = str;
                                    switch (i13) {
                                        case 0:
                                            int i14 = ImageViewerActivity.I;
                                            if (str2 != null && str2.length() != 0) {
                                                imageViewerActivity2.s(str2);
                                                break;
                                            } else {
                                                imageViewerActivity2.t("No se pudo descargar la imagen");
                                                break;
                                            }
                                            break;
                                        default:
                                            int i15 = ImageViewerActivity.I;
                                            if (str2 != null && str2.length() != 0) {
                                                imageViewerActivity2.s(str2);
                                                break;
                                            } else {
                                                imageViewerActivity2.t("No se pudo descargar la imagen");
                                                break;
                                            }
                                    }
                                }
                            });
                            break;
                        default:
                            int i13 = ImageViewerActivity.I;
                            final int i14 = 0;
                            imageViewerActivity.runOnUiThread(new Runnable() { // from class: i7.t
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i132 = i14;
                                    ImageViewerActivity imageViewerActivity2 = imageViewerActivity;
                                    String str2 = str;
                                    switch (i132) {
                                        case 0:
                                            int i142 = ImageViewerActivity.I;
                                            if (str2 != null && str2.length() != 0) {
                                                imageViewerActivity2.s(str2);
                                                break;
                                            } else {
                                                imageViewerActivity2.t("No se pudo descargar la imagen");
                                                break;
                                            }
                                            break;
                                        default:
                                            int i15 = ImageViewerActivity.I;
                                            if (str2 != null && str2.length() != 0) {
                                                imageViewerActivity2.s(str2);
                                                break;
                                            } else {
                                                imageViewerActivity2.t("No se pudo descargar la imagen");
                                                break;
                                            }
                                    }
                                }
                            });
                            break;
                    }
                    return n7.g.f7490c;
                }
            });
        } else {
            if (stringExtra2 == null || !m.f0(stringExtra2, "telegram://", false)) {
                t("Referencia de imagen no proporcionada");
                return;
            }
            Integer Z = h8.l.Z(m.d0(stringExtra2, "telegram://", ""));
            if (Z == null) {
                t("ID de imagen inválido");
            } else {
                final int i10 = 1;
                ((k0) eVar.a()).c(Z.intValue(), new a8.l(this) { // from class: i7.s

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ ImageViewerActivity f5099j;

                    {
                        this.f5099j = this;
                    }

                    @Override // a8.l
                    public final Object a(Object obj) {
                        int i102 = i10;
                        final ImageViewerActivity imageViewerActivity = this.f5099j;
                        final String str = (String) obj;
                        switch (i102) {
                            case 0:
                                int i11 = ImageViewerActivity.I;
                                final int i12 = 1;
                                imageViewerActivity.runOnUiThread(new Runnable() { // from class: i7.t
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int i132 = i12;
                                        ImageViewerActivity imageViewerActivity2 = imageViewerActivity;
                                        String str2 = str;
                                        switch (i132) {
                                            case 0:
                                                int i142 = ImageViewerActivity.I;
                                                if (str2 != null && str2.length() != 0) {
                                                    imageViewerActivity2.s(str2);
                                                    break;
                                                } else {
                                                    imageViewerActivity2.t("No se pudo descargar la imagen");
                                                    break;
                                                }
                                                break;
                                            default:
                                                int i15 = ImageViewerActivity.I;
                                                if (str2 != null && str2.length() != 0) {
                                                    imageViewerActivity2.s(str2);
                                                    break;
                                                } else {
                                                    imageViewerActivity2.t("No se pudo descargar la imagen");
                                                    break;
                                                }
                                        }
                                    }
                                });
                                break;
                            default:
                                int i13 = ImageViewerActivity.I;
                                final int i14 = 0;
                                imageViewerActivity.runOnUiThread(new Runnable() { // from class: i7.t
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int i132 = i14;
                                        ImageViewerActivity imageViewerActivity2 = imageViewerActivity;
                                        String str2 = str;
                                        switch (i132) {
                                            case 0:
                                                int i142 = ImageViewerActivity.I;
                                                if (str2 != null && str2.length() != 0) {
                                                    imageViewerActivity2.s(str2);
                                                    break;
                                                } else {
                                                    imageViewerActivity2.t("No se pudo descargar la imagen");
                                                    break;
                                                }
                                                break;
                                            default:
                                                int i15 = ImageViewerActivity.I;
                                                if (str2 != null && str2.length() != 0) {
                                                    imageViewerActivity2.s(str2);
                                                    break;
                                                } else {
                                                    imageViewerActivity2.t("No se pudo descargar la imagen");
                                                    break;
                                                }
                                        }
                                    }
                                });
                                break;
                        }
                        return n7.g.f7490c;
                    }
                });
            }
        }
    }

    public final void s(String str) {
        k kVar = (k) b.a(this).f1735m.c(this).n(str).e(R.drawable.ic_dialog_alert);
        ImageView imageView = this.E;
        if (imageView == null) {
            i.d("photoView");
            throw null;
        }
        kVar.x(imageView);
        ProgressBar progressBar = this.F;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        } else {
            i.d("progressBar");
            throw null;
        }
    }

    public final void t(String str) {
        ProgressBar progressBar = this.F;
        if (progressBar == null) {
            i.d("progressBar");
            throw null;
        }
        progressBar.setVisibility(8);
        Toast.makeText(this, str, 0).show();
        finish();
    }
}
