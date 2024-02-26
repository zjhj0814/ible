package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

//Image 클래스 없이 하자!!
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Image {
    @Column(nullable = false)
    private String fileName;
    @Column(nullable=false)
    private String fileOriName;
    @Column(nullable=false)
    private String fileUrl;
}
