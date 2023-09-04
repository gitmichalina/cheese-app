package com.example.cheeseapp.cheese;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cheese")
public class CheeseController {

    @GetMapping
    public String getAllCheese() {
        return "List of all cheese";
    }

    @GetMapping("/{cheeseId}")
    public Integer getCheese(@PathVariable("cheeseId") Integer cheeseId) {
        return cheeseId;
    }

    @PostMapping("/")
    public String suggestCheese(){
        return "Thank you, check your e-mail.";
    }

    @PutMapping("/{cheeseId}")
    public String updateCheese(@PathVariable("cheeseId") Integer cheeseId) {
        return cheeseId + " updated";
    }

    @DeleteMapping("/{cheeseId}")
    public String deleteCheese(@PathVariable("cheeseId") Integer cheeseId){
        return "Cheese " + cheeseId + " deleted";
    }
}
