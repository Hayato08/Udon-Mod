package net.hayato08.udonmod.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GraySplashParticle extends WaterDropParticle {
    protected GraySplashParticle(ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
        super(level, x, y, z);
        this.gravity = 0.04F;
        this.xd = xd * 0.3D + (Math.random() * 2.0D - 1.0D) * 0.02D;
        this.yd = yd * 0.3D + (Math.random() * 2.0D - 1.0D) * 0.02D;
        this.zd = zd * 0.3D + (Math.random() * 2.0D - 1.0D) * 0.02D;
        this.lifetime = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;

        // Gray color (adjust values for different shades)
        this.setColor(1.0F, 1.0F, 1.0F);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
            GraySplashParticle particle = new GraySplashParticle(level, x, y, z, xd, yd, zd);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}