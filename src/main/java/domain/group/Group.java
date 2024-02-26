package domain.group;

import domain.Album;
import domain.Board;
import domain.Scheduel;
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

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Album> albums;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Scheduel> scheduels;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Board board;

}
