package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Group {
    @Id
    @Setter
    @Column(name="group_id")
    @Enumerated(EnumType.STRING)
    private GroupName groupName;

    @OneToMany(mappedBy = "album_id")
    private List<Album> alubums;

    @OneToMany(mappedBy = "scheduel_id")
    private List<Scheduel> scheduels;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    @Column(nullable = false)
    private Board board;

}
