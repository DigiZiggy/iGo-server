package com.igo.server.service;

import com.igo.server.model.Address;

import java.util.List;

public interface AddressService {

    Address saveAddress(Address address);

    Address updateAddress(Address address);

    void deleteAddress(Long addressId);

    Address findAddressById(Long addressId);

    List<Address> findAllAddresses();

    Long numberOfAddresses();
}
