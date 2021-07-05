package ru.aleksnech.springboot.spring_data_jpa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aleksnech.springboot.spring_data_jpa.DAO.ClientCreditRepository;
import ru.aleksnech.springboot.spring_data_jpa.DAO.PlategClientRepository;
import ru.aleksnech.springboot.spring_data_jpa.entity.ClientCredit;
import ru.aleksnech.springboot.spring_data_jpa.entity.Plateg;

import java.util.List;
import java.util.Optional;

@Service
public class PlategServiceImpl implements PlategService {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private ClientCreditRepository clientCreditRepository;
    @Autowired
    private PlategClientRepository plategClientRepository;

    @Override
    public List<Plateg> getAllPlateg() {
        logger.info("Show all plateg in Table " + plategClientRepository
                .findAll()
                .size());
        return plategClientRepository.findAll();
    }

    @Override
    public void savePlateg(Plateg plateg) {
        plategClientRepository.save(plateg);

        logger.info("Plateg " + plateg.getId()+ "saved in Table!");
    }

    @Override
    public Plateg getPlateg(int id) {
        Plateg plateg = null;
        Optional<Plateg> plateg1 =plategClientRepository.findById(id);
        if (plateg1.isPresent()){
            plateg = plateg1.get();
            logger.info("Show plateg " + plateg.getId()+ " in Table!");
        } else {
            logger.info("Plateg ID ->" +id+ " not find from Table.");
        }
        return plateg ;
    }

    @Override
    public void deletePlateg(int id) {

        Optional<Plateg> plateg1 = plategClientRepository.findById(id);
        if (plateg1.isPresent()) {
            plategClientRepository.deleteById(id);
            logger.info("Plateg " + id + " deleted  from  Table!");
        } else {
            logger.info("Plateg ID " + id+ " NOT present in Table.");
        }
    }

    @Override
    public Plateg plategUpWork(Plateg plateg) {

        ClientCredit clientCredit = null;

        clientCredit = clientCreditRepository.getById(plateg.getClientId());
            if (clientCredit.getCreditAmount()<=plateg.getPlategClient()) {
                Double pereplata = plateg.getPlategClient()-clientCredit.getCreditAmount();
                clientCredit.setCreditAmount(0.00);
                clientCredit.setAmountDebt(clientCredit.getAmountDebt() - pereplata);
                clientCredit.setPlateg(0.00);

            } else {
                Double dolg = clientCredit.getCreditAmount() - plateg.getPlategClient();
                    clientCredit.setCreditAmount(clientCredit.getCreditAmount() - plateg.getPlategClient());
                System.out.println(dolg);
             }
            clientCredit.setPlateg_date(plateg.getDatePlateg());
            plateg.setDateUpWork(plateg.getDatePlateg());

            plategClientRepository.save(plateg);
            clientCreditRepository.save(clientCredit);
            logger.info("Added new Plateg for Client " + plateg.getClientId()+" credit Amount" +
                     " " +plateg.getPlategClient()+ " " + plateg.getDateUpWork());

        return plateg;
    }

}
