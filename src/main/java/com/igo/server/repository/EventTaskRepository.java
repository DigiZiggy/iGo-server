package com.igo.server.repository;

import com.igo.server.model.EventTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTaskRepository extends JpaRepository<EventTask, Long> {
}
