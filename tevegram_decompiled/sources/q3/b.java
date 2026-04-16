package q3;

import android.content.SharedPreferences;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import s6.f;
import v.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f8469a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f8470b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final f6.a f8471c;

    /* renamed from: d, reason: collision with root package name */
    public final f6.c f8472d;

    public b(SharedPreferences sharedPreferences, f6.a aVar, f6.c cVar) {
        this.f8469a = sharedPreferences;
        this.f8471c = aVar;
        this.f8472d = cVar;
    }

    public static boolean c(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    public final String a(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            try {
                return new String(f.b(this.f8472d.a(str.getBytes(StandardCharsets.UTF_8), "tdlib_prefs".getBytes())), "US-ASCII");
            } catch (UnsupportedEncodingException e9) {
                throw new AssertionError(e9);
            }
        } catch (GeneralSecurityException e10) {
            m7.c.j("Could not encrypt key. ", e10.getMessage(), e10);
            return null;
        }
    }

    public final Object b(String str) {
        String str2;
        if (c(str)) {
            m7.c.l(str);
            return null;
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String a9 = a(str);
            String string = this.f8469a.getString(a9, null);
            if (string != null) {
                byte[] a10 = f.a(string);
                f6.a aVar = this.f8471c;
                Charset charset = StandardCharsets.UTF_8;
                ByteBuffer wrap = ByteBuffer.wrap(aVar.b(a10, a9.getBytes(charset)));
                wrap.position(0);
                int i9 = wrap.getInt();
                int i10 = i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? i9 != 5 ? 0 : 6 : 5 : 4 : 3 : 2 : 1;
                if (i10 == 0) {
                    throw new SecurityException("Unknown type ID for encrypted pref value: " + i9);
                }
                int a11 = h.a(i10);
                if (a11 == 0) {
                    int i11 = wrap.getInt();
                    ByteBuffer slice = wrap.slice();
                    wrap.limit(i11);
                    String charBuffer = charset.decode(slice).toString();
                    if (!charBuffer.equals("__NULL__")) {
                        return charBuffer;
                    }
                } else {
                    if (a11 != 1) {
                        if (a11 == 2) {
                            return Integer.valueOf(wrap.getInt());
                        }
                        if (a11 == 3) {
                            return Long.valueOf(wrap.getLong());
                        }
                        if (a11 == 4) {
                            return Float.valueOf(wrap.getFloat());
                        }
                        if (a11 == 5) {
                            return Boolean.valueOf(wrap.get() != 0);
                        }
                        switch (i10) {
                            case 1:
                                str2 = "STRING";
                                break;
                            case 2:
                                str2 = "STRING_SET";
                                break;
                            case 3:
                                str2 = "INT";
                                break;
                            case 4:
                                str2 = "LONG";
                                break;
                            case 5:
                                str2 = "FLOAT";
                                break;
                            case 6:
                                str2 = "BOOLEAN";
                                break;
                            default:
                                str2 = "null";
                                break;
                        }
                        throw new SecurityException("Unhandled type for encrypted pref value: ".concat(str2));
                    }
                    s.e eVar = new s.e(0);
                    while (wrap.hasRemaining()) {
                        int i12 = wrap.getInt();
                        ByteBuffer slice2 = wrap.slice();
                        slice2.limit(i12);
                        wrap.position(wrap.position() + i12);
                        eVar.add(StandardCharsets.UTF_8.decode(slice2).toString());
                    }
                    if (eVar.f8639k != 1 || !"__NULL__".equals(eVar.f8638j[0])) {
                        return eVar;
                    }
                }
            }
            return null;
        } catch (GeneralSecurityException e9) {
            m7.c.j("Could not decrypt value. ", e9.getMessage(), e9);
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        if (c(str)) {
            m7.c.l(str);
            return false;
        }
        return this.f8469a.contains(a(str));
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(this, this.f8469a.edit());
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : this.f8469a.getAll().entrySet()) {
            if (!c(entry.getKey())) {
                try {
                    String str = new String(this.f8472d.b(f.a(entry.getKey()), "tdlib_prefs".getBytes()), StandardCharsets.UTF_8);
                    if (str.equals("__NULL__")) {
                        str = null;
                    }
                    hashMap.put(str, b(str));
                } catch (GeneralSecurityException e9) {
                    m7.c.j("Could not decrypt key. ", e9.getMessage(), e9);
                    return null;
                }
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z8) {
        Object b9 = b(str);
        return b9 instanceof Boolean ? ((Boolean) b9).booleanValue() : z8;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f9) {
        Object b9 = b(str);
        return b9 instanceof Float ? ((Float) b9).floatValue() : f9;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i9) {
        Object b9 = b(str);
        return b9 instanceof Integer ? ((Integer) b9).intValue() : i9;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j5) {
        Object b9 = b(str);
        return b9 instanceof Long ? ((Long) b9).longValue() : j5;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object b9 = b(str);
        return b9 instanceof String ? (String) b9 : str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Object b9 = b(str);
        Set eVar = b9 instanceof Set ? (Set) b9 : new s.e(0);
        return eVar.size() > 0 ? eVar : set;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f8470b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f8470b.remove(onSharedPreferenceChangeListener);
    }
}
