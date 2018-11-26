package com.nercury.cargobuild

import org.gradle.api.Project
import org.gradle.api.provider.Property

open class CargoPluginExtension(project: Project)  {
    var manifestPath: Property<String> = project.objects.property(String::class.java)

    fun setPath(value: String) {
        manifestPath.set(value)
    }
}