package com.example.HWTM;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.templateparser.markup.HTMLTemplateParser;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HwtmController {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/loginPage")
    public String login(HttpSession session) {

        if (session.getAttribute("currentUser") == null)
            return "loginPage";
        else
            return "redirect:/profile";
    }

    @PostMapping("/profile")
    public String loginPost(Model model, HttpSession session, @RequestParam String userName, @RequestParam String password) {

        List<User> userList = userRepository.getAllUsers();

        for (int i = 0; i < userList.size(); i++) {
            if (userName.equals(userList.get(i).getUserName()) && password.equals(userList.get(i).getUser_password())) {
                session.setAttribute("currentUser", userList.get(i));
                return "redirect:/profile";
            }
        }
        return "loginPage";
    }

    @GetMapping("/profile")
    public String profilePage(HttpSession session, Model model) {
        if (session.getAttribute("currentUser") == null) {
            return "loginPage";
        }

        User currentUser = (User)session.getAttribute("currentUser");
        model.addAttribute("events", eventRepository.getEventsByUserId(currentUser.getId()));
        model.addAttribute("eventsAsGuest", eventRepository.getEventsAsGuestByUserId(currentUser.getId()));

            return "profile";
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {

        user.setUrl("noname.jpg");
        userRepository.saveUser(user);

        return "loginPage";
    }

    @GetMapping("/editProfile")
    public String editProfile(HttpSession session, Model model) {
        if (session.getAttribute("currentUser") == null) {
            return "loginPage";
        }


        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("user", currentUser);
        return "editProfile";
    }

    @PostMapping("/editProfile")
    public String editProfile(@ModelAttribute User user, HttpSession session, Model model) {

        User updatedUser = user;

        User tempUser = (User)session.getAttribute("currentUser");
        updatedUser.setId(tempUser.getId());

        userRepository.updateUser(updatedUser);
        session.setAttribute("currentUser", updatedUser);
        return "redirect:/editProfile";
    }

    @GetMapping("/hostNewEvent")
    public String newEvent(Model model,  HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "loginPage";
        }

        model.addAttribute("event", new Event());
        return "hostNewEvent";
    }

    @PostMapping("/hostNewEvent")
    public String newEvent(@ModelAttribute Event event, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        event.setUser_id(currentUser.getId());
        event.setHost_name(currentUser.getFirstName() + " " + currentUser.getLastName() );
        event.setUrl(currentUser.getUrl());
        eventRepository.saveEvent(event);

        session.setAttribute("currentEvent", event);

        return "redirect:/hostingDetails";
   }

   @GetMapping("/hostingDetails")
    public String hostingDetails(Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "loginPage";
        }

        Event ev = (Event) session.getAttribute("currentEvent");
        model.addAttribute("event", ev);
        return "hostingDetails";
    }

    @GetMapping("/hostingDetails/{event_id}")
    public String hostingAndAttendeeDetails(@PathVariable long event_id, Model model){

        List <User> attendees = eventRepository.getAttendeesByEventId(event_id);
        Event currentEvent = eventRepository.getEventDetails(event_id);


        model.addAttribute("event", currentEvent);
        model.addAttribute("attendees", attendees);

        return "hostingDetails";
    }

    @GetMapping("/findEvent")
    public String findEvent(Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "loginPage";
        }

        List<Event> events = eventRepository.getAllEvents();
        model.addAttribute("events", events);

        return "findEvent";
    }

    @GetMapping("/eventDetailsForGuest/{event_id}")
    public String eventDetailsGuest(@PathVariable long event_id, Model model, HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        boolean isAttending = true;

        Event currentEvent = eventRepository.getEventDetails(event_id);
        model.addAttribute("event", currentEvent);
        model.addAttribute("user", currentUser);
        //isAttending = true;

        return "/eventDetailsForGuest";
    }

    @GetMapping("attend/{event_id}/{user_id}")
    public String attend(@PathVariable long event_id, @PathVariable long user_id){

        eventRepository.saveAttendeeToEvent(event_id, user_id);

        return "redirect:/profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("currentUser");
        return "loginPage";
    }

}
