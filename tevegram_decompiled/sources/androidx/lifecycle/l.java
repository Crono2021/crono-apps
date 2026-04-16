package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {
    private static final /* synthetic */ l[] $VALUES;
    public static final j Companion;
    public static final l ON_ANY;
    public static final l ON_CREATE;
    public static final l ON_DESTROY;
    public static final l ON_PAUSE;
    public static final l ON_RESUME;
    public static final l ON_START;
    public static final l ON_STOP;

    static {
        l lVar = new l("ON_CREATE", 0);
        ON_CREATE = lVar;
        l lVar2 = new l("ON_START", 1);
        ON_START = lVar2;
        l lVar3 = new l("ON_RESUME", 2);
        ON_RESUME = lVar3;
        l lVar4 = new l("ON_PAUSE", 3);
        ON_PAUSE = lVar4;
        l lVar5 = new l("ON_STOP", 4);
        ON_STOP = lVar5;
        l lVar6 = new l("ON_DESTROY", 5);
        ON_DESTROY = lVar6;
        l lVar7 = new l("ON_ANY", 6);
        ON_ANY = lVar7;
        $VALUES = new l[]{lVar, lVar2, lVar3, lVar4, lVar5, lVar6, lVar7};
        Companion = new j();
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) $VALUES.clone();
    }

    public final m a() {
        switch (k.f924a[ordinal()]) {
            case 1:
            case 2:
                return m.f930k;
            case 3:
            case 4:
                return m.f931l;
            case 5:
                return m.f932m;
            case 6:
                return m.f928i;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
