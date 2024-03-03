package domain;

import Dto.PostDto;
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
    @Column(name = "post_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    @Column(nullable = false)
    private Board board;

    @Column(nullable = false)
    @Setter
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @Column(nullable = false)
    private Member member;

    @CreatedDate
    private LocalDateTime createdDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postImage_id")
    private PostImage postImage;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post",orphanRemoval = true)
    private List<Like> likes;
    private Long likeCnt;
    //private Long unlike;

    @Setter
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "post")
    private List<Command> commands;

    //글 쓴 작성자 수정하기
    //필요없는 기능인듯
    
    //게시판 수정하기
    //마찬가지로 필요없는 기능인듯

    //제목과 본문 업데이트하기
    public void update(PostDto dto){
        this.title=dto.getTitle();
        this.content=dto.getContent();
    }

    //포스트 이미지 수정하기
    public void setPostImage(PostImage postImage){
        this.setPostImage(postImage);
    }
    
    //댓글 추가하기
    public void addCommand(Command command){
        commands.add(command);
    }

    //좋아요 수 변경하기
    public void likeChange(Long likeCnt){
        this.likeCnt=likeCnt;
    }
}
