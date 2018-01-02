package vn.edu.hust.lazadaapp.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

import vn.edu.hust.lazadaapp.R;


public class ClearEditText extends AppCompatEditText {
    Drawable crossx, nonecrossx, drawable;
    Boolean visible = false;

    public ClearEditText(Context context) {
        super(context);
        khoitao();
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        khoitao();
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        khoitao();
    }


    private void khoitao() {
        crossx = ContextCompat.getDrawable(getContext(), R.drawable.ic_close_black_24dp).mutate();
        nonecrossx = ContextCompat.getDrawable(getContext(), android.R.drawable.screen_background_light_transparent).mutate();

        cauhinh();
    }

    private void cauhinh() {
        setInputType(InputType.TYPE_CLASS_TEXT);
        Drawable[] drawables = getCompoundDrawables();
        drawable = visible ? crossx : nonecrossx;
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawable, drawables[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction() && event.getX() >= (getRight() - drawable.getBounds().width())) {
            setText("");
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);

        if (lengthAfter == 0 && start == 0) {
            visible = false;
            cauhinh();
        } else {
            visible = true;
            cauhinh();
        }

    }
}