package kr.re.kh.controller.admin;

import kr.re.kh.entity.FavoriteRequest;
import org.springframework.web.bind.annotation.CrossOrigin;


import kr.re.kh.entity.Favorite;
import kr.re.kh.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/favorites")
@AllArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @GetMapping("/folder/{folderId}")
    public List<Favorite> getFavoritesByFolderId(@PathVariable Long folderId) {
        return favoriteService.getFavoritesByFolderId(folderId);
    }

    @PostMapping
    public ResponseEntity<Favorite> createFavorite(@RequestBody FavoriteRequest favoriteRequest) {
      //  System.out.println("Received Request: " + favoriteRequest);
        Favorite createdFavorite = favoriteService.createFavorite(favoriteRequest);
        return ResponseEntity.ok(createdFavorite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        favoriteService.deleteFavorite(id);
        return ResponseEntity.noContent().build();
    }


}
