package kr.re.kh.service;

import kr.re.kh.entity.Folder;

import java.util.List;

public interface FolderService {

    List<Folder> getAllFolders();

    Folder createFolder(Folder folder);
    Folder getFolderById(Long FolderId);
    void deleteFolder(Long folderId);
    void createDefaultFolder(Long userId);


}
