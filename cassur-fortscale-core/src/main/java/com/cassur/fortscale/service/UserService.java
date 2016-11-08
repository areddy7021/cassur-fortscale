package com.cassur.fortscale.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cassur.fortscale.dao.jpa.UserRepository;
import com.cassur.fortscale.domain.User;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public UserService() {
    }

//    public void deleteHotel(Long id) {
//    	userRepository.delete(id);
//    }

    public Page<User> getAllUsers(Integer page, Integer size) {
        Page<User> pageOfHotels = userRepository.findAll(new PageRequest(page, size));
        System.out.println("teh list is "+pageOfHotels);
        if (size > 50) {
            counterService.increment("Cassur.UserService.getAll.largePayload");
        }
        return pageOfHotels;
    }
}
