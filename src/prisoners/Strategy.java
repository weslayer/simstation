package prisoners;

public interface Strategy {
    boolean cooperate(Prisoner me, Prisoner other);
}

// Always cooperate strategy
class Cooperate implements Strategy {
    public boolean cooperate(Prisoner me, Prisoner other) {
        return true;
    }
}

// Always cheat strategy
class Cheat implements Strategy {
    public boolean cooperate(Prisoner me, Prisoner other) {
        return false;
    }
}

// Randomly cooperate strategy
class RandomlyCooperate implements Strategy {
    public boolean cooperate(Prisoner me, Prisoner other) {
        return Math.random() < 0.5;
    }
}

// Tit-for-tat strategy
class TitForTat implements Strategy {
    public boolean cooperate(Prisoner me, Prisoner other) {
        return other.getLastMove();
    }
} 