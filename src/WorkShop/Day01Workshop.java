package WorkShop;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class Day01Workshop {

    public static void main(String[] args) {

        Console cons = System.console();

        List<String> shoppingCart = new LinkedList<String>();

        // print out first welcoming line
        System.out.println("Welcome to your shopping cart: ");

        // looping to keep taking in input unless program is stopped with typing "stop"
        while (true) {
            String input = cons.readLine();

            // case for adding item, check if input starts with "add"
            if (input.toLowerCase().startsWith("add")) {
                input = input.substring(4);

                // splitting the string at ", " if there is any multiple items input
                // the result will be in an array
                String[] tempCart = input.split(", ");

                // looping through the array and check if item is already in cart or not
                // add item if its new
                for (int i = 0; i < tempCart.length; i++) {
                    if (shoppingCart.contains(tempCart[i])) {
                        System.out.printf("You already have %s in your cart\n", tempCart[i]);
                    } else {
                        shoppingCart.add(tempCart[i]);
                        System.out.printf("%s has been added to your cart\n", tempCart[i]);
                    }
                }

                // case for listing the items in the cart
                // if there are no items, print a line stating there are no items
                // else loop through the linked list and print out the items
            } else if (input.toLowerCase().startsWith("list")) {

                if (shoppingCart.size() == 0) {
                    System.out.println("You don't have any items in the cart.\n");
                } else {
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, shoppingCart.get(i));
                    }
                }

                // case for deleting the items
            } else if (input.toLowerCase().startsWith("delete")) {
                input = input.substring(7);
                try {
                    int index = Integer.parseInt(input);
                    if ((index > 0) || (index <= shoppingCart.size())) { // if else to check if int is within the size
                                                                         // of the list
                        System.out.printf("%s has been removed from cart\n", shoppingCart.get(index - 1));
                        shoppingCart.remove(index - 1);
                    } else {
                        System.out.println("Enter a valid number after delete\n");
                    }
                } catch (NumberFormatException e) { // catch in case input after delete is not a int parseable string
                    System.out.println("Enter a valid number after delete\n");
                }

                // case for stopping the programme
            } else if (input.trim().toLowerCase().equals("stop")) {
                break;

                // case for typing anything that is not list, stop, add or delete
                // prints out instruction
            } else {
                System.out.println("Invalid input, enter add to add items, " +
                        "delete to delete items, list to list items in shopping cart, stop to stop the program.\n");
            }
        }

    }

}
