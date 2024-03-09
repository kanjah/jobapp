package com.mohk.jobapp.review;

import java.util.List;

public interface ReviewService {
//    GET ALL REVIEWS
    List<Review> getAllReviews(Long companyId);

// CREATE REVIEW
    boolean createReview(Long companyId,Review review);

//    GET REVIEW BY ID
    Review getReviewById(Long companyId,Long reviewId);

//    UPDATE REVIEW
    boolean updateReview(Long companyId,Long reviewId,Review review);

//    DELETE REVIEW
    boolean deleteReviewById(Long companyId, Long reviewId);
}
