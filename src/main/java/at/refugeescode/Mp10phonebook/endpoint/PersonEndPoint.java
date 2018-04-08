package at.refugeescode.Mp10phonebook.endpoint;

import at.refugeescode.Mp10phonebook.persistence.model.Person;
import at.refugeescode.Mp10phonebook.persistence.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class PersonEndPoint {
    private PersonRepository personRepository;

    public PersonEndPoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @GetMapping
    List<Person> showAll(){
        return personRepository.findAll();
    }

    @PostMapping
    Person save(@RequestBody Person newPerson){
        return personRepository.save(newPerson);
    }
}
