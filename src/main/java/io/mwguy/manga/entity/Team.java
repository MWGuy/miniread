package io.mwguy.manga.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "team")
@RequiredArgsConstructor
public class Team implements Serializable {
    private static final long serialVersionUID = 327749706704614640L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @Type(type = "hstore")
    @Column(name = "name", nullable = false, columnDefinition = "hstore")
    private Map<String, String> name;

    @Column(name = "poster", nullable = false)
    private String poster;

    @Column(name = "description", columnDefinition = "text")
    private String description;
}
