/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    // There is one way to climb 0 or 1 step
    let prev2 = 1;
    let prev1 = 1;

    // Iterate through step 2 to n and update the pointers accordingly
    for (let i = 2; i <= n; i++) {
        const curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }

    // Return the final result
    return prev1;
};