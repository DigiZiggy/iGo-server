package com.igo.server.service;

import com.igo.server.model.Address;
import com.igo.server.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(final Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(final Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(final Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public Address findAddressById(final Long addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Long numberOfAddresses() {
        return addressRepository.count();
    }
}
