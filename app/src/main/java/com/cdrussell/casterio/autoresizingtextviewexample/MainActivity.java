package com.cdrussell.casterio.autoresizingtextviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView shortText = findViewById(R.id.smallLength);
        final TextView mediumText = findViewById(R.id.mediumLength);
        final TextView longText = findViewById(R.id.longLength);

        //TextViewCompat.setAutoSizeTextTypeWithDefaults(shortText, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setHorizontalMargin(shortText, i);
                setHorizontalMargin(mediumText, i);
                setHorizontalMargin(longText, i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void setHorizontalMargin(View view, int margin) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        int marginPx = convertDpToPixel(margin);
        params.setMarginStart(marginPx);
        params.setMarginEnd(marginPx);
        view.setLayoutParams(params);
    }

    private int convertDpToPixel(float dp){
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        return (int) (dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
