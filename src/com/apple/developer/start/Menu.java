package com.apple.developer.start;

import com.apple.developer.dao.IAdminDao;
import com.apple.developer.dao.IPetDao;
import com.apple.developer.dao.IPetStoreDao;
import com.apple.developer.dao.impl.AdminDaoImpl;
import com.apple.developer.dao.impl.PetDaoImpl;
import com.apple.developer.dao.impl.PetStoreDaoImpl;
import com.apple.developer.entity.Admin;
import com.apple.developer.entity.Pet;
import com.apple.developer.entity.PetStore;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

public class Menu {
    private  IPetStoreDao iPetStoreDao=new PetStoreDaoImpl();
    private  IPetDao iPetDao=new PetDaoImpl();

    public void login() throws SQLException {
        System.out.println("\n----------");
        Scanner input=new Scanner(System.in);
        IAdminDao dao=new AdminDaoImpl();
        List<Admin> list=dao.listAll();
        System.out.print("请输入用户名：");
        String name=input.nextLine();
        Boolean nameExists=false;
        String passwordFind=null;
        for(Admin admin:list){
            if(name.equals(admin.getUsername())){
                nameExists=true;
                passwordFind=admin.getPassword();
                break;
            }
        }
        if(!nameExists){
            System.out.println("对不起，此用户不存在，请核对用户名后重试！");
        }else if(nameExists){
            System.out.print("请输入密码；");
            String password=input.nextLine();
            if(password.equals(passwordFind)){
                petStoreMenu();
            }else{
                System.out.println("密码输入错误！");
                loginMenu();
            }
        }
    }

    public void petStoreMenu() throws SQLException {
        Scanner input=new Scanner(System.in);
        System.out.println("\n----------");
        List<PetStore> listPetStore =iPetStoreDao.listAll();
        for(PetStore petStore:listPetStore){
            System.out.println(petStore.getPs_id()+"、"+petStore.getPs_name());
        }
        System.out.println("输入对应宠物商店的编号进入对应宠物商店，输入0添加宠物商店");
        System.out.print("请输入您的选择：");
        int choice=input.nextInt();
        if(choice==0){
            System.out.print("请输入您要添加的宠物商店的名字：");
            String nameOfInsetPetStore=new Scanner(System.in).next();
            int success=iPetStoreDao.insertPetStore(new PetStore(nameOfInsetPetStore));
            if(success>0){
                System.out.println("宠物商店添加成功！");
            }else{
                System.out.println("宠物商店添加失败！");
            }
        }else{
            intoPetStore(choice);
        }
    }

    public void intoPetStore(int ps_id) throws SQLException {
        System.out.println("\n----------");
        System.out.println("欢迎来到"+iPetStoreDao.findNameByid(ps_id));
        System.out.println("1、显示当前这家宠物信息");
        System.out.println("2、添加宠物信息");
        System.out.println("3、修改宠物信息");
        System.out.println("4、删除宠物信息");
        System.out.println("0、返回宠物店列表");
        System.out.print("请输入您的选择：");
        int choice=new Scanner(System.in).nextInt();
        switch (choice){
            case 0:
                petStoreMenu();
                break;
            case 1:
                listAllPets(ps_id);break;
            case 2:
                insertPet(ps_id);break;
            case 3:
                modifyPet(ps_id);break;
            case 4:
                deletePet(ps_id);break;
            default:
                System.out.println("您的输入有误！");
                break;
        }
    }
    public void listAllPets(int ps_id) throws SQLException {
        System.out.println("\n----------");
        List<Pet> listOfPet = iPetDao.listByAddress(iPetStoreDao.findNameByid(ps_id));
        for (Pet pet : listOfPet) {
            System.out.println(pet);
        }
        intoPetStore(ps_id);
    }

    public void insertPet(int ps_id) throws SQLException {
        System.out.println("\n----------");
        Scanner input=new Scanner(System.in);
        System.out.print("请输入添加宠物的名字：");
        String  name=input.next();
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday=simpleDateFormat.format(date);
        int health=new Random().nextInt(100)+1;
        String address=iPetStoreDao.findNameByid(ps_id);
        int suc=iPetDao.insertPet(new Pet(name, health, birthday, address));
        if(suc>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
        intoPetStore(ps_id);
    }

    public void modifyPet(int ps_id) throws SQLException {
        System.out.println("\n----------");
        Scanner input=new Scanner(System.in);
        System.out.print("请输入需要修改信息的宠物编号：");
        int id=input.nextInt();
        System.out.print("请输入修改后的宠物名字：");
        String name=input.next();
        System.out.print("请输入修改后的宠物健康值：");
        int health= input.nextInt();
        System.out.print("请输入修改后的宠物生日：");
        String birthday=input.next();
        System.out.print("请输入修改后的宠物地址：");
        String address=input.next();
        int suc=iPetDao.updatePet(new Pet(id,name,health,birthday,address));
        if(suc>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
        intoPetStore(ps_id);
    }

    public void deletePet(int ps_id) throws SQLException {
        System.out.println("\n----------");
        System.out.print("请输入需要删除的宠物编号：");
        int id=new Scanner(System.in).nextInt();
        int suc=iPetDao.deletePet(id);
        if(suc>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
        intoPetStore(ps_id);
    }

    public void loginMenu() throws SQLException {
        System.out.println("\n----------欢迎来到在线宠物商城----------");
        System.out.println("1、登陆");
        System.out.println("2、退出");
        System.out.print("请选择：");
        int choice=new Scanner(System.in).nextInt();
        if(choice==2){
            System.exit(0);
        }else if(choice==1){
            login();
        }
    }
}
