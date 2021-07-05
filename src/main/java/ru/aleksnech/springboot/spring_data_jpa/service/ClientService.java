package ru.aleksnech.springboot.spring_data_jpa.service;

import ru.aleksnech.springboot.spring_data_jpa.entity.ClientCredit;

import java.util.List;

public interface ClientService {
    public List<ClientCredit> getAllClients();

    public void saveClent(ClientCredit client);

    public ClientCredit getClient(int id);

    public String deleteClient(int id);

    public List<ClientCredit> notCredAmount(Double crdtAmounnt);

    public List<ClientCredit> plategEmpty(Double plateg);
}
