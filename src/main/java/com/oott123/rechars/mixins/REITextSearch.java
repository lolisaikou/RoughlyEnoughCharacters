package com.oott123.rechars.mixins;

import com.oott123.rechars.helpers.MatchHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@SuppressWarnings("UnresolvedMixinReference")
@Pseudo
@Mixin(targets = {
    "me.shedaniel.rei.impl.client.search.argument.type.IdentifierArgumentType",
    "me.shedaniel.rei.impl.client.search.argument.type.ModArgumentType",
    "me.shedaniel.rei.impl.client.search.argument.type.TagArgumentType",
    "me.shedaniel.rei.impl.client.search.argument.type.TextArgumentType",
    "me.shedaniel.rei.impl.client.search.argument.type.TooltipArgumentType"
})
public class REITextSearch {
    @Redirect(method = {"matches"}, at = @At(value = "INVOKE", target = "Ljava/lang/String;contains(Ljava/lang/CharSequence;)Z"))
    private boolean proxyStringContains(String haystack, CharSequence needle) {
        return MatchHelper.contains(haystack, needle);
    }
}
