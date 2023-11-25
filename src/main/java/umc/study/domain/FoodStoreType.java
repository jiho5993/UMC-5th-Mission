package umc.study.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodStoreType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodTypeIdx")
    private FoodType foodType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodStoreIdx")
    private FoodStore foodStore;
}
