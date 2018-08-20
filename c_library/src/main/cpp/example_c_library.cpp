#include <jni.h>
#include <stdio.h>

// This construct is needed to make the C++ compiler generate C-compatible compiled code.
extern "C" 
{
    // Insert all your native functions here...
    
    JNIEXPORT void JNICALL Java_org_example_ExampleJavaApp_hello(JNIEnv *env, jclass cls)
    {
        printf("Hello world\n");
    }

	JNIEXPORT void JNICALL Java_org_example_ExampleJavaApp_sum(JNIEnv *env, jclass cls, jint n)
    {
    	int i=0, sum=0;
    	for (i=1; i<=n; i++) {
    		sum = sum + i;
    	}
    	printf("%d\n", sum);
    }

    JNIEXPORT jint JNICALL Java_org_example_ExampleJavaApp_product(JNIEnv *env, jclass cls, jint n)
    {
    	int i=0, product=1;
    	for (i=1; i<=n; i++) {
    		product = product * i;
    	}
    	return product;
    }    
}
