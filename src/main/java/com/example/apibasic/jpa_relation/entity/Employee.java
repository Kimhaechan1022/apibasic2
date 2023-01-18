package com.example.apibasic.jpa_relation.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    // LAZY = 조인 테이블내 필요데이터 제외하곤 안가져옴
    // EAGER = 조인 테이블내 모든걸 가져옴
    @ManyToOne(fetch = FetchType.LAZY)  // 연관간계 매핑
    @JoinColumn(name = "deptId")
    private Department department;   // m:1 관계에서 객체지향적으로 상대의 키값만 가저오는것이 아닌 객체를 통으로 박음

}
