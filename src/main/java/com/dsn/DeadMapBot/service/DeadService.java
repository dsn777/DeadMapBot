package com.dsn.DeadMapBot.service;

import com.dsn.DeadMapBot.dto.DeadDto;
import com.dsn.DeadMapBot.entity.DeadEntity;

import java.util.List;
import java.util.Optional;

public interface DeadService {
    DeadEntity save(DeadDto deadDto);
    Optional<DeadEntity> findById(Long id);
    List<DeadEntity> findByFullName(String firstname, String lastname, String middlename);
    Optional<DeadEntity> findDead(DeadDto deadDto);
    List<DeadEntity> findByLastname(String lastname);
}
