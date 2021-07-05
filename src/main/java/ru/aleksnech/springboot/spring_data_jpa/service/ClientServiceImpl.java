package ru.aleksnech.springboot.spring_data_jpa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Service;
import ru.aleksnech.springboot.spring_data_jpa.DAO.ClientCreditRepository;
import ru.aleksnech.springboot.spring_data_jpa.entity.ClientCredit;


import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private ClientCreditRepository clientCreditRepository;

    @Override
    public List<ClientCredit> getAllClients() {
        logger.info("Show all Clients " + clientCreditRepository.findAll().size());
        return clientCreditRepository.findAll();
    }

    @Override
    public void saveClent(ClientCredit client) {
        logger.info("Save in Table Client " + client.getId());
        clientCreditRepository.save(client);
    }

    @Override
    public ClientCredit getClient(int id) {
        ClientCredit clientCredit = null;
        Optional<ClientCredit> client1 = clientCreditRepository.findById(id);
        if(client1.isPresent()){
            clientCredit = client1.get();
        } else {
            logger.info("Client ID " + id + "not find in Table");
        }
        return clientCredit;
    }

    @Override
    public String deleteClient(int id) {
        String mes1 = null;
        Optional<ClientCredit> client1 = clientCreditRepository.findById(id);
        if (client1.isPresent()) {
            clientCreditRepository.deleteById(id);
            mes1 = "Client " + id + " DELETED from Table";
            logger.info(mes1);
        } else {
            mes1 = "Client " +id + " not DELETED, not Present in Table";
            logger.info(mes1);
        }
        return mes1;
    }

    @Override
    public List<ClientCredit> notCredAmount(Double crdtAmounnt) {
        logger.info("Show cliens is Credit Amount " + crdtAmounnt + " in Table " +
                clientCreditRepository
                        .findClientCreditByCreditAmount(crdtAmounnt)
                        .size() );
        return clientCreditRepository.findClientCreditByCreditAmount(crdtAmounnt);
    }

    @Override
    public List<ClientCredit> plategEmpty(Double plateg) {
        logger.info(("Show clients by plate " + plateg+ " in Table " +
                clientCreditRepository
                        .findAllByPlategBefore(plateg)
                        .size()));
        return clientCreditRepository.findAllByPlategBefore(plateg);
    }

}
