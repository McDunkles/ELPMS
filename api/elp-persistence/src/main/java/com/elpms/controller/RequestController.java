package com.elpms.controller;

import com.elpms.model.Request;
import com.elpms.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @RequestMapping(value = "/addRequest", method = {RequestMethod.GET, RequestMethod.POST})
    public Request addRequest(
            @RequestParam("id") String id, @RequestParam("name") String name,
            @RequestParam("email") String email, @RequestParam("signout_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate signout_date,
            @RequestParam("return_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate return_date,
            @RequestParam("requested_item1") int requested_item1,
            @RequestParam("requested_item2") int requested_item2
    ) {

        Request newRequest = new Request(id, name, email, signout_date, return_date, requested_item1, requested_item2);

        requestRepo.save(newRequest);
        return newRequest;
    }


    @RequestMapping(value = "/removeRequest", method = {RequestMethod.GET, RequestMethod.DELETE})
    public Request removeRequest(
            @RequestParam("id") String id
    ) {

        Request request = requestRepo.findById(id).orElse(null);

        if (request != null) {
            requestRepo.delete(request);
        }

        return request;
    }

}
