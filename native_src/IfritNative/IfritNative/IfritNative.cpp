#define _CRT_SECURE_NO_WARNINGS
#include "com_aeroraven_ifrit_nativelib_IfritConsoleInterface.h"

#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>

#ifdef _WIN32
#include <Windows.h>
#include <conio.h>
#define IFRIT_WINDOWS 1
#else
#include <unistd.h> 
#include <termio.h>
#include <fcntl.h>
#endif

#define IFRIT_INVALID_RETURN 0
#define IFRIT_DEBUG_MODE true
#define IFRIT_PROMPT(x) printf("IFRIT NATIVE ERROR:%s\n",x);
#define IFRIT_DEBUG_PROMPT(x) if(IFRIT_DEBUG_MODE) IFRIT_PROMPT(x)

#ifdef IFRIT_WINDOWS
#define IFRIT_GETLASTERR_PROMPT if(IFRIT_DEBUG_MODE) printf("ERROR CODE:%d\n",GetLastError());
#endif

#define IFRIT_WARN_UNSUPPORTED_OS "operating system unsupported"
#define IFRIT_WARN_CALL_FAILURE "api call failed"


std::wstring Java_To_WStr(JNIEnv * env, jstring string){
	std::wstring value;
	const jchar* raw = env->GetStringChars(string, 0);
	jsize len = env->GetStringLength(string);
	value.assign(raw, raw + len);
	env->ReleaseStringChars(string, raw);
	return value;
}


JNIEXPORT jlong JNICALL 
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1GetStdHandle
(JNIEnv* jenv, jclass jcl, jint nStdHandle) {
#ifdef IFRIT_WINDOWS
	return (jlong)GetStdHandle(nStdHandle);
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jlong)IFRIT_INVALID_RETURN;
}


JNIEXPORT jboolean JNICALL 
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleTextAttribute
(JNIEnv* jenv, jclass jcl, jlong hConsoleOutput, jshort wAttribute) {
#ifdef IFRIT_WINDOWS
	return SetConsoleTextAttribute((HANDLE)hConsoleOutput, wAttribute);
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jboolean)IFRIT_INVALID_RETURN;
}

JNIEXPORT jboolean JNICALL 
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleCursorPosition
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
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1GetConsoleCursorPositionX
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
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1GetConsoleCursorPositionY
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
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleFontInfoEx
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

JNIEXPORT jint JNICALL
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1Getch
(JNIEnv* jenv, jclass jcl) {
#ifdef IFRIT_WINDOWS
	int s = _getch();
	if (s == 224) s = _getch() + 224;
	return s;
#else
	struct termios tm, tm_old;
	int fd = 0, ch;
	if (tcgetattr(fd, &tm) < 0) {
		return -1;
	}
	tm_old = tm;
	cfmakeraw(&tm);
	if (tcsetattr(fd, TCSANOW, &tm) < 0) {
		return -1;
	}
	ch = getchar();
	if (tcsetattr(fd, TCSANOW, &tm_old) < 0) {
		return -1;
	}
	return ch;
#endif
}

JNIEXPORT jint JNICALL
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1Kbhit
(JNIEnv* jenv, jclass jcl) {
#ifdef IFRIT_WINDOWS
	return _kbhit();
#else
	struct termios oldt, newt;
	int ch;
	int oldf;
	tcgetattr(STDIN_FILENO, &oldt);
	newt = oldt;
	newt.c_lflag &= ~(ICANON | ECHO);
	tcsetattr(STDIN_FILENO, TCSANOW, &newt);
	oldf = fcntl(STDIN_FILENO, F_GETFL, 0);
	fcntl(STDIN_FILENO, F_SETFL, oldf | O_NONBLOCK);
	ch = getchar();
	tcsetattr(STDIN_FILENO, TCSANOW, &oldt);
	fcntl(STDIN_FILENO, F_SETFL, oldf);
	if (ch != EOF) {
		ungetc(ch, stdin);
		return 1;
	}
	return 0;
#endif
}
JNIEXPORT jint JNICALL 
Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleScreenBufferSize
(JNIEnv* jenv, jclass jcl, jlong hStd, jint iW, jint iH) {
#ifdef IFRIT_WINDOWS
	COORD bf;
	bf.X = iW;
	bf.Y = iH;
	SetConsoleScreenBufferSize((HANDLE)hStd, bf);
	return 1;
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jint)IFRIT_INVALID_RETURN;
}

JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleMode
(JNIEnv* jenv, jclass jcl, jlong hStd, jint iMode) {
#ifdef IFRIT_WINDOWS
	if (SetConsoleMode((HANDLE)hStd, iMode) == 0) {
		IFRIT_DEBUG_PROMPT(IFRIT_WARN_CALL_FAILURE);
		IFRIT_GETLASTERR_PROMPT;
	}
	return 1;
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jint)IFRIT_INVALID_RETURN;
}

JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1GetConsoleMode
(JNIEnv* jenv, jclass jcl, jlong hStd) {
#ifdef IFRIT_WINDOWS
	unsigned long mode;
	GetConsoleMode((HANDLE)hStd,&mode);
	return mode;
#endif
	IFRIT_DEBUG_PROMPT(IFRIT_WARN_UNSUPPORTED_OS);
	return (jint)IFRIT_INVALID_RETURN;
}