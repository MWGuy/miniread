package io.mwguy.manga.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "branch", indexes = {
        @Index(name = "idx_branch_manga_id", columnList = "manga_id")
})
public class Branch implements Serializable {
    private static final long serialVersionUID = 1803093757035617465L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manga_id", nullable = false)
    private Manga manga;

    @ManyToMany
    @JoinTable(name = "branch_teams",
            joinColumns = @JoinColumn(name = "branch_id"),
            inverseJoinColumns = @JoinColumn(name = "teams_id"))
    private List<Team> teams = new ArrayList<>();

    @OrderBy("volume desc, number desc")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "branch", orphanRemoval = true)
    private List<Chapter> chapters = new ArrayList<>();

    public String getTeamNames() {
        return getTeams().stream().map(Team::getName).map(i -> i.get("ru")).collect(Collectors.joining(" & "));
    }
}
