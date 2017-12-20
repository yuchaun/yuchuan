package com.jltour.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/9/29 0029.
 */
@Entity
@Table(name = "test")
@Data
@ToString(of = {})
@EqualsAndHashCode(callSuper = false,of = {})
public class TestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Column
    private String name;

}
