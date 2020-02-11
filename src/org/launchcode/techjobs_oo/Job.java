package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public Employer getEmployer() {
        return employer;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public String getName() {
        return name;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (getName() == null || getEmployer() == null|| getLocation() == null || getPositionType() == null || getCoreCompetency() == null){
            return "OOPS! This job does not seem to exist.";
        } else {
            return "\n" +
                    "ID: " + getId() +
                    "\nName: " + ((getName() != null && getName() != "") ? getName() : "No data available.") +
                    "\nEmployer: " + ((getEmployer().toString() != null && getEmployer().toString() != "") ? getEmployer() : "No data available.") +
                    "\nLocation: " + ((getLocation().toString() != null && getLocation().toString() != "") ? getLocation() : "No data available.") +
                    "\nPosition Type: " + ((getPositionType().toString() != null && getPositionType().toString() != "") ? getPositionType() : "No data available.") +
                    "\nCore Competency: " + ((getCoreCompetency().toString() != null && getCoreCompetency().toString() != "") ? getCoreCompetency() : "No data available.") +
                    "\n";
        }
    }
}
