package com.example.submissionmoviecatalogue;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailMovie extends AppCompatActivity {

    /* Inisiasi Object pada TextView & Image pada class MoveWithObjectActivity */
    public static final String EXTRA_MovieParcelable = "MovieParcelable";
    TextView tvTitle, tvOverview, tvRuntime ;
    ImageView ivImgMovie ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_film);

        /* Deklarasi Object pada TextView & Image pada class MovieParcelableAdapter */
        ivImgMovie = findViewById(R.id.img_movie);
        tvTitle = findViewById(R.id.title_movie);
        tvOverview = findViewById(R.id.overview_movie);
        tvRuntime = findViewById(R.id.runtime_movie);

        /* Grab data TextView & Image pada class MovieParcelableAdapter */
        MovieParcelable movieParcelable = getIntent().getParcelableExtra(EXTRA_MovieParcelable);
        Integer img_movie = movieParcelable.getImg_movie();
        String title_movie = movieParcelable.getTitle_movie();
        String overview_movie = movieParcelable.getOverview_movie();
        String runtime_movie = movieParcelable.getRuntime_movie();


        ivImgMovie.setImageResource(img_movie);
        tvTitle.setText(title_movie);
        tvOverview.setText(overview_movie);
        tvRuntime.setText(runtime_movie);

    }
}
