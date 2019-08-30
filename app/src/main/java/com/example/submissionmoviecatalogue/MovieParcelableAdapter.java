package com.example.submissionmoviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MovieParcelableAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<MovieParcelable> movieParcelableArrayList;

    public void setMovieParcelableArrayList(ArrayList<MovieParcelable> movieParcelableArrayList) {
        this.movieParcelableArrayList = movieParcelableArrayList;
    }

    public MovieParcelableAdapter(Context context) {
        this.context = context;
        movieParcelableArrayList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movieParcelableArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieParcelableArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.detail_film, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        MovieParcelable movieParcelableArrayList = (MovieParcelable) getItem(i);
        viewHolder.bind(movieParcelableArrayList);
        return view;
    }

    private class ViewHolder {
        private ImageView viewholderImg;
        private TextView viewholderTitle, viewholderOverview, viewholderGendre, viewholderRuntime, viewholderBudget, viewholderRevenue, viewholderReview;

        ViewHolder(View view) {
            viewholderImg = view.findViewById(R.id.img_movie);
            viewholderTitle = view.findViewById(R.id.title_movie);
            viewholderOverview = view.findViewById(R.id.overview_movie);
            viewholderGendre = view.findViewById(R.id.gendre_movie);
            viewholderRuntime = view.findViewById(R.id.runtime_movie);
            viewholderBudget = view.findViewById(R.id.budget_movie);
            viewholderRevenue = view.findViewById(R.id.revenue_movie);
            viewholderReview = view.findViewById(R.id.review_movie);
        }

        void bind(MovieParcelable movieParcelable) {

            viewholderImg.setImageResource(movieParcelable.getImg_movie());
            viewholderTitle.setText(movieParcelable.getTitle_movie());
            viewholderOverview.setText(movieParcelable.getOverview_movie());
            viewholderGendre.setText(movieParcelable.getGendre_movie());
            viewholderRuntime.setText(movieParcelable.getRuntime_movie());
            viewholderBudget.setText(movieParcelable.getBudget_movie());
            viewholderRevenue.setText(movieParcelable.getRevenue_movie());
            viewholderReview.setText(movieParcelable.getReview_movie());

        }

    }


}



/*
    private String img_movie;
    private String title_movie;
    private String gendre_movie;
    private String runtime_movie;
    private int budget_movie;
    private int revenue_movie;
    private String review_movie;
*/
