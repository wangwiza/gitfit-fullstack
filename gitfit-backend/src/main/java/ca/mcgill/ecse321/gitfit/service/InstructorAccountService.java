package ca.mcgill.ecse321.gitfit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

import ca.mcgill.ecse321.gitfit.dao.InstructorRepository;
import ca.mcgill.ecse321.gitfit.dto.AccountCreationDto;
import ca.mcgill.ecse321.gitfit.dto.PasswordCheckDto;
import ca.mcgill.ecse321.gitfit.exception.SportCenterException;
import ca.mcgill.ecse321.gitfit.model.Instructor;

public class InstructorAccountService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private SportCenterService sportCenterService;

    @Autowired
    private ValidatorService validatorService;

    @Transactional
    public Instructor getInstructor(String username) {
        Instructor instructor = instructorRepository.findInstructorByUsername(username);
        if (instructor == null) {
            throw new SportCenterException(HttpStatus.NOT_FOUND, "Instructor not found.");
        }
        return instructor;
    }

    @Transactional
    public List<Instructor> getAllInstructors() {
        List<Instructor> list = toList(instructorRepository.findAll());
        if (list.isEmpty()) {
            throw new SportCenterException(HttpStatus.NOT_FOUND, "No current instructors.");
        } else {
            return list;
        }
    }

    @Transactional
    public Instructor createInstructor(String username, String email, String password, String lastName,
            String firstName) {

        validatorService.validate(new AccountCreationDto());
        validatorService.validate(new PasswordCheckDto(password));

        Instructor instructor = new Instructor(username, email, password, lastName, firstName,
                sportCenterService.getSportCenter());
        instructorRepository.save(instructor);
        return instructor;
    }

    @Transactional
    public Instructor updateInstructorPassword(String username, String newPassword) {
        Instructor instructor = instructorRepository.findInstructorByUsername(username);

        validatorService.validate(new PasswordCheckDto(newPassword));

        instructor.setPassword(newPassword);
        instructorRepository.save(instructor);
        return instructor;
    }

    private <T> List<T> toList(Iterable<T> iterable) {
        List<T> resultList = new ArrayList<T>();
        for (T t : iterable) {
            resultList.add(t);
        }
        return resultList;
    }
}
