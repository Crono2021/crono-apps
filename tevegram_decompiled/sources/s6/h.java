package s6;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8882a;

    /* renamed from: b, reason: collision with root package name */
    public final o4.d f8883b;

    public /* synthetic */ h(o4.d dVar, int i9) {
        this.f8882a = i9;
        this.f8883b = dVar;
    }

    public final Object a(String str) {
        switch (this.f8882a) {
            case 0:
                String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
                ArrayList arrayList = new ArrayList();
                int i9 = 0;
                for (int i10 = 0; i10 < 2; i10++) {
                    Provider provider = Security.getProvider(strArr[i10]);
                    if (provider != null) {
                        arrayList.add(provider);
                    }
                }
                int size = arrayList.size();
                Exception exc = null;
                while (true) {
                    o4.d dVar = this.f8883b;
                    if (i9 >= size) {
                        return dVar.u(str, null);
                    }
                    Object obj = arrayList.get(i9);
                    i9++;
                    try {
                        return dVar.u(str, (Provider) obj);
                    } catch (Exception e9) {
                        if (exc == null) {
                            exc = e9;
                        }
                    }
                }
            case 1:
                return this.f8883b.u(str, null);
            default:
                String[] strArr2 = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};
                ArrayList arrayList2 = new ArrayList();
                int i11 = 0;
                for (int i12 = 0; i12 < 3; i12++) {
                    Provider provider2 = Security.getProvider(strArr2[i12]);
                    if (provider2 != null) {
                        arrayList2.add(provider2);
                    }
                }
                int size2 = arrayList2.size();
                Exception exc2 = null;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    try {
                        return this.f8883b.u(str, (Provider) obj2);
                    } catch (Exception e10) {
                        if (exc2 == null) {
                            exc2 = e10;
                        }
                    }
                }
                throw new GeneralSecurityException("No good Provider found.", exc2);
        }
    }
}
