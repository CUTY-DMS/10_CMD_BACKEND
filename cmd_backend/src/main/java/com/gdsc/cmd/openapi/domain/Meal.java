package com.gdsc.cmd.openapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type",columnDefinition = "VARCHAR(1000)")
    private String MMEAL_SC_NM;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String date;

    @Column(name = "meals",columnDefinition = "VARCHAR(10000)")
    private String DDISH_NM;

    @Column(name = "calorie",columnDefinition = "VARCHAR(1000)")
    private String CAL_INFO;
}
