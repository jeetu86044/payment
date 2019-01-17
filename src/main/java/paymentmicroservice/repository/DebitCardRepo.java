package paymentmicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import paymentmicroservice.entity.DebitCard;

public interface DebitCardRepo extends CrudRepository<DebitCard,Integer> {
}
