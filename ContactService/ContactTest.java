package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Contact;

class ContactTest {

	//Test Contact create
	@Test
	void testCreateContactSuccess() {
		Contact contact = new Contact("123456", "Harry", "Ron", "123 Main Street", "7141234567");	
		
		assertTrue(contact != null);
		assertTrue(contact.getContactId().equals("123456"));
		assertTrue(contact.getFirstName().equals("Harry"));
		assertTrue(contact.getLastName().equals("Potter"));
		assertTrue(contact.getAddress().equals("123 Main Street"));
		assertTrue(contact.getPhoneNumber().equals("7141234567"));
	}
	
	// fails to Contact ID since there are more than 10 characters
	@Test
	void testCreateContactContactIdFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("12345678901", "Harry", "Potter", "123 Main Street", "7141234567");
		    });	
	}
	// fails the Constact First 
	@Test
	void testCreateContactFirstNameFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("1234567", "Harryyyyyyyyyyyyy", "Potter", "123 Main Street", "7141234567");
		    });	
	}
	// fails Last Name since there are more than 10 characters
	@Test
	void testCreateContactLastNameFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("1234567", "Harry", "Potterrrrrrrrrrr", "123 Main Street, "7141234567");
		    });	
	}
	// fails the address since there are more than 20 characters 
	@Test
	void testCreateContactAddressFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("1234567", "Harry", "Potter", "123 Main Strettttttttttttt", "7141234567");
		    });	
	}
	// fails the phone number since there are more than 10 digits
	@Test
	void testCreateContactNumberToLongFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("1234567", "Harry", "Potter", "123 Main Street", "714123456777");
		    });	
	}
	
	@Test
	void testCreateContactNumberToShortFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("1234567", "Harry", "Potter", "123 Main Street", "714"));
		    });	
	}
	
	
	//Test Contact Update
	
	@Test
	void testUpdateContactSuccess() {
		Contact contact = new Contact("1234567", "Harry", "Potter", "123 Main Street", "7141234567");	
		
		contact.setAddress("New Address");
		contact.setContactFirstName("Jon");
		contact.setContactLasttName("Snow");
		contact.setPhoneNumber("1234567890");
		
		assertTrue(contact.getContactId().equals("123456"));
		assertTrue(contact.getFirstName().equals("Jon"));
		assertTrue(contact.getLastName().equals("Snow"));
		assertTrue(contact.getAddress().equals("New Address"));
		assertTrue(contact.getPhoneNumber().equals("1234567890"));
	}
	
	@Test
	void testUpdateContactAddressFails() {
		Contact contact = new Contact("123456", "Harry", "Ron", "123 Main Street", "7141234567");	
		assertFalse(contact.setAddress("123 Main Streetttttttttt"));
	}
	
	@Test
	void testUpdateContactFirstNameFails() {
		Contact contact = new Contact("123456", "Harry", "Ron", "123 Main Street", "7141234567");	
		assertFalse(contact.setContactFirstName("Harryyyyyyyyyyyyy"));
	}
	
	@Test
	void testUpdateContactLastNameFails() {
		Contact contact = new Contact("123456", "Harry", "Ron", "123 Main Street", "7141234567");	
		assertFalse(contact.setContactLasttName("Potterrrrrrrrrrr"));
	}
	
	@Test
	void testUpdateContactNumberNotDigitFails() {
		Contact contact = new Contact("123456", "Harry", "Ron", "123 Main Street", "7141234567");	
		assertFalse(contact.setPhoneNumber("ABScdEffff"));
	}
	
	@Test
	void testUpdateContactNumberToShortFails() {
		Contact contact = new Contact("123456", "Harry", "Ron", "123 Main Street", "7141234567");	
		assertFalse(contact.setPhoneNumber("12345"));
	}
	
	@Test
	void testUpdateContactNumberToLongFails() {
		Contact contact = new Contact("123456", "Harry", "Ron", "123 Main Street", "7141234567");	
		assertFalse(contact.setPhoneNumber("7141234567890"));
	}
	

}