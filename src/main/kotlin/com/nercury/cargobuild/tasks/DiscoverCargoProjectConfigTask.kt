package com.nercury.cargobuild.tasks

import com.nercury.cargobuild.outputs.DiscoverCargoProjectConfigOutput
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.TaskAction
import java.io.File

open class DiscoverCargoProjectConfigTask : DefaultTask() {
    lateinit var manifestPath: Property<String>

    @TaskAction
    fun run() {
        val projectDir = (project.properties["projectDir"] as File).path!!
        val manifestPath = manifestPath.get()
        val fullManifestPath = File(projectDir, manifestPath)
        val cratePathStr = fullManifestPath.parent
        val targetPath = File(cratePathStr, "target")

        val configuration = DiscoverCargoProjectConfigOutput(
                manifestPath = fullManifestPath.path!!,
                cratePath = cratePathStr,
                targetPath = targetPath.path!!
        )

        extensions.add("configuration", configuration)
    }
}