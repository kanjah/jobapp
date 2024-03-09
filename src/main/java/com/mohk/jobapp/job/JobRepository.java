package com.mohk.jobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}


/*
* JobRepository connects to Job(model) and Long(primary key)
*  */