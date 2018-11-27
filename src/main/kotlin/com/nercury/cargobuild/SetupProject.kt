package com.nercury.cargobuild

import com.nercury.cargobuild.tasks.CargoBuildTask
import com.nercury.cargobuild.tasks.CollectArchitecturesTask
import com.nercury.cargobuild.tasks.DiscoverCargoProjectConfigTask
import org.gradle.api.Project

fun createTasks(project: Project, extension: CargoPluginExtension) {
    val discoverCargoProjectConfigTask = project.tasks.create("DiscoverCargoProjectConfig", DiscoverCargoProjectConfigTask::class.java)
    discoverCargoProjectConfigTask.manifestPath = extension.manifestPath;

    val collectArchitecturesTask = project.tasks.create("CollectArchitecturesTask", CollectArchitecturesTask::class.java)

    val buildTask = project.tasks.create("BuildCargoProjectTask", CargoBuildTask::class.java)

    project.tasks.whenTaskAdded { t ->
        if (t.name == "assembleDebug") {
            t.dependsOn(buildTask)
        }

        buildTask.dependsOn(collectArchitecturesTask)
        buildTask.dependsOn(discoverCargoProjectConfigTask)
    }
}