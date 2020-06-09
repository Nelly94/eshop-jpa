package com.app.service;

import com.app.dao.MarketRepository;
import com.app.dao.ProductRepository;
import com.app.model.Market;
import com.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MarketService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private MarketRepository marketRepo;

    public void saveMarketAndProducts(Market market, List<Product> products){
        marketRepo.save(market);
        for(Product p : products){
            p.setMarket(market);
            productRepo.save(p);
        }
    }

}
