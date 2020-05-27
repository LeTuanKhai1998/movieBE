package com.example.movieBE.constant;

public interface ProcedureName {

    /**
     *
     */
    static final String getBanner = "call get_banner";

    static final String getBannerBottom = "call get_banner_bottom";

    static final String getFeatured = "call get_featured";

    static final String getTopRating = "call get_top_rating";

    static final String getTopViewed = "call get_top_viewed";

    static final String getRecentlyAdded = "call get_recently_added";

    String getMovieByGenre = "call get_movie_by_genre(:slug)";

    String deleteActorHasMovie = "call delete_actor_has_movie(:movieId, :actorId)";

    String getTopViewByTime = "call get_top_view_by_time(:dateIn,:dateOut)";
}
