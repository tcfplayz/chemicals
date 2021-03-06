package tcfplayz.chemicals.items.elements;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import tcfplayz.misc.utils.items.Elements;

import static tcfplayz.misc.utils.other.Timeout.setTimeout;

public class Helium extends Elements {
    public Helium() {
        super();
    }

    @Override
    public String getID() {
        return "helium";
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.getAbilities().allowFlying = true;
        player.sendAbilitiesUpdate();
        setTimeout(() -> player.getAbilities().allowFlying = false, 10000);
        player.sendAbilitiesUpdate();
        player.getInventory().removeStack(player.getInventory().selectedSlot);
        return TypedActionResult.success(player.getStackInHand(hand));
    }

}
