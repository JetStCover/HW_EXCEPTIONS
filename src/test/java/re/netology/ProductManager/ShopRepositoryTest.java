package re.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ShopRepositoryTest {
    @Test
    public void removeProduct() {
        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(1, "Тетрадь", 150);
        Product product2 = new Product(2, "Ручка", 30);
        Product product3 = new Product(3, "Карандаш", 10);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.remove(3);

        Product[] actual = shop.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNegativeProduct() {
        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(1, "Тетрадь", 150);
        Product product2 = new Product(2, "Ручка", 30);
        Product product3 = new Product(3, "Карандаш", 10);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> shop.remove(4));
    }

    @Test
    public void findSameId() {
        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(1, "Тетрадь", 150);
        Product product2 = new Product(2, "Ручка", 30);
        Product product3 = new Product(3, "Карандаш", 10);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.remove(3);

        Product[] actual = shop.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundSameId() {
        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(1, "Тетрадь", 150);
        Product product2 = new Product(2, "Ручка", 30);
        Product product3 = new Product(1, "Карандаш", 10);

        shop.add(product1);
        shop.add(product2);


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.add(product3);
        });
    }

    @Test
    public void findAll() {
        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(1, "Тетрадь", 150);
        Product product2 = new Product(2, "Ручка", 30);
        Product product3 = new Product(3, "Карандаш", 10);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Product[] actual = shop.findAll();
        Product[] expected = {product1, product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }
}