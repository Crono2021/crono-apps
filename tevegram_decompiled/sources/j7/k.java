package j7;

import com.network.tvgramplayer.telegram.TdClient$ExplorerType;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract /* synthetic */ class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f5469a;

    static {
        int[] iArr = new int[TdClient$ExplorerType.values().length];
        try {
            iArr[TdClient$ExplorerType.VIDEO.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[TdClient$ExplorerType.IMAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[TdClient$ExplorerType.LINK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[TdClient$ExplorerType.TOPIC.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f5469a = iArr;
    }
}
