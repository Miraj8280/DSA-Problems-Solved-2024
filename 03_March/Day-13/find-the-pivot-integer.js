/**
 * @param {number} n
 * @return {number}
 */
var pivotInteger = function(n) {
    const x = Math.sqrt(n * (n + 1) / 2);

    if (x % 1 !== 0) {
        return -1;
    }

    return Math.floor(x);
};