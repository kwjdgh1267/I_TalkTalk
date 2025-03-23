package i_talktalk.i_talktalk.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friend_id;

    @ManyToOne
    @JoinColumn(name = "member1")
    private Member member1;

    @ManyToOne
    @JoinColumn(name = "member2")
    private Member member2;

    @Column
    private boolean approved;

    public Friend(Member member1, Member member2) {
        this.member1 = member1;
        this.member2 = member2;
        this.approved = false;
    }
}
