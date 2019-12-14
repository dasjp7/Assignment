package com.jpdas.assignment.FontsUsed;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MontserratBlack extends androidx.appcompat.widget.AppCompatTextView {
    public MontserratBlack(Context context) {
        super(context);
        init();
    }

    public MontserratBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratBlack(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Black.ttf");
        setTypeface(tf ,1);

    }
}
