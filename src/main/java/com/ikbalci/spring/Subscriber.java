package com.ikbalci.spring;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "SUBSCRIBER")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subscId;

    private String subscName;
    private String subscSurname;
    private String msisdn;
    private String tariffId;

    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

}