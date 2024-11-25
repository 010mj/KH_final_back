package kr.re.kh.controller.admin;

import com.example.project.model.FavoriteVO;
import com.example.project.service.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    // 즐겨찾기 추가
    @PostMapping
    public ResponseEntity<FavoriteVO> addFavorite(@RequestBody FavoriteVO favoriteVO) {
        return ResponseEntity.ok(favoriteService.addFavorite(favoriteVO));
    }

    // 사용자 ID로 즐겨찾기 조회
    @GetMapping
    public ResponseEntity<List<FavoriteVO>> getFavorites(@RequestParam Long userId) {
        return ResponseEntity.ok(favoriteService.getFavoritesByUserId(userId));
    }

    // 즐겨찾기 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        favoriteService.deleteFavorite(id);
        return ResponseEntity.noContent().build();
    }
}