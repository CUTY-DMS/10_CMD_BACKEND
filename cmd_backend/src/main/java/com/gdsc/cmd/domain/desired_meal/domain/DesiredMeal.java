package com.gdsc.cmd.domain.desired_meal.domain;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Getter
@Entity
@NoArgsConstructor
public class DesiredMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

}
