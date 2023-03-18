class CharPlayer extends GameControl {

    String characterName;
    String characterSpecial;
    int characterHealth;
    int characterAttack;
    int characterDefense;

    public charPlayer(String CharacterName, int[] ranges) {

        this.characterName = characterName;
        this.characterHealth = randomNum(statRanges[0], statRanges[1]);
        this.characterAttack = randomNum(statRanges[2], statRanges[3]);
        this.characterDefense = randomNum(statRanges[4], statRanges[5]);

    }

    String[] getCharacterStats() {
        return new String[]{this.characterName, String.valueOf(this.characterHealth), String.valueOf(this.characterAttack), String.valueOf(this.characterDefense)};
    }


    public void damageTaken(int damage) throws FileNotFoundException {
        this.CharacterHealth -= damage * (1 - +(this.CharacterDefense / 100));
        checkLiving();
    }

    void attackChar(CharPlayer dTarget, int weaponBoost) {

        if (randomNum(0, 5) < 4) {
            dTarget.damageTaken(this.characterAttack);
        } else {
            System.out.println(this.characterName + " missed their attack! on " + dTarget.characterName);
        }

    }


}
























