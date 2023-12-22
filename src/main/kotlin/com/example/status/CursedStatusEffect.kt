package com.example.status

import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.text.Text

class CursedStatusEffect() : StatusEffect(StatusEffectCategory.HARMFUL, 11604710){

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return true
    }


    override fun applyInstantEffect(
        source: Entity?,
        attacker: Entity?,
        target: LivingEntity,
        amplifier: Int,
        proximity: Double
    ) {
        target.sendMessage(Text.of("You are cursed"))
    }

    override fun applyUpdateEffect(entity: LivingEntity, amplifier: Int) {
        entity.health -= 0.01f
    }


}