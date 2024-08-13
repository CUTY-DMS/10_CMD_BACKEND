package com.gdsc.cmd.domain.notification.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "need")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long needId;

    @Column(columnDefinition = "VARCHAR(30)")
    @NotNull
    private String title;

    @Column(columnDefinition = "VARCHAR(500)")
    private String content;
}
