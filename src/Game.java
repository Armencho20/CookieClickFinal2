public class Game {

    protected int cookieCounter;
    protected int cookiesPerClick;
    protected int cookiesPerSecond;

    protected int cost1;
    protected int cost2;
    protected int cost3;
    protected int cost4;
    protected int cost5;

    protected int count1;
    protected int count3;
    protected int count4;
    protected int count5;

    protected int rebirthCount;
    protected int rebirthCost;
    protected int clickMultiplier;

    protected boolean discountUsed;
    protected int boostTicks;
    private float passiveAccumulator;


    public Game() {
        cookieCounter = 0;
        cookiesPerClick = 1;
        cookiesPerSecond = 0;

        cost1 = 10;
        cost2 = 50;
        cost3 = 100;
        cost4 = 75;
        cost5 = 300;

        count1 = 0;
        count3 = 0;
        count4 = 0;
        count5 = 0;

        rebirthCount = 0;
        rebirthCost = 10000;
        clickMultiplier = 1;

        discountUsed = false;
        boostTicks = 0;
        passiveAccumulator = 0f;
    }


    public void tickPassive() {
        if (boostTicks > 0) {
            boostTicks--;
        }

        passiveAccumulator += cookiesPerSecond / 4f;

        if (passiveAccumulator >= 1f) {
            cookieCounter += (int) passiveAccumulator;
            passiveAccumulator -= (int) passiveAccumulator;
        }
    }

    public void cookieClick() {
        int amount = cookiesPerClick * clickMultiplier;

        if (boostTicks > 0) {
            amount *= 2;
        }

        cookieCounter += amount;
    }


    public void buy1() {
        if (cookieCounter >= cost1) {
            cookieCounter -= cost1;
            cookiesPerClick++;
            count1++;
            cost1 += 10;
        }
    }

    public void buy2() {
        if (cookieCounter >= cost2 && !discountUsed) {
            cookieCounter -= cost2;
            cost1 = cost1 / 2;
            cost3 = cost3 / 2;
            cost4 = cost4 / 2;
            cost5 = cost5 / 2;
            discountUsed = true;
        }
    }

    public void buy3() {
        if (cookieCounter >= cost3) {
            cookieCounter -= cost3;
            boostTicks = 120;
            count3++;
            cost3 += 100;
        }
    }


    public void buy4() {
        if (cookieCounter >= cost4) {
            cookieCounter -= cost4;
            cookiesPerSecond += 1;
            count4++;
            cost4 += 25;
        }
    }

    public void buy5() {
        if (cookieCounter >= cost5) {
            cookieCounter -= cost5;
            cookiesPerSecond += 5;
            count5++;
            cost5 += 150;
        }
    }

    public void rebirth() {
        if (cookieCounter >= rebirthCost) {
            rebirthCount++;
            rebirthCost *= 2;
            clickMultiplier *= 2;

            cookieCounter = 0;
            cookiesPerClick = 1;
            cookiesPerSecond = 0;

            cost1 = 10;
            cost2 = 50;
            cost3 = 100;
            cost4 = 75;
            cost5 = 300;

            count1 = 0;
            count3 = 0;
            count4 = 0;
            count5 = 0;

            discountUsed = false;
            boostTicks = 0;
            passiveAccumulator = 0f;
        }
    }
}


