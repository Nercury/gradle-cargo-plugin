package com.nercury.cargobuild

import org.gradle.api.Plugin
import org.gradle.api.Project

class CargoPlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.android.externalNativeBuild.extensions.create('cargo', CargoPluginExtension, target)

        SetupProjectKt.createTasks target, extension
    }
}
