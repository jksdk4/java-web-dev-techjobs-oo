package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JobTest {
    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;

    @Before
    public void createJobObjects(){
        // blank jobs
        test_job1 = new Job();
        test_job2 = new Job();
        // similar jobs, different id
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        // job with missing field
        test_job5 = new Job("Web Developer", new Employer("LaunchCode"), new Location(), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
    }
    @Test
    public void testSettingJobId(){
        assertTrue(test_job1.getId() == test_job2.getId() - 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(test_job3 instanceof Job);
        assertEquals("Product tester", test_job3.getName());
        assertEquals("ACME", test_job3.getEmployer().getValue());
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
    }

    // uses overridden equals method to check equality via id number
    @Test
    public void testJobsForEquality(){
        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    public void testBlanksToString(){
        assertTrue(test_job4.toString().startsWith("\n"));
        assertTrue(test_job4.toString().endsWith("\n"));
    }

    @Test
    public void testNonexistentJob(){
        assertEquals("OOPS! This job does not seem to exist.",test_job1.toString());
    }

    @Test
    public void testMissingDataField(){
        assertTrue(test_job5.toString().contains("No data available."));
    }


}
