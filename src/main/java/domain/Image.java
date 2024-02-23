package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Image {
    @Column(nullable = false)
    private String fileName;
    @Column(nullable=false)
    private String fileOriName;
    @Column(nullable=false)
    private String fileUrl;
}
