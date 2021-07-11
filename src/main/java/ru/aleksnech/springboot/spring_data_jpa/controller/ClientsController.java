package ru.aleksnech.springboot.spring_data_jpa.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aleksnech.springboot.spring_data_jpa.entity.ClientCredit;
import ru.aleksnech.springboot.spring_data_jpa.entity.Plateg;
import ru.aleksnech.springboot.spring_data_jpa.service.ClientService;
import ru.aleksnech.springboot.spring_data_jpa.service.PlategService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientsController {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private ClientService clientService;
    @Autowired
    private PlategService plategService;

    @GetMapping("/client/all") // Вывод json таблицы всех клиентов со всей инфой
    public List<ClientCredit> showAllClients() {

        List<ClientCredit> allClients = clientService.getAllClients();
        return allClients;
    }

    @GetMapping("/client/allplateg") // Вывод json всей таблицы платежей
    public List<Plateg> showAllPlateg() {
        List<Plateg> allPlateg = plategService.getAllPlateg();
        return allPlateg;
    }

    @GetMapping("/client/nocredamunt/{crdAmnt}") //Вывод списка клиентов с creditAmount == 0.00. возвожно указать любую сумму, будет искать в тадлице клиентов с указанной задолженностью
    public List<ClientCredit> notCredAmnt(@PathVariable Double crdAmnt) {
        List<ClientCredit> notcrdAmnt1 =clientService.notCredAmount(crdAmnt);
        return notcrdAmnt1;
    }

    @GetMapping("/client/plategamnt/{platAmnt}") // Выводит список клиентов с непогашенной задолженностью
    public List<ClientCredit> plategAmnt(@PathVariable Double platAmnt) {
        List<ClientCredit> notcrdAmnt1 =clientService.plategEmpty(platAmnt);
        return notcrdAmnt1;
    }

    @GetMapping("/client/{id}") // Вывод клиента по его id
    public ClientCredit getClient(@PathVariable int id) {
        ClientCredit client = clientService.getClient(id);
        return client;
    }

    @GetMapping("/client/plateg/{id}") // Вывод платежа по id
    public Plateg getPlategById(@PathVariable int id){
        Plateg plateg =plategService.getPlateg(id);
        return plateg;
    }

    @PostMapping("/client/plateg") //Ввод платежа и обработка его в таблицах по клиенту
    public Plateg addPlategClient(@RequestBody Plateg plateg){
        plategService.plategUpWork(plateg);

        return plateg;
    }

    @PostMapping("/client") // Добавление нового клиента в таблицу и ввод по нему данных по обязательному платежу и инфы по сумме остатка по действующему кредиту.
    public ClientCredit addNewClient(@RequestBody ClientCredit client ) {
        clientService.saveClent(client);
        logger.info("Added new Client end credit Amount" + client.getSurName()
                + " " + client.getName() +" " +client.getLastName()
                + " " +client.getAmountDebt()+ " " +client.getAmountDebt());

        return client;
    }

    @PutMapping("/client") // Редактирование инфы по клиенту. В body json обязательно указать id клиента
    public ClientCredit updateClients(@RequestBody ClientCredit client) {
        clientService.saveClent(client);
        logger.info("Update Client end credit Amount" + client.getSurName()
                + " " + client.getName() +" " +client.getLastName()
                + " " +client.getCreditAmount()+ " " +client.getAmountDebt());
        return client;
    }

    @PutMapping("/client/plateg") // Редактирование платежа с последующей обработкой
    public Plateg updatePlateg(@RequestBody Plateg plateg) {
        plategService.plategUpWork(plateg);
        logger.info("Update Client end credit Amount" + + plateg.getClientId()
                + " " +plateg.getPlategClient()+ " " + plateg.getDateUpWork());
        return plateg;
    }

    @DeleteMapping("/client/{id}") //удаление клиента из таблицы
    public String deleteClient(@PathVariable int id){
        String mes1 = null;
        mes1 = clientService.deleteClient(id);
        return mes1;
    }

    @DeleteMapping("/client/plateg/{id}") // удаление платежа из таблицы
    public String deletePlateg(@PathVariable int id){
        plategService.deletePlateg(id);
        return "";
    }

}
