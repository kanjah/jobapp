package com.mohk.jobapp.job;

import com.mohk.jobapp.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    //Response Entity to relay info to user

//    Get all jobs
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return  ResponseEntity.ok(jobService.findAll());
    }
//    Create Job
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
//        Company c = job.getCompany();
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }
//    Get job by id
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id); // from JobServiceImpl.java
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    Delete job
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
     boolean deleted = jobService.deleteJobById(id);


     if(deleted) //from JobServiceImpl
         return new ResponseEntity<>("Job deleted Succesfully", HttpStatus.OK);
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
//    Update Job
    //@PutMapping("/{id}")
    @RequestMapping(value = "/{id}",  method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
