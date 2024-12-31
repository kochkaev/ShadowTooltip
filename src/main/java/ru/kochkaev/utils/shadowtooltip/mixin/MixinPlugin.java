package ru.kochkaev.utils.shadowtooltip.mixin;

import com.google.common.collect.ImmutableMap;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import ru.kochkaev.utils.shadowtooltip.ShadowTooltip;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {

    private static final Map<String, Boolean> CONDITIONS = ImmutableMap.of(
            "ItemStackMixin", !ShadowTooltip.isCarpetShadowInit
    );

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        var className = mixinClassName.replace("ru.kochkaev.utils.shadowtooltip.mixin.", "");
        return CONDITIONS.getOrDefault(className, true);
    }

    @Override public void onLoad(String mixinPackage) {}
    @Override public String getRefMapperConfig() { return null; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
