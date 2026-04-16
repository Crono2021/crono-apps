package q3;

import android.content.SharedPreferences;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import s6.f;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public final b f8465a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences.Editor f8466b;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f8468d = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f8467c = new CopyOnWriteArrayList();

    public a(b bVar, SharedPreferences.Editor editor) {
        this.f8465a = bVar;
        this.f8466b = editor;
    }

    public final void a() {
        if (this.f8468d.getAndSet(false)) {
            b bVar = this.f8465a;
            for (String str : ((HashMap) bVar.getAll()).keySet()) {
                if (!this.f8467c.contains(str) && !b.c(str)) {
                    this.f8466b.remove(bVar.a(str));
                }
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        a();
        this.f8466b.apply();
        b();
        this.f8467c.clear();
    }

    public final void b() {
        b bVar = this.f8465a;
        Iterator it = bVar.f8470b.iterator();
        while (it.hasNext()) {
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
            Iterator it2 = this.f8467c.iterator();
            while (it2.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(bVar, (String) it2.next());
            }
        }
    }

    public final void c(String str, byte[] bArr) {
        b bVar = this.f8465a;
        bVar.getClass();
        if (b.c(str)) {
            m7.c.l(str);
            return;
        }
        this.f8467c.add(str);
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String a9 = bVar.a(str);
            try {
                Pair pair = new Pair(a9, new String(f.b(bVar.f8471c.a(bArr, a9.getBytes(StandardCharsets.UTF_8))), "US-ASCII"));
                this.f8466b.putString((String) pair.first, (String) pair.second);
            } catch (UnsupportedEncodingException e9) {
                throw new AssertionError(e9);
            }
        } catch (GeneralSecurityException e10) {
            m7.c.j("Could not encrypt data: ", e10.getMessage(), e10);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.f8468d.set(true);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f8467c;
        a();
        try {
            return this.f8466b.commit();
        } finally {
            b();
            copyOnWriteArrayList.clear();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z8) {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.putInt(5);
        allocate.put(z8 ? (byte) 1 : (byte) 0);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f9) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(4);
        allocate.putFloat(f9);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i9) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(2);
        allocate.putInt(i9);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j5) {
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.putInt(3);
        allocate.putLong(j5);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        if (str2 == null) {
            str2 = "__NULL__";
        }
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 8);
        allocate.putInt(0);
        allocate.putInt(length);
        allocate.put(bytes);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        int i9 = 0;
        if (set == null) {
            set = new s.e(0);
            set.add("__NULL__");
        }
        ArrayList arrayList = new ArrayList(set.size());
        int size = set.size() * 4;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            byte[] bytes = ((String) it.next()).getBytes(StandardCharsets.UTF_8);
            arrayList.add(bytes);
            size += bytes.length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(size + 4);
        allocate.putInt(1);
        int size2 = arrayList.size();
        while (i9 < size2) {
            Object obj = arrayList.get(i9);
            i9++;
            byte[] bArr = (byte[]) obj;
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        b bVar = this.f8465a;
        bVar.getClass();
        if (b.c(str)) {
            m7.c.l(str);
            return null;
        }
        this.f8466b.remove(bVar.a(str));
        this.f8467c.add(str);
        return this;
    }
}
