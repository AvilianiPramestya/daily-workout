#include <stdlib.h>
#include <jni.h>
#include <stdio.h>

JNIEXPORT jint JNICALL Java_id_ac_ui_cs_mobileprogramming_aviliani_dailyworkouts_View_MainActivity_jniword(JNIEnv* env, jobject obj) {

        int n;
        n = rand() % 9;
        return n;

}