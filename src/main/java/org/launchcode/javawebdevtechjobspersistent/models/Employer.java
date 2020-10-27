package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message="Location cannot be blank")
    @Size(min=2, message="Location must be longer than 2 characters")
    String location;

    public Employer(@NotBlank(message = "Location cannot be blank") @Size(min = 2, message = "Location must be longer than 2 characters") String location) {
        this.location = location;
    }

    public Employer(){ }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
