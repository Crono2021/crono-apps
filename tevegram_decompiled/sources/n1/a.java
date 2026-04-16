package n1;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {
    private static b6.k0 a() {
        b6.j0 j0Var = new b6.j0();
        Integer[] numArr = {8, 7};
        b6.q.a(2, numArr);
        j0Var.e(j0Var.f1345b + 2);
        System.arraycopy(numArr, 0, j0Var.f1344a, j0Var.f1345b, 2);
        j0Var.f1345b += 2;
        int i9 = g1.w.f3713a;
        if (i9 >= 31) {
            Integer[] numArr2 = {26, 27};
            b6.q.a(2, numArr2);
            j0Var.e(j0Var.f1345b + 2);
            System.arraycopy(numArr2, 0, j0Var.f1344a, j0Var.f1345b, 2);
            j0Var.f1345b += 2;
        }
        if (i9 >= 33) {
            j0Var.a(30);
        }
        return j0Var.f();
    }

    public static boolean b(AudioManager audioManager, k kVar) {
        AudioDeviceInfo[] audioDeviceInfoArr;
        int type;
        if (kVar == null) {
            audioManager.getClass();
            audioDeviceInfoArr = audioManager.getDevices(2);
        } else {
            audioDeviceInfoArr = new AudioDeviceInfo[]{kVar.f7284a};
        }
        b6.k0 a9 = a();
        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
            type = audioDeviceInfo.getType();
            if (a9.contains(Integer.valueOf(type))) {
                return true;
            }
        }
        return false;
    }
}
