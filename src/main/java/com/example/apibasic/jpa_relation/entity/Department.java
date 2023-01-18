package com.example.apibasic.jpa_relation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "deptId")
@Builder
@Entity
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId; // 부서번호

    private String deptName; // 부서명

    // onetomany는 굳이 사용하고싶으면해라
    // 논리적으로 생각해도 부서입장에서 부서에 포함된 모든 사원의 모든 정보를 가지고있을 필요는 없음
    // 다만 사원입장에서는 본인이 속한 부서의 정보는 필요할수 있음
    @OneToMany(mappedBy = "department") // 상대방 엔터티에 조인되는 필드명(상대방의)을 씀
    private List<Employee> employees = new ArrayList<>();

}