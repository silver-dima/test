package com.mabaya.test.web.rest;

import com.mabaya.test.domain.Campaign;
import com.mabaya.test.domain.Category;
import com.mabaya.test.domain.Product;
import com.mabaya.test.repository.CampaignRepository;
import com.mabaya.test.services.CampaignManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/serveAd")
@Slf4j
public class ServeAdController {

    @Autowired
    private CampaignManager campaignManager;

    @RequestMapping(value="/{category}", method = RequestMethod.GET)
    public ResponseEntity<Product> getAdd(@PathVariable("category") Category category) {

        return campaignManager.getAd(category)
                .map(product ->  new ResponseEntity<Product>(product, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());

    }

}
