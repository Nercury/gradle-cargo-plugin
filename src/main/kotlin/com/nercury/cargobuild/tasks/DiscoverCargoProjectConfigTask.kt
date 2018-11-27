package com.nercury.cargobuild.tasks

import com.nercury.cargobuild.model.CargoProject
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.TaskAction

open class DiscoverCargoProjectConfigTask : DefaultTask() {
    lateinit var manifestPath: Property<String>

    @TaskAction
    fun run() {
        val configuration = CargoProject(
            manifestPath = manifestPath.get()
        )

        extensions.add("configuration", configuration)
    }
}