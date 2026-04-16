package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.fragment.app.g;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import n.a3;
import n.b3;
import n.c2;
import n.c3;
import n.d2;
import n.d3;
import n.e3;
import n.f3;
import n.g3;
import n.i3;
import n.n;
import n.o0;
import n.x2;
import n.y2;
import n.z2;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class SearchView extends c2 implements l.b {

    /* renamed from: o0, reason: collision with root package name */
    public static final e3 f453o0;
    public final View A;
    public final ImageView B;
    public final ImageView C;
    public final ImageView D;
    public final ImageView E;
    public final View F;
    public g3 G;
    public final Rect H;
    public final Rect I;
    public final int[] J;
    public final int[] K;
    public final ImageView L;
    public final Drawable M;
    public final int N;
    public final int O;
    public final Intent P;
    public final Intent Q;
    public final CharSequence R;
    public View.OnFocusChangeListener S;
    public View.OnClickListener T;
    public boolean U;
    public boolean V;
    public s0.b W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f454a0;

    /* renamed from: b0, reason: collision with root package name */
    public CharSequence f455b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f456c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f457d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f458e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f459f0;

    /* renamed from: g0, reason: collision with root package name */
    public CharSequence f460g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f461h0;
    public int i0;

    /* renamed from: j0, reason: collision with root package name */
    public SearchableInfo f462j0;

    /* renamed from: k0, reason: collision with root package name */
    public Bundle f463k0;

    /* renamed from: l0, reason: collision with root package name */
    public final y2 f464l0;

    /* renamed from: m0, reason: collision with root package name */
    public final y2 f465m0;

    /* renamed from: n0, reason: collision with root package name */
    public final WeakHashMap f466n0;

    /* renamed from: x, reason: collision with root package name */
    public final SearchAutoComplete f467x;

    /* renamed from: y, reason: collision with root package name */
    public final View f468y;

    /* renamed from: z, reason: collision with root package name */
    public final View f469z;

    static {
        e3 e3Var = null;
        if (Build.VERSION.SDK_INT < 29) {
            e3 e3Var2 = new e3();
            e3Var2.f6857a = null;
            e3Var2.f6858b = null;
            e3Var2.f6859c = null;
            e3.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                e3Var2.f6857a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                e3Var2.f6858b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                e3Var2.f6859c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            e3Var = e3Var2;
        }
        f453o0 = e3Var;
    }

    public SearchView(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        this.H = new Rect();
        this.I = new Rect();
        this.J = new int[2];
        this.K = new int[2];
        this.f464l0 = new y2(this, 0);
        this.f465m0 = new y2(this, 1);
        this.f466n0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        a3 a3Var = new a3(this);
        o0 o0Var = new o0(this, 1);
        d2 d2Var = new d2(this, 1);
        x2 x2Var = new x2(this, 0);
        int[] iArr = f.a.f3185u;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i9, 0);
        g gVar = new g(context, obtainStyledAttributes);
        t0.o(this, context, iArr, attributeSet, obtainStyledAttributes, i9);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(19, 2131558425), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(2131362353);
        this.f467x = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f468y = findViewById(2131362349);
        View findViewById = findViewById(2131362352);
        this.f469z = findViewById;
        View findViewById2 = findViewById(2131362394);
        this.A = findViewById2;
        ImageView imageView = (ImageView) findViewById(2131362347);
        this.B = imageView;
        ImageView imageView2 = (ImageView) findViewById(2131362350);
        this.C = imageView2;
        ImageView imageView3 = (ImageView) findViewById(2131362348);
        this.D = imageView3;
        ImageView imageView4 = (ImageView) findViewById(2131362354);
        this.E = imageView4;
        ImageView imageView5 = (ImageView) findViewById(2131362351);
        this.L = imageView5;
        c0.q(findViewById, gVar.Q(20));
        c0.q(findViewById2, gVar.Q(25));
        imageView.setImageDrawable(gVar.Q(23));
        imageView2.setImageDrawable(gVar.Q(15));
        imageView3.setImageDrawable(gVar.Q(12));
        imageView4.setImageDrawable(gVar.Q(28));
        imageView5.setImageDrawable(gVar.Q(23));
        this.M = gVar.Q(22);
        a.a.O(imageView, getResources().getString(2131951637));
        this.N = obtainStyledAttributes.getResourceId(26, 2131558424);
        this.O = obtainStyledAttributes.getResourceId(13, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(x2Var);
        searchAutoComplete.setOnEditorActionListener(a3Var);
        searchAutoComplete.setOnItemClickListener(o0Var);
        searchAutoComplete.setOnItemSelectedListener(d2Var);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new z2(this));
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(18, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.R = obtainStyledAttributes.getText(14);
        this.f455b0 = obtainStyledAttributes.getText(21);
        int i10 = obtainStyledAttributes.getInt(6, -1);
        if (i10 != -1) {
            setImeOptions(i10);
        }
        int i11 = obtainStyledAttributes.getInt(5, -1);
        if (i11 != -1) {
            setInputType(i11);
        }
        setFocusable(obtainStyledAttributes.getBoolean(1, true));
        gVar.i0();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.P = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.Q = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.F = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new c5.a(this, 1));
        }
        w(this.U);
        t();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(2131165238);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(2131165239);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f467x;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f457d0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f467x;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f457d0 = false;
    }

    public int getImeOptions() {
        return this.f467x.getImeOptions();
    }

    public int getInputType() {
        return this.f467x.getInputType();
    }

    public int getMaxWidth() {
        return this.f458e0;
    }

    public CharSequence getQuery() {
        return this.f467x.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f455b0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f462j0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.R : getContext().getText(this.f462j0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.O;
    }

    public int getSuggestionRowLayout() {
        return this.N;
    }

    public s0.b getSuggestionsAdapter() {
        return this.W;
    }

    public final Intent j(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f460g0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f463k0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f462j0.getSearchActivity());
        return intent;
    }

    public final Intent k(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f463k0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void l() {
        int i9 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f467x;
        if (i9 >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        e3 e3Var = f453o0;
        e3Var.getClass();
        e3.a();
        Method method = e3Var.f6857a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        e3Var.getClass();
        e3.a();
        Method method2 = e3Var.f6858b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void m() {
        SearchAutoComplete searchAutoComplete = this.f467x;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.U) {
            clearFocus();
            w(true);
        }
    }

    public final void n(int i9) {
        int i10;
        String h;
        Cursor cursor = this.W.f8661k;
        if (cursor != null && cursor.moveToPosition(i9)) {
            Intent intent = null;
            try {
                int i11 = i3.F;
                String h9 = i3.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (h9 == null) {
                    h9 = this.f462j0.getSuggestIntentAction();
                }
                if (h9 == null) {
                    h9 = "android.intent.action.SEARCH";
                }
                String h10 = i3.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (h10 == null) {
                    h10 = this.f462j0.getSuggestIntentData();
                }
                if (h10 != null && (h = i3.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    h10 = h10 + "/" + Uri.encode(h);
                }
                intent = j(h9, h10 == null ? null : Uri.parse(h10), i3.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), i3.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e9) {
                try {
                    i10 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i10 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + i10 + " returned exception.", e9);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e10) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e10);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f467x;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void o(int i9) {
        Editable text = this.f467x.getText();
        Cursor cursor = this.W.f8661k;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i9)) {
            setQuery(text);
            return;
        }
        String c9 = this.W.c(cursor);
        if (c9 != null) {
            setQuery(c9);
        } else {
            setQuery(text);
        }
    }

    @Override // l.b
    public final void onActionViewCollapsed() {
        SearchAutoComplete searchAutoComplete = this.f467x;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f460g0 = "";
        clearFocus();
        w(true);
        searchAutoComplete.setImeOptions(this.i0);
        this.f461h0 = false;
    }

    @Override // l.b
    public final void onActionViewExpanded() {
        if (this.f461h0) {
            return;
        }
        this.f461h0 = true;
        SearchAutoComplete searchAutoComplete = this.f467x;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.i0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f464l0);
        post(this.f465m0);
        super.onDetachedFromWindow();
    }

    @Override // n.c2, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        if (z8) {
            SearchAutoComplete searchAutoComplete = this.f467x;
            int[] iArr = this.J;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.K;
            getLocationInWindow(iArr2);
            int i13 = iArr[1] - iArr2[1];
            int i14 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i14;
            int height = searchAutoComplete.getHeight() + i13;
            Rect rect = this.H;
            rect.set(i14, i13, width, height);
            int i15 = rect.left;
            int i16 = rect.right;
            int i17 = i12 - i10;
            Rect rect2 = this.I;
            rect2.set(i15, 0, i16, i17);
            g3 g3Var = this.G;
            if (g3Var == null) {
                g3 g3Var2 = new g3(rect2, rect, searchAutoComplete);
                this.G = g3Var2;
                setTouchDelegate(g3Var2);
            } else {
                g3Var.f6870b.set(rect2);
                Rect rect3 = g3Var.f6872d;
                rect3.set(rect2);
                int i18 = -g3Var.f6873e;
                rect3.inset(i18, i18);
                g3Var.f6871c.set(rect);
            }
        }
    }

    @Override // n.c2, android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        if (this.V) {
            super.onMeasure(i9, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        if (mode == Integer.MIN_VALUE) {
            int i12 = this.f458e0;
            size = i12 > 0 ? Math.min(i12, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f458e0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i11 = this.f458e0) > 0) {
            size = Math.min(i11, size);
        }
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f3 f3Var = (f3) parcelable;
        super.onRestoreInstanceState(f3Var.f8991i);
        w(f3Var.f6862k);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        f3 f3Var = new f3(super.onSaveInstanceState());
        f3Var.f6862k = this.V;
        return f3Var;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z8) {
        super.onWindowFocusChanged(z8);
        post(this.f464l0);
    }

    public final void p(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void q() {
        SearchAutoComplete searchAutoComplete = this.f467x;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f462j0 != null) {
            getContext().startActivity(j("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void r() {
        boolean isEmpty = TextUtils.isEmpty(this.f467x.getText());
        int i9 = (!isEmpty || (this.U && !this.f461h0)) ? 0 : 8;
        ImageView imageView = this.D;
        imageView.setVisibility(i9);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!isEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i9, Rect rect) {
        if (this.f457d0 || !isFocusable()) {
            return false;
        }
        if (this.V) {
            return super.requestFocus(i9, rect);
        }
        boolean requestFocus = this.f467x.requestFocus(i9, rect);
        if (requestFocus) {
            w(false);
        }
        return requestFocus;
    }

    public final void s() {
        int[] iArr = this.f467x.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f469z.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.A.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public void setAppSearchData(Bundle bundle) {
        this.f463k0 = bundle;
    }

    public void setIconified(boolean z8) {
        if (z8) {
            m();
            return;
        }
        w(false);
        SearchAutoComplete searchAutoComplete = this.f467x;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.T;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z8) {
        if (this.U == z8) {
            return;
        }
        this.U = z8;
        w(z8);
        t();
    }

    public void setImeOptions(int i9) {
        this.f467x.setImeOptions(i9);
    }

    public void setInputType(int i9) {
        this.f467x.setInputType(i9);
    }

    public void setMaxWidth(int i9) {
        this.f458e0 = i9;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.S = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.T = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f455b0 = charSequence;
        t();
    }

    public void setQueryRefinementEnabled(boolean z8) {
        this.f456c0 = z8;
        s0.b bVar = this.W;
        if (bVar instanceof i3) {
            ((i3) bVar).f6901x = z8 ? 2 : 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
    
        if (getContext().getPackageManager().resolveActivity(r0, 65536) != null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f462j0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.f467x
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.f462j0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.f462j0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f462j0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            s0.b r7 = r6.W
            if (r7 == 0) goto L3b
            r7.b(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.f462j0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            n.i3 r7 = new n.i3
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f462j0
            java.util.WeakHashMap r5 = r6.f466n0
            r7.<init>(r3, r6, r4, r5)
            r6.W = r7
            r2.setAdapter(r7)
            s0.b r7 = r6.W
            n.i3 r7 = (n.i3) r7
            boolean r3 = r6.f456c0
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = 1
        L60:
            r7.f6901x = r3
        L62:
            r6.t()
        L65:
            android.app.SearchableInfo r7 = r6.f462j0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.f462j0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.P
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.f462j0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.Q
        L85:
            if (r0 == 0) goto L98
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r4 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r4)
            if (r7 == 0) goto L98
            goto L99
        L98:
            r1 = 0
        L99:
            r6.f459f0 = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.V
            r6.w(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z8) {
        this.f454a0 = z8;
        w(this.V);
    }

    public void setSuggestionsAdapter(s0.b bVar) {
        this.W = bVar;
        this.f467x.setAdapter(bVar);
    }

    public final void t() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z8 = this.U;
        SearchAutoComplete searchAutoComplete = this.f467x;
        if (z8 && (drawable = this.M) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void u() {
        this.A.setVisibility(((this.f454a0 || this.f459f0) && !this.V && (this.C.getVisibility() == 0 || this.E.getVisibility() == 0)) ? 0 : 8);
    }

    public final void v(boolean z8) {
        boolean z9 = this.f454a0;
        this.C.setVisibility((!z9 || !(z9 || this.f459f0) || this.V || !hasFocus() || (!z8 && this.f459f0)) ? 8 : 0);
    }

    public final void w(boolean z8) {
        this.V = z8;
        int i9 = 8;
        int i10 = z8 ? 0 : 8;
        boolean isEmpty = TextUtils.isEmpty(this.f467x.getText());
        this.B.setVisibility(i10);
        v(!isEmpty);
        this.f468y.setVisibility(z8 ? 8 : 0);
        ImageView imageView = this.L;
        imageView.setVisibility((imageView.getDrawable() == null || this.U) ? 8 : 0);
        r();
        if (this.f459f0 && !this.V && isEmpty) {
            this.C.setVisibility(8);
            i9 = 0;
        }
        this.E.setVisibility(i9);
        u();
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class SearchAutoComplete extends n {

        /* renamed from: m, reason: collision with root package name */
        public int f470m;

        /* renamed from: n, reason: collision with root package name */
        public SearchView f471n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f472o;

        /* renamed from: p, reason: collision with root package name */
        public final d f473p;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f473p = new d(this);
            this.f470m = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i9 = configuration.screenWidthDp;
            int i10 = configuration.screenHeightDp;
            if (i9 >= 960 && i10 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i9 < 600) {
                return (i9 < 640 || i10 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            e3 e3Var = SearchView.f453o0;
            e3Var.getClass();
            e3.a();
            Method method = e3Var.f6859c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f470m <= 0 || super.enoughToFilter();
        }

        @Override // n.n, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f472o) {
                d dVar = this.f473p;
                removeCallbacks(dVar);
                post(dVar);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z8, int i9, Rect rect) {
            super.onFocusChanged(z8, i9, rect);
            SearchView searchView = this.f471n;
            searchView.w(searchView.V);
            searchView.post(searchView.f464l0);
            if (searchView.f467x.hasFocus()) {
                searchView.l();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i9, KeyEvent keyEvent) {
            if (i9 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f471n.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i9, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z8) {
            super.onWindowFocusChanged(z8);
            if (z8 && this.f471n.hasFocus() && getVisibility() == 0) {
                this.f472o = true;
                Context context = getContext();
                e3 e3Var = SearchView.f453o0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        public void setImeVisibility(boolean z8) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.f473p;
            if (!z8) {
                this.f472o = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f472o = true;
                    return;
                }
                this.f472o = false;
                removeCallbacks(dVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f471n = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i9) {
            super.setThreshold(i9);
            this.f470m = i9;
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }
    }

    public void setOnCloseListener(b3 b3Var) {
    }

    public void setOnQueryTextListener(c3 c3Var) {
    }

    public void setOnSuggestionListener(d3 d3Var) {
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130969475);
    }

    public SearchView(Context context) {
        this(context, null);
    }
}
