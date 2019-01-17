package paymentmicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import paymentmicroservice.entity.PaymentOption;

public interface PaymentOptionRepo extends CrudRepository<PaymentOption,Integer> {
}
