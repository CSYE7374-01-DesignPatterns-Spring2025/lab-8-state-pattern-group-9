package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private State state;

    public Restaurant() {
        state = new LunchState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void displayMenu() {
        state.displayMenu();
    }

    public void order(int itemNumber) {
        state.order(itemNumber);
    }

    public void switchToBreakfastState() {
        this.state = new BreakfastState();
    }

    public void switchToLunchState() {
        this.state = new LunchState();
    }

    public void switchToDinnerState() {
        this.state = new DinnerState();
    }
    private interface State {
        void displayMenu();
        void order(int itemNumber);
    }

    private class BreakfastState implements State {
        private List<MenuItem> menu;

        public BreakfastState() {
            menu = new ArrayList<>();
            menu.add(new MenuItem(1, "Cereal", 4.99, "Cereal with milk"));
            menu.add(new MenuItem(2, "Oatmeal", 5.99, "Warm oatmeal with fruit"));
            menu.add(new MenuItem(3, "Eggs", 6.99, "Scrambled eggs with toast"));
            menu.add(new MenuItem(4, "Pancakes", 7.99, "Stack of pancakes with syrup"));
            menu.add(new MenuItem(5, "Bagel", 3.99, "Toasted bagel with cream cheese"));
        }

        public void displayMenu() {
            System.out.println("Breakfast Menu:");
            System.out.println("ITEM      PRICE      DESCRIPTION");
            for (MenuItem item : menu) {
                System.out.println(item);
            }
        }

        public void order(int itemNumber) {
            for (MenuItem item : menu) {
                if (item.getId() == itemNumber) {
                    System.out.println("Ordering " + item.getItemName());
                    return;
                }
            }
            System.out.println("Invalid order");
        }
    }

    private class LunchState implements State {
        private List<MenuItem> menu;

        public LunchState() {
            menu = new ArrayList<>();
            menu.add(new MenuItem(1, "Hot Dog", 1.99, "Juicy hot dog with mustard"));
            menu.add(new MenuItem(2, "Salad", 2.99, "Fresh garden salad"));
            menu.add(new MenuItem(3, "Hamburger", 3.99, "Grilled hamburger with cheese"));
        }

        public void displayMenu() {
            System.out.println("Lunch Menu:");
            System.out.println("ITEM      PRICE      DESCRIPTION");
            for (MenuItem item : menu) {
                System.out.println(item);
            }
        }

        public void order(int itemNumber) {
            for (MenuItem item : menu) {
                if (item.getId() == itemNumber) {
                    System.out.println("Ordering " + item.getItemName());
                    return;
                }
            }
            System.out.println("Invalid order");
        }
    }

    private class DinnerState implements State {
        private List<MenuItem> menu;

        public DinnerState() {
            menu = new ArrayList<>();
            menu.add(new MenuItem(1, "Soup", 11.99, "Hot soup to start your meal"));
            menu.add(new MenuItem(2, "Salad", 12.99, "Mixed greens salad"));
            menu.add(new MenuItem(3, "Steak", 13.99, "Grilled steak cooked to order"));
            menu.add(new MenuItem(4, "Salmon", 14.99, "Seared salmon with lemon butter"));
            menu.add(new MenuItem(5, "Chicken", 15.99, "Roasted chicken with herbs"));
        }

        public void displayMenu() {
            System.out.println("Dinner Menu:");
            System.out.println("ITEM      PRICE      DESCRIPTION");
            for (MenuItem item : menu) {
                System.out.println(item);
            }
        }

        public void order(int itemNumber) {
            for (MenuItem item : menu) {
                if (item.getId() == itemNumber) {
                    System.out.println("Ordering " + item.getItemName());
                    return;
                }
            }
            System.out.println("Invalid order");
        }
    }

    public static void demo() {
        // Breakfast Demo
        Restaurant breakfastRestaurant = new Restaurant();
        breakfastRestaurant.switchToBreakfastState();
        breakfastRestaurant.displayMenu();
        breakfastRestaurant.order(4); // Ordering Pancakes

        System.out.println();

        // Lunch Demo
        Restaurant lunchRestaurant = new Restaurant();
        lunchRestaurant.switchToLunchState();
        lunchRestaurant.displayMenu();
        lunchRestaurant.order(1); // Ordering Hot Dog

        System.out.println();

        // Dinner Demo
        Restaurant dinnerRestaurant = new Restaurant();
        dinnerRestaurant.switchToDinnerState();
        dinnerRestaurant.displayMenu();
        dinnerRestaurant.order(3); // Ordering Steak
    }

}
