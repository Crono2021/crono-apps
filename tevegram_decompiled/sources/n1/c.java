package n1;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioProfile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c {
    public static e a(AudioManager audioManager, d1.g gVar) {
        List directProfilesForAttributes;
        int encapsulationType;
        int format;
        int[] channelMasks;
        int[] channelMasks2;
        directProfilesForAttributes = audioManager.getDirectProfilesForAttributes((AudioAttributes) gVar.a().f8j);
        HashMap hashMap = new HashMap();
        hashMap.put(2, new HashSet(a.a.a(12)));
        for (int i9 = 0; i9 < directProfilesForAttributes.size(); i9++) {
            AudioProfile f9 = m1.u.f(directProfilesForAttributes.get(i9));
            encapsulationType = f9.getEncapsulationType();
            if (encapsulationType != 1) {
                format = f9.getFormat();
                if (g1.w.I(format) || e.f7249e.containsKey(Integer.valueOf(format))) {
                    if (hashMap.containsKey(Integer.valueOf(format))) {
                        Set set = (Set) hashMap.get(Integer.valueOf(format));
                        set.getClass();
                        channelMasks2 = f9.getChannelMasks();
                        set.addAll(a.a.a(channelMasks2));
                    } else {
                        Integer valueOf = Integer.valueOf(format);
                        channelMasks = f9.getChannelMasks();
                        hashMap.put(valueOf, new HashSet(a.a.a(channelMasks)));
                    }
                }
            }
        }
        b6.q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i10 = 0;
        boolean z8 = false;
        for (Map.Entry entry : hashMap.entrySet()) {
            d dVar = new d(((Integer) entry.getKey()).intValue(), (Set) entry.getValue());
            int i11 = i10 + 1;
            if (objArr.length < i11) {
                objArr = Arrays.copyOf(objArr, b6.a0.d(objArr.length, i11));
            } else if (z8) {
                objArr = (Object[]) objArr.clone();
            } else {
                objArr[i10] = dVar;
                i10++;
            }
            z8 = false;
            objArr[i10] = dVar;
            i10++;
        }
        return new e(b6.g0.l(i10, objArr));
    }

    public static k b(AudioManager audioManager, d1.g gVar) {
        List audioDevicesForAttributes;
        try {
            audioManager.getClass();
            audioDevicesForAttributes = audioManager.getAudioDevicesForAttributes((AudioAttributes) gVar.a().f8j);
            if (audioDevicesForAttributes.isEmpty()) {
                return null;
            }
            return new k(a5.c.h(audioDevicesForAttributes.get(0)));
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
