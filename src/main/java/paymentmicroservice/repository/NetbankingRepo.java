package paymentmicroservice.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import paymentmicroservice.entity.Netbanking;
import java.util.List;

public interface NetbankingRepo extends CrudRepository<Netbanking,Integer> {

    @Query("SELECT p.name FROM Netbanking p WHERE p.isActive=true")
    public List<String> getAllBankS();
}
