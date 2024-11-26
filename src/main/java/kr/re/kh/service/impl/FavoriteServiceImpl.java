package kr.re.kh.service.impl;

import kr.re.kh.entity.Favorite;
import kr.re.kh.repository.FavoriteRepository;
import kr.re.kh.repository.FolderRepository;
import kr.re.kh.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final FolderRepository folderRepository;


    @Override
    public List<Favorite> getFavoritesByFolderId(Long folderId) {
        return favoriteRepository.findByFolderId(folderId);
    }

    @Override
    public Favorite createFavorite(Favorite favorite) {
        if (favorite.getFolderId() == null) {
            throw new IllegalArgumentException("Folder ID는 null일 수 없습니다.");
        }

        if (!folderRepository.existsById(favorite.getFolderId())) {
            throw new IllegalArgumentException("없는 폴더 ID입니다: " + favorite.getFolderId());
        }

        return favoriteRepository.save(favorite);
    }

    @Override
    public void deleteFavorite(Long favoriteId) {
        if(!favoriteRepository.existsById(favoriteId)) {
            throw  new IllegalArgumentException("즐겨찾기를 찾을 수 없습니다.");
        }
        favoriteRepository.deleteById(favoriteId);
    }
}
