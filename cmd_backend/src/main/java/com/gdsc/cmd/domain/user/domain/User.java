package com.gdsc.cmd.domain.user.domain;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
@Table(name = "tbl_user")
@NoArgsConstructor
@Getter
@Entity
@Cacheable
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder
    public User(Long phonenumber, String accountId, String password, String major, String email) {
        this.phonenumber = phonenumber;
        this.accountId = accountId;
        this.password = password;
        this.major = major;
        this.email = email;
    }

    @Column(name = "phonenumber")
    private Long phonenumber;

    @Column(columnDefinition = "VARCHAR(30)", name="account_id")  // 오타 수정: accont_id -> account_id
    private String accountId;

    @Column(columnDefinition = "LONGTEXT")  // 비밀번호 길이를 255자로 설정
    private String password;

    @Column(columnDefinition = "VARCHAR(30)")
    private String major;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;
}
