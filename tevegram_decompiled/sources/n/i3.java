package n;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i3 extends s0.b implements View.OnClickListener {
    public static final /* synthetic */ int F = 0;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;

    /* renamed from: p, reason: collision with root package name */
    public final int f6893p;

    /* renamed from: q, reason: collision with root package name */
    public final int f6894q;

    /* renamed from: r, reason: collision with root package name */
    public final LayoutInflater f6895r;

    /* renamed from: s, reason: collision with root package name */
    public final SearchView f6896s;

    /* renamed from: t, reason: collision with root package name */
    public final SearchableInfo f6897t;

    /* renamed from: u, reason: collision with root package name */
    public final Context f6898u;

    /* renamed from: v, reason: collision with root package name */
    public final WeakHashMap f6899v;

    /* renamed from: w, reason: collision with root package name */
    public final int f6900w;

    /* renamed from: x, reason: collision with root package name */
    public int f6901x;

    /* renamed from: y, reason: collision with root package name */
    public ColorStateList f6902y;

    /* renamed from: z, reason: collision with root package name */
    public int f6903z;

    public i3(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f8660j = true;
        this.f8661k = null;
        this.f8659i = false;
        this.f8662l = -1;
        this.f8663m = new s0.a(this);
        this.f8664n = new h2(this, 1);
        this.f6894q = suggestionRowLayout;
        this.f6893p = suggestionRowLayout;
        this.f6895r = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f6901x = 1;
        this.f6903z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.f6896s = searchView;
        this.f6897t = searchableInfo;
        this.f6900w = searchView.getSuggestionCommitIconResId();
        this.f6898u = context;
        this.f6899v = weakHashMap;
    }

    public static String h(Cursor cursor, int i9) {
        if (i9 == -1) {
            return null;
        }
        try {
            return cursor.getString(i9);
        } catch (Exception e9) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e9);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    @Override // s0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.View r21, android.database.Cursor r22) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.i3.a(android.view.View, android.database.Cursor):void");
    }

    @Override // s0.b
    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f6903z = cursor.getColumnIndex("suggest_text_1");
                this.A = cursor.getColumnIndex("suggest_text_2");
                this.B = cursor.getColumnIndex("suggest_text_2_url");
                this.C = cursor.getColumnIndex("suggest_icon_1");
                this.D = cursor.getColumnIndex("suggest_icon_2");
                this.E = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e9) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e9);
        }
    }

    @Override // s0.b
    public final String c(Cursor cursor) {
        String h;
        String h9;
        if (cursor == null) {
            return null;
        }
        String h10 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (h10 != null) {
            return h10;
        }
        SearchableInfo searchableInfo = this.f6897t;
        if (searchableInfo.shouldRewriteQueryFromData() && (h9 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return h9;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (h = h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return h;
    }

    @Override // s0.b
    public final View d(ViewGroup viewGroup) {
        View inflate = this.f6895r.inflate(this.f6893p, viewGroup, false);
        inflate.setTag(new h3(inflate));
        ((ImageView) inflate.findViewById(2131362029)).setImageResource(this.f6900w);
        return inflate;
    }

    public final Drawable e(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            m7.c.g(uri, "No authority: ");
            return null;
        }
        try {
            Resources resourcesForApplication = this.f6898u.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                m7.c.g(uri, "No path: ");
                return null;
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    m7.c.g(uri, "Single path segment is not a resource ID: ");
                    return null;
                }
            } else {
                if (size != 2) {
                    m7.c.g(uri, "More than two path segments: ");
                    return null;
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            m7.c.g(uri, "No resource found for: ");
            return null;
        } catch (PackageManager.NameNotFoundException unused2) {
            m7.c.g(uri, "No package found for authority: ");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable f(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.i3.f(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor g(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f6898u.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // s0.b, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i9, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i9, view, viewGroup);
        } catch (RuntimeException e9) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e9);
            View inflate = this.f6895r.inflate(this.f6894q, viewGroup, false);
            if (inflate != null) {
                ((h3) inflate.getTag()).f6884a.setText(e9.toString());
            }
            return inflate;
        }
    }

    @Override // s0.b, android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i9, view, viewGroup);
        } catch (RuntimeException e9) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e9);
            View d9 = d(viewGroup);
            ((h3) d9.getTag()).f6884a.setText(e9.toString());
            return d9;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.f8661k;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f8661k;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f6896s.p((CharSequence) tag);
        }
    }
}
