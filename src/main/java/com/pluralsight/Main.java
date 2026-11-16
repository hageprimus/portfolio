package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Portfolio myAssets = new Portfolio("Assets", "Hage");
        boolean complete = false;
        do {
            String nameInput = getInputFromConsole("Enter the name of the asset you're creating:", s);
            String typeInput = getInputFromConsole("Enter the type of asset to create:\nEnter \"Done\" to exit.", s);
            switch (typeInput.toLowerCase()) {
                case "bank" -> {
                    String accountNumber = getInputFromConsole("Enter the account number of the bank account: ", s);
                    double balance = Double.parseDouble(getInputFromConsole("Enter the current balance of the bank account: ", s));
                    myAssets.add(new BankAccount(nameInput, accountNumber, balance));
                }
                case "card" -> {
                    String accountNumber = getInputFromConsole("Enter the account number of the credit card: ", s);
                    double balance = Double.parseDouble(getInputFromConsole("Enter the current balance of the credit card: ", s));
                    myAssets.add(new CreditCard(nameInput, accountNumber, balance));
                }
                case "house" -> {
                    double marketValue = Double.parseDouble(getInputFromConsole("Enter the value of the house: ", s));
                    int yearBuilt = Integer.parseInt(getInputFromConsole("Enter the year the house was built: ", s));
                    int squareFeet = Integer.parseInt(getInputFromConsole("Enter the size of the house in square feet: ", s));
                    int bedrooms = Integer.parseInt(getInputFromConsole("Enter the number of bedrooms in the house: ", s));
                    myAssets.add(new House(nameInput, marketValue, yearBuilt, squareFeet, bedrooms));
                }
                case "jewelry" -> {
                    double marketValue = Double.parseDouble(getInputFromConsole("Enter the value of the jewelry: ", s));
                    double karat = Double.parseDouble(getInputFromConsole("Enter how many karats the jewelry is: ", s));
                    myAssets.add(new Jewelry(nameInput, marketValue, karat));
                }
                case "gold" -> {
                    double marketValue = Double.parseDouble(getInputFromConsole("Enter the current value of gold per gram: ", s));
                    double weight = Double.parseDouble(getInputFromConsole("Enter the weight of your gold: ", s));
                    myAssets.add(new Jewelry(nameInput, marketValue, weight));
                }
                case "done" -> {
                    complete = true;
                }
            }
        } while (!complete);
        s.close();

        System.out.println("The total value of the portfolio is: " + myAssets.getValue());
        System.out.println("The most valuable asset is: " + myAssets.getMostValuable());
        System.out.println("The least valuable asset is: " + myAssets.getLeastValuable());
    }

    /**
     * General input retrieval method
     */
    private static String getInputFromConsole(String display, Scanner s) {
        System.out.println(display);
        return s.nextLine().trim();
    }
}
