package io.mwguy.manga.entity;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Entity
@Getter
@Setter
@Table(name = "manga")
@RequiredArgsConstructor
@Indexed(index = "idx_manga")
@TypeDef(name = "hstore", typeClass = PostgreSQLHStoreType.class)
public class Manga implements Serializable {
    private static final long serialVersionUID = 7370844005769714456L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @FullTextField
    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @FullTextField
    @Type(type = "hstore")
    @Column(name = "name", nullable = false, columnDefinition = "hstore")
    private Map<String, String> name;

    @Column(name = "poster", nullable = false)
    private String poster;

    @FullTextField
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "manga")
    private List<Branch> branches = new ArrayList<>();

    public String getCanonicalName() {
        return getName()
                .entrySet()
                .iterator()
                .next()
                .getValue();
    }

    public String getAlternativeNames() {
        return getName()
                .entrySet()
                .stream()
                .skip(1)
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(" / "));
    }
}
