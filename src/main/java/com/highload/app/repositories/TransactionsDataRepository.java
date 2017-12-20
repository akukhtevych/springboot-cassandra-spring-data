package com.highload.app.repositories;

import com.highload.app.models.TransactionData;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface TransactionsDataRepository extends CassandraRepository<TransactionData> {
}
