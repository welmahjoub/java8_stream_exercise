package com.company;

import java.util.*;

public class PhoneBook {

    private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
        {
            put("Jos de Vos", "016/161616");
            put("An de Toekan", "016/161617");
            put("Kris de Vis", "016/161618");
        }
    };

    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

    PhoneBook() { }

    public HashMap<String, String> getPhoneBookEntries() {
        return phoneBookEntries;
    }

    public Optional<String> findPhoneNumberByName(String name){


        return getPhoneBookEntries().entrySet().stream()
                .filter(x -> name.equals(x.getKey()))
                .map(Map.Entry::getValue).findFirst();
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber){
        return getPhoneBookEntries().entrySet().stream()
                .filter(x -> phoneNumber.equals(x.getValue()))
                .map(Map.Entry::getKey).findFirst();
    }

    @Override
    public String toString() {
        System.out.println("Hello from PhoneBook's toString method");
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneBookEntries +
                '}';
    }
}

 class PhoneBookCrawler {

    private PhoneBook phoneBook;

    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name){

        return  phoneBook.getPhoneBookEntries().entrySet().stream()
                .filter(x -> name.equals(x.getValue()))
                .map(Map.Entry::getKey).findFirst().orElseThrow(()->  new IllegalArgumentException("No phone number found") );
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
//        Optional<String> phone=  phoneBook.getPhoneBookEntries().entrySet().stream()
//                .filter(x -> name.equals(x.getValue()))
//                .map(Map.Entry::getKey).findFirst();
//
//
//        if(phone.isPresent())
//            return phone.get();
//        else
//        {
//            System.out.println(phoneBook);
//            return null;
//        }

        return  phoneBook.getPhoneBookEntries().entrySet().stream()
               .filter(x -> name.equals(x.getValue()))
               .map(Map.Entry::getKey).findFirst().orElseGet(() ->
                {
                    System.out.println(phoneBook);
                    return null;
                });

    }

    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){

        return phoneBook.getPhoneBookEntries().entrySet().stream()
                .filter(x -> name.equals(x.getValue()))
                .map(Map.Entry::getKey).findFirst().orElseGet(
                        () -> phoneBook.getPhoneBookEntries().entrySet().stream()
                                .filter(x -> name.equals(x.getValue()))
                                .map(Map.Entry::getKey).findFirst().orElse(null));


    }

    public PhoneBook getPhoneBook(){
        return phoneBook;
    }

}