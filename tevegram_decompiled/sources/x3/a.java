package x3;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import s.d;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final d f10092a;

    /* renamed from: b, reason: collision with root package name */
    public final d f10093b;

    /* renamed from: c, reason: collision with root package name */
    public final d f10094c;

    public a(d dVar, d dVar2, d dVar3) {
        this.f10092a = dVar;
        this.f10093b = dVar2;
        this.f10094c = dVar3;
    }

    public abstract b a();

    public final Class b(Class cls) {
        String name = cls.getName();
        d dVar = this.f10094c;
        Class cls2 = (Class) dVar.getOrDefault(name, null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        dVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) {
        d dVar = this.f10092a;
        Method method = (Method) dVar.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        dVar.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method d(Class cls) {
        String name = cls.getName();
        d dVar = this.f10093b;
        Method method = (Method) dVar.getOrDefault(name, null);
        if (method != null) {
            return method;
        }
        Class b9 = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = b9.getDeclaredMethod("write", cls, a.class);
        dVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i9);

    public final int f(int i9, int i10) {
        return !e(i10) ? i9 : ((b) this).f10096e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i9) {
        if (!e(i9)) {
            return parcelable;
        }
        return ((b) this).f10096e.readParcelable(b.class.getClassLoader());
    }

    public final c h() {
        String readString = ((b) this).f10096e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (c) c(readString).invoke(null, a());
        } catch (ClassNotFoundException e9) {
            m7.c.k("VersionedParcel encountered ClassNotFoundException", e9);
            return null;
        } catch (IllegalAccessException e10) {
            m7.c.k("VersionedParcel encountered IllegalAccessException", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            m7.c.k("VersionedParcel encountered NoSuchMethodException", e11);
            return null;
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e12.getCause());
            }
            m7.c.k("VersionedParcel encountered InvocationTargetException", e12);
            return null;
        }
    }

    public abstract void i(int i9);

    public final void j(int i9, int i10) {
        i(i10);
        ((b) this).f10096e.writeInt(i9);
    }

    public final void k(Parcelable parcelable, int i9) {
        i(i9);
        ((b) this).f10096e.writeParcelable(parcelable, 0);
    }

    public final void l(c cVar) {
        if (cVar == null) {
            ((b) this).f10096e.writeString(null);
            return;
        }
        try {
            ((b) this).f10096e.writeString(b(cVar.getClass()).getName());
            b a9 = a();
            try {
                d(cVar.getClass()).invoke(null, cVar, a9);
                Parcel parcel = a9.f10096e;
                int i9 = a9.f10099i;
                if (i9 >= 0) {
                    int i10 = a9.f10095d.get(i9);
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i10);
                    parcel.writeInt(dataPosition - i10);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e9) {
                m7.c.k("VersionedParcel encountered ClassNotFoundException", e9);
            } catch (IllegalAccessException e10) {
                m7.c.k("VersionedParcel encountered IllegalAccessException", e10);
            } catch (NoSuchMethodException e11) {
                m7.c.k("VersionedParcel encountered NoSuchMethodException", e11);
            } catch (InvocationTargetException e12) {
                if (e12.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e12.getCause());
                }
                m7.c.k("VersionedParcel encountered InvocationTargetException", e12);
            }
        } catch (ClassNotFoundException e13) {
            m7.c.k(cVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e13);
        }
    }
}
