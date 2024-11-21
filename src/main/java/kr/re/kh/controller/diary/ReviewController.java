package kr.re.kh.controller.diary;


import kr.re.kh.entity.ReviewVO;
import kr.re.kh.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 모든 리뷰 조회
    @GetMapping
    public List<ReviewVO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // ID로 리뷰 조회
    @GetMapping("/{id}")
    public ReviewVO getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    // 특정 Place ID에 속한 리뷰 조회
    @GetMapping("/place/{placeId}")
    public List<ReviewVO> getReviewsByPlaceId(@PathVariable Long placeId) {
        return reviewService.getReviewsByPlaceId(placeId);
    }

    // 특정 User ID에 작성된 리뷰 조회
    @GetMapping("/user/{userId}")
    public List<ReviewVO> getReviewsByUserId(@PathVariable Long userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    // 새로운 리뷰 생성
    @PostMapping
    public ReviewVO createReview(@RequestBody ReviewVO review) {
        return reviewService.createReview(review);
    }

    // 리뷰 업데이트
    @PutMapping("/{id}")
    public ReviewVO updateReview(@PathVariable Long id, @RequestBody ReviewVO review) {
        return reviewService.updateReview(id, review);
    }

    // 리뷰 삭제
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}


