package io.mwguy.manga.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "chapter", indexes = {
        @Index(name = "idx_chapter_branch_id", columnList = "branch_id")
})
public class Chapter implements Serializable {
    private static final long serialVersionUID = -3836125510929267221L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "volume", nullable = false)
    private Integer volume;

    @Column(name = "number")
    private Integer number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @OneToMany(mappedBy = "chapter", orphanRemoval = true)
    private List<Page> pages = new ArrayList<>();

    @GeneratedValue
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    public String getFormattedName() {
        var formattedName = String.format("Том %d. Глава %d", volume, number);
        if (name != null) {
            formattedName += " - " + name;
        }

        return formattedName;
    }
}
