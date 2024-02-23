package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Group {
    @Id
    @Column(name="group_id")
    @Enumerated(EnumType.STRING)
    private GroupName id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private GroupImage groupImage;

    private String description; //string에서 다른 데이터 타입으로 변경하기

    @OneToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    private SNS sns;

    //

    private Scheduel scheduel;

    private Album album;

    private Board board;

    private GroupArtist groupArtist;
}
