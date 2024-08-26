package generations.gg.generations.core.generationscore.common.network.packets.dialogue;

import generations.gg.generations.core.generationscore.common.client.screen.dialgoue.configure.ConfigureDialogueScreen;
import generations.gg.generations.core.generationscore.common.network.ClientNetworkPacketHandler;
import generations.gg.generations.core.generationscore.common.world.dialogue.DialogueGraph;
import generations.gg.generations.core.generationscore.common.world.dialogue.Dialogues;
import generations.gg.generations.core.generationscore.common.world.dialogue.nodes.SayNode;
import net.minecraft.client.Minecraft;

import java.util.List;

public class S2COpenDialogueEditorScreenHandler implements ClientNetworkPacketHandler<S2COpenDialogueEditorScreenPacket> {
    public static final S2COpenDialogueEditorScreenHandler INSTANCE = new S2COpenDialogueEditorScreenHandler();

    public void handle(S2COpenDialogueEditorScreenPacket packet, Minecraft minecraft) {
        Minecraft.getInstance().setScreen(
                new ConfigureDialogueScreen(
                        Dialogues.instance().getOrElse(
                                packet.location(), new DialogueGraph(
                                        new SayNode(
                                                List.of("Hi @p!"), null
                                        )
                                )
                        )
                )
        );
    }
}
