package com.rhanem.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoansController {

    @GetMapping("myBalance")
    public String getBalanceDetails(){

        return "Balance";
    }
}
