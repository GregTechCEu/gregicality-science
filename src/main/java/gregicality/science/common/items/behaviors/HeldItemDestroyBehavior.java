package gregicality.science.common.items.behaviors;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nonnull;

public class HeldItemDestroyBehavior implements IItemBehaviour {

    private final MetaItem<?>.MetaValueItem replacementItem;

    private int timer = 1;

    public HeldItemDestroyBehavior(MetaItem<?>.MetaValueItem replacementItem) {
        this.replacementItem = replacementItem;
    }

    @Override
    public void onUpdate(@Nonnull ItemStack itemStack, Entity entity) {
        if (entity instanceof EntityPlayer && !entity.getEntityWorld().isRemote && !((EntityPlayer) entity).isCreative()) {
            if (timer % 100 == 0) {
                timer = 0;
                entity.sendMessage(new TextComponentTranslation("metaitem.behavior.held_item_destroy.message", itemStack.getItem().getItemStackDisplayName(itemStack)));
                int amount = itemStack.getCount();
                itemStack.setCount(0);
                ((EntityPlayer) entity).addItemStackToInventory(replacementItem.getStackForm(amount));
            }
            timer++;
        }
    }
}
