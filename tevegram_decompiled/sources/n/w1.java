package n;

import android.widget.AbsListView;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class w1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Field f7082a;

    static {
        Field field = null;
        try {
            field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            field.setAccessible(true);
        } catch (NoSuchFieldException e9) {
            e9.printStackTrace();
        }
        f7082a = field;
    }
}
