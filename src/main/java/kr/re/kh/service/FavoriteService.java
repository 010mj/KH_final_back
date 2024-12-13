package kr.re.kh.service;

import kr.re.kh.entity.Favorite;
import kr.re.kh.entity.FavoriteRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FavoriteService {
    List<Favorite> getFavoritesByFolderId(Long folderId);
    Favorite createFavorite(FavoriteRequest favoriteRequest);
    void deleteFavorite(Long favoriteId);
}