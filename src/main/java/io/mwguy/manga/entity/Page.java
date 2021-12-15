package io.mwguy.manga.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "page", indexes = {
        @Index(name = "idx_page_chapter_id", columnList = "chapter_id")
})
public class Page implements Serializable {
    private static final long serialVersionUID = 3755073765379943599L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "image", nullable = false)
    private String image;

    @ManyToOne(optional = false)
    @JoinColumn(name = "chapter_id", nullable = false)
    private Chapter chapter;
}
