package paymentmicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import paymentmicroservice.entity.Summary;

public interface SummaryRepo extends CrudRepository<Summary,Integer> {
}
