package com.nercury.cargobuild.model

/**
 * Holds collected information collected during cargo built.
 * Most importantly, it contains the location of built libraries.
 *
 * This information is produced by BuildTask.
 */
open class CargoBuildOutput(
        val sharedLibraryPath: String
)
