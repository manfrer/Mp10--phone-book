package at.refugeescode.Mp10phonebook.endpoint;

import at.refugeescode.Mp10phonebook.persistence.model.Person;
import at.refugeescode.Mp10phonebook.persistence.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class PersonEndPoint {
    private PersonRepository personRepository;

    public PersonEndPoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @GetMapping("/{id}")
    Person showOneById(@PathVariable Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent())
            return optionalPerson.get();
        return null;
    }

    @GetMapping
    List<Person> showAll(){
        return personRepository.findAll();
    }

    @PostMapping
    Person save(@RequestBody Person newPerson){
        return personRepository.save(newPerson);
    }

    @DeleteMapping("/{id}")
    String deleteOneById(@PathVariable Long id){
        personRepository.deleteById(id);
        return "the contact has been deleted";
    }
}
