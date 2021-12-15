package io.mwguy.manga.service;

import io.mwguy.manga.entity.Manga;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class SearchService {
    private final EntityManager entityManager;

    public SearchService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Manga> search(String query, int limit) {
        var searchSession = Search.session(entityManager);
        var scope = searchSession.scope(Manga.class);

        var result = searchSession.search(scope)
                .where(scope.predicate().match()
                        .fields("slug", "name", "description")
                        .matching(query)
                        .toPredicate())
                .fetch(limit);

        return result.hits();
    }

    @SneakyThrows
    @Transactional
    @Scheduled(cron = "0 0 0/1 1/1 * ?")
    public void reindexManga() {
        var searchSession = Search.session(entityManager);
        var indexer = searchSession
                .massIndexer(Manga.class)
                .threadsToLoadObjects(Runtime.getRuntime().availableProcessors() - 1);

        indexer.startAndWait();
    }
}
