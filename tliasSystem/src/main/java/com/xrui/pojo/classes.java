package com.xrui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author NXRUI
 * @version 1.0
 * @date 2023/5/25 0:32
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class classes {
    private Integer id;
    private String name;
    private String classesNumber;
    private LocalDate startTime;
    private LocalDate finishTime;
    private String empId;
}
