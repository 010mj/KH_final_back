package kr.re.kh.repository;

import kr.re.kh.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByFolderId(Long folderId);
}