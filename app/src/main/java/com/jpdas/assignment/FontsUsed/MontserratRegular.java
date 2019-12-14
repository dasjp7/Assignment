package com.jpdas.assignment.FontsUsed;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MontserratRegular extends androidx.appcompat.widget.AppCompatTextView {
    public MontserratRegular(Context context) {
        super(context);
        init();
    }

    public MontserratRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Regular.ttf");
        setTypeface(tf, 1);

    }
}
