package com.SHARKY2023.EngineeringReimagined.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SolarProduction {

    public static float computeSunIntensity(World world, BlockPos pos, SolarPanelTier solarPanelTier)
    {
        float sunIntensity = 0;

        if(world.canBlockSeeSky(pos))
        {
            float multiplicator = 1.5f;
            float displacement = 1.2f;
            // Celestial angle == 0 at zenith.
            float celestialAngleRadians = world.getCelestialAngleRadians(1.0f);
            if(celestialAngleRadians > Math.PI)
            {
                celestialAngleRadians = (2 * 3.141592f - celestialAngleRadians);
            }

            sunIntensity = multiplicator * MathHelper.cos(celestialAngleRadians / displacement);
            sunIntensity = Math.max(0, sunIntensity);
            sunIntensity = Math.min(1, sunIntensity);

            if(sunIntensity > 0)
            {
                if(solarPanelTier == SolarPanelTier.Basic)
                    sunIntensity = 1;

                if(world.isRaining())
                    sunIntensity *= 0.5;

                if(world.isThundering())
                    sunIntensity *= 0.3;
            }
        }

        return sunIntensity;
    }
}
