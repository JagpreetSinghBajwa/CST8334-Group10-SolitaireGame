package cst8334_group10.commands;

import cst8334_group10.beans.Card;
import cst8334_group10.beans.Game;

public class FlipCard implements Command {

    private final Game game;
    private final Card cardToFlip;
    private final int score;

    public FlipCard(Game game, Card cardToFlip, int score) {
        this.game = game;
        this.cardToFlip = cardToFlip;
        this.score = score;
    }

    @Override
    public void execute() {
        game.flipCard(cardToFlip);
        game.setScore(score);
    }

    @Override
    public void undo() {
        game.flipCard(cardToFlip);
        game.setScore(-score);
    }

}
