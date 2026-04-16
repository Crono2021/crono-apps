package m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class c0 extends androidx.fragment.app.i implements Menu {

    /* renamed from: k, reason: collision with root package name */
    public final m f6376k;

    public c0(Context context, m mVar) {
        super(context);
        if (mVar != null) {
            this.f6376k = mVar;
        } else {
            m7.c.n("Wrapped Object can not be null.");
            throw null;
        }
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return j(this.f6376k.a(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i9, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f6376k.addIntentOptions(i9, i10, i11, componentName, intentArr, intent, i12, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i13 = 0; i13 < length; i13++) {
                menuItemArr[i13] = j(menuItemArr2[i13]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f6376k.addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        s.h hVar = (s.h) this.f762j;
        if (hVar != null) {
            hVar.clear();
        }
        this.f6376k.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f6376k.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i9) {
        return j(this.f6376k.findItem(i9));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i9) {
        return j(this.f6376k.getItem(i9));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f6376k.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i9, KeyEvent keyEvent) {
        return this.f6376k.isShortcutKey(i9, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i9, int i10) {
        return this.f6376k.performIdentifierAction(i9, i10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i9, KeyEvent keyEvent, int i10) {
        return this.f6376k.performShortcut(i9, keyEvent, i10);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i9) {
        if (((s.h) this.f762j) != null) {
            int i10 = 0;
            while (true) {
                s.h hVar = (s.h) this.f762j;
                if (i10 >= hVar.f8653k) {
                    break;
                }
                if (((h0.a) hVar.h(i10)).getGroupId() == i9) {
                    ((s.h) this.f762j).j(i10);
                    i10--;
                }
                i10++;
            }
        }
        this.f6376k.removeGroup(i9);
    }

    @Override // android.view.Menu
    public final void removeItem(int i9) {
        if (((s.h) this.f762j) != null) {
            int i10 = 0;
            while (true) {
                s.h hVar = (s.h) this.f762j;
                if (i10 >= hVar.f8653k) {
                    break;
                }
                if (((h0.a) hVar.h(i10)).getItemId() == i9) {
                    ((s.h) this.f762j).j(i10);
                    break;
                }
                i10++;
            }
        }
        this.f6376k.removeItem(i9);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i9, boolean z8, boolean z9) {
        this.f6376k.setGroupCheckable(i9, z8, z9);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i9, boolean z8) {
        this.f6376k.setGroupEnabled(i9, z8);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i9, boolean z8) {
        this.f6376k.setGroupVisible(i9, z8);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z8) {
        this.f6376k.setQwertyMode(z8);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f6376k.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9) {
        return this.f6376k.addSubMenu(i9);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9, int i10, int i11, CharSequence charSequence) {
        return this.f6376k.addSubMenu(i9, i10, i11, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9, int i10, int i11, int i12) {
        return this.f6376k.addSubMenu(i9, i10, i11, i12);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9) {
        return j(this.f6376k.add(i9));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9, int i10, int i11, CharSequence charSequence) {
        return j(this.f6376k.a(i9, i10, i11, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9, int i10, int i11, int i12) {
        return j(this.f6376k.add(i9, i10, i11, i12));
    }
}
