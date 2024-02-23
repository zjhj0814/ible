package domain;

import domain.Member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(nullable = false)
    @Setter
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @CreatedDate
    private LocalDateTime createdDate;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poastImage_id")
    private PostImage postImage;

    @Column(nullable = false)
    private String content;

    private Long like;

    private Long unlike;

    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "command_id")
    private List<Command> commands;
}
