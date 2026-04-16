package x0;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.text.l;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f10024a;

    /* renamed from: b, reason: collision with root package name */
    public final o4.d f10025b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        o4.d dVar = new o4.d(21);
        this.f10024a = editText;
        this.f10025b = dVar;
        if (l.f624j != null) {
            l a9 = l.a();
            if (a9.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            androidx.emoji2.text.g gVar = a9.f629e;
            gVar.getClass();
            Bundle bundle = editorInfo.extras;
            w0.b bVar = (w0.b) gVar.f616c.f30i;
            int a10 = bVar.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", a10 != 0 ? ((ByteBuffer) bVar.f7134d).getInt(a10 + bVar.f7131a) : 0);
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i9, int i10) {
        Editable editableText = this.f10024a.getEditableText();
        this.f10025b.getClass();
        return o4.d.w(this, editableText, i9, i10, false) || super.deleteSurroundingText(i9, i10);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i9, int i10) {
        Editable editableText = this.f10024a.getEditableText();
        this.f10025b.getClass();
        return o4.d.w(this, editableText, i9, i10, true) || super.deleteSurroundingTextInCodePoints(i9, i10);
    }
}
