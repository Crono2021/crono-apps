package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f2189y = 0;

    /* renamed from: x, reason: collision with root package name */
    public final Chip f2190x;

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        g gVar = new g();
        LayoutInflater.from(context).inflate(2131558499, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(2131362184);
        materialButtonToggleGroup.f1967k.add(new f());
        Chip chip = (Chip) findViewById(2131362189);
        Chip chip2 = (Chip) findViewById(2131362186);
        this.f2190x = chip2;
        i iVar = new i(new GestureDetector(getContext(), new h()));
        chip.setOnTouchListener(iVar);
        chip2.setOnTouchListener(iVar);
        chip.setTag(2131362357, 12);
        chip2.setTag(2131362357, 10);
        chip.setOnClickListener(gVar);
        chip2.setOnClickListener(gVar);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i9) {
        super.onVisibilityChanged(view, i9);
        if (view == this && i9 == 0) {
            this.f2190x.sendAccessibilityEvent(8);
        }
    }
}
