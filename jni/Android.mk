/**
 * This file is part of the Embeded TP.
 *
 * (c) Mickael Gaillard <mickael.gaillard@tactfactory.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := engine_c
LOCAL_SRC_FILES := engine_c.c

include $(BUILD_SHARED_LIBRARY)
