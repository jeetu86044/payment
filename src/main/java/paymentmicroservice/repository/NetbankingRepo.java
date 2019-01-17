package paymentmicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import paymentmicroservice.entity.Netbanking;

public interface NetbankingRepo extends CrudRepository<Netbanking,Integer> {
}
