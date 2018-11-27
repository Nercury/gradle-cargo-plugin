package com.nercury.cargobuild.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.plugins.ExtensionAware
import kotlin.reflect.full.superclasses

@Suppress("UNCHECKED_CAST")
inline fun<reified D: ExtensionAware, T> DefaultTask.ext(name: String): T {
    return (this
                .dependsOn.first { i -> i is D } as D
            )
            .extensions.getByName(name) as T
}

fun Any?.debug(): String {
    return if (this == null) {
        "null"
    } else {
        val superclassesStr = this::class.superclasses
                .mapNotNull { i -> i.qualifiedName }
                .joinToString(",\n      ", "\n      ", "\n   ")
        val interfacesStr = this::class.java.interfaces
                .joinToString(",\n      ", "\n      ", "\n   ") { i -> i.name
                }
        "${this::class.java.name}\n" +
                "   toString: $this\n" +
                "   superclasses: [$superclassesStr]\n" +
                "   interfaces: [$interfacesStr]"
    }
}