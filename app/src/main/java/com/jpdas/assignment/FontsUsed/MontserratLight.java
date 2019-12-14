package com.jpdas.assignment.FontsUsed;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MontserratLight extends androidx.appcompat.widget.AppCompatTextView {
    public MontserratLight(Context context) {
        super(context);
        init();
    }

    public MontserratLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Light.ttf");
        setTypeface(tf, 1);

    }
}
