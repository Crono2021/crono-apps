package g;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import i7.e1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final f f3568a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3569b;

    public j(Context context, int i9) {
        this.f3568a = new f(new ContextThemeWrapper(context, k.h(context, i9)));
        this.f3569b = i9;
    }

    public j a() {
        this.f3568a.f3517m = false;
        return this;
    }

    public j b(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        f fVar = this.f3568a;
        fVar.f3520p = charSequenceArr;
        fVar.f3522r = onClickListener;
        return this;
    }

    public j c(String str) {
        this.f3568a.f3511f = str;
        return this;
    }

    public k create() {
        ListAdapter listAdapter;
        f fVar = this.f3568a;
        ContextThemeWrapper contextThemeWrapper = fVar.f3506a;
        ContextThemeWrapper contextThemeWrapper2 = fVar.f3506a;
        k kVar = new k(contextThemeWrapper, this.f3569b);
        View view = fVar.f3510e;
        i iVar = kVar.f3576n;
        if (view != null) {
            iVar.f3560w = view;
        } else {
            CharSequence charSequence = fVar.f3509d;
            if (charSequence != null) {
                iVar.f3542d = charSequence;
                TextView textView = iVar.f3558u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = fVar.f3508c;
            if (drawable != null) {
                iVar.f3556s = drawable;
                ImageView imageView = iVar.f3557t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    iVar.f3557t.setImageDrawable(drawable);
                }
            }
        }
        String str = fVar.f3511f;
        if (str != null) {
            iVar.f3543e = str;
            TextView textView2 = iVar.f3559v;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
        CharSequence charSequence2 = fVar.f3512g;
        if (charSequence2 != null) {
            iVar.d(-1, charSequence2, fVar.h);
        }
        CharSequence charSequence3 = fVar.f3513i;
        if (charSequence3 != null) {
            iVar.d(-2, charSequence3, fVar.f3514j);
        }
        String str2 = fVar.f3515k;
        if (str2 != null) {
            iVar.d(-3, str2, fVar.f3516l);
        }
        if (fVar.f3520p != null || fVar.f3521q != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) fVar.f3507b.inflate(iVar.A, (ViewGroup) null);
            if (fVar.f3525u) {
                listAdapter = new c(fVar, contextThemeWrapper2, iVar.B, fVar.f3520p, alertController$RecycleListView);
            } else {
                int i9 = fVar.f3526v ? iVar.C : iVar.D;
                ListAdapter listAdapter2 = fVar.f3521q;
                if (listAdapter2 == null) {
                    listAdapter2 = new h(contextThemeWrapper2, i9, R.id.text1, fVar.f3520p);
                }
                listAdapter = listAdapter2;
            }
            iVar.f3561x = listAdapter;
            iVar.f3562y = fVar.f3527w;
            if (fVar.f3522r != null) {
                alertController$RecycleListView.setOnItemClickListener(new d(fVar, iVar));
            } else if (fVar.f3528x != null) {
                alertController$RecycleListView.setOnItemClickListener(new e(fVar, alertController$RecycleListView, iVar));
            }
            if (fVar.f3526v) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (fVar.f3525u) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            iVar.f3544f = alertController$RecycleListView;
        }
        View view2 = fVar.f3523s;
        if (view2 != null) {
            iVar.f3545g = view2;
            iVar.h = false;
        }
        kVar.setCancelable(fVar.f3517m);
        if (fVar.f3517m) {
            kVar.setCanceledOnTouchOutside(true);
        }
        kVar.setOnCancelListener(fVar.f3518n);
        kVar.setOnDismissListener(null);
        m.n nVar = fVar.f3519o;
        if (nVar != null) {
            kVar.setOnKeyListener(nVar);
        }
        return kVar;
    }

    public j d(String str, DialogInterface.OnClickListener onClickListener) {
        f fVar = this.f3568a;
        fVar.f3513i = str;
        fVar.f3514j = onClickListener;
        return this;
    }

    public j e(String str, DialogInterface.OnClickListener onClickListener) {
        f fVar = this.f3568a;
        fVar.f3515k = str;
        fVar.f3516l = onClickListener;
        return this;
    }

    public j f(e1 e1Var) {
        this.f3568a.f3518n = e1Var;
        return this;
    }

    public j g(String str, DialogInterface.OnClickListener onClickListener) {
        f fVar = this.f3568a;
        fVar.f3512g = str;
        fVar.h = onClickListener;
        return this;
    }

    public Context getContext() {
        return this.f3568a.f3506a;
    }

    public final k h() {
        k create = create();
        create.show();
        return create;
    }

    public j setNegativeButton(int i9, DialogInterface.OnClickListener onClickListener) {
        f fVar = this.f3568a;
        fVar.f3513i = fVar.f3506a.getText(i9);
        fVar.f3514j = onClickListener;
        return this;
    }

    public j setPositiveButton(int i9, DialogInterface.OnClickListener onClickListener) {
        f fVar = this.f3568a;
        fVar.f3512g = fVar.f3506a.getText(i9);
        fVar.h = onClickListener;
        return this;
    }

    public j setTitle(CharSequence charSequence) {
        this.f3568a.f3509d = charSequence;
        return this;
    }

    public j setView(View view) {
        this.f3568a.f3523s = view;
        return this;
    }

    public j(Context context) {
        this(context, k.h(context, 0));
    }
}
