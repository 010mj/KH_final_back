package kr.re.kh.service.impl;

import kr.re.kh.entity.ReviewVO;
import kr.re.kh.repository.ReviewRepository;
import kr.re.kh.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewVO> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public ReviewVO getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }
    @Override
    public List<ReviewVO> getReviewsByPlaceId(Long placeId) {
        return reviewRepository.findByPlaceId(placeId);
    }

    @Override
    public List<ReviewVO> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public ReviewVO createReview(ReviewVO review) {
        return reviewRepository.save(review);
    }

    @Override
    public ReviewVO updateReview(Long id, ReviewVO review) {
        ReviewVO existingReview = getReviewById(id);
        existingReview.setRating(review.getRating());
        existingReview.setCmt(review.getCmt());
        return reviewRepository.save(existingReview);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

}
