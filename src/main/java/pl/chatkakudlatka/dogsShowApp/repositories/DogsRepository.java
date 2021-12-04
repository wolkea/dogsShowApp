package pl.chatkakudlatka.dogsShowApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.chatkakudlatka.dogsShowApp.model.Dog;

@Repository
public interface DogsRepository extends JpaRepository<Dog, Integer> {

}