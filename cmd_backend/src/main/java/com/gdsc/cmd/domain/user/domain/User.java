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
    public User(Long phonenumber, String accountId, String password, String major, String deviceToken, String email) {
        this.phonenumber = phonenumber;
        this.accountId = accountId;
        this.password = password;
        this.major = major;
        this.deviceToken = deviceToken;
        this.email = email;
    }




    @Column(name = "phonenumber")
    private Long phonenumber;
    @Column(columnDefinition = "VARCHAR(50)", name="accont_id")
    private String accountId;
    @Column(columnDefinition = "VARCHAR(50)")
    private String password;
    @Column(columnDefinition = "VARCHAR(30)")
    private String major;

    @Setter
    @Column(name = "device_token")
    private String deviceToken;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;


}
