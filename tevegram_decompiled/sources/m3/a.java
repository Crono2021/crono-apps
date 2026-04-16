package m3;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6606a;

    /* renamed from: b, reason: collision with root package name */
    public final c f6607b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f6608c;

    /* renamed from: d, reason: collision with root package name */
    public final File f6609d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6610e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6611f = false;

    /* renamed from: g, reason: collision with root package name */
    public b[] f6612g;
    public byte[] h;

    public a(AssetManager assetManager, Executor executor, c cVar, String str, File file) {
        this.f6606a = executor;
        this.f6607b = cVar;
        this.f6610e = str;
        this.f6609d = file;
        int i9 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i9 >= 24 && i9 <= 33) {
            switch (i9) {
                case 24:
                case 25:
                    bArr = d.h;
                    break;
                case 26:
                    bArr = d.f6627g;
                    break;
                case 27:
                    bArr = d.f6626f;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = d.f6625e;
                    break;
                case 31:
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                case 33:
                    bArr = d.f6624d;
                    break;
            }
        }
        this.f6608c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e9) {
            String message = e9.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f6607b.n();
            return null;
        }
    }

    public final void b(int i9, Serializable serializable) {
        this.f6606a.execute(new g1.i(i9, 1, this, serializable));
    }
}
