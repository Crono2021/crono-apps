package q0;

import a3.i;
import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import i7.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f8304a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InputConnection inputConnection, i iVar) {
        super(inputConnection, false);
        this.f8304a = iVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i9, Bundle bundle) {
        x xVar = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            xVar = new x(new f(inputContentInfo), 20);
        }
        if (this.f8304a.f(xVar, i9, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i9, bundle);
    }
}
