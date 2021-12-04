package pl.chatkakudlatka.dogsShowApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.chatkakudlatka.dogsShowApp.model.Owner;

@Repository

public interface OwnersRepository extends JpaRepository<Owner, Integer> {
}
