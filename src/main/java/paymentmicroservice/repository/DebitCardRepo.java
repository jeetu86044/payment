package paymentmicroservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import paymentmicroservice.entity.DebitCard;

import javax.print.DocFlavor;
import java.util.List;

public interface DebitCardRepo extends CrudRepository<DebitCard,Integer> {

    @Query("SELECT debitCard.name FROM DebitCard debitCard WHERE debitCard.isActive=true")
    public List<String> getCardTypes();
}
