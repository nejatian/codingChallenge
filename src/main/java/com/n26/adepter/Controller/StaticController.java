package com.n26.adepter.Controller;

import com.n26.Model.Transaction;
import com.n26.adepter.Service.StaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StaticController {
    @Autowired
    private StaticService staticService;


    @PostMapping("/transactions")
    public ResponseEntity<?> newTransaction(@Valid @RequestBody Transaction transaction) {

        staticService.newTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }

    @GetMapping("/statistics")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getStatics() {

        return ResponseEntity.status(HttpStatus.OK).body(staticService.getStatics());
    }

    @DeleteMapping("/transactions")
    public ResponseEntity<?> deleteAll() {
        staticService.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}
