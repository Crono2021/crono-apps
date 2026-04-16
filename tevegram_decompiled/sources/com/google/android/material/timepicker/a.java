package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import o5.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends n {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ChipTextInputComboView f2191i;

    public a(ChipTextInputComboView chipTextInputComboView) {
        this.f2191i = chipTextInputComboView;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean isEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.f2191i;
        Chip chip = chipTextInputComboView.f2174i;
        if (isEmpty) {
            chip.setText(ChipTextInputComboView.a(chipTextInputComboView, "00"));
            return;
        }
        String a9 = ChipTextInputComboView.a(chipTextInputComboView, editable);
        if (TextUtils.isEmpty(a9)) {
            a9 = ChipTextInputComboView.a(chipTextInputComboView, "00");
        }
        chip.setText(a9);
    }
}
