package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="postImage_id")
    private Long id;

    @OneToOne(fetch =FetchType.LAZY, mappedBy = "postImage")
    @Column(name = "post_id")
    private Post post;

    @Embedded
    private Image image;
}
