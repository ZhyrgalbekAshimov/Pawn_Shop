import enums.CreditStatus;
import models.Client;
import models.Operation;
import models.Product;
import exceptions.ClientNotFound;
import services.impl.ClientServiceImpl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {


    public static void main(String[] args) {


        ClientServiceImpl clientServiceImpl = (ClientServiceImpl) ClientServiceImpl.INSTANCE;
        Client client;
        try {
            client = clientServiceImpl.findClientByIdCard("ID0776048");
        }catch (ClientNotFound ex){
            client = clientServiceImpl.createClient("Асан Омуров", "ID0776048");
        }

        Product product = new Product("Ноутбук", 20000);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        Operation operation = new Operation();
        operation.setId(1);
        operation.setCreditStatus(CreditStatus.OPEN);
        operation.setStartDate(new Date());
        operation.setClient(client);
        operation.setProducts(products);

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_YEAR, 20);

        operation.setEndDate(calendar.getTime());


        double totalPrice = 0;

        for (Product item:products) {
            totalPrice += item.getPrice();
        }

        operation.setPrice(totalPrice + totalPrice * 20 / 100);

        System.out.println("Клиент: " + operation.getClient().getName());
        System.out.println("Дата начала: " + operation.getStartDate());
        System.out.println("Дата окончания: " + operation.getEndDate());
        System.out.println("Общая сумма:" + operation.getPrice());





    }
}
