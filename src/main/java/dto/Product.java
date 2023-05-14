package dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {
    private String name;
    private String category;
    private String warehouse;
    private Integer count;

    public static Product of(String line) {
        String[] splitLine = line.split(",");
        Product product = new Product();
        product.setName(splitLine[0]);
        product.setCategory(splitLine[1]);
        product.setWarehouse(splitLine[2]);
        product.setCount(Integer.valueOf(splitLine[3]));
        return product;

    }
}
