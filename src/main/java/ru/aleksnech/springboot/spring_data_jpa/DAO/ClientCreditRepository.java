package ru.aleksnech.springboot.spring_data_jpa.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aleksnech.springboot.spring_data_jpa.entity.ClientCredit;

import java.util.List;

public interface ClientCreditRepository extends JpaRepository<ClientCredit, Integer> {
    public List<ClientCredit> findAllByPlategBefore(Double amDebt);

    public List<ClientCredit> findClientCreditByCreditAmount(Double credAmnt);

}
