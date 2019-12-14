package com.jpdas.assignment.FontsUsed;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MontserratExtraBold extends androidx.appcompat.widget.AppCompatTextView {
    public MontserratExtraBold(Context context) {
        super(context);
        init();
    }

    public MontserratExtraBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratExtraBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-ExtraBold.ttf");
        setTypeface(tf, 1);

    }

}
