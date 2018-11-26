package com.nercury.cargobuild.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.TaskAction

open class DiscoverCargoProjectConfigTask : DefaultTask() {
    lateinit var manifestPath: Property<String>

    @TaskAction
    fun run() {
        project.logger.info("In task with ${manifestPath.get()}")
    }
}