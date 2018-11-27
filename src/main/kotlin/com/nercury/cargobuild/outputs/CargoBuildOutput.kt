package com.nercury.cargobuild.outputs

/**
 * Holds collected information collected during cargo built.
 * Most importantly, it contains the location of built libraries.
 *
 * This information is produced by CargoBuildTask.
 */
open class CargoBuildOutput(
        val sharedLibraryPath: String
)
