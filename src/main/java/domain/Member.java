package domain;

import domain.group.Group;
import domain.Email.Email;
import domain.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
public class Member {
    @Id
    @Column(name="member_id", nullable = false)
    private String id;

    @Column(nullable = false)
    @Setter
    private String password;

    @Column(nullable = false)
    @Embedded
    private Email email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    @Setter
    private Group group;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy = "post_id", orphanRemoval = true)
    private List<Post> posts;

//    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "like_cnt")
//    private List<Like> likes; //유저가 누른 좋아요 리스트

}
