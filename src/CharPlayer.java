class CharPlayer extends GameControl {

    String characterName;
    int characterHealth;
    int characterAttack;
    int characterDefense;

    public CharPlayer(String CharacterName, int[] statRanges) {

        this.characterName = CharacterName;
        this.characterHealth = randomNum(statRanges[0], statRanges[1]);
        this.characterAttack = randomNum(statRanges[2], statRanges[3]);
        this.characterDefense = randomNum(statRanges[4], statRanges[5]);

    }

    String[] getCharacterStats() {
        return new String[]{this.characterName, String.valueOf(this.characterHealth), String.valueOf(this.characterAttack), String.valueOf(this.characterDefense)};
    }


    public void damageTaken(int damage) {
        this.characterHealth -= damage * (1 - +(this.characterDefense / 100));
    }

    void attackChar(CharPlayer dTarget, int weaponBoost) {

        if (randomNum(0, 5) < 4) {
            dTarget.damageTaken(this.characterAttack);
        } else {
            System.out.println(this.characterName + " missed their attack! on " + dTarget.characterName);
        }

    }


}
























