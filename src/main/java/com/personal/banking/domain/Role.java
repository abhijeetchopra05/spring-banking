package com.personal.banking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Role {


    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
//    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", initialValue = 1, schema = "banking")
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "roleSet")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
