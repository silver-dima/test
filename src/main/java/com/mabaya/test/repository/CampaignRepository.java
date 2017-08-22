package com.mabaya.test.repository;

import com.mabaya.test.domain.Campaign;
import com.mabaya.test.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findAllByCategoryAndStatus(Category category, Campaign.Status status);

}
