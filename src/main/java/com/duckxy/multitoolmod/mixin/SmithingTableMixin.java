package com.duckxy.multitoolmod.mixin;

import com.duckxy.multitoolmod.MultiToolItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.SmithingScreenHandler;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SmithingScreenHandler.class)
public class SmithingTableMixin {

    /**
     * Injects into the slot validation to allow MultiToolItem in the base slot
     */
    @Inject(method = "canInsertIntoSlot", at = @At("HEAD"), cancellable = true)
    private void allowMultiToolInBaseSlot(ItemStack stack, Slot slot, CallbackInfoReturnable<Boolean> cir) {
        // Check if this is the base slot (index 1) and the item is a MultiToolItem
        if (slot.id == 1 && stack.getItem() instanceof MultiToolItem) {
            cir.setReturnValue(true);
        }
    }
}
