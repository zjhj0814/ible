package domain.Member;

import domain.Group;
import domain.GroupName;
import domain.Member.Email.Email;
import domain.Post;
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

    //
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="group_id")
    @Setter
    private Group group;

    //
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "post_id")
    private List<Post> posts;

}
