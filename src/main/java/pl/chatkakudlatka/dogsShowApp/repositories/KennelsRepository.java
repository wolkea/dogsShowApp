package pl.chatkakudlatka.dogsShowApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.chatkakudlatka.dogsShowApp.model.Kennel;

@Repository
public interface KennelsRepository extends JpaRepository <Kennel,Integer>{
}
