package net.chuck.chucksmod.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class WyattAnimations {
    public static final Animation IDLE = Animation.Builder.create(2.88f).looping()
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.44f, AnimationHelper.createRotationalVector(0f, 0f, 2.5f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.88f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.44f, AnimationHelper.createRotationalVector(0f, 0f, -2.5f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.88f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("main_body",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("main_body",
                    new Transformation(Transformation.Targets.SCALE,
                            new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.44f, AnimationHelper.createScalingVector(1.02f, 1.02f, 1.02f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.88f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation WALK = Animation.Builder.create(1.44f).looping()
            .addBoneAnimation("right_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.36f, AnimationHelper.createRotationalVector(-30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.08f, AnimationHelper.createRotationalVector(30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.44f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.36f, AnimationHelper.createRotationalVector(30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.08f, AnimationHelper.createRotationalVector(-30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.44f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.36f, AnimationHelper.createRotationalVector(30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.08f, AnimationHelper.createRotationalVector(-30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.44f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.36f, AnimationHelper.createRotationalVector(-30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.08f, AnimationHelper.createRotationalVector(30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.44f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation ATTACK = Animation.Builder.create(0.375f)
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.0417f, AnimationHelper.createRotationalVector(-9.99f, -0.43f, -10.04f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.2083f, AnimationHelper.createRotationalVector(-92.93f, 33.03f, 4.84f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.2917f, AnimationHelper.createRotationalVector(-63.84f, 8.65f, 10.3f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.375f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
}
