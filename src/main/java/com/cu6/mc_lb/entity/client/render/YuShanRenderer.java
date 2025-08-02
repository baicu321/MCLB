package com.cu6.mc_lb.entity.client.render;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.entity.client.MCPlayerModel;
import com.cu6.mc_lb.entity.client.ModModelLayers;
import com.cu6.mc_lb.entity.custom.YuShanEntity;
import com.cu6.mc_lb.entity.custom.ZiMinEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class YuShanRenderer extends MobRenderer<YuShanEntity, MCPlayerModel<YuShanEntity>> {
    public YuShanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new MCPlayerModel<>(pContext.bakeLayer(ModModelLayers.MCPLAYER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(YuShanEntity YuShanEntity) {
        return new ResourceLocation(MCLB.MOD_ID,"textures/entity/yushan.png");
    }

    @Override
    public void render(YuShanEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.95f, 0.95f, 0.95f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
