package com.gdsc.cmd.openapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type",columnDefinition = "VARCHAR(2)")
    private String MMEAL_SC_NM;

    @Column(name = "date", nullable = false,columnDefinition = "VARCHAR(8)")
    private String MLSV_YMD;

    @Column(name = "meals", nullable = false,columnDefinition = "VARCHAR()")
    private String DDISH_NM;

    @Column(name = "calorie", nullable = false,columnDefinition = "VARCHAR()")
    private String CAL_INFO;

    @Builder
    public Meal(String MMEAL_SC_NM, String MLSV_YMD, String DDISH_NM, String CAL_INFO) {
        this.MMEAL_SC_NM = MMEAL_SC_NM;
        this.MLSV_YMD = MLSV_YMD;
        this.DDISH_NM = DDISH_NM;
        this.CAL_INFO = CAL_INFO;
    }
}
