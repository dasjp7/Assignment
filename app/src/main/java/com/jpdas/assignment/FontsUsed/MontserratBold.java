package com.jpdas.assignment.FontsUsed;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MontserratBold extends androidx.appcompat.widget.AppCompatTextView {
    public MontserratBold(Context context) {
        super(context);
        init();
    }

    public MontserratBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Bold.ttf");
        setTypeface(tf, 1);

    }
}
