package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;

            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;

            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplementToAdd;

        switch (type) {
            case "Powdered":
                supplementToAdd = new Powdered();
                break;

            case "Liquid":
                supplementToAdd = new Liquid();
                break;

            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplement.add(supplementToAdd);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Supplement supplementToAdd = supplement.findByType(supplementType);
        Field field = fields.stream().filter(field1 -> field1.getName().equals(fieldName)).findFirst().orElse(null);

        if (supplementToAdd == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        if (field != null) {
            field.addSupplement(supplementToAdd);
            supplement.remove(supplementToAdd);
        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        Field field = this.fields.stream().filter(field1 -> field1.getName().equals(fieldName)).findFirst().orElse(null);

        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;

            case "Women":
                player = new Women(playerName, nationality, strength);
                break;

            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        if ((player instanceof Men && field instanceof NaturalGrass) ||
                (player instanceof Women && field instanceof ArtificialTurf)) {
            field.addPlayer(player);
        }else{
            return FIELD_NOT_SUITABLE;
        }

        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType,fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        int dragPlayersCount = 0;

       for (Field field : this.fields){
           field.drag();
           dragPlayersCount ++;
       }

        return String.format(PLAYER_DRAG,dragPlayersCount);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = this.fields.stream().filter(field1 -> field1.getName().equals(fieldName)).findFirst().orElse(null);
        int fieldValue = field.getPlayers().stream().mapToInt(Player::getStrength).sum();

        return String.format(STRENGTH_FIELD,fieldName,fieldValue);
    }

    @Override
    public String getStatistics() {
        return fields.stream().map(Field::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
