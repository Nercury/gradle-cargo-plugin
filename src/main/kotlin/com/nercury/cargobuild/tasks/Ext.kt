package com.nercury.cargobuild.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.plugins.ExtensionAware

@Suppress("UNCHECKED_CAST")
inline fun<reified D: ExtensionAware, T> DefaultTask.ext(name: String): T {
    return (this
                .dependsOn.first { i -> i is D } as D
            )
            .extensions.getByName(name) as T
}