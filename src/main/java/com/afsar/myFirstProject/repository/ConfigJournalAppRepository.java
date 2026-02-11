package com.afsar.myFirstProject.repository;

import com.afsar.myFirstProject.entity.ConfigJournalApp;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalApp, ObjectId> {
}
