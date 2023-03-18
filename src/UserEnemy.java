class UserEnemy extends CharPlayer {

    UserEnemy(String enemyName, int[] statRanges) {
        super(enemyName, statRanges);
    }

    public boolean enemyCheckLiving() {
        return (this.characterHealth < 0);
    }
}
