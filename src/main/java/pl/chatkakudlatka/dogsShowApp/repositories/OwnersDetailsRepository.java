package pl.chatkakudlatka.dogsShowApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.chatkakudlatka.dogsShowApp.model.OwnerDetails;

@Repository
public interface OwnersDetailsRepository extends JpaRepository <OwnerDetails, Integer> {
}
