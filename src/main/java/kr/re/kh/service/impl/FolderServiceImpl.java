package kr.re.kh.service.impl;

import kr.re.kh.entity.Favorite;
import kr.re.kh.entity.Folder;
import kr.re.kh.repository.FavoriteRepository;
import kr.re.kh.repository.FolderRepository;

import kr.re.kh.service.FolderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
    private final FavoriteRepository favoriteRepository;



    @Override
    public List<Folder> getAllFolders(){
        return folderRepository.findAll();
    }

    @Override
    public Folder createFolder(Folder folder){
        return folderRepository.save(folder);
    }

    @Override
    public Folder getFolderById(Long folderId) {
        return folderRepository.findById(folderId)
                .orElseThrow(() -> new IllegalArgumentException("폴더를 찾을 수 없습니다."));
    }

    @Override
    public void deleteFolder(Long folderId) {
        List< Favorite> favorites = favoriteRepository.findByFolderId(folderId);
        if(!favorites.isEmpty()) {
            throw  new IllegalStateException("즐겨찾기가 남아있어, 폴더를 삭제할 수 없습니다.");
        }
        folderRepository.deleteById(folderId);
    }
}
