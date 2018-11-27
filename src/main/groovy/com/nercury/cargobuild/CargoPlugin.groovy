package com.nercury.cargobuild

import org.gradle.api.Plugin
import org.gradle.api.Project

class CargoPlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {
        // Unclear how to convert the following line of code to Kotlin

        def extension = target.android.externalNativeBuild.extensions.create('cargo', CargoPluginExtension, target)

        // Continue main set up in Kotlin code

        SetupProjectKt.createTasks target, extension
    }
}
