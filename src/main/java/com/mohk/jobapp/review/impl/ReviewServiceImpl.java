package com.mohk.jobapp.review.impl;

import com.mohk.jobapp.company.Company;
import com.mohk.jobapp.company.CompanyService;
import com.mohk.jobapp.review.Review;
import com.mohk.jobapp.review.ReviewRepository;
import com.mohk.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.companyService = companyService;
        this.reviewRepository = reviewRepository;
    }
//    GET ALL REVIEWS

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }
//    CREATE REVIEW

    @Override
    public boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

//    GET REVIEW BY ID

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream(). //check if companyid is equal to reviewid
                filter(review -> review.getId().equals(reviewId)).
                findFirst().
                orElse(null);
        }

//    UPDATE REVIEW
    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId)!=null){
            updatedReview.setCompany(companyService.getCompanyById(companyId)); //check if companyid is equal to reviewId);
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

//    DELETE REVIEW
    @Override
    public boolean deleteReviewById(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null); //retrieve review
            Company company = review.getCompany();//retrieve company
            company.getReviews().remove(review); //remove review from company
            review.setCompany(null);
            companyService.updateCompany(company,companyId); //update company
            reviewRepository.delete(review);//delete review
            return true;
        }
        return false;
    }

}



