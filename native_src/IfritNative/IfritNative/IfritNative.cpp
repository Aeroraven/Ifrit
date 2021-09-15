#include "com_aeroraven_ifrit_IfritConsoleInterface.h"

#include <iostream>
#include <cstdio>

#ifdef _WIN32
#include <Windows.h>
#define IFRIT_WINDOWS 1
#endif

#define IFRIT_INVALID_RETURN 0
#define IFRIT_DEBUG_MODE true
#define IFRIT_PROMPT(x) printf("ERROR:%s\n",x);
#define IFRIT_DEBUG_PROMPT(x) if(IFRIT_DEBUG_MODE) IFRIT_PROMPT(x)

#define IFRIT_WARN_UNSUPPORTED_OS "operating system unsupported"


JNIEXPORT jlong JNICALL 
Java_com_aeroraven_ifrit_IfritConsoleInterface_ICI_1GetStdHandle
(JNIEnv* jenv, jclass jcl, jint nStdHandle) {
#ifdef IFRIT_WINDOWS
	return (jlong)GetStdHandle(nStdHandle);
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jlong)IFRIT_INVALID_RETURN;
}


JNIEXPORT jboolean JNICALL
Java_com_aeroraven_ifrit_IfritConsoleInterface_ICI_1SetConsoleTextAttribute
(JNIEnv* jenv, jclass jcl, jlong hConsoleOutput, jshort wAttribute) {
#ifdef IFRIT_WINDOWS
	return SetConsoleTextAttribute((HANDLE)hConsoleOutput, wAttribute);
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jboolean)IFRIT_INVALID_RETURN;
}