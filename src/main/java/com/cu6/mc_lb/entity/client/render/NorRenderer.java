package com.cu6.mc_lb.entity.client.render;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.entity.client.MCPlayerModel;
import com.cu6.mc_lb.entity.client.ModModelLayers;
import com.cu6.mc_lb.entity.custom.NorEntity;
import com.cu6.mc_lb.entity.custom.TianQiEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NorRenderer extends MobRenderer<NorEntity, MCPlayerModel<NorEntity>> {
    public NorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MCPlayerModel<>(pContext.bakeLayer(ModModelLayers.MCPLAYER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(NorEntity norEntity) {
        return new ResourceLocation(MCLB.MOD_ID,"textures/entity/nor.png");
    }

    @Override
    public void render(NorEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.95f, 0.95f, 0.95f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
