package com.mabaya.test.services;

import com.mabaya.test.domain.Campaign;
import com.mabaya.test.domain.Category;
import com.mabaya.test.domain.Product;
import com.mabaya.test.repository.CampaignRepository;
import com.mabaya.test.repository.ProductRepository;
import com.mabaya.test.web.rest.request.CampaignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignManager {

    @Value("${mabaya.campaign.defaultDuration}")
    private Integer campaignDefaultDuration;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    public Campaign createCampaign(CampaignRequest campaignRequest) {
        List<Product> products = productRepository.findProductsByCategory(campaignRequest.getCategory());

        Campaign campaign = new Campaign();
        campaign.setName(campaignRequest.getName());
        campaign.setStartDate(campaignRequest.getStartDate());
        campaign.setCategory(campaignRequest.getCategory());
        campaign.setBid(campaignRequest.getBid());
        campaign.setEndDate(campaignRequest.getStartDate().plusDays(campaignDefaultDuration));
        products.stream().forEach(p -> campaign.setProduct(p));

        campaignRepository.save(campaign);

        return campaign;
    }

    public Optional<Product> getAd(Category category) {

        List<Campaign> campaigns;
        campaigns = campaignRepository.findAllByCategoryAndStatus(category, Campaign.Status.active);

        if (campaigns.size() == 0) {
            campaigns = campaignRepository.findAll();
        }

        Optional<Product> product = campaigns.stream()
                .flatMap(campaign -> campaign.getProducts().stream())
                .sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .findFirst();

        return product;
    }
}
