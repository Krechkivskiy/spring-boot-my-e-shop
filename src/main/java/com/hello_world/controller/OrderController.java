package com.hello_world.controller;


import com.hello_world.entity.Code;
import com.hello_world.entity.Orders;
import com.hello_world.entity.User;
import com.hello_world.service.CodeService;
import com.hello_world.service.MailService;
import com.hello_world.service.OrderService;
import com.hello_world.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrderController {

    private final OrderService orderService;
    private final MailService mailService;
    private final CodeService codeService;

    public OrderController(OrderService orderService, MailService mailService, CodeService codeService) {
        this.orderService = orderService;
        this.mailService = mailService;
        this.codeService = codeService;
    }

    @GetMapping("/user/buy")
    String buyProduct(Model model) {
        return "form_to_confirm_order";
    }

    @PostMapping("/user/buy")
    String buyProducts(@ModelAttribute("order") Orders order, Model model,
                       @AuthenticationPrincipal User user) {
        order.setUser(user);
        orderService.createOrder(order);
        Code code = new Code(Generator.getVerificationCode(), order);
        codeService.add(code);
        mailService.send(user.getEmail(), String.valueOf(code.getCode()));
        return "confirm_password";
    }
}
