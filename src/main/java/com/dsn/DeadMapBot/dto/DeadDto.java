package com.dsn.DeadMapBot.dto;

import com.dsn.DeadMapBot.entity.DeadEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DeadDto {
    private String firstname;
    private String lastname;
    private String middlename;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private String latitude;
    private String longitude;

    public DeadEntity toEntity() {
        DeadEntity deadEntity = new DeadEntity();
        deadEntity.setFirstname(this.getFirstname());
        deadEntity.setLastname(this.getLastname());
        deadEntity.setMiddlename(this.getMiddlename());
        deadEntity.setBirthdate(this.getBirthdate());
        deadEntity.setDeathdate(this.getDeathdate());
        deadEntity.setLatitude(this.getLatitude());
        deadEntity.setLongitude(this.getLongitude());

        return deadEntity;
    }

    public static DeadDto of(DeadEntity deadEntity) {
        DeadDto dto = new DeadDto();
        dto.setFirstname(deadEntity.getFirstname());
        dto.setLastname(deadEntity.getLastname());
        dto.setMiddlename(deadEntity.getMiddlename());
        dto.setBirthdate(deadEntity.getBirthdate());
        dto.setDeathdate(deadEntity.getDeathdate());
        dto.setLatitude(deadEntity.getLatitude());
        dto.setLongitude(deadEntity.getLongitude());

        return dto;
    }
}
