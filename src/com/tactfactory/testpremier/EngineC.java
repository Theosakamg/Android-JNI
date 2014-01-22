/**
 * This file is part of the Embeded TP.
 *
 * (c) Mickael Gaillard <mickael.gaillard@tactfactory.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.tactfactory.testpremier;

/**
 * C engine (very fast) wrapper
 */
public class EngineC {

	static {
		System.loadLibrary("engine_c");
	}

	public native String calculate(int value);

}
