LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := jni_words
LOCAL_SRC_FILES := jni_words.c

include $(BUILD_SHARED_LIBRARY)