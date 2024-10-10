package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.*;
import umc.study.validation.annotation.ExistMember;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

    private LocalDateTime birthday;

    private Integer zipcode;

    @Column(nullable = false, length = 40)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private SocialType socialType;

//    @Column(nullable = false, length = 30)
    private String email;

    private Integer point;

    private Boolean locationAllowance;

    private Boolean marketingAllowance;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberFoodCategory> memberFoodCategoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAllowance> memberAllowanceList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();




}
