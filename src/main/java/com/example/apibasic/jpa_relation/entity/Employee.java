package com.example.apibasic.jpa_relation.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "empId")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    @ManyToOne  // 연관간계 매핑
    @JoinColumn(name = "deptId")
    private Department department;   // m:1 관계에서 객체지향적으로 상대의 키값만 가저오는것이 아닌 객체를 통으로 박음

}
