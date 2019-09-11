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

    /*Declarasi Contex & Array MovieParcelable*/
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


    /* Function View pada layout list_film  */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_film, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        MovieParcelable movieParcelableArrayList = (MovieParcelable) getItem(i);
        viewHolder.bind(movieParcelableArrayList);
        return view;
    }

    /* Function Bind Guna untuk narik data pada viewholder ke R.id  */
    private class ViewHolder {
        private ImageView viewholderImg;
        private TextView viewholderTitle, viewholderOverview, viewholderRuntime;


        ViewHolder(View view) {

            viewholderImg = view.findViewById(R.id.list_img);
            viewholderTitle = view.findViewById(R.id.list_title);
            viewholderOverview = view.findViewById(R.id.list_description);
            viewholderRuntime = view.findViewById(R.id.list_runtime);

        }

        void bind(MovieParcelable movieParcelable) {

            viewholderImg.setImageResource(movieParcelable.getImg_movie());
            viewholderTitle.setText(movieParcelable.getTitle_movie());
            viewholderOverview.setText(movieParcelable.getOverview_movie());
            viewholderRuntime.setText(movieParcelable.getRuntime_movie());

        }

    }


}