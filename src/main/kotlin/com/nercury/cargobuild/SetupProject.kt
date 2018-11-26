package com.nercury.cargobuild

import com.nercury.cargobuild.tasks.DiscoverCargoProjectConfigTask
import org.gradle.api.Project

fun createTasks(project: Project, extension: CargoPluginExtension) {
    val discoverCargoProjectConfigTask = project.tasks.create("DiscoverCargoProjectConfig", DiscoverCargoProjectConfigTask::class.java)
    discoverCargoProjectConfigTask.manifestPath = extension.manifestPath;

    project.tasks.whenTaskAdded { t ->
        if (t.name == "assembleDebug") {
            t.dependsOn(discoverCargoProjectConfigTask)
        }
    }
}