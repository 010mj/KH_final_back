package kr.re.kh.repository;

import com.example.project.model.FavoriteVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<FavoriteVO, Long> {
    List<FavoriteVO> findByUserId(Long userId); // 사용자 ID로 즐겨찾기 조회
}