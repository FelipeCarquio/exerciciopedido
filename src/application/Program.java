package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date: (DD/MM/YYYY): ");
        String birthDate = sc.next();

        Client client = new Client(name, email, dateFormat.parse(birthDate));

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int nItems = sc.nextInt();
        for (int i = 0; i < nItems; i++) {
            System.out.println("Enter " + (i + 1) + "º item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            System.out.print("Product price: R$ ");
            double price = sc.nextDouble();

            Product product = new Product(nameProduct, price);

            System.out.print("Quantity: ");
            int qnt = sc.nextInt();

            OrderItem orderItem = new OrderItem(qnt, price, product);

            order.addItem(orderItem);
        }
            System.out.println();
            System.out.println(order.toString());
    }
}
