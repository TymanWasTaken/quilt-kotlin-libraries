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

package org.quiltmc.qkl.wrapper.minecraft.brigadier

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.*
import com.mojang.brigadier.builder.ArgumentBuilder
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.builder.RequiredArgumentBuilder
import com.mojang.brigadier.context.CommandContext

public typealias RequiredArgumentAction<S> = RequiredArgumentBuilder<S, *>.() -> Unit
public typealias LiteralArgumentAction<S> = LiteralArgumentBuilder<S>.() -> Unit
public typealias CommandAction<S> = CommandContext<S>.() -> Int

/**
 * Registers a command under [command] as the name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S> CommandDispatcher<S>.register(
    command: String,
    action: LiteralArgumentAction<S>
) {
    val argument = LiteralArgumentBuilder.literal<S>(command)
    argument.apply(action)
    register(argument)
}

/**
 * Adds a literal with [name] as the literal.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.literal(
    name: String,
    action: LiteralArgumentAction<S>
) {
    val argument = LiteralArgumentBuilder.literal<S>(name)
    argument.apply(action)
    then(argument)
}

/**
 * Adds a string with [name] as the parameter name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.string(
    name: String,
    action: RequiredArgumentAction<S>
) {
    val argument = RequiredArgumentBuilder.argument<S, String>(
        name,
        StringArgumentType.string()
    )
    argument.apply(action)
    then(argument)
}

/**
 * Adds a greedy string with [name] as the parameter name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.greedyString(
    name: String,
    action: RequiredArgumentAction<S>
) {
    val argument = RequiredArgumentBuilder.argument<S, String>(
        name,
        StringArgumentType.greedyString()
    )
    argument.apply(action)
    then(argument)
}

/**
 * Adds a word with [name] as the parameter name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.word(
    name: String,
    action: RequiredArgumentBuilder<S, String>.() -> Unit = { }
) {
    val argument = RequiredArgumentBuilder.argument<S, String>(
        name,
        StringArgumentType.word()
    )
    argument.apply(action)
    then(argument)
}

/**
 * Adds a boolean with [name] as the parameter name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.boolean(
    name: String,
    action: RequiredArgumentAction<S>
) {
    val argument = RequiredArgumentBuilder.argument<S, Boolean>(
        name,
        BoolArgumentType.bool()
    )
    argument.apply(action)
    then(argument)
}

/**
 * Adds a double with [name] as the parameter name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.double(
    name: String,
    min: Double? = null,
    max: Double? = null,
    action: RequiredArgumentAction<S>
) {
    val argument = RequiredArgumentBuilder.argument<S, Double>(
        name,
        DoubleArgumentType.doubleArg(min ?: -Double.MAX_VALUE, max ?: Double.MAX_VALUE)
    )
    argument.apply(action)
    then(argument)
}

/**
 * Adds a float with [name] as the parameter name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.float(
    name: String,
    min: Float? = null,
    max: Float? = null,
    action: RequiredArgumentAction<S>
) {
    val argument = RequiredArgumentBuilder.argument<S, Float>(
        name,
        FloatArgumentType.floatArg(min ?: -Float.MAX_VALUE, max ?: Float.MAX_VALUE)
    )
    argument.apply(action)
    then(argument)
}

/**
 * Adds a integer with [name] as the parameter name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.integer(
    name: String,
    min: Int? = null,
    max: Int? = null,
    action: RequiredArgumentAction<S>
) {
    val argument = RequiredArgumentBuilder.argument<S, Int>(
        name,
        IntegerArgumentType.integer(min ?: -Int.MAX_VALUE, max ?: Int.MAX_VALUE)
    )
    argument.apply(action)
    then(argument)
}

/**
 * Adds a long with [name] as the parameter name.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.long(
    name: String,
    min: Long? = null,
    max: Long? = null,
    action: RequiredArgumentAction<S>
) {
    val argument = RequiredArgumentBuilder.argument<S, Long>(
        name,
        LongArgumentType.longArg(min ?: -Long.MAX_VALUE, max ?: Long.MAX_VALUE)
    )
    argument.apply(action)
    then(argument)
}

/**
 * Adds an executor to the command tree.
 *
 * @author Oliver-makes-code (Emma)
 */
public fun <S, T : ArgumentBuilder<S, T>?> ArgumentBuilder<S, T>.executes(
    action: CommandAction<S>
) {
    executes(action)
}