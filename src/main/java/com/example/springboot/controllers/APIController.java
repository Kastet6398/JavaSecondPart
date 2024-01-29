package com.example.springboot.controllers;

import com.example.springboot.models.MessageModel;
import com.example.springboot.models.PersonModel;
import com.example.springboot.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class APIController {

    @GetMapping("/")
    public MessageModel index(@RequestParam(name = "name", required = false) String name) {
        PersonModel person = null;
        try {
            person = (PersonModel) Utils.readJson("person.json", PersonModel.class);
        } catch (IOException ignored) {
        }

        String message;
        if (name == null && person != null) {
            message = STR."Hello, \{person.getName()}!";
        } else {
            message = "Hello, Guest!";
        }

        return new MessageModel(message);
    }

    @GetMapping("/person")
    public PersonModel showPerson() {
        try {
            return (PersonModel) Utils.readJson("person.json", PersonModel.class);
        } catch (IOException ignored) {
            return new PersonModel();
        }
    }

    @PostMapping("/person")
    public MessageModel processForm(@RequestBody PersonModel personForm) {
        try {
            Utils.writeJson("person.json", personForm);
            return new MessageModel("Person details saved successfully!");
        } catch (IOException e) {
            return new MessageModel("Error saving person details.");
        }
    }

    @DeleteMapping("/person")
    public MessageModel deletePerson() {
        try {
            Utils.delete("person.json");
            return new MessageModel("Person details deleted successfully!");
        } catch (IOException e) {
            return new MessageModel("Error deleting person details.");
        }
    }

    @GetMapping("/person-details")
    @PostMapping("/person-details")
    public PersonModel personDetails() {
        try {
            return (PersonModel) Utils.readJson("person.json", PersonModel.class);
        } catch (IOException ignored) {
            return new PersonModel();
        }
    }
}
