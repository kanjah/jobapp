package com.mohk.jobapp.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
   }

//   GET ALL REVIEWS
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
       List<Review> reviews = reviewService.getAllReviews(companyId);
        return ResponseEntity.ok(reviews);
    }
//    CREATE REVIEW
    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId,@RequestBody Review review){
        boolean isCreated = reviewService.createReview(companyId,review);
        if(!isCreated){
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
    }

//    GET REVIEW BY ID
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReviewById(companyId,reviewId),HttpStatus.OK);


    }

//    UPDATE REVIEW
  @PutMapping("/reviews/{reviewId}")
  public ResponseEntity<String> updateReview(@PathVariable Long companyId, //which company to update
                                             @PathVariable Long reviewId, //which review to update
                                             @RequestBody Review review){ //updated review
      boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId,review);
      if(isReviewUpdated)
          return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
      return new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
  }
//    DELETE REVIEW
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long companyId,
                                                   @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReviewById(companyId,reviewId);
        if(isReviewDeleted)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
    }

}
