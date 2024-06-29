package org.example.firstjobapp.repository;

import org.example.firstjobapp.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
