package kr.re.kh.controller.admin;

import kr.re.kh.entity.Folder;
import kr.re.kh.service.FolderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/folders")
@AllArgsConstructor
public class FolderController {
    private final FolderService folderService;

    @GetMapping
    public List<Folder> getAllFolders(){
        return  folderService.getAllFolders();
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
        folderService.deleteFolder(id);
        return ResponseEntity.noContent().build();
    }




}
