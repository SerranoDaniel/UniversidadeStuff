/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.reservation;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;


@ManagedBean
@SessionScoped
public class ReservationBean implements Serializable {

    private String name = "";
    private String totalValue = "120.00";
    private String email = "";
    private String emailAgain = "";
    private String date = "";
    private String tickets = "1";
    private String price = "120";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAgain() {
        return emailAgain;
    }

    public void setEmailAgain(String emailAgain) {
        this.emailAgain = emailAgain;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void calculateTotal(AjaxBehaviorEvent event) 
            throws AbortProcessingException {
        int ticketsNum = 1;
        int ticketPrice = 0;
        int total = 0;

        if (tickets.trim().length() > 0) {
            ticketsNum = Integer.parseInt(tickets);
        }
        if (price.trim().length() > 0) {
            ticketPrice = Integer.parseInt(price);
        }
        total = (ticketsNum * ticketPrice);
        totalValue = String.valueOf(total) + ".00";
    }

    public void clear(AjaxBehaviorEvent event) 
            throws AbortProcessingException {
        name = "";
        email = "";
        emailAgain = "";
        date = "";
        price = "120.00";
        totalValue = "120.00";
        tickets = "1";
    }
}
