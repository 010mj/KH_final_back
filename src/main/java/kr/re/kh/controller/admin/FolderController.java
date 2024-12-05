package kr.re.kh.controller.admin;

import kr.re.kh.annotation.CurrentUser;
import kr.re.kh.entity.Folder;
import kr.re.kh.model.CustomUserDetails;
import kr.re.kh.service.FolderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/folders")
@AllArgsConstructor
public class FolderController {
    private final FolderService folderService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SYSTEM')")
    public List<?> getAllFolders(@CurrentUser CustomUserDetails currentUser){
        return  folderService.selectFolderByUserId(currentUser.getId());
    }
    @PostMapping
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder){

        Folder createdFolder = folderService.createFolder(folder);
        return ResponseEntity.ok(createdFolder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Folder> getFolderById(@PathVariable Long id) {
        Folder folder = folderService.getFolderById(id);
        return ResponseEntity.ok(folder);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFolder(@PathVariable Long id) {
        try {
            folderService.deleteFolderAndFavorites(id); // 폴더와 관련된 즐겨찾기 삭제
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}
