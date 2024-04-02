package MoonLight.tutorialmod.client;

import com.mojang.blaze3d.platform.InputConstants;
import MoonLight.tutorialmod.TutorialMod;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

public class Keybindings {
    public static final Keybindings INSTANCE = new Keybindings();

    private Keybindings() {}

    private static final String CATEGORY = "key.categories." + TutorialMod.MOD_ID;

    public final KeyMapping exampleKey = new KeyMapping(
            "key." + TutorialMod.MOD_ID + ".example_key",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_H, -1),
            CATEGORY

    );

    public final KeyMapping examplePacketKey = new KeyMapping(
            "key." + TutorialMod.MOD_ID + ".example_packet_key",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_J, -1),
            CATEGORY

    );
}
