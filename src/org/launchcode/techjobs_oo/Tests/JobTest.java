package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.Employer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JobTest {
    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;

    @Before
    public void createJobObjects(){
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId(){
        assertTrue(test_job1.getId() == test_job2.getId() - 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(test_job3 instanceof Job);
        assertEquals("Product tester", test_job3.getName());
    }

    // uses overridden equals method to check equality via id number
    @Test
    public void testJobsForEquality(){
        assertFalse(test_job3.equals(test_job4));
    }


}
