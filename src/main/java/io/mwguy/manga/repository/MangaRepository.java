package io.mwguy.manga.repository;

import io.mwguy.manga.entity.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MangaRepository extends JpaRepository<Manga, UUID> {
    @Query("select m from Manga m where upper(m.slug) = upper(?1)")
    Optional<Manga> findBySlugIgnoreCase(String slug);
}
