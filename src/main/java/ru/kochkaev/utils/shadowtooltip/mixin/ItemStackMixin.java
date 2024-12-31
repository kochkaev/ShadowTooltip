package ru.kochkaev.utils.shadowtooltip.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import ru.kochkaev.utils.shadowtooltip.ShadowNBTData;
import ru.kochkaev.utils.shadowtooltip.ShadowTooltip;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @ModifyReturnValue(method = "getTooltip", at = @At("RETURN"))
    private List<Text> postToolTip(List<Text> original) {
        var list = new ArrayList<>(original);
        var components = ((ItemStack)(Object)this).getComponents();
        var component = components.get(ShadowNBTData.SHADOW);
        if (component != null && component.shouldShowTooltip())
            list.add(component.getTooltip());
        return list;
    }
}
