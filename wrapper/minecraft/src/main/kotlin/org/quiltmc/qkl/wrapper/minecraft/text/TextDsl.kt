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

package org.quiltmc.qkl.wrapper.minecraft.text

import net.minecraft.nbt.NbtCompound
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.text.data.TextData
import org.quiltmc.qkl.core.annotations.QklDslMarker
import java.util.Optional
import java.util.stream.Stream

/**
 * This class contains the functions for building a [Text] object.
 * To use the DSL use [buildText].
 *
 *
 * @author NoComment1105
 */
@QklDslMarker
public class TextDsl internal constructor(action: TextDsl.() -> Unit) {
    init {
        apply(action)
    }

    /**
     * The text object being built.
     *
     * @author NoComment1105
     */
    public val text: MutableText = Text.empty()

    /**
     * Adds a translatable text.
     *
     * @param value The translation key of the text.
     * @param args Any arguments to apply to the translatable text. Can be left
     * empty for no arguments.
     * @see MutableStyle for action
     *
     * @author NoComment1105
     */
    public inline fun translatable(
        value: String,
        vararg args: Any,
        action: MutableStyle.() -> Unit = { }
    ) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        text.append(mutableStyle.applyTo(Text.translatable(value, args)))
    }

    /**
     * Adds a literal text.
     *
     * @param value The text.
     * @see MutableStyle for action
     *
     * @author NoComment1105
     */
    public inline fun literal(value: String, action: MutableStyle.() -> Unit = { }) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        text.append(mutableStyle.applyTo(Text.literal(value)))
    }

    /**
     * Adds a mutable key bind text.
     *
     * @param key The key of the Key bind
     * @see MutableStyle for action
     *
     * @author NoComment1105
     */
    public inline fun keyBind(key: String, action: MutableStyle.() -> Unit = { }) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        text.append(mutableStyle.applyTo(Text.keyBind(key)))
    }


    /**
     * @see Text.nbt
     *
     * @author NoComment1105
     */
    public inline fun nbt(
        pathPattern: String,
        interpreting: Boolean,
        separator: Optional<Text>,
        nbt: TextData,
        action: MutableStyle.() -> Unit = { }
    ) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        text.append(mutableStyle.applyTo(Text.nbt(pathPattern, interpreting, separator, nbt)))
    }

    /**
     * @see Text.nbt
     *
     * @author NoComment1105
     */
    public inline fun nbt(
        pathPattern: String,
        interpreting: Boolean,
        separator: Optional<Text>,
        noinline nbt: ((ServerCommandSource) -> Stream<NbtCompound>),
        action: MutableStyle.() -> Unit = { }
    ) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        text.append(mutableStyle.applyTo(Text.nbt(pathPattern, interpreting, separator, nbt)))
    }

    /**
     * Add a plain text.
     *
     * @param value The text to add
     * @see MutableStyle for action
     *
     * @author NoComment1105
     */
    public inline fun text(value: String, action: MutableStyle.() -> Unit = { }) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        text.append(mutableStyle.applyTo(Text.empty().append(value)))
    }

    /**
     * Adds a scoreboard.
     *
     * @param name The name to add to the scoreboard
     * @param objective The objective of the scoreboard
     * @see MutableStyle for action
     *
     * @author NoComment1105
     */
    public inline fun scoreboardText(
        name: String,
        objective: String,
        action: MutableStyle.() -> Unit = { }
    ) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        text.append(mutableStyle.applyTo(Text.score(name, objective)))
    }

    /**
     * Adds a resolvable entity selector.
     *
     * @param separator the optional separator if there's multiple matches issued from the selector
     * @param selector the selector
     * @see MutableStyle for action
     *
     * @author NoComment1105
     */
    public inline fun selectorText(
        selector: String,
        separator: Optional<Text>,
        action: MutableStyle.() -> Unit = { }
    ) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        this.text.append(mutableStyle.applyTo(Text.selector(selector, separator)))
    }

    /**
     * Adds a mutable empty text.
     *
     * @see MutableStyle for action
     *
     * @author NoComment1105
     */
    public inline fun empty(action: MutableStyle.() -> Unit = { }) {
        val mutableStyle = MutableStyle()
        mutableStyle.apply(action)
        text.append(mutableStyle.applyTo(Text.empty()))
    }
}

/**
 * The DSL for building a [Text] object.
 *
 * @see TextDsl for action
 *
 * @author NoComment1105
 */
public fun buildText(action: TextDsl.() -> Unit): Text {
    return TextDsl(action).text
}