package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 200)
    private String content;

    @Column(nullable = false)
    private int point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'AWAITING'")
    private MissionStatus status;

    @Column(nullable = false)
    private int targetPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodStoreIdx")
    private FoodStore foodStore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regionIdx")
    private Region region;

    @OneToMany(mappedBy = "mission")
    private List<MissionReview> missionReviews = new ArrayList<>();
}
