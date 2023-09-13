package com.example.cheeseapp.user;

import com.example.cheeseapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;  // field injection

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        try {
            List<User> userList = new ArrayList<>();
//            userRepository.findAll().forEach(userList::add);
            userList.addAll(userRepository.findAll());

            //ale kolekcja moze byc pusta!
            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // zwracamy status ale tez dane
            }
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //gdyby cos poszlo nie tak
        }
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        Optional<User> userData = userRepository.findById(userId);// bo moze byc null
        // mozna tu dodac try i catch
        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK); //get() zeby faktycznie pobrac dane
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
//        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id : " + userId));
//        return ResponseEntity.ok(user);
//    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {  // stad bierzemy wszystko poza id

        //try i catch tutaj mozna
        User newUserObject = userRepository.save(user);
        // tutaj obiekt jaki chcemy zapisać, ale tez zwraca tu obiekt, ktory bedzie stworzony w bazie danych - cały

        return new ResponseEntity<>(newUserObject, HttpStatus.OK);
    }

//    @PostMapping("/{userId}")
//    public ResponseEntity<User> updateUserById(@PathVariable("userId") Long userId, @RequestBody User newUserData) {
//
//        Optional<User> oldUserData = userRepository.findById(userId);
//        if(oldUserData.isPresent()) {
//            User updatedUserData = oldUserData.get();
//            updatedUserData.setGender(newUserData.getGender());
//            updatedUserData.setFirstName(newUserData.getFirstName());
//            updatedUserData.setLastName(newUserData.getLastName());
//            updatedUserData.setStatus(newUserData.getStatus());
//            updatedUserData.setRole(newUserData.getRole());
//            updatedUserData.setType(newUserData.getType());
//            updatedUserData.setUsername(newUserData.getUsername());
//            updatedUserData.setEmail(newUserData.getEmail());
//            updatedUserData.setLocation(newUserData.getLocation());
//            updatedUserData.setProfileImageId(newUserData.getProfileImageId());
//            updatedUserData.setDescription(newUserData.getDescription());
//            updatedUserData.setModifiedAt((newUserData.getModifiedAt()));
//            updatedUserData.setCreatedAt((newUserData.getCreatedAt()));
//
//            User updatedUserObject = userRepository.save(updatedUserData);
//            return new ResponseEntity<>(updatedUserObject, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User newUserData){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id : " + userId));

        user.setStatus(newUserData.getStatus());
        user.setType(newUserData.getType());
        user.setUsername(newUserData.getUsername());
        user.setEmail(newUserData.getEmail());
        user.setProfileImageId(newUserData.getProfileImageId());
        user.setDescription(newUserData.getDescription());
        user.setModifiedAt((newUserData.getModifiedAt()));
        user.setCreatedAt((newUserData.getCreatedAt()));

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("userId") Long userId) {

        userRepository.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);

        // jak nie znajdzie id to jest 500

    }
}
