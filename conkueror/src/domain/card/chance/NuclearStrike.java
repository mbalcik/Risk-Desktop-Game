package domain.card.chance;

import domain.game.Game;
import domain.mapstate.TerritoryState;
import domain.player.Player;
import util.CoreUtils;

import java.io.Serializable;

public class NuclearStrike implements ChanceEffect, Serializable {

    private Game game = Game.getInstance();

    @Override
    public void applyEffect() {
        TerritoryState selectedTerritory = game.nukeTo;
        Player player = game.getCurrentPlayer();
        TerritoryState randomTerritory = CoreUtils.chooseRandom(player.getTerritories());
        selectedTerritory.setPlayable(false);
        selectedTerritory.removeOwner();
        randomTerritory.setPlayable(false);
        randomTerritory.removeOwner();
        game.nukeTo = null;
    }

}
