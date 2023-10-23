import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products {
    String name;
    double price;

    public Products(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getNameOrPrice() {
        String rubs = Check.print(price);
        String formattedDouble = new DecimalFormat("#0.00").format(price);
        formattedDouble = formattedDouble.replace(',','.');
        return name + " цена: " + formattedDouble + rubs;
    }

    static double onePeople(int countPeople, double allPriceProduct)
    {
        return allPriceProduct/countPeople;
    }

    static void productAll(int countPeople) {
        Scanner in = new Scanner(System.in);
        //boolean flag = true;
        List<Products> products = new ArrayList<>();
        double allPriceProduct = 0.00f;
        while (true) {
            System.out.println("Введите название продукта:");
            String nameProduct = in.next();
            System.out.println("Введите цену на данный товар:");
            String enterPrice = in.next();
            enterPrice = enterPrice.replace(',', '.');
            if (Check.isDouble(enterPrice)) {
                double priceProduct = Double.parseDouble(enterPrice);
                if (priceProduct <= 0)
                {
                    priceProduct = Check.checkPrice(enterPrice);
                    allPriceProduct += priceProduct;
                    Products product = new Products(nameProduct, priceProduct);
                    products.add(product);
                }
                else
                {
                    allPriceProduct += priceProduct;
                    Products product = new Products(nameProduct, priceProduct);
                    products.add(product);
                }
            } else {
                double priceProduct = Check.checkPrice(enterPrice);
                allPriceProduct += priceProduct;
                Products product = new Products(nameProduct, priceProduct);
                products.add(product);
            }

            System.out.println("Хотите ли вы ввести еще один продукт? Да - введите любой символ, нет - введите 'завершить'.");
            String answer = in.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                //flag = false;
                break;
            }
        }
        double priceForOne = onePeople(countPeople, allPriceProduct);
        String formattedDouble = new DecimalFormat("#0.00").format(priceForOne);
        formattedDouble = formattedDouble.replace(',','.');
        double result = Double.parseDouble(formattedDouble);
        System.out.println("Добавленные товары:");
        for(Products products1 : products) {
            System.out.println(products1.getNameOrPrice());
        }
        String formattedDoubleTwo = new DecimalFormat("#0.00").format(allPriceProduct);
        formattedDoubleTwo = formattedDoubleTwo.replace(',','.');
        String rubsOne = Check.print(allPriceProduct);
        System.out.println("Общая сумма: " + formattedDoubleTwo + " " + rubsOne);
        String rubs = Check.print(result);
        System.out.println("К оплате для одного человека: " + result + rubs);
    }
}
