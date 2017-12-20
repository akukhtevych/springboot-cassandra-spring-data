package com.highload.app.services;

import com.highload.app.models.TransactionData;
import com.highload.app.repositories.TransactionsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private TransactionsDataRepository repository;

    public TransactionData save(final TransactionData data) {
        return repository.save(data);
    }

    public TransactionData findOne(UUID id, final String user) {
        return repository.findOne(BasicMapId.id("id", id));
    }

    public List<TransactionData> findAll() {
        List<TransactionData> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public void delete(final UUID id) {
        repository.delete(BasicMapId.id("id", id));
    }

    public long count() {
        return repository.count();
    }

    public boolean exists(final String id) {
        return repository.exists(BasicMapId.id("id", id));
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
