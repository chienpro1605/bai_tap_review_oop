package baitaptonghopCRUD;

import java.io.IOException;
import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) throws IOException {
        QuanLyDienThoai ql = new QuanLyDienThoai();
        ql.addDienThoai(new DienThoại("iphone 12",40000,"apple","i1"));
        ql.addDienThoai(new DienThoại("samsung s4",13000,"samsung","s1"));
        ql.addDienThoai(new DienThoại("oppo s3",45000,"oppo","o1"));
//        ql.display();
//
//        System.out.println(ql.findVitri("samsung s6"));
//        ql.seachDienThoai("iphone 12");

//
////        System.out.println("nhập tên muốn sửa");
//       Scanner sc = new Scanner(System.in);
////        String name= sc.nextLine();
////        ql.edit(name, new DienThoại("gfhfj",4000, "kb","s12"));
////        ql.display();
//
////        System.out.println("nhập tên muốn xóa");
////        String name1 = sc.nextLine();
////        ql.deleteDienThoai(name1);
////        ql.display();
////
//        ql.sortDienThoai();
//        ql.display();
            Scanner scanner = new Scanner(System.in);
//            QuanLyDienThoai ql = new QuanLyDienThoai();
            int choice;
            while (true){
                dispalyMenu();
                System.out.println("nhập lựa chọn");
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        scanner.nextLine();
                        System.out.println("nhập tên điện thoại");
                        String name = scanner.nextLine();
                        System.out.println("nhập giá");
                        int price = scanner.nextInt();
                        System.out.println("nhập hãng điện thoại");
                        scanner.nextLine();
                        String brand = scanner.nextLine();
                        System.out.println("nhập mã máy");
                        String maMay = scanner.nextLine();
                        DienThoại dienThoại = new DienThoại(name,price,brand,maMay);
                        ql.addDienThoai(dienThoại);
                        ql.writeFile("demo.csv",ql.list);
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("nhập tên điện thoại muốn update");
                        String name1 = scanner.nextLine();
                        if (ql.findVitri(name1) != -1){
                            System.out.println("nhập tên điện thoại mới");
                            String name2 = scanner.nextLine();
                            System.out.println("nhập giá");
                            int price2 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("sửa hãng máy");
                            String hangmay = scanner.nextLine();
                            System.out.println("nhập mã máy mới");
                            String maMay2 = scanner.nextLine();
                            ql.edit(name1, new DienThoại(name2,price2,hangmay,maMay2));
                        }else {
                            System.out.println("không tìm thấy ");
                        }
                        break;
                    case 3:
                        scanner.nextLine();
                        System.out.println("nhập tên điện thoại muốn xóa");
                        String name3 = scanner.nextLine();
                        if (ql.findVitri(name3) == -1){
                            System.out.println("không tìm thấy nhập lại đi");
                        }else {
                            ql.deleteDienThoai(name3);
                        }
                        break;
                    case 4:
                        System.out.println("bạn muốn tìm kiếm điện thoại theo kiểu gì");
                        System.out.println("1.giá   2.name   3.hãng máy");
                        int option = scanner.nextInt();
                        switch (option){
                            case 1:
                                System.out.println("nhập giá đt cần tìm");
                                int price4 = scanner.nextInt();
                                ql.seachPrice(price4);
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.println("nhập tên điện thoại cần tìm");
                                String name4 = scanner.nextLine();
                                ql.seachDienThoai(name4);
                                break;
                            case 3:
                                scanner.nextLine();
                                System.out.println("nhập hãng máy cần tìm");
                                String hangmay = scanner.nextLine();
                                ql.seachBrand(hangmay);
                                break;
                        }
                        break;

                    case 5:
                        System.out.println("bạn muốn sắp xếp điện thoại theo kiểu gì");
                        System.out.println("1.sắp xếp giá    2.sắp xếp theo tên máy    3.sắp xếp theo hãng máy");
                        int luachon = scanner.nextInt();
                        switch (luachon){
                            case 1:
                                ql.sortDienThoai();
                                break;
                            case 2:
                                ql.sortName();
                                break;
                            case 3:
                                ql.sortBrand();
                                break;
                        }
                        break;
                    case 6:
                        ql.display();
                        break;
                    case 7:
                        ql.writeFile("demo.csv",ql.list);
                        break;
                    case 8:
                        ql.readFile("demo.csv");
                        break;
                    case 0:
                        System.out.println("tạm biệt bạn");
                        System.exit(0);


                }
            }
    }
    public static void dispalyMenu(){
        System.out.println("--------------Menu---------");
        System.out.println("1. thêm điện thoại");
        System.out.println("2. cập nhật thông tin điện thoại");
        System.out.println("3. xóa thông tin điện thoại");
        System.out.println("4. tìm kiếm điện thoại");
        System.out.println("5. sắp xếp điện thoại");
        System.out.println("6. hiển thị");
        System.out.println("7. lưu dữ liệu điện thoại");
        System.out.println("8. hiện thị dữ liệu từ file");
        System.out.println("0. thoát");
    }
}
