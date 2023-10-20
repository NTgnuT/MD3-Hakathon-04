package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

import static Exam_Advance_1.ra.run.ProductManagement.catalogList;

public class Product implements IShop,Comparable<Product> {
    private int productId;
    private static int count = 50;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
        this.productId = Product.count++;
    }

    public Product( String productName, String title, String descriptions, Catalog catalog, float importPrice, boolean productStatus) {
        this.productId = Product.count++;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = importPrice * RATE;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();

        System.out.println("Nhập tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();

        System.out.println("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();

        System.out.println("Nhập giá nhập sản phẩm: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        this.exportPrice = this.importPrice * RATE;

        for (int i = 0; i < catalogList.size(); i++) {
            catalogList.get(i).displayData();
        }
        System.out.println("Nhập mã danh mục bạn muốn thêm sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());
        boolean check = false;

        for (int i = 0; i < catalogList.size(); i++) {
            check = false;
            if (catalogList.get(i).getCatalogId() == n) {
                this.catalog = catalogList.get(i);
                check = true;
                break;
            }
        }

        if (!check) {
            System.out.println("Không có danh mục của mã vừa nhập, hãy thêm mới");
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogList.add(catalog);
            this.catalog = catalog;
        }


        System.out.println("Nhập trạng thái sản phẩm (true-còn hàng, false-hết hàng): ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %d, tên sản phẩm: %s, tên danh mục sản phẩm: %s, giá bán: %.02f, trạng thái: %s \n",
                productId, productName, catalog.getCatalogName(), exportPrice, productStatus?"Còn hàng" : "Hết hàng");
    }

    @Override
    public int compareTo(Product p) {
        return (int) (this.getExportPrice() - p.getExportPrice());
    }
}
