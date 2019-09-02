package com.example.submissionmoviecatalogue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailMovieAdapter extends RecyclerView.Adapter<DetailMovieAdapter.ListViewHolder> {

    private ArrayList<MovieParcelable> movieParcelableArrayList;

    public DetailMovieAdapter (ArrayList<MovieParcelable> list) {this.movieParcelableArrayList = list; }

    @NonNull
    @Override DetailMovieAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_list_film, viewGroup, false);
        return new DetailMovieAdapter().ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final DetailMovieAdapter.ListViewHolder holder, int position) {
        MovieParcelable movieParcelable = movieParcelableArrayList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movieParcelable.getImg_movie())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.dataImgMovieDetail);

        holder.dataTitleMovieDetail.setText(MovieParcelableAdapter.getTitle_movie());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + movieParcelableArrayList.get(holder.getAdapterPosition()).getTitle_movie(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return movieParcelableArrayList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView dataImgMovieDetail;
        TextView dataTitleMovieDetail;

        ListViewHolder(View itemView) {
            super(itemView);

            dataImgMovieDetail = itemView.findViewById(R.id.img_movie);
            dataTitleMovieDetail = itemView.findViewById(R.id.title_movie);
        }
    }



}
