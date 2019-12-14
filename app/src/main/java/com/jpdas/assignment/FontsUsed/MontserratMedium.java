package com.jpdas.assignment.FontsUsed;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MontserratMedium extends androidx.appcompat.widget.AppCompatTextView {
    public MontserratMedium(Context context) {
        super(context);
        init();
    }

    public MontserratMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Medium.ttf");
        setTypeface(tf, 1);

    }
}
