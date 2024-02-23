package domain.Member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] data;

    //Member가 ProfilePicture의 연관관계 주인
    @OneToOne(mappedBy = "profilePicture", fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
}
