package f0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends android.support.v4.media.session.b {
    public static Font D0(FontFamily fontFamily, int i9) {
        FontStyle fontStyle = new FontStyle((i9 & 1) != 0 ? 700 : 400, (i9 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int E0 = E0(fontStyle, font.getStyle());
        for (int i10 = 1; i10 < fontFamily.getSize(); i10++) {
            Font font2 = fontFamily.getFont(i10);
            int E02 = E0(fontStyle, font2.getStyle());
            if (E02 < E0) {
                font = font2;
                E0 = E02;
            }
        }
        return font;
    }

    public static int E0(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // android.support.v4.media.session.b
    public final Typeface x(Context context, e0.f fVar, Resources resources, int i9) {
        try {
            FontFamily.Builder builder = null;
            for (e0.g gVar : fVar.f2982a) {
                try {
                    Font build = new Font.Builder(resources, gVar.f2988f).setWeight(gVar.f2984b).setSlant(gVar.f2985c ? 1 : 0).setTtcIndex(gVar.f2987e).setFontVariationSettings(gVar.f2986d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(D0(build2, i9).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // android.support.v4.media.session.b
    public final Typeface y(Context context, k0.g[] gVarArr, int i9) {
        int i10;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = gVarArr.length;
            FontFamily.Builder builder = null;
            while (i10 < length) {
                k0.g gVar = gVarArr[i10];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(gVar.f5519a, "r", null);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    i10 = openFileDescriptor == null ? i10 + 1 : 0;
                } else {
                    try {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(gVar.f5521c).setSlant(gVar.f5522d ? 1 : 0).setTtcIndex(gVar.f5520b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                openFileDescriptor.close();
            }
            if (builder != null) {
                FontFamily build2 = builder.build();
                return new Typeface.CustomFallbackBuilder(build2).setStyle(D0(build2, i9).getStyle()).build();
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    @Override // android.support.v4.media.session.b
    public final Typeface z(Context context, Resources resources, int i9, String str, int i10) {
        try {
            Font build = new Font.Builder(resources, i9).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
