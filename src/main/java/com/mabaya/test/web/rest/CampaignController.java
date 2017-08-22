package com.mabaya.test.web.rest;

import com.mabaya.test.domain.Campaign;
import com.mabaya.test.services.CampaignManager;
import com.mabaya.test.web.rest.request.CampaignRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/campaign")
@Slf4j
public class CampaignController {


    @Autowired
    private CampaignManager campaignManager;

    @RequestMapping(value = "", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campaign> createCampaign(@RequestBody CampaignRequest campaignRequest) {

        return new ResponseEntity<Campaign>(campaignManager.createCampaign(campaignRequest), HttpStatus.OK);
    }

}
