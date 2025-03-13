package _04_dsl_frontend_backend.backend.annotation

import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FUNCTION

@DslMarker
@Target(FUNCTION, CLASS)
annotation class BackendApiDsl