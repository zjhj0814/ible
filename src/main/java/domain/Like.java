package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @Column(nullable = false)
    @OneToOne(mappedBy="member_id", fetch = FetchType.LAZY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
