package com.elpms.controller;

import com.elpms.model.Request;
import com.elpms.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Author: Duncan MacLeod (101160585)
 *
 * Contains the API mappings and function calls that manipulate the 'request' table in the database
 */
@RestController
@RequestMapping("api/request")
public class RequestController {

    @Autowired
    RequestRepository requestRepo;

    @GetMapping("/getAll")
    public List<Request> getAllItems() {
        return requestRepo.findAll();
    }

    @GetMapping("/findByName")
    public List<Request> findByName(@RequestParam("name") String name) {
        return requestRepo.findByName(name);
    }

    @GetMapping("/findById")
    public Request findById(@RequestParam("id") String id) {

        Optional<Request> account = requestRepo.findById(id);

        return account.orElse(null);
    }

}
