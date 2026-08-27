#include <jni.h>
#include <string>
#include <cstdlib>
#include "node.h"

extern "C" JNIEXPORT jint JNICALL
Java_com_cineflix_android_MainActivity_startNodeWithArguments(JNIEnv *env, jobject /* this */, jobjectArray arguments) {
    int argc = env->GetArrayLength(arguments);
    char **argv = new char*[argc];
    
    // Convert JNI strings to C strings
    for (int i = 0; i < argc; i++) {
        jstring str = (jstring) env->GetObjectArrayElement(arguments, i);
        const char *c_str = env->GetStringUTFChars(str, 0);
        
        // Copy string
        argv[i] = (char*) malloc(strlen(c_str) + 1);
        strcpy(argv[i], c_str);
        
        env->ReleaseStringUTFChars(str, c_str);
    }

    // Start Node.js engine
    int result = node::Start(argc, argv);

    // Memory cleanup
    for(int i = 0; i < argc; i++) {
        free(argv[i]);
    }
    delete[] argv;

    return result;
}
