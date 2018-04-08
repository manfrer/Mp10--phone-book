package at.refugeescode.Mp10phonebook.persistence.repository;

import at.refugeescode.Mp10phonebook.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person save(Person person);
}

