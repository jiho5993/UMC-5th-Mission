package umc.study.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.UserGender;
import umc.study.domain.enums.UserStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserGender gender;

    private LocalDate birth;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, length = 300)
    private String detailAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVATED'")
    private UserStatus status;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int point;

    @OneToMany(mappedBy = "user")
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<MissionReview> missionReviews = new ArrayList<>();
}
