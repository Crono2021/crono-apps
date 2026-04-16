package h4;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements com.bumptech.glide.load.data.e {

    /* renamed from: i, reason: collision with root package name */
    public final Resources.Theme f3976i;

    /* renamed from: j, reason: collision with root package name */
    public final Resources f3977j;

    /* renamed from: k, reason: collision with root package name */
    public final androidx.emoji2.text.o f3978k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3979l;

    /* renamed from: m, reason: collision with root package name */
    public Object f3980m;

    public e(Resources.Theme theme, Resources resources, androidx.emoji2.text.o oVar, int i9) {
        this.f3976i = theme;
        this.f3977j = resources;
        this.f3978k = oVar;
        this.f3979l = i9;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f3978k.f638i) {
            case 3:
                return AssetFileDescriptor.class;
            case 4:
                return Drawable.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        Object obj = this.f3980m;
        if (obj != null) {
            try {
                switch (this.f3978k.f638i) {
                    case 3:
                        ((AssetFileDescriptor) obj).close();
                        break;
                    case 4:
                        break;
                    default:
                        ((InputStream) obj).close();
                        break;
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.g gVar, com.bumptech.glide.load.data.d dVar) {
        Object openRawResourceFd;
        try {
            androidx.emoji2.text.o oVar = this.f3978k;
            Resources.Theme theme = this.f3976i;
            Resources resources = this.f3977j;
            int i9 = this.f3979l;
            switch (oVar.f638i) {
                case 3:
                    openRawResourceFd = resources.openRawResourceFd(i9);
                    break;
                case 4:
                    Context context = oVar.f639j;
                    openRawResourceFd = com.bumptech.glide.c.x(context, context, i9, theme);
                    break;
                default:
                    openRawResourceFd = resources.openRawResource(i9);
                    break;
            }
            this.f3980m = openRawResourceFd;
            dVar.K(openRawResourceFd);
        } catch (Resources.NotFoundException e9) {
            dVar.x(e9);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}
