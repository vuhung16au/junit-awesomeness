// package com.vuhung.junit5showcase.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

public class JUnit5ShowcaseTest {
	
	
	@BeforeEach
	// JUnit Jupiter annotation 
	void init() { 
		//
	    System.out.println("**--- Executed before each test method in this class ---**");

	}
	
	@BeforeAll
	// JUnit Jupiter annotation 
	static void setup() { 
	    System.out.println("**--- Executed once before all test methods in this class ---**");

	}

    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {
        assertEquals("Hi jUnit5", JUnit5Showcase.get());
    }
    
    @DisplayName("The test case is disabled")
    @Disabled 
    void testDisabledTestCase() { 
    	assertEquals(2, 1 + 1);
    }
    
   @Test 
   void trueAssumption() { 
	   assumeTrue(2 > 1);
	   assertEquals(1 + 1, 2);
	   
   }
   
   @Test 
   void falseAssumption() { 
	   assumeFalse(2 < 1);
	   assertEquals(1 + 1, 2);
   }
   
   @Test 
   void assumptionThat() { 
	   String myName = "vuhung";
	   
	   // execute the 2nd assert but only if the supplied assumption is valid
	   // https://junit.org/junit5/docs/5.5.2/api/org/junit/jupiter/api/Assumptions.html
	   assumingThat(
			   myName.equals("vuhung"),
			   () -> assertEquals(1 + 1, 2)
			   );
   }
    
   
   @Test 
   void testOnProd() { 
	   System.setProperty("ENV", "PROD");
	   // Only proceed if ENV is not set to DEV
	   Assumptions.assumeFalse("DEV".equals(System.getProperty("PROD")));
	   // The remainder of the test proceed here
   }
   
   @Test void shouldThrowException() { 
	   Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
		   throw new UnsupportedOperationException("Not supported");
	   });
	   
	   // same exception message thrown 
	   assertEquals("Not supported", exception.getMessage());
   }
   
   
   @Test 
   public void whenAssertingArraysEquality_thenEqual() {
	   int[] expected = {1, 4, 9, 16};
	   int[] actual = {1, 2*2, 3*3, 4*4};
	   
	   assertArrayEquals(expected, actual);
	   
   }
   
   
   @DisplayName ("Asserts that expected and actual iterables are deeply equal. ")
   @Test 
   public void whenAssertingIterableArray_thenEquals() { 
	   Iterable<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 9, 16));
	   Iterable<Integer> listTwo = new ArrayList<>(Arrays.asList(1*1, 2*2, 3*3, 4*4));
	   
	   assertIterableEquals(listOne, listTwo);
   }
   
   
   @DisplayName("Test long-running tasks. If a given task inside the test takes more than the specified duration, then the test will fail.")
   @Test 
   public void testLongRunProcess() { 
	   
	   // This will pass
	   // Assert that timeout is less than 500ms
	   // The actual processing time is 400ms 
	   assertTimeout(Duration.ofMillis(500), () -> {
		   Thread.sleep(400);
		   return "Execution result";
	   });
   }
   
   @DisplayName("Assert equals, with a delta")
   @Test 
   public void whenAssertingEqualityWithDelta_thenEqual() { 
	   
	   //Expected result of a square of 2
	   float expectedArea = 2*2;
	   // Actual measured value 
	   float actualAread = 2.01f * 2.02f;
	   
	   // Tolerance within 0.5 is acceptable
	   assertEquals(expectedArea, actualAread, 0.5);
   }
   
   @DisplayName("assertAll(): Grouped assertions")
   @Test 
   public void givenMultipleAssertion_whenAssertingAll_thenOK() { 
	   
	   assertAll("Multiple assertion",
			   () -> assertEquals(1 + 1, 2),
			   () -> assertEquals("vuhung", "Vuhung".toLowerCase())
			   );
   }
   
   
    @AfterEach 
	// JUnit Jupiter annotation 
    void tearDown() { 
        System.out.println("**--- Executed after each test method in this class ---**");

    	
    }
    
    @AfterAll 
	// JUnit Jupiter annotation 
    static void done() { 
        System.out.println("**--- Executed once after all test methods in this class ---**");

    	
    }
    

}
