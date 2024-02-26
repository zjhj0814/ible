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

    private String original_filename;
    private String savedFilename;

    @OneToOne(fetch = FetchType.LAZY, mappedBy="postImage")
    private Post post;
}
