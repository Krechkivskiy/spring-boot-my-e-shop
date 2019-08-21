package com.hello_world.controller;

import com.hello_world.entity.User;
import com.hello_world.service.CodeService;
import com.hello_world.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class CodeController {

    private CodeService codeService;
    private OrderService orderService;

    @Autowired
    public CodeController(CodeService codeService, OrderService orderService) {
        this.codeService = codeService;
        this.orderService = orderService;
    }

    @GetMapping("/user/confirm")
    String confirmOrder(@AuthenticationPrincipal User user,
                        @RequestParam("code") String code, Model model) {
        int code1 = codeService.getCode(orderService.getOrderUser(user).get());
        if (String.valueOf(code1).equals(code)) {
            model.addAttribute("errorMsg", "success");
        } else {
            model.addAttribute("errorMsg", "incorrect code");
        }
        return "confirm_password";
    }
}
