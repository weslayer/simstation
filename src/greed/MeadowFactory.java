package greed;

import mvc.Model;
import mvc.View;
import simStation.WorldFactory;

public class MeadowFactory extends WorldFactory {
    public Model makeModel() {
        return new Meadow();
    }

    public View makeView(Model m) {
        return new MeadowView(m);
    }



    public String getTitle() {
        return "Greedy Pastures";
    }


    public String about() {
        return "Greedy Pastures version 1.0. Copyright 2025 by Nicholas pang, ___, and Rustico Dela Cruz III.";
    }

}
