package com.example.submissionmoviecatalogue;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailMovie extends AppCompatActivity {

    /* Inisiasi String pada class MoveWithObjectActivity */
    public static final String EXTRA_MovieParcelable = "MovieParcelable";
    TextView tvObject;
    ImageView ivObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_film);

        tvObject = findViewById(R.id.title_movie);
        ivObject = findViewById(R.id.img_movie);

        MovieParcelable movieParcelable = getIntent().getParcelableExtra(EXTRA_MovieParcelable);
        String text = movieParcelable.getTitle_movie();
        Integer img = movieParcelable.getImg_movie();
        tvObject.setText(text);
        ivObject.setImageResource(img);
    }
}
