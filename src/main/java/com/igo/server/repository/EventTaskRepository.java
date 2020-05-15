package com.igo.server.repository;

import com.igo.server.model.EventTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTaskRepository extends JpaRepository<EventTask, Long> {
}
