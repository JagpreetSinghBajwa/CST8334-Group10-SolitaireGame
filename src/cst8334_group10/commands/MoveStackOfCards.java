package cst8334_group10.commands;

import cst8334_group10.beans.CardPile;
import cst8334_group10.beans.Game;

public class MoveStackOfCards implements Command {

    private final Game game;
    private final CardPile fromPile;
    private final CardPile toPile;
    private final int score;
    private final CardPile moveStack;

    public MoveStackOfCards(Game game, CardPile fromPile, CardPile toPile, int score) {
        this.fromPile = fromPile;
        this.toPile = toPile;
        this.game = game;
        this.score = score;
        
        this.moveStack = null;
    }
    public MoveStackOfCards(Game game, CardPile moveStack, CardPile fromPile, CardPile toPile, int score) {
        this.fromPile = fromPile;
        this.toPile = toPile;
        this.game = game;
        this.score = score;
        
        this.moveStack = moveStack;
    }


    @Override
    public void execute() {
        if (moveStack != null) {
            game.moveStack(fromPile, toPile, moveStack);
        } else {
            game.moveStack(fromPile, toPile);
        }
        
        game.setScore(score);
    }

    @Override
    public void undo() {
        if (moveStack != null) {
            game.moveStack(toPile, fromPile, moveStack);
        } else {
            game.moveStack(toPile, fromPile);
        }
        game.setScore(-score);
    }


}