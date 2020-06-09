import com.app.conf.AppConf;
import com.app.dao.ProductDao;
import com.app.dao.ProductDaoImpl;
import com.app.dao.ProductRepository;
import com.app.model.Market;
import com.app.model.Product;
import com.app.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args){
        AnnotationConfigApplicationContext conf = new AnnotationConfigApplicationContext(AppConf.class);

        /*ProductDao productDao = conf.getBean(ProductDao.class);
        productDao.create(new Product("white", "fresh meat", 8));
        productDao.create(new Product("kinder", "chocolate", 19));

        ProductRepository repo = conf.getBean(ProductRepository.class);
        List<Product> foundByDescription = repo.findByThisDescription("meat");
        List<Product> foundByPrice = repo.findByPriceBetween(10,20);

        List<Product> products = productDao.findAll();
        for(Product p : products){
            System.out.println(p.getBrand());
        }
        System.out.println("By description:");
        for(Product p : foundByDescription){
            System.out.println(p.toString());
        }
        System.out.println("By price:");
        for(Product p : foundByPrice){
            System.out.println(p.toString());
        }*/

        MarketService marketService = conf.getBean(MarketService.class);
        Product p1 = new Product("white", "fresh meat", 5);
        Product p2 = new Product("kinder", "chocolate", 18);
        Market market = new Market("First market");
        List<Product> products = Arrays.asList(p1, p2);
        marketService.saveMarketAndProducts(market, products);

    }
}


