package com.ikbalci.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subscribers")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("subscriber", new Subscriber());
        return "subscriber-form";
    }

    @PostMapping("/save")
    public String saveSubscriber(Subscriber subscriber) {
        try {
            subscriberService.saveSubscriber(subscriber);
            return "redirect:/subscribers/success";
        } catch (Exception e) {
            return "redirect:/subscribers/failure";
        }
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @GetMapping("/failure")
    public String showFailurePage() {
        return "failure";
    }
}
