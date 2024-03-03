package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"like\"") //MySQL에서는 테이블명으로 like 불가능
public class Like {
    @Id
    @Column(nullable = false)
    @OneToOne(mappedBy="Like", fetch = FetchType.LAZY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member; //좋아요를 누른 유저

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post; //좋아요 눌린 게시글
}
