package domain;

import domain.group.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//게시판
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Board { //그룹
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @Column(nullable = false)
    private Group group;

    @OneToMany
    private List<Post> posts;
}
