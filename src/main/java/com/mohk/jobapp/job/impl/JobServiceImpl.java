package com.mohk.jobapp.job.impl;

import com.mohk.jobapp.job.Job;
import com.mohk.jobapp.job.JobRepository;
import com.mohk.jobapp.job.JobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    //JobRepository constructor
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;

    }
   // private List<Job> jobs = jobRepository.findAll();

    //GET ALL JOBS
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    //CREATE JOB
    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    //GET JOB BY ID

    @Override
    public Job getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);
    }

    //DELETE JOB
    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


//    UPDATE JOB
    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }

        return false;
    }
}
