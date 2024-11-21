package kr.re.kh.service;

import kr.re.kh.entity.ReviewVO;
import kr.re.kh.repository.ReviewRepository;

import java.util.List;

public interface ReviewService {
    List<ReviewVO> getAllReviews();
    ReviewVO getReviewById(Long id);
    List<ReviewVO> getReviewsByPlaceId(Long placeId);
    List<ReviewVO> getReviewsByUserId(Long userId);
    ReviewVO createReview(ReviewVO review);
    ReviewVO updateReview(Long id, ReviewVO review);
    void deleteReview(Long id);

}
