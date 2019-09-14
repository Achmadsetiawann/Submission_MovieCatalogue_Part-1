package com.example.submissionmoviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;


public class MovieParcelable implements Parcelable {

    /* Deklarasi Data yg di butuhkan */

    private int img_movie;
    private String title_movie;
    private String overview_movie;
    private String runtime_movie;



    /* Set Data Construct sesuai dengan variable di atas  */

    public int getImg_movie() {
        return img_movie;
    }

    public void setImg_movie(int img_movie) {
        this.img_movie = img_movie;
    }

    public String getTitle_movie() {
        return title_movie;
    }

    public void setTitle_movie(String title_movie) {
        this.title_movie = title_movie;
    }


    public String getOverview_movie() {
        return overview_movie;
    }

    public void setOverview_movie(String overview_movie) {
        this.overview_movie = overview_movie;
    }

    public String getRuntime_movie() {
        return runtime_movie;
    }

    public void setRuntime_movie(String runtime_movie) {
        this.runtime_movie = runtime_movie;
    }


    /* Fungsi Android Parcelable Data */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img_movie);
        dest.writeString(this.title_movie);
        dest.writeString(this.overview_movie);
        dest.writeString(this.runtime_movie);
    }

    public MovieParcelable() {

    }

    private MovieParcelable(Parcel in) {
        this.img_movie = in.readInt();
        this.title_movie = in.readString();
        this.overview_movie = in.readString();
        this.runtime_movie = in.readString();
    }

    public static final Parcelable.Creator<MovieParcelable> CREATOR = new Parcelable.Creator<MovieParcelable>() {
        @Override
        public MovieParcelable createFromParcel(Parcel source) {
            return new MovieParcelable(source);
        }

        @Override
        public MovieParcelable[] newArray(int size) {
            return new MovieParcelable[size];
        }
    };
}
