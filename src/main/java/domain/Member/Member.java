package domain.Member;

import domain.Like;
import domain.group.Group;
import domain.Member.Email.Email;
import domain.Post;
import domain.group.GroupName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="group_id")
    @Setter
    private Group group;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy = "post_id", orphanRemoval = true)
    private List<Post> posts;

//    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "like_cnt")
//    private List<Like> likes; //유저가 누른 좋아요 리스트

    //관심 그룹 수정하기 -> 그냥 setter로 수정하면 안 되나..?
    public GroupName setGroup(GroupName groupName){
        group.setGroupName(groupName);
        return group.getGroupName();
    }

}
