package com.stackroute.ust.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customers {

    private int customerId;
    private String customername;

    private Address homeAddress;
    private Address workAddress;
}
