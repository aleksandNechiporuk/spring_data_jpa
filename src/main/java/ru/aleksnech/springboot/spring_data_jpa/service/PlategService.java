package ru.aleksnech.springboot.spring_data_jpa.service;

import ru.aleksnech.springboot.spring_data_jpa.entity.Plateg;

import java.util.List;

public interface PlategService {

    public List<Plateg> getAllPlateg();

    public void savePlateg(Plateg plateg);

    public Plateg getPlateg(int id);

    public void deletePlateg(int id);

    public Plateg plategUpWork(Plateg plateg);

//    public Plateg addPlategClient(Plateg plateg);
//
}
