package com.cu6.mc_lb.entity.client.render;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.entity.client.MCPlayerModel;
import com.cu6.mc_lb.entity.client.ModModelLayers;
import com.cu6.mc_lb.entity.custom.XiaoBenEnity;
import com.cu6.mc_lb.entity.custom.ZiMinEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class XiaoBenRenderer extends MobRenderer<XiaoBenEnity, MCPlayerModel<XiaoBenEnity>> {
    public XiaoBenRenderer(EntityRendererProvider.Context context) {
        super(context,new MCPlayerModel<>(context.bakeLayer(ModModelLayers.MCPLAYER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(XiaoBenEnity xiaoBenEnity) {
        return new ResourceLocation(MCLB.MOD_ID,"textures/entity/xiaoben.png");
    }

    @Override
    public void render(XiaoBenEnity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.95f, 0.95f, 0.95f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
