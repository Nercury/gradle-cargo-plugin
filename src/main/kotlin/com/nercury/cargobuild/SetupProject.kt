package com.nercury.cargobuild

import com.nercury.cargobuild.tasks.BuildTask
import com.nercury.cargobuild.tasks.DiscoverCargoProjectConfigTask
import org.gradle.api.Project

fun createTasks(project: Project, extension: CargoPluginExtension) {
    val discoverCargoProjectConfigTask = project.tasks.create("DiscoverCargoProjectConfig", DiscoverCargoProjectConfigTask::class.java)
    discoverCargoProjectConfigTask.manifestPath = extension.manifestPath;

    val buildTask = project.tasks.create("BuildCargoProjectTask", BuildTask::class.java)

    project.tasks.whenTaskAdded { t ->
        if (t.name == "assembleDebug") {
            t.dependsOn(buildTask)
        }

        buildTask.dependsOn(discoverCargoProjectConfigTask)
    }
}