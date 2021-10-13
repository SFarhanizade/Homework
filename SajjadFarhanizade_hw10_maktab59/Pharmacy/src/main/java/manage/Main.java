package manage;

import dao.AdminDao;
import dao.ItemDao;
import dao.PatientDao;
import dao.PrescriptionDao;
import db_config.DbConfig;
import entity.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static UserBase loggedInUser;
    static Scanner input = new Scanner(System.in);
    static int count;

    public static void main(String[] args) throws SQLException {
        char u = ' ';
        while (true) {
            if (loggedInUser == null) {
                System.out.println("""
                        1-Patient
                        2-Admin
                        """);
                int menuNum = input.nextInt();
                input.nextLine();
                if (menuNum == 1)
                    u = 'p';
                else
                    u = 'a';
                if (login(u))
                {
                    System.out.println("Logged In!");
                count = 0;
            }
                else {
                    System.out.println("Wrong username or password!");
                    continue;
                }
            } else {
                int menuNum = 0;
                switch (u) {
                    case 'p': {
                        System.out.println("""
                                1-Add prescription
                                2-Show confirmed prescriptions
                                3-Edit unconfirmed prescription
                                4-Delete unconfirmed prescription
                                5-Sign out
                                """);
                        menuNum = input.nextInt();
                        input.nextLine();
                        switch (menuNum) {
                            case 1: {
                                if(count==3) {
                                    System.out.println("Not allowed to add more prescriptions!");
                                    break;
                                }
                                List<Item> items = new ItemDao().getItemsList();
                                List<Item> myItems = new ArrayList<>();
                                for (int i = 0; i < items.size(); i++) {
                                    System.out.println((i + 1) + "-" + items.get(i).getName());
                                }
                                System.out.println("Choose the items you want. Enter 0 to finish");
                                int itemNum = 0;
                                for (int i = 0; i < 10; i++) {
                                    System.out.print((i + 1) + "-Enter the Item Number: ");
                                    itemNum = input.nextInt();
                                    input.nextLine();
                                    if (itemNum == 0) {
                                        System.out.println("Finished!");
                                        break;
                                    } else if (itemNum < 0 || itemNum > items.size()) {
                                        System.out.println("Wrong Number!");
                                        continue;
                                    }
                                    myItems.add(items.get(itemNum - 1));
                                    System.out.println();
                                    for (int j = 0; j < myItems.size(); j++) {
                                        System.out.println((j + 1) + "-" + myItems.get(j).getName());
                                    }
                                }
                                new PrescriptionDao().createPrescription(new Prescription(0, new Date(2021, 10, 10),
                                        loggedInUser.getId(), 0, myItems));
                                count++;
                                break;
                            }
                            case 2: {
                                List<Prescription> prescriptions = new PrescriptionDao()
                                        .getAcceptedPrescriptions(loggedInUser.getId());
                                for (int i = 0; i < prescriptions.size(); i++) {
                                    int price = new PrescriptionDao().getFactor(prescriptions.get(i));
                                    System.out.println((i + 1) + "-" + prescriptions.get(i).getId()+"  --Price: "+price);
                                }
                                System.out.print("\nEnter (0 to back)/the number to see the items: ");
                                int pNum = input.nextInt();
                                if (pNum == 0)
                                    break;

                                List<Item> items = prescriptions.get(pNum - 1).getItems();
                                for (int i = 0; i < items.size(); i++) {
                                    System.out.println((i + 1) + "-" + items.get(i).getName());
                                }
                                break;
                            }
                            case 3: {
                                List<Prescription> prescriptions = new PrescriptionDao()
                                        .getNotAcceptedPrescriptions((Patient) loggedInUser);
                                for (int i = 0; i < prescriptions.size(); i++) {
                                    System.out.println((i + 1) + "-" + prescriptions.get(i).getId());
                                }
                                System.out.print("\nEnter (0 to back)/the number to edit: ");
                                int pNum = input.nextInt();
                                input.nextLine();
                                if(pNum==0)
                                    break;
                                Prescription p = prescriptions.get(pNum-1);
                                System.out.println("""
                                        0-Back
                                        1-Delete
                                        2-Add Item
                                        3-Delete an Item
                                        """);
                                pNum = input.nextInt();
                                input.nextLine();
                                switch (pNum){
                                    case 0:{
                                        break;
                                    }
                                    case 1: {
                                        System.out.println("Are you sure? (y/n)");
                                        if(input.nextLine().equals("n"))
                                            break;
                                        new PrescriptionDao().delete(p);
                                        count--;
                                        break;
                                    }
                                    case 2:{
                                        List<Item> items = new ItemDao().getItemsList();
                                        List<Item> myItems = new ArrayList<>();
                                        myItems.addAll(p.getItems());
                                        for (int i = 0; i < items.size(); i++) {
                                            System.out.println((i + 1) + "-" + items.get(i).getName());
                                        }
                                        System.out.println("Choose the items you want. Enter 0 to finish");
                                        int itemNum = 0;
                                        for (int i = 0; i < 10; i++) {
                                            System.out.print((i + 1) + "-Enter the Item Number: ");
                                            itemNum = input.nextInt();
                                            input.nextLine();
                                            if (itemNum == 0) {
                                                System.out.println("Finished!");
                                                break;
                                            } else if (itemNum < 0 || itemNum > items.size()) {
                                                System.out.println("Wrong Number!");
                                                continue;
                                            }
                                            if(myItems.size()==10){
                                                System.out.println("Not allowed to add more!");
                                                break;
                                            }
                                            myItems.add(items.get(itemNum - 1));
                                            System.out.println();
                                            for (int j = 0; j < myItems.size(); j++) {
                                                System.out.println((j + 1) + "-" + myItems.get(j).getName());
                                            }
                                        }
                                        p.setItems(myItems);
                                        new PrescriptionDao().updateNotAcceptedPrescriptions(p);
                                        break;
                                    }
                                    case 3:{
                                        List<Item> myItems = p.getItems();
                                        for (int i = 0; i < myItems.size(); i++) {
                                            System.out.println((i + 1) + "-" + myItems.get(i).getName());
                                        }
                                        System.out.println("\nChoose the items to be deleted (0 to finish): ");
                                        while (true){
                                            pNum = input.nextInt();
                                            if(pNum==0)
                                                break;
                                            if(pNum<0 || pNum>myItems.size()) {
                                                System.out.println("Wrong Number!");
                                                continue;
                                            }
                                            myItems.remove(pNum-1);
                                            if(myItems.size()>0) {
                                                for (int i = 0; i < myItems.size(); i++) {
                                                    System.out.println((i + 1) + "-" + myItems.get(i).getName());
                                                }
                                                System.out.println("\nChoose the items to be deleted (0 to finish): ");
                                            }else {
                                                new  PrescriptionDao().delete(p);
                                                break;
                                            }
                                        }
                                        p.setItems(myItems);
                                        new PrescriptionDao().updateNotAcceptedPrescriptions(p);
                                    }
                                }
                                break;
                            }
                            case 4: {
                                List<Prescription> prescriptions = new PrescriptionDao()
                                        .getNotAcceptedPrescriptions((Patient) loggedInUser);
                                for (int i = 0; i < prescriptions.size(); i++) {
                                    System.out.println((i + 1) + "-" + prescriptions.get(i).getId());
                                }
                                System.out.print("\nEnter the number to delete (0 to back): ");
                                int pNum = input.nextInt();
                                if(pNum==0)
                                    break;

                                new PrescriptionDao().delete(prescriptions.get(pNum - 1));
                                count--;
                                break;
                            }
                            case 5: {
                                loggedInUser = null;
                                count=0;
                                break;
                            }
                        }
                        break;
                    }
                    case 'a': {
                        System.out.println("""
                                1-Show new prescriptions
                                2-Show all prescriptions
                                3-Sign out
                                """);
                        menuNum = input.nextInt();
                        input.nextLine();
                        switch (menuNum) {
                            case 1: {
                                List<Prescription> prescriptions = new PrescriptionDao().getPrescriptions(0);
                                for (int i = 0; i < prescriptions.size(); i++) {
                                    System.out.println((i + 1) + "-" + prescriptions.get(i).getId());
                                }
                                System.out.print("\nChoose a prescription: ");
                                int pNum = input.nextInt();
                                input.nextLine();
                                List<Item> items = prescriptions.get(pNum - 1).getItems();
                                for (int i = 0; i < items.size(); i++) {
                                    System.out.println("\n" + items.get(i).getName());
                                    System.out.print("Exists? (y/n): ");
                                    items.get(i).setDoesExist((input.nextLine().equals("y")));
                                    if (items.get(i).isDoesExist()) {
                                        System.out.print("Enter the price: ");
                                        items.get(i).setPrice(input.nextInt());
                                        input.nextLine();
                                    }
                                }
                                prescriptions.get(pNum - 1).setItems(items);
                                new AdminDao().acceptPrescription(prescriptions.get(pNum - 1), (Admin) loggedInUser);
                                break;
                            }
                            case 2: {
                                List<Prescription> prescriptions = new PrescriptionDao().getPrescriptions(1);
                                for (int i = 0; i < prescriptions.size(); i++) {
                                    System.out.println((i + 1) + "-" + prescriptions.get(i).getId()+" ("+
                                            ((prescriptions.get(i).getAdmin_id()==0)?"Not Confirmed":"Confirmed")+")");
                                }
                                System.out.print("Choose a prescription to see the items (0 to back): ");
                                int pNum = input.nextInt();
                                if(pNum==0)
                                    break;
                                List<Item> items = prescriptions.get(pNum-1).getItems();
                                for (int i=0;i<items.size();i++){
                                    System.out.println((i+1)+"-"+items.get(i).getName());
                                }
                                break;
                            }
                            case 3: {
                                loggedInUser = null;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    public static boolean login(char u) throws SQLException {
        System.out.print("Enter the username: ");
        String username = input.nextLine();
        System.out.print("Enter the password: ");
        String password = input.nextLine();
        if (u == 'p') {
            loggedInUser = new PatientDao().login(username, password);
        } else {
            loggedInUser = new AdminDao().login(username, password);
        }
        return loggedInUser != null;
    }
}