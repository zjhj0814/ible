package domain;

import domain.Member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "command_id")
    private Long id;

    @Setter
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member; //작성자

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    //댓글 update하는 기능(댓글 수정)
    public void update(String newContent){
        this.content=newContent;
    }
}
