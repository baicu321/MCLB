package com.cu6.mc_lb.entity.client;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.entity.custom.MCPlayerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MCPlayerRenderer extends MobRenderer<MCPlayerEntity,MCPlayerModel<MCPlayerEntity>> {
    public MCPlayerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new MCPlayerModel<>(pContext.bakeLayer(ModModelLayers.MCPLAYER_LAYER)),1f);
    }

    @Override
    public ResourceLocation getTextureLocation(MCPlayerEntity mcPlayerEntity) {
        return new ResourceLocation(MCLB.MOD_ID,"textures/entity/mc_player.png");
    }

    @Override
    public void render(MCPlayerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()){
            pPoseStack.scale(1f,1f,1f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
