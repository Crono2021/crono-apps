package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import n0.d0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: i, reason: collision with root package name */
    public final Chip f2174i;

    /* renamed from: j, reason: collision with root package name */
    public final EditText f2175j;

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LocaleList locales;
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(2131558497, (ViewGroup) this, false);
        this.f2174i = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(2131558498, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.f2175j = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new a(this));
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            editText.setImeHintLocales(locales);
        }
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(2131362187);
        WeakHashMap weakHashMap = t0.f7209a;
        editText.setId(d0.a());
        d0.h(textView, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    public static String a(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        try {
            return String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f2174i.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        LocaleList locales;
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.f2175j.setImeHintLocales(locales);
        }
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z8) {
        Chip chip = this.f2174i;
        chip.setChecked(z8);
        int i9 = z8 ? 0 : 4;
        EditText editText = this.f2175j;
        editText.setVisibility(i9);
        chip.setVisibility(z8 ? 8 : 0);
        if (chip.isChecked()) {
            editText.requestFocus();
            editText.post(new a7.a(editText, 19));
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2174i.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i9, Object obj) {
        this.f2174i.setTag(i9, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f2174i.toggle();
    }
}
