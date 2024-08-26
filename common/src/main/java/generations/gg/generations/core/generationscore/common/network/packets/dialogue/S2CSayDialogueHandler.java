package generations.gg.generations.core.generationscore.common.network.packets.dialogue;

import generations.gg.generations.core.generationscore.common.client.screen.dialgoue.display.DialogueScreen;
import generations.gg.generations.core.generationscore.common.network.ClientNetworkPacketHandler;
import net.minecraft.client.Minecraft;

public class S2CSayDialogueHandler implements ClientNetworkPacketHandler<S2CSayDialoguePacket> {
    public static final S2CSayDialogueHandler INSTANCE = new S2CSayDialogueHandler();

    @Override
    public void handle(S2CSayDialoguePacket packet, Minecraft minecraft) {
        if (Minecraft.getInstance().screen instanceof DialogueScreen dialogueScreen)
            dialogueScreen.activeInfo = new DialogueScreen.SayActiveInfo(packet.text(), packet.useNextArrow());
    }
}
