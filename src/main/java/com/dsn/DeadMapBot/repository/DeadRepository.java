package com.dsn.DeadMapBot.repository;

import com.dsn.DeadMapBot.entity.DeadEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeadRepository extends CrudRepository<DeadEntity, Long> {
    //List<DeadEntity> findByFirstnameLastnameMiddlename(String firstname, String lastname, String middlename);
    List<DeadEntity> findByLastname(String lastname);
}
