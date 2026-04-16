package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final View f3502i;

    /* renamed from: j, reason: collision with root package name */
    public final String f3503j;

    /* renamed from: k, reason: collision with root package name */
    public Method f3504k;

    /* renamed from: l, reason: collision with root package name */
    public Context f3505l;

    public e0(View view, String str) {
        this.f3502i = view;
        this.f3503j = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f3504k == null) {
            View view2 = this.f3502i;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f3503j;
                if (context == null) {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    StringBuilder r8 = androidx.activity.g.r("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    r8.append(view2.getClass());
                    r8.append(str);
                    throw new IllegalStateException(r8.toString());
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f3504k = method;
                        this.f3505l = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f3504k.invoke(this.f3505l, view);
        } catch (IllegalAccessException e9) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e9);
        } catch (InvocationTargetException e10) {
            throw new IllegalStateException("Could not execute method for android:onClick", e10);
        }
    }
}
