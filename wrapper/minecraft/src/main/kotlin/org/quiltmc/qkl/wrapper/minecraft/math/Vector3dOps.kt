/*
 * Copyright 2022 QuiltMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.quiltmc.qkl.wrapper.minecraft.math

import net.minecraft.client.util.math.Vector3d
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3f
import net.minecraft.util.math.Vec3i
import kotlin.math.sqrt

//region Standard math operators
/**
 * Adds a [Vector3d] to a [Vector3d].
 */
public operator fun Vector3d.plus(other: Vector3d): Vector3d {
    return Vector3d(
        this.x + other.x,
        this.y + other.y,
        this.z + other.z
    )
}

/**
 * Subtracts a [Vector3d] from a [Vector3d].
 */
public operator fun Vector3d.minus(other: Vector3d): Vector3d {
    return Vector3d(
        this.x - other.x,
        this.y - other.y,
        this.z - other.z
    )
}

/**
 * Multiplies a [Vector3d] and a [Vector3d].
 * This method is a shorthand for component wise multiplication.
 */
public operator fun Vector3d.times(other: Vector3d): Vector3d {
    return Vector3d(
        this.x * other.x,
        this.y * other.y,
        this.z * other.z
    )
}

/**
 * Multiplies a [Vector3d] and a Double.
 */
public operator fun Vector3d.times(other: Double): Vector3d {
    return Vector3d(
        this.x * other,
        this.y * other,
        this.z * other
    )
}

/**
 * Multiplies a Double and a [Vector3d].
 */
public operator fun Double.times(other: Vector3d): Vector3d {
    return Vector3d(
        this * other.x,
        this * other.y,
        this * other.z
    )
}

/**
 * Divides a [Vector3d] and a Double.
 */
public operator fun Vector3d.div(other: Double): Vector3d {
    return Vector3d(
        this.x / other,
        this.y / other,
        this.z / other
    )
}

/**
 * Negates a [Vector3d].
 */
public operator fun Vector3d.unaryMinus(): Vector3d {
    return this.times(-1.0)
}
//endregion

//region Type compatibility operator variations
/**
 * Adds a [Vec3d] to a [Vector3d].
 */
public operator fun Vector3d.plus(other: Vec3d): Vector3d {
    return Vector3d(
        this.x + other.x,
        this.y + other.y,
        this.z + other.z
    )
}

/**
 * Subtracts a [Vec3d] from a [Vector3d].
 */
public operator fun Vector3d.minus(other: Vec3d): Vector3d {
    return Vector3d(
        this.x - other.x,
        this.y - other.y,
        this.z - other.z
    )
}

/**
 * Multiplies a [Vector3d] and a [Vec3d].
 * This method is a shorthand for component wise multiplication.
 */
public operator fun Vector3d.times(other: Vec3d): Vector3d {
    return Vector3d(
        this.x * other.x,
        this.y * other.y,
        this.z * other.z
    )
}
//endregion

//region xAssign math operators
/**
 * Adds a [Vec3d] to a [Vector3d].
 */
public operator fun Vector3d.plusAssign(other: Vec3d) {
    this.x = this.x + other.x
    this.y = this.y + other.y
    this.z = this.z + other.z
}

/**
 * Adds a [Vector3d] to a [Vector3d].
 */
public operator fun Vector3d.plusAssign(other: Vector3d) {
    this.x = this.x + other.x
    this.y = this.y + other.y
    this.z = this.z + other.z
}

/**
 * Subtracts a [Vec3d] from a [Vector3d].
 */
public operator fun Vector3d.minusAssign(other: Vec3d) {
    this.x = this.x - other.x
    this.y = this.y - other.y
    this.z = this.z - other.z
}

/**
 * Subtracts a [Vector3d] from a [Vector3d].
 */
public operator fun Vector3d.minusAssign(other: Vector3d) {
    this.x = this.x - other.x
    this.y = this.y - other.y
    this.z = this.z - other.z
}

/**
 * Multiplies a [Vector3d] and a [Vec3d].
 * This method is a shorthand for component wise multiplication.
 */
public operator fun Vector3d.timesAssign(other: Vec3d) {
    this.x = this.x * other.x
    this.y = this.y * other.y
    this.z = this.z * other.z
}

/**
 * Multiplies a [Vector3d] and a [Vector3d].
 * This method is a shorthand for component wise multiplication.
 */
public operator fun Vector3d.timesAssign(other: Vector3d) {
    this.x = this.x * other.x
    this.y = this.y * other.y
    this.z = this.z * other.z
}

/**
 * Multiplies a [Vector3d] and a Double.
 */
public operator fun Vector3d.timesAssign(other: Double) {
    this.x = this.x * other
    this.y = this.y * other
    this.z = this.z * other
}

/**
 * Divides a [Vector3d] and a Double.
 */
public operator fun Vector3d.divAssign(other: Double) {
    this.x = this.x / other
    this.y = this.y / other
    this.z = this.z / other
}
//endregion

//region Vector specific operators
/**
 * The dot product of a [Vector3d] and a [Vec3d].
 */
public infix fun Vector3d.dot(other: Vec3d): Double {
    return this.x * other.x + this.y * other.y + this.z * other.z
}

/**
 * The cross product of a [Vector3d] and a [Vec3d].
 */
public infix fun Vector3d.cross(other: Vec3d): Vector3d {
    return Vector3d(
        this.y * other.z - this.z * other.y,
        this.z * other.x - this.x * other.z,
        this.x * other.y - this.y * other.x
    )
}

/**
 * The dot product of a [Vector3d] and a [Vector3d].
 */
public infix fun Vector3d.dot(other: Vector3d): Double {
    return this.x * other.x + this.y * other.y + this.z * other.z
}

/**
 * The cross product of a [Vector3d] and a [Vector3d].
 */
public infix fun Vector3d.cross(other: Vector3d): Vector3d {
    return Vector3d(
        this.y * other.z - this.z * other.y,
        this.z * other.x - this.x * other.z,
        this.x * other.y - this.y * other.x
    )
}

/**
 * Returns the normalized form of a [Vector3d].
 */
public fun Vector3d.normalize(): Vector3d {
    val len = length()
    return if (len < EPSILON) {
        Vector3d(0.0, 0.0, 0.0)
    } else {
        Vector3d(this.x / len, this.y / len, this.z / len)
    }
}

/**
 * The length of a [Vector3d].
 */
public fun Vector3d.length(): Double {
    return sqrt(this.x * this.x + this.y * this.y + this.z * this.z)
}

/**
 * The length squared of a [Vector3d].
 */
public fun Vector3d.lengthSquared(): Double {
    return this.x * this.x + this.y * this.y + this.z * this.z
}

/**
 * The [`x`][Vector3d.x] component of a [Vector3d].
 */
public operator fun Vector3d.component1(): Double {
    return this.x
}

/**
 * The [`y`][Vector3d.y] component of a [Vector3d].
 */
public operator fun Vector3d.component2(): Double {
    return this.y
}

/**
 * The [`z`][Vector3d.z] component of a [Vector3d].
 */
public operator fun Vector3d.component3(): Double {
    return this.z
}
//endregion

//region Conversion methods
/**
 * Converts a [Vector3d] to a [Vec3d].
 */
public fun Vector3d.toVec3d(): Vec3d {
    return Vec3d(
        this.x,
        this.y,
        this.z
    )
}

/**
 * Converts a [Vector3d] to a [Vec3f].
 */
public fun Vector3d.toVec3f(): Vec3f {
    return Vec3f(
        this.x.toFloat(),
        this.y.toFloat(),
        this.z.toFloat()
    )
}

/**
 * Converts a [Vector3d] to a [Vec3i].
 */
public fun Vector3d.toVec3i(): Vec3i {
    return Vec3i(
        this.x.toInt(),
        this.y.toInt(),
        this.z.toInt()
    )
}

/**
 * Converts a [Vector3d] to a [BlockPos].
 */
public fun Vector3d.toBlockPos(): BlockPos {
    return BlockPos(
        this.x.toInt(),
        this.y.toInt(),
        this.z.toInt()
    )
}
//endregion
