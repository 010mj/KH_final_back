package kr.re.kh.service;

import com.example.project.model.FavoriteVO;
import com.example.project.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    // 즐겨찾기 추가
    public FavoriteVO addFavorite(FavoriteVO favoriteVO) {
        return favoriteRepository.save(favoriteVO);
    }

    // 사용자 ID로 즐겨찾기 조회
    public List<FavoriteVO> getFavoritesByUserId(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    // 즐겨찾기 삭제
    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }
}