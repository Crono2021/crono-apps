package i7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.player.PlayerManager;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class y2 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5219i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f5220j;

    public /* synthetic */ y2(PlayerActivity playerActivity, int i9) {
        this.f5219i = i9;
        this.f5220j = playerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String stringExtra;
        Uri data;
        int i9 = this.f5219i;
        int i10 = 1;
        int i11 = 0;
        PlayerActivity playerActivity = this.f5220j;
        switch (i9) {
            case 0:
                PlayerActivity playerActivity2 = this.f5220j;
                e7.a aVar = playerActivity2.H;
                if (aVar == null) {
                    return;
                }
                Intent intent = playerActivity2.getIntent();
                r7.c cVar = null;
                if (intent == null || (data = intent.getData()) == null || (stringExtra = data.toString()) == null) {
                    Intent intent2 = playerActivity2.getIntent();
                    stringExtra = intent2 != null ? intent2.getStringExtra("EXTRA_CONTEXT_URL") : null;
                    if (stringExtra == null) {
                        stringExtra = aVar.f3151a;
                    }
                }
                i8.w.j(androidx.lifecycle.g0.a(playerActivity2), i8.c0.f5251b, new b7.c(aVar, playerActivity2, stringExtra, cVar, 4), 2);
                return;
            case 1:
                int i12 = PlayerActivity.X;
                playerActivity.finish();
                return;
            case 2:
                int i13 = PlayerActivity.X;
                playerActivity.v();
                return;
            case 3:
                int i14 = PlayerActivity.X;
                playerActivity.w();
                return;
            case 4:
                Playlist playlist = playerActivity.O;
                if (playlist == null) {
                    return;
                }
                boolean isShuffleEnabled = playlist.isShuffleEnabled();
                boolean z8 = !isShuffleEnabled;
                a0.l lVar = playerActivity.L;
                if (lVar == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                lVar.z(playlist.getId(), z8);
                Toast.makeText(playerActivity, !isShuffleEnabled ? "Aleatorio ACTIVADO" : "Aleatorio DESACTIVADO", 0).show();
                playerActivity.B();
                return;
            case 5:
                int i15 = PlayerActivity.X;
                MediaCodecList mediaCodecList = new MediaCodecList(1);
                List<String> D0 = o7.i.D0("audio/ac3", "audio/eac3", "audio/vnd.dts", "audio/mpeg", "audio/mp4a-latm");
                StringBuilder sb = new StringBuilder("🔍 Reporte de Códecs de Audio:\n\n");
                for (String str : D0) {
                    sb.append("• **" + str + "**:\n");
                    MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
                    codecInfos.getClass();
                    ArrayList arrayList = new ArrayList();
                    for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                        if (!mediaCodecInfo.isEncoder()) {
                            String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                            supportedTypes.getClass();
                            int length = supportedTypes.length;
                            int i16 = 0;
                            while (true) {
                                if (i16 < length) {
                                    String str2 = supportedTypes[i16];
                                    str2.getClass();
                                    Locale locale = Locale.ROOT;
                                    String lowerCase = str2.toLowerCase(locale);
                                    lowerCase.getClass();
                                    String lowerCase2 = str.toLowerCase(locale);
                                    lowerCase2.getClass();
                                    if (h8.e.g0(lowerCase, lowerCase2, false)) {
                                        arrayList.add(mediaCodecInfo);
                                    } else {
                                        i16++;
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        sb.append("  ❌ No soportado por Hardware\n");
                    } else {
                        int size = arrayList.size();
                        int i17 = 0;
                        while (i17 < size) {
                            Object obj = arrayList.get(i17);
                            i17++;
                            MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) obj;
                            String name = mediaCodecInfo2.getName();
                            name.getClass();
                            String lowerCase3 = name.toLowerCase(Locale.ROOT);
                            lowerCase3.getClass();
                            sb.append("  ✅ " + mediaCodecInfo2.getName() + " (" + ((h8.m.f0(lowerCase3, "omx.google", false) || h8.m.f0(lowerCase3, "c2.android", false)) ? "Software" : "Hardware") + ")\n");
                        }
                    }
                    sb.append("\n");
                }
                new g.j(playerActivity).setTitle("Diagnóstico de Códecs").c(sb.toString()).g("Cerrar", null).h();
                return;
            case 6:
                h7.k0 k0Var = playerActivity.I;
                if (k0Var != null) {
                    k0Var.b();
                    return;
                } else {
                    b8.i.d("tdClient");
                    throw null;
                }
            case 7:
                Playlist playlist2 = playerActivity.O;
                if (playlist2 == null) {
                    return;
                }
                boolean isLoopEnabled = playlist2.isLoopEnabled();
                boolean z9 = !isLoopEnabled;
                a0.l lVar2 = playerActivity.L;
                if (lVar2 == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                lVar2.x(playlist2.getId(), z9);
                Toast.makeText(playerActivity, !isLoopEnabled ? "Bucle ACTIVADO" : "Bucle DESACTIVADO", 0).show();
                playerActivity.B();
                return;
            case 8:
                int i18 = PlayerActivity.X;
                k7.a aVar2 = new k7.a(playerActivity);
                aVar2.f5628b.edit().putBoolean("visualizer_enabled", !aVar2.d()).apply();
                playerActivity.C();
                playerActivity.y();
                Toast.makeText(playerActivity, aVar2.d() ? "Espectros Activados" : "Espectros Desactivados", 0).show();
                return;
            case 9:
                int i19 = PlayerActivity.X;
                playerActivity.v();
                return;
            case 10:
                int i20 = PlayerActivity.X;
                playerActivity.w();
                return;
            case 11:
                int i21 = PlayerActivity.X;
                PlayerActivity playerActivity3 = this.f5220j;
                k7.a aVar3 = new k7.a(playerActivity3);
                View inflate = playerActivity3.getLayoutInflater().inflate(2131558456, (ViewGroup) null, false);
                int i22 = 2131361888;
                Button button = (Button) com.bumptech.glide.d.z(inflate, 2131361888);
                if (button != null) {
                    i22 = 2131361889;
                    if (((Button) com.bumptech.glide.d.z(inflate, 2131361889)) != null) {
                        Button button2 = (Button) com.bumptech.glide.d.z(inflate, 2131361890);
                        if (button2 == null) {
                            i22 = 2131361890;
                        } else if (((Button) com.bumptech.glide.d.z(inflate, 2131361917)) != null) {
                            Button button3 = (Button) com.bumptech.glide.d.z(inflate, 2131361929);
                            if (button3 != null) {
                                EditText editText = (EditText) com.bumptech.glide.d.z(inflate, 2131362022);
                                if (editText != null) {
                                    EditText editText2 = (EditText) com.bumptech.glide.d.z(inflate, 2131362023);
                                    if (editText2 != null) {
                                        EditText editText3 = (EditText) com.bumptech.glide.d.z(inflate, 2131362026);
                                        if (editText3 == null) {
                                            i22 = 2131362026;
                                        } else if (((RadioButton) com.bumptech.glide.d.z(inflate, 2131362299)) == null) {
                                            i22 = 2131362299;
                                        } else if (((RadioButton) com.bumptech.glide.d.z(inflate, 2131362300)) == null) {
                                            i22 = 2131362300;
                                        } else if (((RadioGroup) com.bumptech.glide.d.z(inflate, 2131362301)) != null) {
                                            Switch r22 = (Switch) com.bumptech.glide.d.z(inflate, 2131362398);
                                            if (r22 != null) {
                                                Switch r23 = (Switch) com.bumptech.glide.d.z(inflate, 2131362407);
                                                if (r23 == null) {
                                                    i22 = 2131362407;
                                                } else if (((Switch) com.bumptech.glide.d.z(inflate, 2131362409)) == null) {
                                                    i22 = 2131362409;
                                                } else if (((Switch) com.bumptech.glide.d.z(inflate, 2131362411)) == null) {
                                                    i22 = 2131362411;
                                                } else if (((Switch) com.bumptech.glide.d.z(inflate, 2131362412)) != null) {
                                                    Switch r24 = (Switch) com.bumptech.glide.d.z(inflate, 2131362414);
                                                    if (r24 != null) {
                                                        Switch r25 = (Switch) com.bumptech.glide.d.z(inflate, 2131362415);
                                                        if (r25 != null) {
                                                            Switch r26 = (Switch) com.bumptech.glide.d.z(inflate, 2131362416);
                                                            if (r26 != null) {
                                                                Switch r27 = (Switch) com.bumptech.glide.d.z(inflate, 2131362417);
                                                                if (r27 != null) {
                                                                    TextView textView = (TextView) com.bumptech.glide.d.z(inflate, 2131362504);
                                                                    if (textView != null) {
                                                                        ScrollView scrollView = (ScrollView) inflate;
                                                                        final c7.f fVar = new c7.f(scrollView, button, button2, button3, editText, editText2, editText3, r22, r23, r24, r25, r26, r27, textView);
                                                                        SharedPreferences sharedPreferences = aVar3.f5628b;
                                                                        editText2.setText(String.valueOf(sharedPreferences.getInt("min_buffer_ms", 15000)));
                                                                        editText.setText(String.valueOf(sharedPreferences.getInt("max_buffer_ms", 50000)));
                                                                        editText3.setText(String.valueOf(sharedPreferences.getInt("playback_buffer_ms", 2500)));
                                                                        r24.setChecked(sharedPreferences.getBoolean("streaming_mode", true));
                                                                        PlayerActivity.z(r24, "Modo Streaming", sharedPreferences.getBoolean("streaming_mode", true), "(Ahorra espacio)", "(Descarga completa)");
                                                                        final int i23 = 0;
                                                                        r24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i7.b3
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                                                                                int i24 = i23;
                                                                                c7.f fVar2 = fVar;
                                                                                switch (i24) {
                                                                                    case 0:
                                                                                        int i25 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1721g, "Modo Streaming", z10, "(Ahorra espacio)", "(Descarga completa)");
                                                                                        break;
                                                                                    case 1:
                                                                                        int i26 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1720f, "Aceleración HW", z10, "(Rápido)", "(Lento/Compatible)");
                                                                                        break;
                                                                                    case 2:
                                                                                        int i27 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1722i, "Audio por Software", z10, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    case 3:
                                                                                        int i28 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.h, "Subtítulos", z10, "(Mostrar)", "(Ocultar)");
                                                                                        break;
                                                                                    case 4:
                                                                                        int i29 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1719e, "Auto Frame Rate", z10, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    default:
                                                                                        int i30 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1723j, "Habilitar Espectros", z10, "", "");
                                                                                        break;
                                                                                }
                                                                            }
                                                                        });
                                                                        SharedPreferences sharedPreferences2 = playerActivity3.getSharedPreferences("tvgram_settings", 0);
                                                                        r23.setChecked(aVar3.c());
                                                                        r26.setChecked(sharedPreferences.getBoolean("use_software_audio", false));
                                                                        PlayerActivity.z(r23, "Aceleración HW", aVar3.c(), "(Activa)", "(Desact.)");
                                                                        PlayerActivity.z(r26, "Audio por Software", sharedPreferences.getBoolean("use_software_audio", false), "(Activo)", "(Desactivado)");
                                                                        final int i24 = 1;
                                                                        r23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i7.b3
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                                                                                int i242 = i24;
                                                                                c7.f fVar2 = fVar;
                                                                                switch (i242) {
                                                                                    case 0:
                                                                                        int i25 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1721g, "Modo Streaming", z10, "(Ahorra espacio)", "(Descarga completa)");
                                                                                        break;
                                                                                    case 1:
                                                                                        int i26 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1720f, "Aceleración HW", z10, "(Rápido)", "(Lento/Compatible)");
                                                                                        break;
                                                                                    case 2:
                                                                                        int i27 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1722i, "Audio por Software", z10, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    case 3:
                                                                                        int i28 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.h, "Subtítulos", z10, "(Mostrar)", "(Ocultar)");
                                                                                        break;
                                                                                    case 4:
                                                                                        int i29 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1719e, "Auto Frame Rate", z10, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    default:
                                                                                        int i30 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1723j, "Habilitar Espectros", z10, "", "");
                                                                                        break;
                                                                                }
                                                                            }
                                                                        });
                                                                        final int i25 = 2;
                                                                        r26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i7.b3
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                                                                                int i242 = i25;
                                                                                c7.f fVar2 = fVar;
                                                                                switch (i242) {
                                                                                    case 0:
                                                                                        int i252 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1721g, "Modo Streaming", z10, "(Ahorra espacio)", "(Descarga completa)");
                                                                                        break;
                                                                                    case 1:
                                                                                        int i26 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1720f, "Aceleración HW", z10, "(Rápido)", "(Lento/Compatible)");
                                                                                        break;
                                                                                    case 2:
                                                                                        int i27 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1722i, "Audio por Software", z10, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    case 3:
                                                                                        int i28 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.h, "Subtítulos", z10, "(Mostrar)", "(Ocultar)");
                                                                                        break;
                                                                                    case 4:
                                                                                        int i29 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1719e, "Auto Frame Rate", z10, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    default:
                                                                                        int i30 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1723j, "Habilitar Espectros", z10, "", "");
                                                                                        break;
                                                                                }
                                                                            }
                                                                        });
                                                                        boolean z10 = sharedPreferences2.getBoolean("enable_subtitles", true);
                                                                        r25.setChecked(z10);
                                                                        PlayerActivity.z(r25, "Subtítulos", z10, "(Mostrar)", "(Ocultar)");
                                                                        final int i26 = 3;
                                                                        r25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i7.b3
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                                                                                int i242 = i26;
                                                                                c7.f fVar2 = fVar;
                                                                                switch (i242) {
                                                                                    case 0:
                                                                                        int i252 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1721g, "Modo Streaming", z102, "(Ahorra espacio)", "(Descarga completa)");
                                                                                        break;
                                                                                    case 1:
                                                                                        int i262 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1720f, "Aceleración HW", z102, "(Rápido)", "(Lento/Compatible)");
                                                                                        break;
                                                                                    case 2:
                                                                                        int i27 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1722i, "Audio por Software", z102, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    case 3:
                                                                                        int i28 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.h, "Subtítulos", z102, "(Mostrar)", "(Ocultar)");
                                                                                        break;
                                                                                    case 4:
                                                                                        int i29 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1719e, "Auto Frame Rate", z102, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    default:
                                                                                        int i30 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1723j, "Habilitar Espectros", z102, "", "");
                                                                                        break;
                                                                                }
                                                                            }
                                                                        });
                                                                        r22.setChecked(aVar3.b());
                                                                        RadioButton radioButton = (RadioButton) scrollView.findViewById(2131362300);
                                                                        RadioButton radioButton2 = (RadioButton) scrollView.findViewById(2131362299);
                                                                        if (aVar3.a() == 1) {
                                                                            radioButton2.setChecked(true);
                                                                        } else {
                                                                            radioButton.setChecked(true);
                                                                        }
                                                                        PlayerActivity.z(r22, "Auto Frame Rate", aVar3.b(), "(Activo)", "(Desactivado)");
                                                                        final int i27 = 4;
                                                                        r22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i7.b3
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                                                                                int i242 = i27;
                                                                                c7.f fVar2 = fVar;
                                                                                switch (i242) {
                                                                                    case 0:
                                                                                        int i252 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1721g, "Modo Streaming", z102, "(Ahorra espacio)", "(Descarga completa)");
                                                                                        break;
                                                                                    case 1:
                                                                                        int i262 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1720f, "Aceleración HW", z102, "(Rápido)", "(Lento/Compatible)");
                                                                                        break;
                                                                                    case 2:
                                                                                        int i272 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1722i, "Audio por Software", z102, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    case 3:
                                                                                        int i28 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.h, "Subtítulos", z102, "(Mostrar)", "(Ocultar)");
                                                                                        break;
                                                                                    case 4:
                                                                                        int i29 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1719e, "Auto Frame Rate", z102, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    default:
                                                                                        int i30 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1723j, "Habilitar Espectros", z102, "", "");
                                                                                        break;
                                                                                }
                                                                            }
                                                                        });
                                                                        final int i28 = 5;
                                                                        ((Button) scrollView.findViewById(2131361889)).setOnClickListener(new y2(playerActivity3, i28));
                                                                        button2.setOnClickListener(new y2(playerActivity3, 6));
                                                                        r27.setChecked(aVar3.d());
                                                                        PlayerActivity.z(r27, "Habilitar Espectros", aVar3.d(), "", "");
                                                                        r27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i7.b3
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                                                                                int i242 = i28;
                                                                                c7.f fVar2 = fVar;
                                                                                switch (i242) {
                                                                                    case 0:
                                                                                        int i252 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1721g, "Modo Streaming", z102, "(Ahorra espacio)", "(Descarga completa)");
                                                                                        break;
                                                                                    case 1:
                                                                                        int i262 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1720f, "Aceleración HW", z102, "(Rápido)", "(Lento/Compatible)");
                                                                                        break;
                                                                                    case 2:
                                                                                        int i272 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1722i, "Audio por Software", z102, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    case 3:
                                                                                        int i282 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.h, "Subtítulos", z102, "(Mostrar)", "(Ocultar)");
                                                                                        break;
                                                                                    case 4:
                                                                                        int i29 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1719e, "Auto Frame Rate", z102, "(Activo)", "(Desactivado)");
                                                                                        break;
                                                                                    default:
                                                                                        int i30 = PlayerActivity.X;
                                                                                        PlayerActivity.z(fVar2.f1723j, "Habilitar Espectros", z102, "", "");
                                                                                        break;
                                                                                }
                                                                            }
                                                                        });
                                                                        button3.setText("Grupo: ".concat(aVar3.e()));
                                                                        button3.setOnClickListener(new c3(aVar3, playerActivity3, fVar));
                                                                        String string = sharedPreferences.getString("storage_path", "");
                                                                        String str3 = string != null ? string : "";
                                                                        if (str3.length() == 0) {
                                                                            str3 = "Almacenamiento Interno (Por defecto)";
                                                                        }
                                                                        textView.setText(str3);
                                                                        button.setOnClickListener(new c3(playerActivity3, fVar, aVar3));
                                                                        new g.j(playerActivity3).setView(scrollView).g("Guardar", new i1(aVar3, fVar, radioButton2, playerActivity3, sharedPreferences2, 1)).d("Cancelar", null).h();
                                                                        return;
                                                                    }
                                                                    i22 = 2131362504;
                                                                } else {
                                                                    i22 = 2131362417;
                                                                }
                                                            } else {
                                                                i22 = 2131362416;
                                                            }
                                                        } else {
                                                            i22 = 2131362415;
                                                        }
                                                    } else {
                                                        i22 = 2131362414;
                                                    }
                                                } else {
                                                    i22 = 2131362412;
                                                }
                                            } else {
                                                i22 = 2131362398;
                                            }
                                        } else {
                                            i22 = 2131362301;
                                        }
                                    } else {
                                        i22 = 2131362023;
                                    }
                                } else {
                                    i22 = 2131362022;
                                }
                            } else {
                                i22 = 2131361929;
                            }
                        } else {
                            i22 = 2131361917;
                        }
                    }
                }
                m7.c.o("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i22)));
                return;
            case 12:
                PlayerManager playerManager = playerActivity.F;
                if (playerManager == null) {
                    b8.i.d("playerManager");
                    throw null;
                }
                List<PlayerManager.SubtitleTrack> subtitleTracks = playerManager.getSubtitleTracks();
                View inflate2 = playerActivity.getLayoutInflater().inflate(2131558457, (ViewGroup) null);
                RecyclerView recyclerView = (RecyclerView) inflate2.findViewById(2131362323);
                View findViewById = inflate2.findViewById(2131362447);
                if (subtitleTracks.isEmpty()) {
                    findViewById.setVisibility(0);
                    recyclerView.setVisibility(8);
                    return;
                } else {
                    findViewById.setVisibility(8);
                    recyclerView.setVisibility(0);
                    recyclerView.setLayoutManager(new LinearLayoutManager(1));
                    recyclerView.setAdapter(new j7.t(subtitleTracks, new a3(playerActivity, new k5.b(playerActivity, 0).n(inflate2).h(), i11)));
                    return;
                }
            default:
                PlayerManager playerManager2 = playerActivity.F;
                if (playerManager2 == null) {
                    b8.i.d("playerManager");
                    throw null;
                }
                List<PlayerManager.AudioTrack> audioTracks = playerManager2.getAudioTracks();
                View inflate3 = playerActivity.getLayoutInflater().inflate(2131558457, (ViewGroup) null);
                RecyclerView recyclerView2 = (RecyclerView) inflate3.findViewById(2131362323);
                View findViewById2 = inflate3.findViewById(2131362447);
                TextView textView2 = (TextView) inflate3.findViewById(2131362460);
                if (textView2 != null) {
                    textView2.setText("Seleccionar Audio");
                }
                if (audioTracks.isEmpty()) {
                    findViewById2.setVisibility(0);
                    recyclerView2.setVisibility(8);
                    return;
                } else {
                    findViewById2.setVisibility(8);
                    recyclerView2.setVisibility(0);
                    recyclerView2.setLayoutManager(new LinearLayoutManager(1));
                    recyclerView2.setAdapter(new j7.b(audioTracks, new a3(playerActivity, new k5.b(playerActivity, 0).n(inflate3).h(), i10)));
                    return;
                }
        }
    }
}
