package r0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s implements ActionMode.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final ActionMode.Callback f8515a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8516b;

    /* renamed from: c, reason: collision with root package name */
    public Class f8517c;

    /* renamed from: d, reason: collision with root package name */
    public Method f8518d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8519e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8520f = false;

    public s(ActionMode.Callback callback, TextView textView) {
        this.f8515a = callback;
        this.f8516b = textView;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f8515a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f8515a.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode actionMode) {
        this.f8515a.onDestroyActionMode(actionMode);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        int checkSelfPermission;
        TextView textView = this.f8516b;
        Context context = textView.getContext();
        PackageManager packageManager = context.getPackageManager();
        boolean z8 = this.f8520f;
        Class<?> cls = Integer.TYPE;
        if (!z8) {
            this.f8520f = true;
            try {
                Class<?> cls2 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.f8517c = cls2;
                this.f8518d = cls2.getDeclaredMethod("removeItemAt", cls);
                this.f8519e = true;
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                this.f8517c = null;
                this.f8518d = null;
                this.f8519e = false;
            }
        }
        try {
            Method declaredMethod = (this.f8519e && this.f8517c.isInstance(menu)) ? this.f8518d : menu.getClass().getDeclaredMethod("removeItemAt", cls);
            for (int size = menu.size() - 1; size >= 0; size--) {
                MenuItem item = menu.getItem(size);
                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                    declaredMethod.invoke(menu, Integer.valueOf(size));
                }
            }
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0)) {
                    if (!context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (activityInfo.exported) {
                            String str = activityInfo.permission;
                            if (str != null) {
                                checkSelfPermission = context.checkSelfPermission(str);
                                if (checkSelfPermission == 0) {
                                }
                            }
                        }
                    }
                    arrayList.add(resolveInfo);
                }
            }
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i9);
                MenuItem add = menu.add(0, 0, i9 + 100, resolveInfo2.loadLabel(packageManager));
                Intent putExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()));
                ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                add.setIntent(putExtra.setClassName(activityInfo2.packageName, activityInfo2.name)).setShowAsAction(1);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return this.f8515a.onPrepareActionMode(actionMode, menu);
    }
}
