package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field{

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumEnergy() {
        int energySum = 0;
        for (Supplement supplement : supplements) {
            energySum += supplement.getEnergy();
        }
        return energySum;
    }

    @Override
    public void addPlayer(Player player) {
        if(capacity <= players.size()){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }else{
            players.add(player);
        }
    }

    @Override
    public void removePlayer(Player player) {
      players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
     supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):",name,getClass().getSimpleName()));
        sb.append(System.lineSeparator());

        if(players.isEmpty()){
            sb.append("Player: none");
           // sb.append(System.lineSeparator());
        }else{
            sb.append("Player: ").append(players.stream().map(Player::getName).collect(Collectors.joining(" ")));
            sb.append(System.lineSeparator());
        }
        sb.append(String.format("Supplement: %d",supplements.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Energy: %d",sumEnergy()));

        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(players);
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return Collections.unmodifiableCollection(supplements);
    }

    @Override
    public String getName() {
        return name;
    }
}
