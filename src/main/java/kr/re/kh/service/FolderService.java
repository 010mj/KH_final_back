package kr.re.kh.service;

import kr.re.kh.entity.Folder;
import kr.re.kh.model.vo.FolderVO;

import java.util.List;

public interface FolderService {

    List<Folder> getAllFolders();

    Folder createFolder(Folder folder);
    Folder getFolderById(Long FolderId);
    void deleteFolderAndFavorites(Long folderId);
    void createDefaultFolder(Long userId);
    List<FolderVO> selectFolderByUserId(Long userId);

}
