package pl.chatkakudlatka.dogsShowApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.chatkakudlatka.dogsShowApp.model.Breed;

@Repository
public interface BreedsRepository extends JpaRepository <Breed, Integer> {
}
