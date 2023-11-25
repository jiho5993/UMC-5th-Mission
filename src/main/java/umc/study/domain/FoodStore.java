package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.FoodStoreStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodStore extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVATED'")
    private FoodStoreStatus status;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @OneToMany(mappedBy = "foodStore")
    private List<FoodStoreType> foodStoreTypes = new ArrayList<>();

    @OneToMany(mappedBy = "foodStore")
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "foodStore")
    private List<MissionCertificationCode> missionCertificationCodes = new ArrayList<>();

    @OneToMany(mappedBy = "foodStore")
    private List<MissionReview> missionReviews = new ArrayList<>();
}
