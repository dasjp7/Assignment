package com.jpdas.assignment.FontsUsed;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MontserratSemiBold extends androidx.appcompat.widget.AppCompatTextView  {
    public MontserratSemiBold(Context context) {
        super(context);
        init();
    }

    public MontserratSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratSemiBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-SemiBold.ttf");
        setTypeface(tf, 1);

    }
}
