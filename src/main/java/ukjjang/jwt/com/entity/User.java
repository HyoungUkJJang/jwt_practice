package ukjjang.jwt.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // 데이터 베이스의 테이블과 1:1 매핑되는 객체를 뜻한다.
@Table(name = "user") // 테이블 명을 지정하기 위해 쓰이는 어노테이션
@Builder
public class User {

    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가되는 pk
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @JsonIgnore
    @Column(name="activated")
    private boolean activated;

    // user객체와 권한객체의 다대다 관계 일대다, 다대일 관계의 조인 테이블로 정의했다는 뜻이다.
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")}
    )
    private Set<Authority> authorites;

}
