package com.example.HWTM;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HwtmApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	EventRepository eventRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDataConnection(){
		List<User> users = userRepository.getAllUsers();

		Assert.assertEquals("size of result is 5", 5, users.size());
		Assert.assertEquals("first user is rob", "Rob", users.get(0).getFirstName());
		Assert.assertEquals("second user is Miriam", "Miriam", users.get(1).getFirstName());
		Assert.assertEquals("third user is Greg", "Greg", users.get(2).getFirstName());
	}

	@Test
	public void testSaveUser(){
		int diff;
		User user = new User("Bill","Jenkins","billy", "billy@mail.com","bill", "Bill Street");
		List<User> usersBeforeAdding = userRepository.getAllUsers();
		userRepository.saveUser(user);
		List<User> usersAfterAdding = userRepository.getAllUsers();
		diff = usersAfterAdding.size() - usersBeforeAdding.size();
		Assert.assertEquals("size of result is 1", 1, diff);
	}

	@Test
	public void testUpdateUser(){

		User rob = userRepository.getAllUsers().get(0);
		rob.setFirstName("Bob");
		userRepository.updateUser(rob);
		Assert.assertEquals("First name of user will be change to Bob", "Bob", rob.getFirstName());
	}

	@Test
	public void testFindAllEvents(){
		List<Event> events = eventRepository.getAllEvents();
		Assert.assertEquals("The number of events must be 8", 8, events.size());
	}

	@Test
	public void testSaveEvent(){
		Event testEvent = new Event(1, "Rob", "Dinner", "19:39", "22/02/18", "Ggatan 3", "A fun event", 6, 299);
		int sizeBefore = eventRepository.getAllEvents().size();
		eventRepository.saveEvent(testEvent);
		int sizeAfter = eventRepository.getAllEvents().size();

		Assert.assertEquals("Size should increase by 1", 1, sizeAfter - sizeBefore );
	}

	@Test
	public void testGetEventsByUserId(){
		List<Event> events = eventRepository.getEventsByUserId(1);
		Assert.assertEquals("Size of list should be 2",2, events.size());
	}

	@Test
    public void testGetAllAttendeesToEventById(){
	    List<User> attendees = eventRepository.getAttendeesByEventId(1L);

	    Assert.assertEquals("Attendees should be 2", 2, attendees.size());
    }

    @Test
    public void testEventDetailsMethod(){
	    Event events = eventRepository.getEventDetails(1L);
	    Assert.assertEquals("it shoud return a size of 1", 1, events.getEvent_id());
    }

}
