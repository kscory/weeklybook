package com.kscory.weeklybook.domain.exception

class MissingUseCaseParameterException(kClass: Class<Any>) :
        IllegalArgumentException("Parameters are mendatory for" + kClass::class.java.simpleName)