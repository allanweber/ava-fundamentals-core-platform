package com.allan.reflection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        BankAccount bankAccount = new BankAccount(1, 100);

        Class<?> theClass = bankAccount.getClass();
        showName(theClass);

        Class<?> classFromName = Class.forName("com.allan.reflection.BankAccount");
        showName(classFromName);
    }

    public static void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());
    }
}
