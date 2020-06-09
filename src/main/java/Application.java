import com.app.conf.AppConf;
import com.app.dao.ProductDao;
import com.app.dao.ProductDaoImpl;
import com.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args){
        AnnotationConfigApplicationContext conf = new AnnotationConfigApplicationContext(AppConf.class);

        ProductDao productDao = conf.getBean(ProductDao.class);
        productDao.create(new Product("white"));
        productDao.create(new Product("kinder"));
        List<Product> products = productDao.findAll();
        for(Product p : products){
            System.out.println(p.getBrand());
        }

    }
}


