package pl.chatkakudlatka.dogsShowApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.chatkakudlatka.dogsShowApp.model.Dog;
import pl.chatkakudlatka.dogsShowApp.repositories.BreedsRepository;
import pl.chatkakudlatka.dogsShowApp.repositories.DogsRepository;

import java.util.List;

@Service
public class DogServices {
    private final DogsRepository dogsRepository;
    private final BreedsRepository breedsRepository;

    @Autowired
    public DogServices(DogsRepository dogsRepository, BreedsRepository breedsRepository) {
        this.dogsRepository = dogsRepository;
        this.breedsRepository = breedsRepository;
    }

    public List<Dog> getAllDogs() {
        return dogsRepository.findAll();
    }

    public Dog getDog(Integer id) {
        return dogsRepository.getById(id);
    }

    public Dog save(Dog dogToSave) {
        return dogsRepository.save(dogToSave);
    }
}
