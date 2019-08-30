package com.example.submissionmoviecatalogue;

import java.util.ArrayList;

public class MovieParcelableAdapter {

    public static String[][] data = new String[][]{
            {
                "E:\\Workspace\\Andriod\\SubmissionMovieCatalogue\\app\\src\\main\\res\\mipmap-hdpi\\poster_a_star.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "ACTION",
                "2 Hours 16 Minute",
                "200,000,000.00",
                "588,759,740.00",
                "Written by msbreviews on August 5, 2019\n" +
                        "If you enjoy reading my Spoiler-Free reviews, please follow my blog :)\n" +
                        "\n" +
                        "Here’s the thing about the Fast & Furious franchise: it can be dumb fun. Every movie has the right to be entertaining even if it completely disregards physics and logic… As long as it establishes its tone from the start. You can’t make an action film where the main characters survive basically everything they shouldn’t and take everything seriously. It’s not that you can’t have that mix of tones (Furious 7 did it brilliantly), but that’s reserved for some of the best movies of the year since it’s not easy (at all) to bala... read the rest."
            },


            /*{" ", " ", " "},*/
    };


    /* Fungsi API Arraylist<GalerriData> */

    public static ArrayList<MovieParcelable> getListData() {
        ArrayList<MovieParcelable> list = new ArrayList<>();
        for (String[] aData : data) {
            MovieParcelable movieParcelable = new MovieParcelable();
            movieParcelable.setImg_movie(aData[0]);
            movieParcelable.setTitle_movie(aData[1]);
            movieParcelable.setGendre_movie(aData[2]);
            movieParcelable.setRuntime_movie(aData[3]);
            movieParcelable.setBudget_movie(aData[4]);
            movieParcelable.setRevenue_movie(aData[5]);
            movieParcelable.setReview_movie(aData[6]);

            list.add(movieParcelable);
        }

        return list;
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
