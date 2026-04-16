package l1;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final AudioManager f5812a;

    /* renamed from: b, reason: collision with root package name */
    public final c f5813b;

    /* renamed from: c, reason: collision with root package name */
    public y f5814c;

    /* renamed from: d, reason: collision with root package name */
    public d1.g f5815d;

    /* renamed from: e, reason: collision with root package name */
    public int f5816e;

    /* renamed from: f, reason: collision with root package name */
    public int f5817f;

    /* renamed from: g, reason: collision with root package name */
    public float f5818g = 1.0f;
    public AudioFocusRequest h;

    public d(Context context, Handler handler, y yVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.f5812a = audioManager;
        this.f5814c = yVar;
        this.f5813b = new c(this, handler);
        this.f5816e = 0;
    }

    public final void a() {
        if (this.f5816e == 0) {
            return;
        }
        int i9 = g1.w.f3713a;
        AudioManager audioManager = this.f5812a;
        if (i9 >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                audioManager.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            audioManager.abandonAudioFocus(this.f5813b);
        }
        b(0);
    }

    public final void b(int i9) {
        if (this.f5816e == i9) {
            return;
        }
        this.f5816e = i9;
        float f9 = i9 == 3 ? 0.2f : 1.0f;
        if (this.f5818g == f9) {
            return;
        }
        this.f5818g = f9;
        y yVar = this.f5814c;
        if (yVar != null) {
            b0 b0Var = yVar.f6065i;
            b0Var.o0(1, 2, Float.valueOf(b0Var.f5779h0 * b0Var.H.f5818g));
        }
    }

    public final int c(int i9, boolean z8) {
        int requestAudioFocus;
        AudioFocusRequest.Builder b9;
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        if (i9 == 1 || this.f5817f != 1) {
            a();
            return z8 ? 1 : -1;
        }
        if (z8) {
            if (this.f5816e != 1) {
                int i10 = g1.w.f3713a;
                AudioManager audioManager = this.f5812a;
                c cVar = this.f5813b;
                if (i10 >= 26) {
                    AudioFocusRequest audioFocusRequest = this.h;
                    if (audioFocusRequest == null) {
                        if (audioFocusRequest == null) {
                            b.f();
                            b9 = a5.a.j(this.f5817f);
                        } else {
                            b.f();
                            b9 = b.b(this.h);
                        }
                        d1.g gVar = this.f5815d;
                        boolean z9 = gVar != null && gVar.f2424a == 1;
                        gVar.getClass();
                        audioAttributes = b9.setAudioAttributes((AudioAttributes) gVar.a().f8j);
                        willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(z9);
                        onAudioFocusChangeListener = willPauseWhenDucked.setOnAudioFocusChangeListener(cVar);
                        build = onAudioFocusChangeListener.build();
                        this.h = build;
                    }
                    requestAudioFocus = audioManager.requestAudioFocus(this.h);
                } else {
                    this.f5815d.getClass();
                    requestAudioFocus = audioManager.requestAudioFocus(cVar, 3, this.f5817f);
                }
                if (requestAudioFocus == 1) {
                    b(1);
                    return 1;
                }
                b(0);
                return -1;
            }
        }
    }
}
