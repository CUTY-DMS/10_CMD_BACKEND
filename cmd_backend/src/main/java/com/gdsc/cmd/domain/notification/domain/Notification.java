package com.gdsc.cmd.domain.notification.domain;


import com.gdsc.cmd.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Table(name = "need")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @Column(columnDefinition = "VARCHAR(30)")
    @NotNull
    private String title;

    @Column(columnDefinition = "VARCHAR(500)")
    private String content;

    @Column(columnDefinition = "VARCHAR(30)")
    private String writer;

    @Column(columnDefinition = "VARCHAR(100)")
    private LocalDate createdTime;

}
