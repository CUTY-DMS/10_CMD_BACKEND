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

    @Column(columnDefinition = "VARCHAR(30)", name="account_id")
    private String accountId;

    @Column(columnDefinition = "VARCHAR(60)")
    private String password;

    @Column(name = "phonenumber")
    private Long phonenumber;

    @Column(columnDefinition = "VARCHAR(30)")
    private String major;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    private int classNumber;

    private int birth;

    @Builder
    public User(String accountId, String password, Long phonenumber, String major, String email, int classNumber, int birth) {
        this.accountId = accountId;
        this.password = password;
        this.phonenumber = phonenumber;
        this.major = major;
        this.email = email;
        this.classNumber = classNumber;
        this.birth = birth;
    }
}
