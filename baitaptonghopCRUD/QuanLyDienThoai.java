package baitaptonghopCRUD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyDienThoai {
        ArrayList<DienThoại> list = null;
    public QuanLyDienThoai(){
        this.list = new ArrayList<>();
    }
   public void addDienThoai(DienThoại dienThoại){
        list.add(dienThoại);
    }
    public void display(){
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("---------------");
    }
  public int findVitri(String name){
          for (int i = 0; i<list.size(); i++){
              if (list.get(i).getName().equals(name)){
                  return i;
              }
          }
          return -1;
  }
  public void seachDienThoai(String name){
        boolean ten = false;
       for (int i = 0; i<list.size(); i++){
           if (list.get(i).getName().equals(name)){
               System.out.println(list.get(i).toString());
               ten = true;
           }
       }
       if (!ten){
           System.out.println("không tìm thấy");
       }
    }
    public void seachPrice(int price){
        boolean gia = false;
        for (int i = 0; i<list.size(); i++){
            if (list.get(i).getPrice() == price){
                System.out.println(list.get(i).toString());
                gia = true;
            }
        }
        if (!gia){
            System.out.println("không tìm thấy");
        }
    }
   public void seachBrand(String brand){
        boolean hang = false;
        for (int i = 0; i<list.size(); i++){
            if (list.get(i).getBrand().equals(brand)){
                System.out.println(list.get(i).toString());
                hang = true;
            }
        }
        if (!hang){
            System.out.println("không tìm thấy");
        }

   }
  public void edit(String name, DienThoại dienThoại){
        if (findVitri(name) == -1){
            System.out.println("không tìm thấy");
        }else {
            list.set(findVitri(name),dienThoại);
        }
    }
    public void deleteDienThoai(String name){
        if (findVitri(name) == -1){
            System.out.println("không tìm thấy");
        }else {
           list.remove(findVitri(name));
        }
    }
    public void sortDienThoai(){
       list.sort(Comparator.comparing(DienThoại::getPrice));
    }
    public void sortName(){
        Collections.sort(list, new Comparator<DienThoại>() {
            @Override
            public int compare(DienThoại o1, DienThoại o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    public void sortBrand(){
        Collections.sort(list, new Comparator<DienThoại>() {
            @Override
            public int compare(DienThoại o1, DienThoại o2) {
                int result =  o1.getBrand().compareTo(o2.getName());
                if (result == 0)
                    return o1.getName().compareTo(o2.getBrand());
                return result;
            }
        });
    }


}
