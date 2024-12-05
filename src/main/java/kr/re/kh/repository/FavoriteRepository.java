package kr.re.kh.repository;

import kr.re.kh.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    @Transactional
    void deleteByFolderId(Long folderId);
    List<Favorite> findByFolderId(Long folderId);
}