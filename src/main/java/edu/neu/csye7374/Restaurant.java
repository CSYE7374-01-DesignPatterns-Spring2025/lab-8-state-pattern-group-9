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
