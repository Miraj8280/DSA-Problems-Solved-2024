/**
 * @param {string} s
 * @return {string}
 */
var maximumOddBinaryNumber = function(s) {
    let count0 = 0;
    let count1 = 0;

    for (let ch of s) {
        if (ch === '0' ) {
            count0++;
        }
        else if (ch === '1') {
            count1++;
        }
    }

    let result = '1'.repeat(count1 - 1) + '0'.repeat(count0) + '1';

    return result;
};