package i7;

import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.network.tvgramplayer.player.RawPlayerJNI;
import com.network.tvgramplayer.ui.LiveStreamActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d0 implements SurfaceHolder.Callback {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ LiveStreamActivity f4815i;

    public d0(LiveStreamActivity liveStreamActivity) {
        this.f4815i = liveStreamActivity;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i9, int i10, int i11) {
        surfaceHolder.getClass();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        boolean z8;
        String str;
        String str2;
        AudioTrack audioTrack;
        AudioTrack.Builder audioAttributes;
        AudioTrack.Builder audioFormat;
        AudioTrack.Builder bufferSizeInBytes;
        AudioTrack.Builder transferMode;
        LiveStreamActivity liveStreamActivity = this.f4815i;
        boolean z9 = liveStreamActivity.I;
        surfaceHolder.getClass();
        try {
            Log.i("LiveStreamActivity", "🖼️ Native Surface Created");
            liveStreamActivity.H = surfaceHolder.getSurface();
            if (z9) {
                RawPlayerJNI rawPlayerJNI = RawPlayerJNI.INSTANCE;
                Surface surface = surfaceHolder.getSurface();
                surface.getClass();
                z8 = z9;
                str = "✅ Native player ready (handle=";
                liveStreamActivity.G = rawPlayerJNI.nativeInitPull(surface);
                k7.a aVar = new k7.a(liveStreamActivity);
                SharedPreferences sharedPreferences = aVar.f5628b;
                str2 = "🔊 AudioTrack Started (Mode: ";
                Log.i("LiveStreamActivity", "⚙️ [SETTINGS CHECK] AudioOffset: " + sharedPreferences.getInt("audio_offset_ms", 0) + ", V-Target: " + sharedPreferences.getInt("video_buffer_target", 5) + ", A-Target: " + sharedPreferences.getInt("audio_packet_buffer_target", 5) + ", HW: " + aVar.c());
                Log.i("LiveStreamActivity", "⚙️ [SETTINGS CHECK] Smart Sync: " + sharedPreferences.getBoolean("smart_sync", true) + ", Multi-Sync: " + sharedPreferences.getBoolean("multithreaded_sync", true) + ", Multi-Dec: " + sharedPreferences.getBoolean("multithreaded_decoding", true));
                rawPlayerJNI.nativeSetSyncSettingsPull(liveStreamActivity.G, sharedPreferences.getInt("audio_offset_ms", 0), sharedPreferences.getInt("video_buffer_target", 5), sharedPreferences.getInt("audio_packet_buffer_target", 5), aVar.c());
                rawPlayerJNI.nativeSetSyncModePull(liveStreamActivity.G, sharedPreferences.getBoolean("sync_auto", true) ? 1 : 0);
                rawPlayerJNI.nativeSetMultithreadedPull(liveStreamActivity.G, sharedPreferences.getBoolean("multithreaded_decoding", true));
                rawPlayerJNI.nativeSetPlayerModePull(liveStreamActivity.G, sharedPreferences.getInt("player_sync_mode", 3));
                rawPlayerJNI.nativeSetSmartSyncEnabledPull(liveStreamActivity.G, sharedPreferences.getBoolean("smart_sync", true));
                rawPlayerJNI.nativeSetAdaptiveBufferEnabledPull(liveStreamActivity.G, sharedPreferences.getBoolean("adaptive_buffer_enabled", true));
                rawPlayerJNI.nativeSetSyncThreadEnabledPull(liveStreamActivity.G, sharedPreferences.getBoolean("multithreaded_sync", true));
            } else {
                z8 = z9;
                str = "✅ Native player ready (handle=";
                str2 = "🔊 AudioTrack Started (Mode: ";
                RawPlayerJNI rawPlayerJNI2 = RawPlayerJNI.INSTANCE;
                Surface surface2 = surfaceHolder.getSurface();
                surface2.getClass();
                liveStreamActivity.G = rawPlayerJNI2.nativeInit(surface2);
                SharedPreferences sharedPreferences2 = new k7.a(liveStreamActivity).f5628b;
                rawPlayerJNI2.nativeSetSyncMode(liveStreamActivity.G, sharedPreferences2.getBoolean("sync_auto", true) ? 1 : 0);
                rawPlayerJNI2.nativeSetMultithreaded(liveStreamActivity.G, sharedPreferences2.getBoolean("multithreaded_decoding", true));
                rawPlayerJNI2.nativeSetSyncThreadEnabled(liveStreamActivity.G, sharedPreferences2.getBoolean("multithreaded_sync", true));
                rawPlayerJNI2.nativeSetSmartSyncEnabled(liveStreamActivity.G, sharedPreferences2.getBoolean("smart_sync", true));
                rawPlayerJNI2.nativeSetAudioOffset(liveStreamActivity.G, sharedPreferences2.getInt("audio_offset_ms", 0));
            }
            int minBufferSize = AudioTrack.getMinBufferSize(48000, 12, 2) * 4;
            AudioAttributes build = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
            AudioFormat build2 = new AudioFormat.Builder().setEncoding(2).setSampleRate(48000).setChannelMask(12).build();
            if (Build.VERSION.SDK_INT >= 23) {
                a5.c.p();
                audioAttributes = n1.f.c().setAudioAttributes(build);
                audioFormat = audioAttributes.setAudioFormat(build2);
                bufferSizeInBytes = audioFormat.setBufferSizeInBytes(minBufferSize);
                transferMode = bufferSizeInBytes.setTransferMode(1);
                audioTrack = transferMode.build();
            } else {
                audioTrack = new AudioTrack(3, 48000, 12, 2, minBufferSize, 1);
            }
            liveStreamActivity.O = audioTrack;
            if (audioTrack != null) {
                if (z8) {
                    RawPlayerJNI.INSTANCE.nativeSetAudioTrackPull(liveStreamActivity.G, audioTrack);
                } else {
                    RawPlayerJNI.INSTANCE.nativeSetAudioTrack(liveStreamActivity.G, audioTrack);
                }
                audioTrack.play();
                Log.i("LiveStreamActivity", str2 + (z8 ? "PULL" : "PUSH") + ")");
            }
            Log.i("LiveStreamActivity", str + liveStreamActivity.G + ")");
        } catch (Exception e9) {
            Log.e("LiveStreamActivity", "💥 Error initializing Native Player surface: " + e9.getMessage(), e9);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        surfaceHolder.getClass();
        Log.i("LiveStreamActivity", "🖼️ Native Surface Destroyed");
        LiveStreamActivity liveStreamActivity = this.f4815i;
        synchronized (liveStreamActivity.V) {
            try {
                long j5 = liveStreamActivity.G;
                if (j5 != 0) {
                    liveStreamActivity.G = 0L;
                    if (liveStreamActivity.I) {
                        RawPlayerJNI.INSTANCE.nativeReleasePull(j5);
                    } else {
                        RawPlayerJNI.INSTANCE.nativeRelease(j5);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
