package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message="Location cannot be blank")
    @Size(min=2, message="Location must be longer than 2 characters")
    private String location;

    @OneToMany
    @JoinColumn(name = "job_id")
   private List<Job> jobs = new ArrayList<>();

    public Employer(@NotBlank(message = "Location cannot be blank") @Size(min = 2, message = "Location must be longer than 2 characters") String location) {
        this.location = location;
    }


    public Employer(){ }

    public List<Job> getJobs() {
        return jobs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
