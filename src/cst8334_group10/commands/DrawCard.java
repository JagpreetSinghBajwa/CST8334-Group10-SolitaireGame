package cst8334_group10.commands;

import cst8334_group10.beans.Game;

public class DrawCard implements Command {

    private final Game game;

    public DrawCard(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.drawFromDeck();

    }

    @Override
    public void undo() {
        game.addToDeck();

    }

}