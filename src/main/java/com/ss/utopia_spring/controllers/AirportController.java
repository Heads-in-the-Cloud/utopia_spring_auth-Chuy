package com.ss.utopia_spring.controllers;

import com.ss.utopia_spring.entities.Airport;
import com.ss.utopia_spring.services.AirportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// Rest controller is going to be one of the objects we will manage
@RestController
public class AirportController {

    // Autowired means give me the class so i can work with it.
    @Autowired 
    AirportService airportService;

    // GET A SPECIFIC AIRPORT BY AIRPORT CODE
    @RequestMapping(path= "/airports/{airportcode}", method= RequestMethod.GET)
    public Airport getAirport(@PathVariable String airportcode){
        return airportService.getAirportByCode(airportcode);
    }

    // GET ALL AIRPORTS
    @RequestMapping(path= "/airports", method= RequestMethod.GET)
    public List<Airport> getAirports(){
        return airportService.getAirports();
    }

    // ADD A NEW AIRPORT
    @RequestMapping(path= "/airports/newairport", method= RequestMethod.POST)
    public ResponseEntity<Object> addAirport(@RequestBody Airport airport){
        airportService.addAirport(airport);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

}
