#define _CRT_SECURE_NO_WARNINGS
#include "com_aeroraven_ifrit_win32_IfritConsoleInterface.h"

#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>

#ifdef _WIN32
#include <Windows.h>
#define IFRIT_WINDOWS 1
#endif

#define IFRIT_INVALID_RETURN 0
#define IFRIT_DEBUG_MODE true
#define IFRIT_PROMPT(x) printf("ERROR:%s\n",x);
#define IFRIT_DEBUG_PROMPT(x) if(IFRIT_DEBUG_MODE) IFRIT_PROMPT(x)

#define IFRIT_WARN_UNSUPPORTED_OS "operating system unsupported"


std::wstring Java_To_WStr(JNIEnv * env, jstring string){
	std::wstring value;
	const jchar* raw = env->GetStringChars(string, 0);
	jsize len = env->GetStringLength(string);
	value.assign(raw, raw + len);
	env->ReleaseStringChars(string, raw);
	return value;
}


JNIEXPORT jlong JNICALL 
Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1GetStdHandle
(JNIEnv* jenv, jclass jcl, jint nStdHandle) {
#ifdef IFRIT_WINDOWS
	return (jlong)GetStdHandle(nStdHandle);
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jlong)IFRIT_INVALID_RETURN;
}


JNIEXPORT jboolean JNICALL 
Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1SetConsoleTextAttribute
(JNIEnv* jenv, jclass jcl, jlong hConsoleOutput, jshort wAttribute) {
#ifdef IFRIT_WINDOWS
	return SetConsoleTextAttribute((HANDLE)hConsoleOutput, wAttribute);
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jboolean)IFRIT_INVALID_RETURN;
}

JNIEXPORT jboolean JNICALL 
Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1SetConsoleCursorPosition
(JNIEnv* jenv, jclass jcl, jlong hConsoleOutput, jshort wX, jshort wY) {
#ifdef IFRIT_WINDOWS
	COORD cCoord;
	cCoord.X = wX;
	cCoord.Y = wY;
	return SetConsoleCursorPosition((HANDLE)hConsoleOutput, cCoord);
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jboolean)IFRIT_INVALID_RETURN;
}

JNIEXPORT jint JNICALL 
Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1GetConsoleCursorPositionX
(JNIEnv* jevnv, jclass jcl, jlong hConsoleOutput) {
#ifdef IFRIT_WINDOWS
	CONSOLE_SCREEN_BUFFER_INFO cinf;
	GetConsoleScreenBufferInfo((HANDLE)hConsoleOutput, &cinf);
	return (jint)cinf.dwCursorPosition.X;
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jint)IFRIT_INVALID_RETURN;
}

JNIEXPORT jint JNICALL
Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1GetConsoleCursorPositionY
(JNIEnv* jevnv, jclass jcl, jlong hConsoleOutput) {
#ifdef IFRIT_WINDOWS
	CONSOLE_SCREEN_BUFFER_INFO cinf;
	GetConsoleScreenBufferInfo((HANDLE)hConsoleOutput, &cinf);
	return (jint)cinf.dwCursorPosition.Y;
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jint)IFRIT_INVALID_RETURN;
}


JNIEXPORT jint JNICALL 
Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1SetConsoleFontInfoEx
(JNIEnv* jenv, jclass jcl, jint nFont, jshort fsx, jshort fsy, jint fontfam, jint fontweight, jstring fontface) {
#ifdef IFRIT_WINDOWS
	CONSOLE_FONT_INFOEX cfi;
	cfi.cbSize = sizeof(cfi);
	cfi.nFont = nFont;
	cfi.dwFontSize.X = fsx;
	cfi.dwFontSize.Y = fsy;
	cfi.FontFamily = FF_DONTCARE;
	cfi.FontWeight = FW_NORMAL;
	wcscpy(cfi.FaceName, L"Arial");
	SetCurrentConsoleFontEx(GetStdHandle(STD_OUTPUT_HANDLE), FALSE, &cfi);
	return 1;
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jint)IFRIT_INVALID_RETURN;
}