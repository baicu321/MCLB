package com.cu6.mc_lb.entity.client.render;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.entity.client.MCPlayerModel;
import com.cu6.mc_lb.entity.client.ModModelLayers;
import com.cu6.mc_lb.entity.custom.MoonBoosEntity;
import com.cu6.mc_lb.entity.custom.TianQiEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TianQiRenderer extends MobRenderer<TianQiEntity, MCPlayerModel<TianQiEntity>> {
    public TianQiRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new MCPlayerModel<>(pContext.bakeLayer(ModModelLayers.MCPLAYER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TianQiEntity TianQiEntity) {
        return new ResourceLocation(MCLB.MOD_ID,"textures/entity/tianqi.png");
    }

    @Override
    public void render(TianQiEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.95f, 0.95f, 0.95f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
