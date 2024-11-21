package kr.re.kh.repository;

import kr.re.kh.entity.ReviewVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewVO, Long> {

    List<ReviewVO> findByPlaceId(Long placeId);

    List<ReviewVO> findByUserId(Long userId);
}
