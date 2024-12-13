package kr.re.kh.service.impl;

import kr.re.kh.entity.Favorite;
import kr.re.kh.entity.Folder;
import kr.re.kh.mapper.FolderMapper;
import kr.re.kh.model.vo.FolderVO;
import kr.re.kh.repository.FavoriteRepository;
import kr.re.kh.repository.FolderRepository;

import kr.re.kh.service.FolderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
    private final FavoriteRepository favoriteRepository;
    private final FolderMapper folderMapper;



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
    public void deleteFolderAndFavorites(Long folderId) {
        // 폴더에 포함된 즐겨찾기 데이터 삭제
        favoriteRepository.deleteByFolderId(folderId);

        // 폴더 삭제
        folderRepository.deleteById(folderId);
    }

    @Override
    @Transactional
    public void createDefaultFolder(Long userId) {
        Folder defaultFolder = new Folder();
        defaultFolder.setUserId(userId);
        defaultFolder.setFolderName("기본 폴더");
        defaultFolder.setCreatedAt(LocalDateTime.now());
        folderRepository.save(defaultFolder);
    }

    @Override
    public List<FolderVO> selectFolderByUserId(Long userId) {
        return folderMapper.selectFolderByUserId(userId);
    }


}
