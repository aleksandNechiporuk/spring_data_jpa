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

    @GetMapping("/client/all")
    public List<ClientCredit> showAllClients() {

        List<ClientCredit> allClients = clientService.getAllClients();
        return allClients;
    }

    @GetMapping("/client/allplateg")
    public List<Plateg> showAllPlateg() {
        List<Plateg> allPlateg = plategService.getAllPlateg();
        return allPlateg;
    }

    @GetMapping("/client/nocredamunt/{crdAmnt}")
    public List<ClientCredit> notCredAmnt(@PathVariable Double crdAmnt) {
        List<ClientCredit> notcrdAmnt1 =clientService.notCredAmount(crdAmnt);
        return notcrdAmnt1;
    }

    @GetMapping("/client/plategamnt/{platAmnt}")
    public List<ClientCredit> plategAmnt(@PathVariable Double platAmnt) {
        List<ClientCredit> notcrdAmnt1 =clientService.plategEmpty(platAmnt);
        return notcrdAmnt1;
    }

    @GetMapping("/client/{id}")
    public ClientCredit getClient(@PathVariable int id) {
        ClientCredit client = clientService.getClient(id);
        return client;
    }

    @GetMapping("/client/plateg/{id}")
    public Plateg getPlategById(@PathVariable int id){
        Plateg plateg =plategService.getPlateg(id);
        return plateg;
    }

    @PostMapping("/client/plateg")
    public Plateg addPlategClient(@RequestBody Plateg plateg){
        plategService.plategUpWork(plateg);

        return plateg;
    }

    @PostMapping("/client")
    public ClientCredit addNewClient(@RequestBody ClientCredit client ) {
        clientService.saveClent(client);
        logger.info("Added new Client end credit Amount" + client.getSurName()
                + " " + client.getName() +" " +client.getLastName()
                + " " +client.getAmountDebt()+ " " +client.getAmountDebt());

        return client;
    }

    @PutMapping("/client")
    public ClientCredit updateClients(@RequestBody ClientCredit client) {
        clientService.saveClent(client);
        logger.info("Update Client end credit Amount" + client.getSurName()
                + " " + client.getName() +" " +client.getLastName()
                + " " +client.getCreditAmount()+ " " +client.getAmountDebt());
        return client;
    }

    @PutMapping("/client/plateg")
    public Plateg updatePlateg(@RequestBody Plateg plateg) {
        plategService.plategUpWork(plateg);
        logger.info("Update Client end credit Amount" + + plateg.getClientId()
                + " " +plateg.getPlategClient()+ " " + plateg.getDateUpWork());
        return plateg;
    }

    @DeleteMapping("/client/{id}")
    public String deleteClient(@PathVariable int id){
        String mes1 = null;
        mes1 = clientService.deleteClient(id);
        return mes1;
    }

    @DeleteMapping("/client/plateg/{id}")
    public String deletePlateg(@PathVariable int id){
        plategService.deletePlateg(id);
        return "";
    }

}
