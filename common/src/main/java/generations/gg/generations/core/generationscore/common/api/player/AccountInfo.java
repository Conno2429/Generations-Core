package generations.gg.generations.core.generationscore.common.api.player;

import com.cobblemon.mod.common.Cobblemon;
import com.google.gson.JsonObject;
import generations.gg.generations.core.generationscore.common.GenerationsCore;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class AccountInfo extends PlayerDataExtension {
    public static String KEY = "account_info";
    private BigDecimal balance;

    public AccountInfo() {
        balance = BigDecimal.ZERO;
    }

    public AccountInfo(BigDecimal balance) {
        this.balance = balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @NotNull
    @Override
    public String name() {
        return KEY;
    }

    @NotNull
    @Override
    public JsonObject serialize() {
        var json = super.serialize();
        json.addProperty("balance", balance);
        return json;
    }

    @NotNull
    @Override
    public PlayerDataExtension deserialize(@NotNull JsonObject jsonObject) {
        return new AccountInfo(jsonObject.getAsJsonPrimitive("balance").getAsBigDecimal());
    }

    public static AccountInfo get(Player player) {
        return (AccountInfo) new AccountInfo(GenerationsCore.CONFIG.economy.startingFunds); //Cobblemon.playerDataManager.getGenericData(player).getExtraData().computeIfAbsent(KEY, key -> new AccountInfo(GenerationsCore.CONFIG.economy.startingFunds)); TODO: rework
    }
}
