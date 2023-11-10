package com.progresssoft.warehouse.repositorytest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.progresssoft.warehouse.dto.DealDTO;
import com.progresssoft.warehouse.repository.DealRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DealRepositoryTests {
 
     
    @Autowired
    private DealRepository repo;
    
    @Test
    public void testRetreivingExistedDeal() {
        DealDTO newDeal = new DealDTO("111111","USD","JOD",Instant.now(),5);     
        DealDTO savedDeal = repo.save(newDeal);      
        DealDTO existDeal = repo.findById(savedDeal.getId()).get();      
        assertThat(newDeal.getDealId()).isEqualTo(existDeal.getDealId());  
    }
    
    @Test
    public void testRetrievingNotExistedDeal() {
        DealDTO deal = repo.findById((long) 000000).get();      
        assertNull(deal);  
    }
    
    @Test
    public void testCorrectNewDeal() {
        DealDTO newDeal = new DealDTO("111111","USD","JOD",Instant.now(),5);     
        DealDTO savedDeal = repo.save(newDeal);      
        assertNotNull(savedDeal);  
    }
    
    @Test
    public void testInorrectNewDeal() {
        DealDTO newDeal = new DealDTO(null,"USD","JOD",Instant.now(),5);     
        DealDTO savedDeal = repo.save(newDeal);      
        assertNotNull(savedDeal);
    } 
}