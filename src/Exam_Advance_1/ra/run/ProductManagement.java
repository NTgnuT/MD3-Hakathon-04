package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    static Scanner scanner = new Scanner(System.in);

    public static List<Catalog> catalogList = new ArrayList<>();
    static Catalog catalog1 = new Catalog("Mũ", 4, "Mũ", true);
    static Catalog catalog2 = new Catalog("Áo", 1, "Áo", true);
    static Catalog catalog3 = new Catalog("Quần", 2, "Quần", true);


    public static List<Product> productList = new ArrayList<>();
    static Product product1 = new Product("Quần jean", "Quần jean", "quần", catalog3, 200000, true);
    static Product product2 = new Product("Mũ lưỡi trai", "Mũ lưỡi trai", "mũ", catalog1, 50000, true);
    static Product product3 = new Product("Áo phông", "Áo phông trơn", "áo", catalog2, 80000, true);
    static Product product4 = new Product("Quần âu", "Quần âu", "quần ", catalog3, 18000, true);
    static Product product5 = new Product("Mũ tai bèo", "Mũ tai bèo", "mũ vải", catalog1, 40000, true);


    public static void main(String[] args) {
        catalogList.add(catalog1);
        catalogList.add(catalog2);
        catalogList.add(catalog3);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục\n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần \n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n" +
                    "5. Thoát");
            System.out.println("*****************************");
            System.out.println("Nhập lựa chọn của bạn (1-5)");
            int choice = Integer.parseInt(scanner.nextLine());
            handleChoice(choice);
        }
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addCatalog();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                sortProduct();
                break;
            case 4:
                findProduct();
                break;
            case 5:
                System.exit(1);
            default:
                System.out.println("Không có lựa chọn này!!");
                break;
        }
    }

    private static void findProduct() {
        System.out.println("Nhập tên danh mục sản phẩm bạn muốn tìm kiếm: ");
        String inputName = scanner.nextLine();
        boolean find = false;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getCatalog().getCatalogName().toLowerCase().contains(inputName.toLowerCase())) {
                productList.get(i).displayData();
                find = true;
            }
        }

        if (!find) {
            System.out.println("Danh mục bạn cần tìm không có!!!");
        }
    }

    private static void sortProduct() {
        System.out.println("Danh sách sản phẩm theo giá tăng dần: ");
        Collections.sort(productList);
        for (Product product : productList) {
            product.displayData();
        }

    }

    private static void addProduct() {
        System.out.println("Nhập số lượng sản phẩm bạn muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sản phẩm thứ: " + (i+1));
            Product newProduct = new Product();
            newProduct.inputData();
            productList.add(newProduct);
        }

        for (Product product : productList) {
            product.displayData();
        }

    }

    private static void addCatalog() {
        System.out.println("Nhập số lượng danh mục bạn muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập danh mục thứ: " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogList.add(newCatalog);
        }

        for (Catalog catalog : catalogList) {
            catalog.displayData();
        }
    }
}
