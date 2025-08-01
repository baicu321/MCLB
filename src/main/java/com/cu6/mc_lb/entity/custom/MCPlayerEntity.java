package com.cu6.mc_lb.entity.custom;

import com.cu6.mc_lb.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class MCPlayerEntity extends Animal {
    public MCPlayerEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));

        this.goalSelector.addGoal(1,new BreedGoal(this,1.15D));
        this.goalSelector.addGoal(2,new WaterAvoidingRandomStrollGoal(this,1.1D));
        this.goalSelector.addGoal(3,new LookAtPlayerGoal(this, Player.class,3f));
        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,2D)
                .add(Attributes.MOVEMENT_SPEED,0.1D);
    }


    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.MCPLAYER.get().create(serverLevel);
    }
}
