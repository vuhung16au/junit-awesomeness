package com.vuhung.app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
 
	public int square(int n) { 
		return n * n;
	}
	
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test 
    public void testSquare() { 
    	App sqr4 = new App();
    	int sqr4Int = sqr4.square(4);
    	
    	assertEquals(16, sqr4Int);
    }
    
    @Test 
    public void whenAssertingEquality_thenEqual() { 
    	String expectedResult = "Vu Hung"; 
    	String actualResult = "Vu Hung";
    	
    	assertEquals(expectedResult, actualResult);
    }
    
    @Test 
    public void givenNullArrays_whenAssertingArraysEquality_thenEqual() { 
    	int[] expected = null;
    	int[] actual = null;
    	
    	assertArrayEquals(expected, actual);
    }
    
    @Test 
    public void whenAssertingNull_thenTrue() { 
    	String namesString = null;
    	
    	assertNull(namesString);
    }
    
    @Test 
    public void whenAssertingNotSameObject_thenDifferent() { 
    	String pokemon = "Lugia";
    	String legendary = "Ho-oh";
    	
    	assertNotSame(pokemon, legendary);
    }
    
    @Test 
    public void whenAssertingConditions_thenVerified() { 
    	
    	assertTrue("16 is greater than 11", 16 > 11);
    	assertFalse("11 is not greater tha 16", 11 > 16);
    	
    }
    
    
//    public void testAssertThatHasItems() { 
//        assertThat(
//        	      Arrays.asList("Java", "Kotlin", "Scala"), 
//        	      hasItems("Java", "Kotlin"));    
//    }
//    
	/*
	 * // fail() when try
	 * 
	 * @Test public void whenCheckingExceptionMessage_thenEqual() {
	 * 
	 * try { // call a method that throw exception } catch (FileNotFoundException e)
	 * { // } }
	 */
}
