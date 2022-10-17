package services;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Contact;
import service.ContactService;

class ContactServiceTest {

	private static ContactService contactService;
	
	@BeforeAll
	static void setup() {
		contactService = ContactService.getService();
	}
	
	@Test
	void testAddContactSuccess() {
		Contact contact = new Contact("123456", "Harry", "Ron", "123 Main Street", "7141234567");	
		assertTrue(contactService.addContact(contact));
		
		Contact getContact = contactService.getContact("123456");
		
		assertTrue(getContact.getContactId().contentEquals(contact.getContactId()));
		assertTrue(getContact.getFirstName().contentEquals(contact.getFirstName()));
		assertTrue(getContact.getLastName().contentEquals(contact.getLastName()));
		assertTrue(getContact.getAddress().contentEquals(contact.getAddress()));
		assertTrue(getContact.getPhoneNumber().contentEquals(contact.getPhoneNumber()));
	}
	
	@Test
	void testAddMultipleContactsSuccess() {
		Contact contact1 = new Contact("12345", "Harry", "Potter", "123 Main Street", "7141234567");
		Contact contact2 = new Contact("12356", "Jon", "Snow", "123 Winterfell", "7141234577");
		
		assertTrue(contactService.addContact(contact1));
		assertTrue(contactService.addContact(contact2));

	}
	
	@Test
	void testAddContactDuplicateIdFail() {
		Contact contact1 = new Contact("12345", "Harry", "Potter", "123 Main Street", "7141234567");
		Contact contact2 = new Contact("12345", "Jon", "Snow", "123 Winterfell", "7141234577");
		
		assertTrue(contactService.addContact(contact1));
		assertFalse(contactService.addContact(contact2));

	}
	
	@Test
	void testGetContactAndUpdateSuccess() {
		Contact contact1 = new Contact("1", "Jon", "Snow", "123 Winterfell", "7141234577");

		assertTrue(contactService.addContact(contact1));
		Contact updateContact = contactService.getContact(contact1.getContactId());
		
		updateContact.setPhoneNumber("7141234577");
		updateContact = contactService.getContact(updateContact.getContactId());
		assertTrue(updateContact.getPhoneNumber().equals("7141234577"));
		
	}
	
	@Test
	void testGetContactAndDeleteSuccess() {
		Contact contact1 = new Contact("12", "Jon", "Snow", "123 Winterfell", "7141234577");

		assertTrue(contactService.addContact(contact1));
		
		Contact contact2 = contactService.getContact(contact1.getContactId());
		assertTrue(contactService.deleteContact(contact2.getContactId()));

		assertTrue(contactService.getContact(contact2.getContactId()) == null);
		
	}
	
	@Test
	void testDeleteInvalidContactFail() {
		String invalidContactId = "1";

		assertFalse(contactService.deleteContact(invalidContactId));
	}

}
