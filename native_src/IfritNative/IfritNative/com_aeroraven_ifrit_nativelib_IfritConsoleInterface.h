/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_aeroraven_ifrit_nativelib_IfritConsoleInterface */

#ifndef _Included_com_aeroraven_ifrit_nativelib_IfritConsoleInterface
#define _Included_com_aeroraven_ifrit_nativelib_IfritConsoleInterface
#ifdef __cplusplus
extern "C" {
#endif
	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_GetStdHandle
	 * Signature: (I)J
	 */
	JNIEXPORT jlong JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1GetStdHandle
	(JNIEnv*, jclass, jint);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_SetConsoleTextAttribute
	 * Signature: (JS)Z
	 */
	JNIEXPORT jboolean JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleTextAttribute
	(JNIEnv*, jclass, jlong, jshort);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_SetConsoleCursorPosition
	 * Signature: (JSS)Z
	 */
	JNIEXPORT jboolean JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleCursorPosition
	(JNIEnv*, jclass, jlong, jshort, jshort);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_GetConsoleCursorPositionX
	 * Signature: (J)I
	 */
	JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1GetConsoleCursorPositionX
	(JNIEnv*, jclass, jlong);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_GetConsoleCursorPositionY
	 * Signature: (J)I
	 */
	JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1GetConsoleCursorPositionY
	(JNIEnv*, jclass, jlong);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_SetConsoleFontInfoEx
	 * Signature: (ISSIILjava/lang/String;)I
	 */
	JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleFontInfoEx
	(JNIEnv*, jclass, jint, jshort, jshort, jint, jint, jstring);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_Getch
	 * Signature: ()I
	 */
	JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1Getch
	(JNIEnv*, jclass);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_Kbhit
	 * Signature: ()I
	 */
	JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1Kbhit
	(JNIEnv*, jclass);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_SetConsoleScreenBufferSize
	 * Signature: (JII)I
	 */
	JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleScreenBufferSize
	(JNIEnv*, jclass, jlong, jint, jint);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_GetConsoleMode
	 * Signature: (J)I
	 */
	JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1GetConsoleMode
	(JNIEnv*, jclass, jlong);

	/*
	 * Class:     com_aeroraven_ifrit_nativelib_IfritConsoleInterface
	 * Method:    ICI_SetConsoleMode
	 * Signature: (JI)I
	 */
	JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_nativelib_IfritConsoleInterface_ICI_1SetConsoleMode
	(JNIEnv*, jclass, jlong, jint);

#ifdef __cplusplus
}
#endif
#endif