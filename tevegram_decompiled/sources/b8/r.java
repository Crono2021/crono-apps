package b8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class r {
    public static void a(int i9, Object obj) {
        if (obj instanceof n7.a) {
            if ((obj instanceof g ? ((g) obj).e() : obj instanceof a8.a ? 0 : obj instanceof a8.l ? 1 : obj instanceof a8.p ? 2 : obj instanceof a8.q ? 3 : obj instanceof a8.r ? 4 : -1) == i9) {
                return;
            }
        }
        String name = obj.getClass().getName();
        ClassCastException classCastException = new ClassCastException(name + " cannot be cast to " + ("kotlin.jvm.functions.Function" + i9));
        i.b(classCastException, r.class.getName());
        throw classCastException;
    }

    public static final a b(Object[] objArr) {
        objArr.getClass();
        return new a(objArr);
    }
}
