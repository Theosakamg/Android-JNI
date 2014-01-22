/**
 * This file is part of the Embeded TP.
 *
 * (c) Mickael Gaillard <mickael.gaillard@tactfactory.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
#include <string.h>
#include <stdio.h>
#include <jni.h>

char* concatMg(char* a, char* b) {
	/* Malloc the memory */
	char *concatenated = malloc(strlen(a) + strlen(b) + 1);
	strcpy(concatenated, a);
	strcat(concatenated, b);

	return concatenated;
}

const char *itoa(int num, char *buf) {
	if (snprintf(buf, sizeof buf, "%d", num) == -1)
		return "";

	return buf;
}

jstring Java_com_tactfactory_testpremier_EngineC_calculate(JNIEnv* env,
		jobject thiz, jint valuz) {
	char *result = "";
	int i = 3, count, c;
	int value = valuz;

	if (value >= 1) {
		result = concatMg("", "2, ");
	}

	for (count = 2; count <= value;) {
		for (c = 2; c <= i - 1; c++) {
			if (i % c == 0)
				break;
		}

		if (c == i) {
			char buffer[33];
			itoa(i, buffer);

			char *sub = concatMg(buffer, ", ");
			result = concatMg(result, sub);
			free(sub);
			count++;
		}
		i++;
	}

	return (*env)->NewStringUTF(env, result);
	free(result);
}

