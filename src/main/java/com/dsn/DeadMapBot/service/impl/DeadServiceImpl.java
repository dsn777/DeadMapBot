package com.dsn.DeadMapBot.service.impl;

import com.dsn.DeadMapBot.dto.DeadDto;
import com.dsn.DeadMapBot.entity.DeadEntity;
import com.dsn.DeadMapBot.repository.DeadRepository;
import com.dsn.DeadMapBot.service.DeadService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DeadServiceImpl implements DeadService {

    private final DeadRepository deadRepo;

    @Override
    public DeadEntity save(DeadDto deadDto) {
        return deadRepo.save(deadDto.toEntity());
    }

    @Override
    public Optional<DeadEntity> findById(Long id) {
        return deadRepo.findById(id);
    }

    @Override
    public List<DeadEntity> findByFullName(String firstname, String lastname, String middlename) {
        //return deadRepo.findByFirstnameLastnameMiddlename(firstname, lastname, middlename);
        return null;
    }

    @Override
    public Optional<DeadEntity> findDead(DeadDto deadDto) {
        return null;
    }

    @Override
    public List<DeadEntity> findByLastname(String lastname) {
        return deadRepo.findByLastname(lastname);
    }

    @PostConstruct
    public void initDefauldValues() {
        var pushkin = new DeadDto();
        pushkin.setFirstname("Александр");
        pushkin.setMiddlename("Сергеевич");
        pushkin.setLastname("Пушкин");
        pushkin.setBirthdate(LocalDate.of(1799, 6, 6));
        pushkin.setDeathdate(LocalDate.of(1837, 2, 10));
        pushkin.setLatitude("57.022798");
        pushkin.setLongitude("28.919857");

        var lenin = new DeadDto();
        lenin.setFirstname("Владимир");
        lenin.setMiddlename("Ильич");
        lenin.setLastname("Ленин");
        lenin.setBirthdate(LocalDate.of(1870, 4, 22));
        lenin.setDeathdate(LocalDate.of(1924, 1, 21));
        lenin.setLatitude("55.753673");
        lenin.setLongitude("37.619881");

        var polina = new DeadDto();
        polina.setFirstname("Полина");
        polina.setMiddlename("Алексеевна");
        polina.setLastname("Зубченко");
        polina.setBirthdate(LocalDate.of( 2003, 3, 29));
        polina.setDeathdate(LocalDate.of(2124, 12, 11));
        polina.setLatitude("59.971750");
        polina.setLongitude("30.323477");

        var savedpushkin = deadRepo.save(pushkin.toEntity());
        var savedLenin = deadRepo.save(lenin.toEntity());
        var savedPolina = deadRepo.save(polina.toEntity());

        System.out.println(savedLenin);
        System.out.println(savedpushkin);
        System.out.println(savedPolina);
    }
}
