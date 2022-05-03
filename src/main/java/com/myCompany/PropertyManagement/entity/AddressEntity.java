package com.myCompany.PropertyManagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS_TABLE")
@Getter
@Setter
@NoArgsConstructor

public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "USER_ID")
    private Long id;
    private String houseNo;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;
}
