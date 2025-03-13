package _04_dsl_frontend_backend

import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FUNCTION

@DslMarker
@Target(FUNCTION, CLASS)
annotation class FrontendDsl