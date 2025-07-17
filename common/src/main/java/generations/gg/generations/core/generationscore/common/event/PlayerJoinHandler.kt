package generations.gg.generations.core.generationscore.common.event

import com.cobblemon.mod.common.util.party
import net.minecraft.server.level.ServerPlayer

object PlayerJoinHandler {
    fun onJoin(player: ServerPlayer) {
        val party = player.party()
        party.forEach { pokemon ->
            pokemon.features.removeIf { it.name == "terastal_active"}
            pokemon.features.removeIf { it.name.contains("tera_")}
        }
    }
}