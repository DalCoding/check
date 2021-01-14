package org.techtown.te1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button result_txt;
    Button btn, btn_no ,btn_ok;
    RatingBar rating;
    Dialog dialog;


    float num;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_road_page);
        Dialog dialog = new Dialog(this);

        result_txt = findViewById(R.id.setReviewScoreBtn);
        btn = findViewById(R.id.setReviewScoreBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setCancelable(false);

                dialog.setContentView(R.layout.dtr_rating);

                rating = dialog.findViewById(R.id.rating);
                btn_ok = dialog.findViewById(R.id.rating_ok);
                btn_no = dialog.findViewById(R.id.rating_no);


                rating.setIsIndicator(false);

                rating.setStepSize(0.5f);

                rating.setOnRatingBarChangeListener(ratClick);

                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getApplicationContext(), num + "점 ",Toast.LENGTH_SHORT).show();

                        dialog.dismiss();

                    }
                });
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                    }
                });


                dialog.show();

            }
        });
    }// onCreate()


    RatingBar.OnRatingBarChangeListener ratClick = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float r, boolean b) {
            num = r;
            float st = 5.0f / rating.getNumStars();

            String str = String.format("%.1f", st * r);

            result_txt.setText(str + "점");
        }
    };
}
