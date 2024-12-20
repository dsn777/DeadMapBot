package com.dsn.DeadMapBot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

//@Getter
//@Setter
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class DeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String middlename;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private String latitude;
    private String longitude;
}
