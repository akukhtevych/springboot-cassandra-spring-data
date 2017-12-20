package com.highload.app.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.highload.app.models.TransactionData;
import com.highload.app.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TransactionsDataController extends BaseController {
    @Autowired
    private TransactionService service;

    @RequestMapping(value = "/transaction_data", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> save(@RequestBody TransactionData data) {
        TransactionData one = service.save(data);
        return new ResponseEntity<>(one, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/transaction_data", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/transaction_data/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> findOne(@PathVariable UUID id, @PathVariable String user) {
        TransactionData transactionData = service.findOne(id,user);
        return new ResponseEntity<>(transactionData == null ? Collections.EMPTY_MAP : transactionData, HttpStatus.OK);
    }

    @RequestMapping(value = "/transaction_data/id/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> delete(@PathVariable UUID id, @PathVariable String user) {
        service.delete(id);
        return new ResponseEntity<>(Collections.EMPTY_MAP, HttpStatus.OK);
    }

    @RequestMapping(value = "/transaction_data/deleteAll", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>(Collections.EMPTY_MAP, HttpStatus.OK);
    }

    @RequestMapping(value = "/transaction_data/count", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> count() {
        ObjectNode node = createObjectNode();
        node.put("count", service.count());
        return new ResponseEntity<>(node, HttpStatus.OK);
    }
}
