package com.dmiyaniuk;

public class DDD extends CCC {
    public int x;
    private int y;

    @Override
    public int getPropertyX() {
        return this.x;
    }

    @Override
    public int getPropertyY() {
        return this.y;
    }

    public DDD() {
        super();
        this.x = 1;
        this.y = 1;
    }

    public DDD(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
        System.out.println("---super.x in constructor = " + super.getPropertyX() + "---");
        System.out.println("---super.y in constructor = " + super.getPropertyY() + "---");
    }

    @Override
    public int sum() {
        int super_sum = super.sum();
        return this.x + this.y + super_sum;
    }

    public int calc() {
        return (this.x + this.y) * (super.getPropertyX() + super.getPropertyY());
    }
}
