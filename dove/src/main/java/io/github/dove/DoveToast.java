package io.github.dove;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

public class DoveToast {

    private Context context;
    private String message;
    private Drawable icon;
    private int duration = Dove.DOVE_LENGTH_LONG;
    private int cardBackColor = Color.WHITE;

    public DoveToast(Context context) {
        this.context = context;
    }

    public DoveToast setMessage(String message) {
        this.message = message;
        return this;
    }

    public DoveToast setMessage(int messageRes) {
        setMessage(context.getResources().getString(messageRes));
        return this;
    }

    public DoveToast setIcon(Drawable icon) {
        this.icon = icon;
        return this;
    }

    public DoveToast setIcon(int iconRes) {
        setIcon(context.getResources().getDrawable(iconRes));
        return this;
    }

    public DoveToast setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public DoveToast setBackgroundColor(int cardBackColor) {
        this.cardBackColor = cardBackColor;
        return this;
    }

    public void show() {
        Toast toast = getToast(context, icon);
        toast.show();
    }

    public static DoveToast makeText(Context context, String message, Drawable icon, int duration) {
        return new DoveToast(context)
                .setMessage(message)
                .setIcon(icon)
                .setBackgroundColor(Color.WHITE)
                .setDuration(duration);
    }

    public static DoveToast makeText(Context context, String message, int duration) {
        return makeText(context, message, null, duration);
    }

    public static DoveToast makeText(Context context, int messageId, int duration) {
        return makeText(context, context.getResources().getString(messageId), null, duration);
    }

    public static DoveToast makeText(Context context, int messageId, Drawable icon, int duration) {
        return makeText(context, context.getResources().getString(messageId), icon, duration);
    }

    public static DoveToast makeText(Context context, String message, int iconId, int duration) {
        return makeText(context, message, context.getResources().getDrawable(iconId), duration);
    }

    public static DoveToast makeText(Context context, int messageId, int iconId, int duration) {
        return makeText(context, context.getResources().getString(messageId),
                context.getResources().getDrawable(iconId), duration);
    }

    private Toast getToast(Context context, Drawable icon) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater == null) {
            return null;
        }
        Toast toast = new Toast(context);

        View view = inflater.inflate(R.layout.dove_layout, null);
        CardView cardView = view.findViewById(R.id.card_view);
        cardView.setCardBackgroundColor(cardBackColor);
        AppCompatTextView textView = view.findViewById(android.R.id.message);

        textView.setTypeface(Typeface.create("sans-serif-condensed", Typeface.NORMAL));

        if (message != null) {
            textView.setText(message);
        }
        textView.setTextColor(Color.WHITE);

        toast.setView(view);

        if (icon != null) {
            AppCompatImageView iconIV = view.findViewById(R.id.icon);
            iconIV.setVisibility(View.VISIBLE);
            iconIV.setImageDrawable(icon);
        }

        toast.setDuration(duration);

        return toast;
    }

}
