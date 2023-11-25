package umc.study.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.study.domain.enums.MissionReviewStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@AllArgsConstructor
public class MissionReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(nullable = false, length = 500)
    private String content;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("ACTIVATED")
    private MissionReviewStatus status;

    @Column(nullable = false)
    private float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missionIdx")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodStoreIdx")
    private FoodStore foodStore;
}
