package com.gdsc.cmd.domain.user.domain;



import com.gdsc.cmd.domain.user.domain.type.Role;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
@Table(name = "tbl_user")
@NoArgsConstructor
@Getter
@Entity
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(30)", name = "account_id")
    private String accountId;

    @Column(columnDefinition = "VARCHAR(60)")
    private String password;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(columnDefinition = "VARCHAR(30)")
    private String major;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(columnDefinition = "VARCHAR(5)")
    private String classNumber;

    @Column(columnDefinition = "VARCHAR(6)")
    private String birth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private Role role;


}