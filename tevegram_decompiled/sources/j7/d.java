package j7;

import android.R;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import i7.u;
import java.io.File;
import java.util.List;
import java.util.Set;
import o3.d1;
import o3.g0;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends g0 {

    /* renamed from: d, reason: collision with root package name */
    public final Set f5443d;

    /* renamed from: e, reason: collision with root package name */
    public final i7.a f5444e;

    /* renamed from: f, reason: collision with root package name */
    public List f5445f;

    public d(Set set, i7.a aVar) {
        set.getClass();
        this.f5443d = set;
        this.f5444e = aVar;
        this.f5445f = o7.p.f8013i;
    }

    @Override // o3.g0
    public final int a() {
        return this.f5445f.size();
    }

    @Override // o3.g0
    public final void d(d1 d1Var, int i9) {
        TdApi.File file;
        TdApi.LocalFile localFile;
        c cVar = (c) d1Var;
        ImageView imageView = cVar.f5442w;
        Object obj = this.f5445f.get(i9);
        obj.getClass();
        TdApi.Chat chat = (TdApi.Chat) obj;
        cVar.f5440u.setText(chat.title);
        cVar.f5441v.setChecked(this.f5443d.contains(Long.valueOf(chat.id)));
        cVar.f7618a.setOnClickListener(new u(cVar, this, chat, 3));
        TdApi.ChatPhotoInfo chatPhotoInfo = chat.photo;
        String str = (chatPhotoInfo == null || (file = chatPhotoInfo.small) == null || (localFile = file.local) == null) ? null : localFile.path;
        if (str == null || str.length() == 0) {
            imageView.setImageResource(R.drawable.ic_menu_slideshow);
        } else {
            imageView.setImageURI(Uri.fromFile(new File(str)));
        }
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558470, viewGroup, false);
        inflate.getClass();
        return new c(inflate);
    }
}
