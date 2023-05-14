import dto.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        // поиск по предикату
        Stream<String> lines = Files.lines(Paths.get("./data.csv"));
        Optional<Product> products = lines.map(Product::of)// метод of в Мейне
                .filter(s -> s.getWarehouse().equals("Химки"))
                .findAny();

        // поиск количества по предикату
        long count = lines.map(Product::of)
                .filter(s -> s.getWarehouse().equals("Химки"))
                .count();

        // сумма товаров на всех складах
        int sum = lines.map(Product::of)
                .filter(e -> e.getName().equals("Гвозди"))
                .mapToInt(e -> e.getCount())
                .sum();
        System.out.println(sum);

        // Все склады, где есть товары категории
        List<String> warehouses = lines.map(Product::of)
                .filter(s -> s.getCategory().equals("Инструменты"))
                .map(Product::getWarehouse)
                .collect(Collectors.toList());
        warehouses.forEach(System.out::println);

        //Уникальные товары
                Set<String> collect = lines.map(Product::of)
              .map(s -> s.getCategory())
            .collect(Collectors.toSet());
         System.out.println(collect);

        //Получение товара и общего количества на всех складах
        Map<String, Integer> collect1 = lines.map(Product::of)
                .collect(Collectors.groupingBy(
                        Product::getName,
                        Collectors.summingInt(Product::getCount)));
        for (Map.Entry<String, Integer> stringLongEntry : collect1.entrySet()) {
            System.out.println(stringLongEntry);
        }
    }
}

        // Stream<String> lines = Files.lines(Paths.get("./data.csv"));
        // lines.map(Product::of)
        //        .filter(s->s.getWarehouse().equals("Химки"))
        //        .forEach(System.out::println);

                //вывести город Химки
//        Stream<String> lines = Files.lines(Paths.get("./data.csv"));
//        lines.forEach(s -> {
//            Product product = Product.of(s);
//            if (product.getWarehouse().equals("Химки")) {
//                System.out.println(product);

